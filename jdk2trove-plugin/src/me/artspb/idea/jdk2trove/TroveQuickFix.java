package me.artspb.idea.jdk2trove;

import com.intellij.codeInsight.FileModificationService;
import com.intellij.codeInspection.LocalQuickFix;
import com.intellij.codeInspection.ProblemDescriptor;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.project.Project;
import com.intellij.psi.*;
import com.intellij.psi.codeStyle.CodeStyleManager;
import com.intellij.psi.codeStyle.JavaCodeStyleManager;
import com.intellij.util.IncorrectOperationException;
import com.siyeh.ig.PsiReplacementUtil;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;

import static com.intellij.psi.util.ClassUtil.extractClassName;
import static com.intellij.psi.util.PsiTreeUtil.getChildOfType;

/**
 * @author Artem Khvastunov
 */
abstract public class TroveQuickFix implements LocalQuickFix {

    private static final Logger LOG = Logger.getInstance("#" + TroveQuickFix.class.getName());

    private final String interfaceName;
    private final String collectionName;

    protected TroveQuickFix(@NotNull String interfaceName, @NotNull String collectionName) {
        this.interfaceName = interfaceName;
        this.collectionName = collectionName;
    }

    @NotNull
    public String getInterfaceName() {
        return interfaceName;
    }

    @NotNull
    public String getCollectionName() {
        return collectionName;
    }

    @NotNull
    protected PsiElementFactory getFactory(@NotNull Project project) {
        return JavaPsiFacade.getInstance(project).getElementFactory();
    }

    @Override
    public void applyFix(@NotNull Project project, @NotNull ProblemDescriptor descriptor) {
        if (FileModificationService.getInstance().prepareFileForWrite(descriptor.getPsiElement().getContainingFile())) {
            try {
                apply(project, descriptor);
            } catch (IncorrectOperationException e) {
                LOG.error(e);
            }
        }
    }

    protected void apply(@NotNull Project project, @NotNull ProblemDescriptor descriptor) {
        PsiElement psiElement = descriptor.getPsiElement();
        processTypeElement(project, psiElement);
        processExpression(project, psiElement);
        shortenAndReformat(project, psiElement);
    }

    protected void processTypeElement(@NotNull Project project, @NotNull PsiElement psiElement) {
        PsiTypeElement typeElement = getChildOfType(psiElement, PsiTypeElement.class);
        assert typeElement != null;
        String typeElementText = replace(typeElement, getInterfaceName());
        PsiTypeElement newTypeElement = getFactory(project).createTypeElementFromText(typeElementText, typeElement);
        typeElement.replace(newTypeElement);
    }

    protected void processExpression(@NotNull Project project, @NotNull PsiElement psiElement) {
        PsiNewExpression expression = getChildOfType(psiElement, PsiNewExpression.class);
        assert expression != null;
        String expressionText = replace(expression, getCollectionName());
        PsiExpression newExpression = getFactory(project).createExpressionFromText(expressionText, expression);
        expression.replace(newExpression);
    }

    @NotNull
    protected String replace(@NotNull PsiElement element, String name) {
        PsiElement psiElement = getChildOfType(element, PsiAnonymousClass.class);
        if (psiElement == null) {
            psiElement = element;
        }
        PsiJavaCodeReferenceElement reference = getChildOfType(psiElement, PsiJavaCodeReferenceElement.class);
        assert reference != null;
        if (reference.isQualified()) {
            PsiJavaCodeReferenceElement referencePackage = getChildOfType(reference, PsiJavaCodeReferenceElement.class);
            assert referencePackage != null;
            referencePackage.delete();
        }
        PsiIdentifier identifier = getChildOfType(reference, PsiIdentifier.class);
        assert identifier != null;
        return PsiReplacementUtil.getElementText(element, identifier, name);
    }

    protected void shortenAndReformat(@NotNull Project project, @NotNull PsiElement replacementExp) {
        JavaCodeStyleManager.getInstance(project).shortenClassReferences(replacementExp);
        CodeStyleManager.getInstance(project).reformat(replacementExp);
    }

    @Nls
    @NotNull
    @Override
    public String getName() {
        return "Use Trove " + extractClassName(collectionName) + " (may change semantics)";
    }

    @NotNull
    @Override
    public String getFamilyName() {
        return "Trove collections";
    }
}

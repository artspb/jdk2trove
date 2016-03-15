package me.artspb.idea.jdk2trove.hashset;

import com.intellij.codeInspection.LocalQuickFix;
import com.intellij.codeInspection.ProblemsHolder;
import com.intellij.psi.*;
import me.artspb.idea.jdk2trove.TroveInspection;
import me.artspb.idea.jdk2trove.TroveUtils;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;

import static com.intellij.psi.util.PsiTreeUtil.getChildOfType;
import static me.artspb.idea.jdk2trove.TroveUtils.JDK_HASH_SET;
import static me.artspb.idea.jdk2trove.TroveUtils.JDK_LINKED_HASH_SET;

/**
 * @author Artem Khvastunov
 */
public class THashSetCreationInspection extends TroveInspection {

    @Nls
    @NotNull
    @Override
    public String getDisplayName() {
        return "Trove 'THashSet' instead of JDK 'HashSet'";
    }

    @NotNull
    @Override
    public PsiElementVisitor buildVisitor(@NotNull final ProblemsHolder holder, boolean isOnTheFly) {
        return new THashSetCreationJavaElementVisitor(holder);
    }

    private class THashSetCreationJavaElementVisitor extends JavaElementVisitor {

        private final ProblemsHolder holder;

        public THashSetCreationJavaElementVisitor(ProblemsHolder holder) {
            this.holder = holder;
        }

        @Override
        public void visitField(PsiField field) {
            super.visitField(field);
            analise(field);
        }

        @Override
        public void visitLocalVariable(PsiLocalVariable variable) {
            super.visitLocalVariable(variable);
            analise(variable);
        }

        private void analise(PsiElement element) {
            PsiNewExpression expression = getChildOfType(element, PsiNewExpression.class);
            if (expression == null) {
                return;
            }
            PsiElement psiElement = getChildOfType(expression, PsiAnonymousClass.class);
            if (psiElement == null) {
                psiElement = expression;
            }
            PsiJavaCodeReferenceElement reference = getChildOfType(psiElement, PsiJavaCodeReferenceElement.class);
            if (reference == null) {
                return;
            }
            String qualifiedName = reference.getQualifiedName();
            if (JDK_HASH_SET.equals(qualifiedName)) {
                checkParameters(element, reference);
            } else if (JDK_LINKED_HASH_SET.equals(qualifiedName)) {
                registerProblem(element, TLinkedHashSetQuickFix.getInstance());
            }
        }

        private void checkParameters(PsiElement element, PsiJavaCodeReferenceElement reference) {
            PsiType[] parameters = reference.getTypeParameters();
            if (parameters.length == 1) {
                String type = TroveUtils.PRIMITIVE_WRAPPERS.get(parameters[0].getCanonicalText());
                if (type != null) {
                    registerProblem(element, new TTypeHashSetQuickFix(type));
                } else {
                    registerProblem(element, THashSetQuickFix.getInstance());
                }
            } else {
                registerProblem(element, THashSetQuickFix.getInstance());
            }
        }

        private void registerProblem(PsiElement element, LocalQuickFix quickFix) {
            holder.registerProblem(element, "Inefficient collection use", quickFix);
        }
    }
}

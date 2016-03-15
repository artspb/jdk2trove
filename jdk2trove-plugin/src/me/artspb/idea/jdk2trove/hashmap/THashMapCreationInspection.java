package me.artspb.idea.jdk2trove.hashmap;

import com.intellij.codeInspection.LocalQuickFix;
import com.intellij.codeInspection.ProblemsHolder;
import com.intellij.psi.*;
import me.artspb.idea.jdk2trove.TroveInspection;
import me.artspb.idea.jdk2trove.TroveUtils;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;

import static com.intellij.psi.util.PsiTreeUtil.getChildOfType;
import static me.artspb.idea.jdk2trove.TroveUtils.JDK_HASH_MAP;
import static me.artspb.idea.jdk2trove.TroveUtils.JDK_IDENTITY_HASH_MAP;

/**
 * @author Artem Khvastunov
 */
public class THashMapCreationInspection extends TroveInspection {

    @Nls
    @NotNull
    @Override
    public String getDisplayName() {
        return "Trove 'THashMap' instead of JDK 'HashMap'";
    }

    @NotNull
    @Override
    public PsiElementVisitor buildVisitor(@NotNull final ProblemsHolder holder, boolean isOnTheFly) {
        return new THashMapCreationJavaElementVisitor(holder);
    }

    private class THashMapCreationJavaElementVisitor extends JavaElementVisitor {

        private final ProblemsHolder holder;

        public THashMapCreationJavaElementVisitor(ProblemsHolder holder) {
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
            if (JDK_HASH_MAP.equals(qualifiedName)) {
                checkParameters(element, reference);
            } else if (JDK_IDENTITY_HASH_MAP.equals(qualifiedName)) {
                registerProblem(element, TCustomHashMapQuickFix.getInstance());
            }
        }

        private void checkParameters(PsiElement element, PsiJavaCodeReferenceElement reference) {
            PsiType[] parameters = reference.getTypeParameters();
            if (parameters.length == 2) {
                String type1 = TroveUtils.PRIMITIVE_WRAPPERS.get(parameters[0].getCanonicalText());
                String type2 = TroveUtils.PRIMITIVE_WRAPPERS.get(parameters[1].getCanonicalText());
                if (type1 != null) {
                    if (type2 != null) {
                        registerProblem(element, new TTypeTypeHashMapQuickFix(type1, type2));
                    } else {
                        registerProblem(element, new TTypeObjectHashMapQuickFix(type1));
                    }
                } else if (type2 != null) {
                    registerProblem(element, new TObjectTypeHashMapQuickFix(type2));
                } else {
                    registerProblem(element, THashMapQuickFix.getInstance());
                }
            } else {
                registerProblem(element, THashMapQuickFix.getInstance());
            }
        }

        private void registerProblem(PsiElement element, LocalQuickFix quickFix) {
            holder.registerProblem(element, "Inefficient collection use", quickFix);
        }
    }
}

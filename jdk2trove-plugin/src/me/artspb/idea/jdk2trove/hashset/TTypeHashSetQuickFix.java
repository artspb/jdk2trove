package me.artspb.idea.jdk2trove.hashset;

import com.intellij.psi.PsiElement;
import me.artspb.idea.jdk2trove.TroveQuickFix;
import org.jetbrains.annotations.NotNull;

import static java.lang.String.format;
import static me.artspb.idea.jdk2trove.TroveUtils.TROVE_HASH_SET;
import static me.artspb.idea.jdk2trove.TroveUtils.TROVE_SET;

/**
 * @author Artem Khvastunov
 */
public class TTypeHashSetQuickFix extends TroveQuickFix {

    public TTypeHashSetQuickFix(@NotNull String type) {
        super(format(TROVE_SET, type), format(TROVE_HASH_SET, type));
    }

    @NotNull
    @Override
    protected String replace(@NotNull PsiElement element, String name) {
        String newExpression = super.replace(element, name);
        return newExpression.replaceFirst("<.*>", "");
    }
}

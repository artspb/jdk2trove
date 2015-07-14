package me.artspb.idea.jdk2trove.hashmap;

import com.intellij.psi.PsiElement;
import me.artspb.idea.jdk2trove.TroveQuickFix;
import org.jetbrains.annotations.NotNull;

import static java.lang.String.format;
import static me.artspb.idea.jdk2trove.TroveUtils.*;

/**
 * @author Artem Khvastunov
 */
public class TObjectTypeHashMapQuickFix extends TroveQuickFix {

    public TObjectTypeHashMapQuickFix(String type2) {
        super(format(TROVE_MAP, OBJECT + type2), format(TROVE_HASH_MAP, OBJECT + type2));
    }

    @NotNull
    @Override
    protected String replace(@NotNull PsiElement element, String name) {
        String newExpression = super.replace(element, name);
        return newExpression.replaceFirst(",.*>", ">");
    }
}

package me.artspb.idea.jdk2trove.hashmap;

import com.intellij.psi.*;
import me.artspb.idea.jdk2trove.TroveQuickFix;
import org.jetbrains.annotations.NotNull;

import static java.lang.String.format;
import static me.artspb.idea.jdk2trove.TroveUtils.*;

/**
 * @author Artem Khvastunov
 */
public class TTypeObjectHashMapQuickFix extends TroveQuickFix {

    public TTypeObjectHashMapQuickFix(String type1) {
        super(format(TROVE_MAP, type1 + OBJECT), format(TROVE_HASH_MAP, type1 + OBJECT));
    }

    @NotNull
    @Override
    protected String replace(@NotNull PsiElement element, String name) {
        String newExpression = super.replace(element, name);
        return newExpression.replaceFirst("<.*, *", "<");
    }
}

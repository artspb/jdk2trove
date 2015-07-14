package me.artspb.idea.jdk2trove.hashmap;

import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiNewExpression;
import me.artspb.idea.jdk2trove.TroveQuickFix;
import org.jetbrains.annotations.NotNull;

import static me.artspb.idea.jdk2trove.TroveUtils.JDK_MAP;
import static me.artspb.idea.jdk2trove.TroveUtils.TROVE_CUSTOM_HASH_MAP;
import static me.artspb.idea.jdk2trove.TroveUtils.TROVE_IDENTITY_HASHING_STRATEGY;

/**
 * @author Artem Khvastunov
 */
public class TCustomHashMapQuickFix extends TroveQuickFix {

    private static final TCustomHashMapQuickFix INSTANCE = new TCustomHashMapQuickFix();

    private TCustomHashMapQuickFix() {
        super(JDK_MAP, TROVE_CUSTOM_HASH_MAP);
    }

    public static TCustomHashMapQuickFix getInstance() {
        return INSTANCE;
    }

    @NotNull
    @Override
    protected String replace(@NotNull PsiElement element, String name) {
        String expression = super.replace(element, name);
        if (!(element instanceof PsiNewExpression)) {
            return expression;
        }
        String[] parts = expression.split("\\(");
        assert parts.length == 2;
        StringBuilder builder = new StringBuilder(parts[0]);
        builder.append("(");
        builder.append(TROVE_IDENTITY_HASHING_STRATEGY);
        if (!parts[1].startsWith(")")) {
            builder.append(",");
        }
        builder.append(parts[1]);
        return builder.toString();
    }
}

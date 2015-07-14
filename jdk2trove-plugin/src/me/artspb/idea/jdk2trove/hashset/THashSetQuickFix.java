package me.artspb.idea.jdk2trove.hashset;

import me.artspb.idea.jdk2trove.TroveQuickFix;

import static java.lang.String.format;
import static me.artspb.idea.jdk2trove.TroveUtils.JDK_SET;
import static me.artspb.idea.jdk2trove.TroveUtils.TROVE_HASH_SET;

/**
 * @author Artem Khvastunov
 */
public class THashSetQuickFix extends TroveQuickFix {

    private static final THashSetQuickFix INSTANCE = new THashSetQuickFix();

    private THashSetQuickFix() {
        super(JDK_SET, format(TROVE_HASH_SET, ""));
    }

    public static THashSetQuickFix getInstance() {
        return INSTANCE;
    }
}

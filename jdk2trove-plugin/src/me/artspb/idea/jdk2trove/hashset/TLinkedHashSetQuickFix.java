package me.artspb.idea.jdk2trove.hashset;

import me.artspb.idea.jdk2trove.TroveQuickFix;

import static java.lang.String.format;
import static me.artspb.idea.jdk2trove.TroveUtils.JDK_SET;
import static me.artspb.idea.jdk2trove.TroveUtils.TROVE_HASH_SET;

/**
 * @author Artem Khvastunov
 */
public class TLinkedHashSetQuickFix extends TroveQuickFix {

    private static final TLinkedHashSetQuickFix INSTANCE = new TLinkedHashSetQuickFix();

    private TLinkedHashSetQuickFix() {
        super(JDK_SET, format(TROVE_HASH_SET, "Linked"));
    }

    public static TLinkedHashSetQuickFix getInstance() {
        return INSTANCE;
    }
}

package me.artspb.idea.jdk2trove.hashset;

import me.artspb.idea.jdk2trove.TroveQuickFix;

import static me.artspb.idea.jdk2trove.TroveUtils.JDK_SET;
import static me.artspb.idea.jdk2trove.TroveUtils.TROVE_LINKED_HASH_SET;

/**
 * @author Artem Khvastunov
 */
public class TLinkedHashSetQuickFix extends TroveQuickFix {

    private static final TLinkedHashSetQuickFix INSTANCE = new TLinkedHashSetQuickFix();

    private TLinkedHashSetQuickFix() {
        super(JDK_SET, TROVE_LINKED_HASH_SET);
    }

    public static TLinkedHashSetQuickFix getInstance() {
        return INSTANCE;
    }
}

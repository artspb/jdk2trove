package me.artspb.idea.jdk2trove.hashmap;

import me.artspb.idea.jdk2trove.TroveQuickFix;

import static java.lang.String.format;
import static me.artspb.idea.jdk2trove.TroveUtils.JDK_MAP;
import static me.artspb.idea.jdk2trove.TroveUtils.TROVE_HASH_MAP;

/**
 * @author Artem Khvastunov
 */
public class THashMapQuickFix extends TroveQuickFix {

    private static final THashMapQuickFix INSTANCE = new THashMapQuickFix();

    private THashMapQuickFix() {
        super(JDK_MAP, format(TROVE_HASH_MAP, ""));
    }

    public static THashMapQuickFix getInstance() {
        return INSTANCE;
    }
}

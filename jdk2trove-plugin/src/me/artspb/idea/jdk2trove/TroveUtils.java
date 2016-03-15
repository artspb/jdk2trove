package me.artspb.idea.jdk2trove;

import com.google.common.collect.ImmutableMap;

import java.util.Map;

import static com.intellij.psi.CommonClassNames.*;

/**
 * @author Artem Khvastunov
 */
final public class TroveUtils {

    public static final String JDK_MAP = JAVA_UTIL_MAP;
    public static final String JDK_HASH_MAP = JAVA_UTIL_HASH_MAP;
    public static final String JDK_IDENTITY_HASH_MAP = "java.util.IdentityHashMap";
    public static final String TROVE_MAP = "gnu.trove.map.T%sMap";
    public static final String TROVE_HASH_MAP = "gnu.trove.map.hash.T%sHashMap";
    public static final String TROVE_IDENTITY_HASHING_STRATEGY = "gnu.trove.strategy.IdentityHashingStrategy.INSTANCE";

    public static final String JDK_SET = JAVA_UTIL_SET;
    public static final String JDK_HASH_SET = JAVA_UTIL_HASH_SET;
    public static final String JDK_LINKED_HASH_SET = "java.util.LinkedHashSet";
    public static final String TROVE_SET = "gnu.trove.set.T%sSet";
    public static final String TROVE_HASH_SET = "gnu.trove.set.hash.T%sHashSet";

    public static final String OBJECT = JAVA_LANG_OBJECT_SHORT;

    public static final Map<String, String> PRIMITIVE_WRAPPERS = ImmutableMap.<String, String>builder().
            put(JAVA_LANG_BYTE, "Byte").
            put(JAVA_LANG_CHARACTER, "Char").
            put(JAVA_LANG_DOUBLE, "Double").
            put(JAVA_LANG_FLOAT, "Float").
            put(JAVA_LANG_INTEGER, "Int").
            put(JAVA_LANG_LONG, "Long").
            put(JAVA_LANG_SHORT, "Short").build();

    private TroveUtils() {
    }
}

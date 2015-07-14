package me.artspb.idea.jdk2trove;

import com.google.common.collect.ImmutableMap;

import java.util.Map;

import static org.apache.commons.lang.WordUtils.capitalize;

/**
 * @author Artem Khvastunov
 */
final public class TroveUtils {

    public static final String JDK_MAP = "java.util.Map";
    public static final String JDK_HASH_MAP = "java.util.HashMap";
    public static final String JDK_IDENTITY_HASH_MAP = "java.util.IdentityHashMap";
    public static final String TROVE_MAP = "gnu.trove.map.T%sMap";
    public static final String TROVE_HASH_MAP = "gnu.trove.map.hash.T%sHashMap";
    public static final String TROVE_CUSTOM_HASH_MAP = "gnu.trove.map.hash.TCustomHashMap";
    public static final String TROVE_IDENTITY_HASHING_STRATEGY = "gnu.trove.strategy.IdentityHashingStrategy.INSTANCE";

    public static final String JDK_SET = "java.util.Set";
    public static final String JDK_HASH_SET = "java.util.HashSet";
    public static final String JDK_LINKED_HASH_SET = "java.util.LinkedHashSet";
    public static final String TROVE_SET = "gnu.trove.set.T%sSet";
    public static final String TROVE_HASH_SET = "gnu.trove.set.hash.T%sHashSet";
    public static final String TROVE_LINKED_HASH_SET = "gnu.trove.set.hash.TLinkedHashSet";

    public static final String OBJECT = "Object";

    public static final Map<String, String> PRIMITIVE_WRAPPERS = ImmutableMap.<String, String>builder().
            put(Byte.class.getName(), capitalize(byte.class.getName())).
            put(Character.class.getName(), capitalize(char.class.getName())).
            put(Double.class.getName(), capitalize(double.class.getName())).
            put(Float.class.getName(), capitalize(float.class.getName())).
            put(Integer.class.getName(), capitalize(int.class.getName())).
            put(Long.class.getName(), capitalize(long.class.getName())).
            put(Short.class.getName(), capitalize(short.class.getName())).build();

    private TroveUtils() {
    }
}

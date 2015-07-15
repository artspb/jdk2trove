package me.artspb.idea.jdk2trove.example;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;

/**
 * @author Artem Khvastunov
 */
public class THashMapExample {

    private static final Map<String, String> STRING_STRING_CONSTANT = new HashMap<>();
    private static final Map<Integer, String> INT_STRING_CONSTANT = new HashMap<>();
    private static final Map<String, Integer> STRING_INT_CONSTANT = new HashMap<>();
    private static final Map<Integer, Integer> INT_INT_CONSTANT = new HashMap<>();
    private static final Map<Integer, Integer> IDENTITY_CONSTANT = new IdentityHashMap<>();

    private static final Map<Byte, Byte> BYTE_BYTE_CONSTANT = new HashMap<>();
    private static final Map<Character, Character> CHAR_CHAR_CONSTANT = new HashMap<>();
    private static final Map<Double, Double> DOUBLE_DOUBLE_CONSTANT = new HashMap<>();
    private static final Map<Float, Float> FLOAT_FLOAT_CONSTANT = new HashMap<>();
    private static final Map<Long, Long> LONG_LONG_CONSTANT = new HashMap<>();
    private static final Map<Short, Short> SHORT_SHORT_CONSTANT = new HashMap<>();

    private Map<String, String> stringStringField = new HashMap<>();
    private Map<Integer, String> intStringField = new HashMap<>();
    private Map<String, Integer> stringIntField = new HashMap<>();
    private Map<Integer, Integer> intIntField = new HashMap<>();
    private Map<Integer, Integer> identityField = new IdentityHashMap<>();

    public void plain() {
        Map local = new HashMap();
    }

    public void unsafe() {
        Map local = new HashMap<String, String>();
    }

    public void explicit() {
        Map<String, String> local = new HashMap<String, String>();
    }

    public void diamond() {
        Map<String, String> local = new HashMap<>();
    }

    public void qualified() {
        java.util.Map<String, String> local = new java.util.HashMap<>();
    }

    public void anonymous() {
        Map<String, String> local = new HashMap<String, String>() {{
        }};
    }

    public void explicitClass() {
        HashMap<String, String> local = new HashMap<>();
    }

    public void finalLocal() {
        final Map<String, String> local = new HashMap<>();
    }

    public void intString() {
        Map<Integer, String> local = new HashMap<Integer, String>();
    }

    public void stringInt() {
        Map<String, Integer> local = new HashMap<String, Integer>();
    }

    public void intInt() {
        Map<Integer, Integer> local = new HashMap<Integer, Integer>();
    }

    public void identity() {
        Map<String, String> local = new IdentityHashMap<>();
    }

    public void constructor() {
        Map<Integer, Integer> local = new IdentityHashMap<>(0);
    }

    public Map<Integer, Integer> returnIntInt() {
        return new HashMap<Integer, Integer>();
    }

    public Map<Integer, String> returnIntObject() {
        return new HashMap<Integer, String>();
    }

    public Map<String, Integer> returnObjectInt() {
        return new HashMap<String, Integer>();
    }
}
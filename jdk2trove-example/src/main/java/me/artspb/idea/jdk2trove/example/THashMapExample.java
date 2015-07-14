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

    private Map<String, String> field = new HashMap<>();

    public void empty() {
        Map local = new HashMap();
    }

    public void unsafe() {
        Map local = new HashMap<String, String>();
    }

    public void old() {
        Map<String, String> local = new HashMap<String, String>();
    }

    public void diamond() {
        Map<String, String> local = new HashMap<>();
    }

    public void qualified() {
        Map<String, String> local = new java.util.HashMap<>();
    }

    public void anonymous() {
        Map<String, String> local = new HashMap<String, String>() {{}};
    }

    public void exactClass() {
        HashMap<String, String> local = new HashMap<>(0);
    }

    public void finalLocal() {
        final Map<String, String> local = new HashMap<>();
    }

    public void intObject() {
        java.util.Map<Integer, String> local = new HashMap<Integer, String>();
    }

    public void objectInt() {
        java.util.Map<String, Integer> local = new HashMap<String, Integer>();
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
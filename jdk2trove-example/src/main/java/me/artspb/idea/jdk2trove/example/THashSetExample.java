package me.artspb.idea.jdk2trove.example;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author Artem Khvastunov
 */
public class THashSetExample {

    private static final Set<String> STRING_CONSTANT = new HashSet<>();
    private static final Set<Integer> INT_CONSTANT = new HashSet<>();

    private Set<String> field = new HashSet<>();

    public void empty() {
        Set local = new HashSet();
    }

    public void unsafe() {
        Set local = new HashSet<String>();
    }

    public void old() {
        Set<String> local = new HashSet<String>();
    }

    public void diamond() {
        Set<String> local = new HashSet<>();
    }

    public void qualified() {
        Set<String> local = new java.util.HashSet<>();
    }

    public void anonymous() {
        Set<String> local = new HashSet<String>() {{}};
    }

    public void exactClass() {
        HashSet<String> local = new HashSet<>(0);
    }

    public void finalLocal() {
        final Set<String> local = new HashSet<>();
    }

    public void intLocal() {
        Set<Integer> local = new HashSet<Integer>();
    }

    public void linked() {
        Set<String> local = new LinkedHashSet<>();
    }

    public Set<Integer> returnLocal() {
        return new HashSet<Integer>();
    }
}
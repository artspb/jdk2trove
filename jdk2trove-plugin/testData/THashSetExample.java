import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class THashSetExample {

    <warning descr="Inefficient collection use">private static final Set<String> STRING_CONSTANT = new HashSet<>();</warning>
    <warning descr="Inefficient collection use">private static final Set<Integer> INT_CONSTANT = new HashSet<>();</warning>

    <warning descr="Inefficient collection use">private Set<String> stringField = new HashSet<>();</warning>
    <warning descr="Inefficient collection use">private Set<Integer> intField = new HashSet<>();</warning>

    public void plain() {
        <warning descr="Inefficient collection use">Set local = new HashSet();</warning>
    }

    public void unsafe() {
        <warning descr="Inefficient collection use">Set local = new HashSet<String>();</warning>
    }

    public void explicit() {
        <warning descr="Inefficient collection use">Set<String> local = new HashSet<String>();</warning>
    }

    public void diamond() {
        <warning descr="Inefficient collection use">Set<String> local = new HashSet<>();</warning>
    }

    public void qualified() {
        <warning descr="Inefficient collection use">java.util.Set<String> local = new java.util.HashSet<>();</warning>
    }

    public void anonymous() {
        <warning descr="Inefficient collection use">Set<String> local = new HashSet<String>() {{
        }};</warning>
    }

    public void explicitClass() {
        <warning descr="Inefficient collection use">HashSet<String> local = new HashSet<>();</warning>
    }

    public void finalLocal() {
        <warning descr="Inefficient collection use">final Set<String> local = new HashSet<>();</warning>
    }

    public void intLocal() {
        <warning descr="Inefficient collection use">Set<Integer> local = new HashSet<Integer>();</warning>
    }

    public void linked() {
        <warning descr="Inefficient collection use">Set<String> local = new LinkedHashSet<>();</warning>
    }

    public Set<Integer> returnLocal() {
        return new HashSet<Integer>();
    }
}
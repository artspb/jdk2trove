import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;

public class THashMapExample {

    <warning descr="Inefficient collection use">private static final Map<String, String> STRING_STRING_CONSTANT = new HashMap<>();</warning>
    <warning descr="Inefficient collection use">private static final Map<Integer, String> INT_STRING_CONSTANT = new HashMap<>();</warning>
    <warning descr="Inefficient collection use">private static final Map<String, Integer> STRING_INT_CONSTANT = new HashMap<>();</warning>
    <warning descr="Inefficient collection use">private static final Map<Integer, Integer> INT_INT_CONSTANT = new HashMap<>();</warning>

    <warning descr="Inefficient collection use">private Map<String, String> field = new HashMap<>();</warning>

    public void empty() {
        <warning descr="Inefficient collection use">Map local = new HashMap();</warning>
    }

    public void unsafe() {
        <warning descr="Inefficient collection use">Map local = new HashMap<String, String>();</warning>
    }

    public void old() {
        <warning descr="Inefficient collection use">Map<String, String> local = new HashMap<String, String>();</warning>
    }

    public void diamond() {
        <warning descr="Inefficient collection use">Map<String, String> local = new HashMap<>();</warning>
    }

    public void qualified() {
        <warning descr="Inefficient collection use">Map<String, String> local = new HashMap<>();</warning>
    }

    public void anonymous() {
        <warning descr="Inefficient collection use">Map<String, String> local = new HashMap<String, String>() {{
        }};</warning>
    }

    public void exactClass() {
        <warning descr="Inefficient collection use">HashMap<String, String> local = new HashMap<>();</warning>
    }

    public void finalLocal() {
        <warning descr="Inefficient collection use">final Map<String, String> local = new HashMap<>();</warning>
    }

    public void intObject() {
        <warning descr="Inefficient collection use">Map<Integer, String> local = new HashMap<Integer, String>();</warning>
    }

    public void objectInt() {
        <warning descr="Inefficient collection use">Map<String, Integer> local = new HashMap<String, Integer>();</warning>
    }

    public void intInt() {
        <warning descr="Inefficient collection use">Map<Integer, Integer> local = new HashMap<Integer, Integer>();</warning>
    }

    public void identity() {
        <warning descr="Inefficient collection use">Map<String, String> local = new IdentityHashMap<>();</warning>
    }
}
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;

public class THashMapExample {

    <warning descr="Inefficient collection use">private static final Map<String, String> STRING_STRING_CONSTANT = new HashMap<>();</warning>
    <warning descr="Inefficient collection use">private static final Map<Integer, String> INT_STRING_CONSTANT = new HashMap<>();</warning>
    <warning descr="Inefficient collection use">private static final Map<String, Integer> STRING_INT_CONSTANT = new HashMap<>();</warning>
    <warning descr="Inefficient collection use">private static final Map<Integer, Integer> INT_INT_CONSTANT = new HashMap<>();</warning>
    <warning descr="Inefficient collection use">private static final Map<Integer, Integer> IDENTITY_CONSTANT = new IdentityHashMap<>();</warning>

    <warning descr="Inefficient collection use">private static final Map<Byte, Byte> BYTE_BYTE_CONSTANT = new HashMap<>();</warning>
    <warning descr="Inefficient collection use">private static final Map<Character, Character> CHAR_CHAR_CONSTANT = new HashMap<>();</warning>
    <warning descr="Inefficient collection use">private static final Map<Double, Double> DOUBLE_DOUBLE_CONSTANT = new HashMap<>();</warning>
    <warning descr="Inefficient collection use">private static final Map<Float, Float> FLOAT_FLOAT_CONSTANT = new HashMap<>();</warning>
    <warning descr="Inefficient collection use">private static final Map<Long, Long> LONG_LONG_CONSTANT = new HashMap<>();</warning>
    <warning descr="Inefficient collection use">private static final Map<Short, Short> SHORT_SHORT_CONSTANT = new HashMap<>();</warning>

    <warning descr="Inefficient collection use">private Map<String, String> stringStringField = new HashMap<>();</warning>
    <warning descr="Inefficient collection use">private Map<Integer, String> intStringField = new HashMap<>();</warning>
    <warning descr="Inefficient collection use">private Map<String, Integer> stringIntField = new HashMap<>();</warning>
    <warning descr="Inefficient collection use">private Map<Integer, Integer> intIntField = new HashMap<>();</warning>
    <warning descr="Inefficient collection use">private Map<Integer, Integer> identityField = new IdentityHashMap<>();</warning>

    public void plain() {
        <warning descr="Inefficient collection use">Map local = new HashMap();</warning>
    }

    public void unsafe() {
        <warning descr="Inefficient collection use">Map local = new HashMap<String, String>();</warning>
    }

    public void explicit() {
        <warning descr="Inefficient collection use">Map<String, String> local = new HashMap<String, String>();</warning>
    }

    public void diamond() {
        <warning descr="Inefficient collection use">Map<String, String> local = new HashMap<>();</warning>
    }

    public void qualified() {
        <warning descr="Inefficient collection use">java.util.Map<String, String> local = new java.util.HashMap<>();</warning>
    }

    public void anonymous() {
        <warning descr="Inefficient collection use">Map<String, String> local = new HashMap<String, String>() {{
        }};</warning>
    }

    public void explicitClass() {
        <warning descr="Inefficient collection use">HashMap<String, String> local = new HashMap<>();</warning>
    }

    public void finalLocal() {
        <warning descr="Inefficient collection use">final Map<String, String> local = new HashMap<>();</warning>
    }

    public void intString() {
        <warning descr="Inefficient collection use">Map<Integer, String> local = new HashMap<Integer, String>();</warning>
    }

    public void stringInt() {
        <warning descr="Inefficient collection use">Map<String, Integer> local = new HashMap<String, Integer>();</warning>
    }

    public void intInt() {
        <warning descr="Inefficient collection use">Map<Integer, Integer> local = new HashMap<Integer, Integer>();</warning>
    }

    public void identity() {
        <warning descr="Inefficient collection use">Map<String, String> local = new IdentityHashMap<>();</warning>
    }

    public void constructor() {
        <warning descr="Inefficient collection use">Map<Integer, Integer> local = new IdentityHashMap<>(0);</warning>
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
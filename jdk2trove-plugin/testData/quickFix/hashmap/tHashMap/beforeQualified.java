// "Use Trove THashMap (may change semantics)"

public class THashMapExample {
    public void qualified() {
        <caret>java.util.Map<String, String> local = new java.util.HashMap<>();
    }
}
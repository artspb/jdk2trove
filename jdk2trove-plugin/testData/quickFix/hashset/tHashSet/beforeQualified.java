// "Use Trove THashSet (may change semantics)"

public class THashSetExample {
    public void qualified() {
        <caret>java.util.Set<String> local = new java.util.HashSet<>();
    }
}
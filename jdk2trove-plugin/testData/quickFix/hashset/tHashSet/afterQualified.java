// "Use Trove THashSet (may change semantics)"

import gnu.trove.set.hash.THashSet;

import java.util.Set;

public class THashSetExample {
    public void qualified() {
        <caret>Set<String> local = new THashSet<>();
    }
}
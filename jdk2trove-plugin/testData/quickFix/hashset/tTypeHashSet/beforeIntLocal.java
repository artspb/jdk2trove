// "Use Trove TIntHashSet (may change semantics)"

import java.util.HashSet;
import java.util.Set;

public class THashSetExample {
    public void intLocal() {
        <caret>Set<Integer> local = new HashSet<Integer>();
    }
}
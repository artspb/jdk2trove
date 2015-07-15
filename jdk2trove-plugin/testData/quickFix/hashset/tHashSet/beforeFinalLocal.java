// "Use Trove THashSet (may change semantics)"

import java.util.HashSet;
import java.util.Set;

public class THashSetExample {
    public void finalLocal() {
        <caret>final Set<String> local = new HashSet<>();
    }
}
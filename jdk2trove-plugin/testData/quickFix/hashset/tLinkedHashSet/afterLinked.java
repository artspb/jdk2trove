// "Use Trove TLinkedHashSet (may change semantics)"

import gnu.trove.set.hash.TLinkedHashSet;

import java.util.LinkedHashSet;
import java.util.Set;

public class THashSetExample {
    public void linked() {
        <caret>Set<String> local = new TLinkedHashSet<>();
    }
}
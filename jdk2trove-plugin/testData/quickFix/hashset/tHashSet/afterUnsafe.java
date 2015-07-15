// "Use Trove THashSet (may change semantics)"

import gnu.trove.set.hash.THashSet;

import java.util.HashSet;
import java.util.Set;

public class THashSetExample {
    public void unsafe() {
        <caret>Set local = new THashSet<String>();
    }
}
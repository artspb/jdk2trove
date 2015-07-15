// "Use Trove TIntHashSet (may change semantics)"

import gnu.trove.set.TIntSet;
import gnu.trove.set.hash.TIntHashSet;

import java.util.HashSet;
import java.util.Set;

public class THashSetExample {
    <caret>private TIntSet intField = new TIntHashSet();
}
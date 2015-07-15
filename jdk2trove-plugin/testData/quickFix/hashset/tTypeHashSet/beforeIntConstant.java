// "Use Trove TIntHashSet (may change semantics)"

import java.util.HashSet;
import java.util.Set;

public class THashSetExample {
    <caret>private static final Set<Integer> INT_CONSTANT = new HashSet<>();
}
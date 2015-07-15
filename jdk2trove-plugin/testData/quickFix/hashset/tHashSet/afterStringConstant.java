// "Use Trove THashSet (may change semantics)"

import gnu.trove.set.hash.THashSet;

import java.util.HashSet;
import java.util.Set;

public class THashSetExample {
    <caret>private static final Set<String> STRING_CONSTANT = new THashSet<>();
}
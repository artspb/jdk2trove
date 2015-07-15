// "Use Trove TCustomHashMap (may change semantics)"

import java.util.IdentityHashMap;
import java.util.Map;

public class THashMapExample {
    <caret>private static final Map<Integer, Integer> IDENTITY_CONSTANT = new IdentityHashMap<>();
}
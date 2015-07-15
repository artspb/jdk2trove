// "Use Trove TCustomHashMap (may change semantics)"

import java.util.IdentityHashMap;
import java.util.Map;

public class THashMapExample {
    <caret>private Map<Integer, Integer> identityField = new IdentityHashMap<>();
}
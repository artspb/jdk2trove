// "Use Trove TCustomHashMap (may change semantics)"

import java.util.IdentityHashMap;
import java.util.Map;

public class THashMapExample {
    public void constructor() {
        <caret>Map<Integer, Integer> local = new IdentityHashMap<>(0);
    }
}
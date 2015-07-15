// "Use Trove TCustomHashMap (may change semantics)"

import gnu.trove.map.hash.TCustomHashMap;
import gnu.trove.strategy.IdentityHashingStrategy;

import java.util.IdentityHashMap;
import java.util.Map;

public class THashMapExample {
    public void constructor() {
        <caret>Map<Integer, Integer> local = new TCustomHashMap<>(IdentityHashingStrategy.INSTANCE, 0);
    }
}
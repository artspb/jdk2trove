// "Use Trove TCustomHashMap (may change semantics)"

import gnu.trove.map.hash.TCustomHashMap;
import gnu.trove.strategy.IdentityHashingStrategy;

import java.util.IdentityHashMap;
import java.util.Map;

public class THashMapExample {
    <caret>private Map<Integer, Integer> identityField = new TCustomHashMap<>(IdentityHashingStrategy.INSTANCE);
}
// "Use Trove TCustomHashMap (may change semantics)"

import java.util.IdentityHashMap;
import java.util.Map;

public class THashMapExample {
    public void identity() {
        <caret>Map<String, String> local = new IdentityHashMap<>();
    }
}
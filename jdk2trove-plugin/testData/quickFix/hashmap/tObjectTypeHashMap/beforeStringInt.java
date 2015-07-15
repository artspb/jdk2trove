// "Use Trove TObjectIntHashMap (may change semantics)"

import java.util.HashMap;
import java.util.Map;

public class THashMapExample {
    public void stringInt() {
        <caret>Map<String, Integer> local = new HashMap<String, Integer>();
    }
}
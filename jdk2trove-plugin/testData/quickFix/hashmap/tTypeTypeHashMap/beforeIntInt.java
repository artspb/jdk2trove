// "Use Trove TIntIntHashMap (may change semantics)"

import java.lang.Integer;
import java.util.HashMap;
import java.util.Map;

public class THashMapExample {
    public void intInt() {
        <caret>Map<Integer, Integer> local = new HashMap<Integer, Integer>();
    }
}
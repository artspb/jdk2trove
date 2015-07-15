// "Use Trove TIntObjectHashMap (may change semantics)"

import java.util.HashMap;
import java.util.Map;

public class THashMapExample {
    public void intString() {
        <caret>Map<Integer, String> local = new HashMap<Integer, String>();
    }
}
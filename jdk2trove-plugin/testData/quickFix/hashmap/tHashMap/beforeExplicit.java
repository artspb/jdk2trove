// "Use Trove THashMap (may change semantics)"

import java.util.HashMap;
import java.util.Map;

public class THashMapExample {
    public void explicit() {
        <caret>Map<String, String> local = new HashMap<String, String>();
    }
}
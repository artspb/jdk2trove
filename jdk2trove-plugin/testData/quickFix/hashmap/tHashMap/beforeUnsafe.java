// "Use Trove THashMap (may change semantics)"

import java.util.HashMap;
import java.util.Map;

public class THashMapExample {
    public void unsafe() {
        <caret>Map local = new HashMap<String, String>();
    }
}
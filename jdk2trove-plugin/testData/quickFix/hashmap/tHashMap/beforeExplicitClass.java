// "Use Trove THashMap (may change semantics)"

import java.util.HashMap;
import java.util.Map;

public class THashMapExample {
    public void explicitClass() {
        <caret>HashMap<String, String> local = new HashMap<>();
    }
}
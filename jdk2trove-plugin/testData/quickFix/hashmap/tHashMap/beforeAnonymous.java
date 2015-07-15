// "Use Trove THashMap (may change semantics)"

import java.util.HashMap;
import java.util.Map;

public class THashMapExample {
    public void anonymous() {
        <caret>Map<String, String> local = new HashMap<String, String>() {{
        }};
    }
}
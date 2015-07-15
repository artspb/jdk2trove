// "Use Trove THashMap (may change semantics)"

import java.util.HashMap;
import java.util.Map;

public class THashMapExample {
    public void plain() {
        <caret>Map local = new HashMap();
    }
}
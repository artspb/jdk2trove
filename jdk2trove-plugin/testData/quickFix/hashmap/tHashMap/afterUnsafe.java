// "Use Trove THashMap (may change semantics)"

import gnu.trove.map.hash.THashMap;

import java.util.HashMap;
import java.util.Map;

public class THashMapExample {
    public void unsafe() {
        <caret>Map local = new THashMap<String, String>();
    }
}
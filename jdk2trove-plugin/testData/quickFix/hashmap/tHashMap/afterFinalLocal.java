// "Use Trove THashMap (may change semantics)"

import gnu.trove.map.hash.THashMap;

import java.util.HashMap;
import java.util.Map;

public class THashMapExample {
    public void finalLocal() {
        <caret>final Map<String, String> local = new THashMap<>();
    }
}
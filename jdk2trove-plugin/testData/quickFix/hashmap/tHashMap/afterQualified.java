// "Use Trove THashMap (may change semantics)"

import gnu.trove.map.hash.THashMap;

import java.util.Map;

public class THashMapExample {
    public void qualified() {
        <caret>Map<String, String> local = new THashMap<>();
    }
}
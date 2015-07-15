// "Use Trove THashMap (may change semantics)"

import gnu.trove.map.hash.THashMap;

import java.util.HashMap;
import java.util.Map;

public class THashMapExample {
    <caret>private Map<String, String> stringStringField = new THashMap<>();
}
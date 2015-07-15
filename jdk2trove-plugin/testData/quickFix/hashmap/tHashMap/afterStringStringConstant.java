// "Use Trove THashMap (may change semantics)"

import gnu.trove.map.hash.THashMap;

import java.util.HashMap;
import java.util.Map;

public class THashMapExample {
    <caret>private static final Map<String, String> STRING_STRING_CONSTANT = new THashMap<>();
}
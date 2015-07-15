// "Use Trove TObjectIntHashMap (may change semantics)"

import java.util.HashMap;
import java.util.Map;

public class THashMapExample {
    <caret>private Map<String, Integer> stringIntField = new HashMap<>();
}
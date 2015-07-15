// "Use Trove TIntIntHashMap (may change semantics)"

import java.lang.Integer;
import java.util.HashMap;
import java.util.Map;

public class THashMapExample {
    <caret>private Map<Integer, Integer> intIntField = new HashMap<>();
}
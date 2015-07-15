// "Use Trove TIntIntHashMap (may change semantics)"

import java.lang.Integer;
import java.util.HashMap;
import java.util.Map;

public class THashMapExample {
    <caret>private static final Map<Integer, Integer> INT_INT_CONSTANT = new HashMap<>();
}
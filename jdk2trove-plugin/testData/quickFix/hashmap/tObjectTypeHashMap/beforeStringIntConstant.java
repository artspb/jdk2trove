// "Use Trove TObjectIntHashMap (may change semantics)"

import java.util.HashMap;
import java.util.Map;

public class THashMapExample {
    <caret>private static final Map<String, Integer> STRING_INT_CONSTANT = new HashMap<>();
}
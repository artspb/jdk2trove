// "Use Trove TIntObjectHashMap (may change semantics)"

import java.util.HashMap;
import java.util.Map;

public class THashMapExample {
    <caret>private static final Map<Integer, String> INT_STRING_CONSTANT = new HashMap<>();
}
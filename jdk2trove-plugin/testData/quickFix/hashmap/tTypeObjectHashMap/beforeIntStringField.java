// "Use Trove TIntObjectHashMap (may change semantics)"

import java.util.HashMap;
import java.util.Map;

public class THashMapExample {
    <caret>private Map<Integer, String> intStringField = new HashMap<>();
}
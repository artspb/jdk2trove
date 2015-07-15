// "Use Trove THashMap (may change semantics)"

import java.util.HashMap;
import java.util.Map;

public class THashMapExample {
    <caret>private Map<String, String> stringStringField = new HashMap<>();
}
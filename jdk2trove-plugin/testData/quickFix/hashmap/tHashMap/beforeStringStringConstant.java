// "Use Trove THashMap (may change semantics)"

import java.util.HashMap;
import java.util.Map;

public class THashMapExample {
    <caret>private static final Map<String, String> STRING_STRING_CONSTANT = new HashMap<>();
}
// "Use Trove TShortShortHashMap (may change semantics)"

import java.lang.Short;
import java.util.HashMap;
import java.util.Map;

public class THashMapExample {
    <caret>private static final Map<Short, Short> INT_INT_CONSTANT = new HashMap<>();
}
// "Use Trove TLongLongHashMap (may change semantics)"

import java.lang.Long;
import java.util.HashMap;
import java.util.Map;

public class THashMapExample {
    <caret>private static final Map<Long, Long> INT_INT_CONSTANT = new HashMap<>();
}
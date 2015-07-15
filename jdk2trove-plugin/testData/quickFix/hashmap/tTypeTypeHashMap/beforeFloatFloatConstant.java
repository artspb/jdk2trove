// "Use Trove TFloatFloatHashMap (may change semantics)"

import java.lang.Float;
import java.util.HashMap;
import java.util.Map;

public class THashMapExample {
    <caret>private static final Map<Float, Float> INT_INT_CONSTANT = new HashMap<>();
}
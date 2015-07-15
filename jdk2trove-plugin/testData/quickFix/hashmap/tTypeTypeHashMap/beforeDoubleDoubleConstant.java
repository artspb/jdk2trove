// "Use Trove TDoubleDoubleHashMap (may change semantics)"

import java.lang.Double;
import java.util.HashMap;
import java.util.Map;

public class THashMapExample {
    <caret>private static final Map<Double, Double> INT_INT_CONSTANT = new HashMap<>();
}
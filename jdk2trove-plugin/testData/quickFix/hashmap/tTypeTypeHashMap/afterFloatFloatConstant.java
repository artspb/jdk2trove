// "Use Trove TFloatFloatHashMap (may change semantics)"

import gnu.trove.map.TFloatFloatMap;
import gnu.trove.map.hash.TFloatFloatHashMap;

import java.lang.Float;
import java.util.HashMap;
import java.util.Map;

public class THashMapExample {
    <caret>private static final TFloatFloatMap INT_INT_CONSTANT = new TFloatFloatHashMap();
}
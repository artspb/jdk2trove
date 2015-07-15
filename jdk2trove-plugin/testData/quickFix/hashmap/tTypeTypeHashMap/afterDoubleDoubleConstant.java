// "Use Trove TDoubleDoubleHashMap (may change semantics)"

import gnu.trove.map.TDoubleDoubleMap;
import gnu.trove.map.hash.TDoubleDoubleHashMap;

import java.lang.Double;
import java.util.HashMap;
import java.util.Map;

public class THashMapExample {
    <caret>private static final TDoubleDoubleMap INT_INT_CONSTANT = new TDoubleDoubleHashMap();
}
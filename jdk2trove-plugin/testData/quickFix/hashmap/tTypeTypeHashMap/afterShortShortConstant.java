// "Use Trove TShortShortHashMap (may change semantics)"

import gnu.trove.map.TShortShortMap;
import gnu.trove.map.hash.TShortShortHashMap;

import java.lang.Short;
import java.util.HashMap;
import java.util.Map;

public class THashMapExample {
    <caret>private static final TShortShortMap INT_INT_CONSTANT = new TShortShortHashMap();
}
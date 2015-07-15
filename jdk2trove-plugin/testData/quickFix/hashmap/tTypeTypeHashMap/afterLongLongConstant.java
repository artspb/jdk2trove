// "Use Trove TLongLongHashMap (may change semantics)"

import gnu.trove.map.TLongLongMap;
import gnu.trove.map.hash.TLongLongHashMap;

import java.lang.Long;
import java.util.HashMap;
import java.util.Map;

public class THashMapExample {
    <caret>private static final TLongLongMap INT_INT_CONSTANT = new TLongLongHashMap();
}
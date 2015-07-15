// "Use Trove TByteByteHashMap (may change semantics)"

import gnu.trove.map.TByteByteMap;
import gnu.trove.map.hash.TByteByteHashMap;

import java.lang.Byte;
import java.util.HashMap;
import java.util.Map;

public class THashMapExample {
    <caret>private static final TByteByteMap INT_INT_CONSTANT = new TByteByteHashMap();
}
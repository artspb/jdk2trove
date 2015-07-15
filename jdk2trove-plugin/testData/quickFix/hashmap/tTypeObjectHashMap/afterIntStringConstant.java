// "Use Trove TIntObjectHashMap (may change semantics)"

import gnu.trove.map.TIntObjectMap;
import gnu.trove.map.hash.TIntObjectHashMap;

import java.util.HashMap;
import java.util.Map;

public class THashMapExample {
    <caret>private static final TIntObjectMap<String> INT_STRING_CONSTANT = new TIntObjectHashMap<>();
}
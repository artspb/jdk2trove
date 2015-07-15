// "Use Trove TIntObjectHashMap (may change semantics)"

import gnu.trove.map.TIntObjectMap;
import gnu.trove.map.hash.TIntObjectHashMap;

import java.util.HashMap;
import java.util.Map;

public class THashMapExample {
    <caret>private TIntObjectMap<String> intStringField = new TIntObjectHashMap<>();
}
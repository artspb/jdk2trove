// "Use Trove TObjectIntHashMap (may change semantics)"

import gnu.trove.map.TObjectIntMap;
import gnu.trove.map.hash.TObjectIntHashMap;

import java.util.HashMap;
import java.util.Map;

public class THashMapExample {
    <caret>private static final TObjectIntMap<String> STRING_INT_CONSTANT = new TObjectIntHashMap<>();
}
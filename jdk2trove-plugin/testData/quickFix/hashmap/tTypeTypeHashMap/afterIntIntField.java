// "Use Trove TIntIntHashMap (may change semantics)"

import gnu.trove.map.TIntIntMap;
import gnu.trove.map.hash.TIntIntHashMap;

import java.lang.Integer;
import java.util.HashMap;
import java.util.Map;

public class THashMapExample {
    <caret>private TIntIntMap intIntField = new TIntIntHashMap();
}
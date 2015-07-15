// "Use Trove TObjectIntHashMap (may change semantics)"

import gnu.trove.map.TObjectIntMap;
import gnu.trove.map.hash.TObjectIntHashMap;

import java.util.HashMap;
import java.util.Map;

public class THashMapExample {
    public void stringInt() {
        <caret>TObjectIntMap<String> local = new TObjectIntHashMap<String>();
    }
}
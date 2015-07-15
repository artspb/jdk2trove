// "Use Trove TIntIntHashMap (may change semantics)"

import gnu.trove.map.TIntIntMap;
import gnu.trove.map.hash.TIntIntHashMap;

import java.lang.Integer;
import java.util.HashMap;
import java.util.Map;

public class THashMapExample {
    public void intInt() {
        <caret>TIntIntMap local = new TIntIntHashMap();
    }
}
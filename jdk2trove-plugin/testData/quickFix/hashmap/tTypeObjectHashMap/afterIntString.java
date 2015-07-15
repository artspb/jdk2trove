// "Use Trove TIntObjectHashMap (may change semantics)"

import gnu.trove.map.TIntObjectMap;
import gnu.trove.map.hash.TIntObjectHashMap;

import java.util.HashMap;
import java.util.Map;

public class THashMapExample {
    public void intString() {
        <caret>TIntObjectMap<String> local = new TIntObjectHashMap<String>();
    }
}
// "Use Trove TCharCharHashMap (may change semantics)"

import gnu.trove.map.TCharCharMap;
import gnu.trove.map.hash.TCharCharHashMap;

import java.lang.Character;
import java.util.HashMap;
import java.util.Map;

public class THashMapExample {
    <caret>private static final TCharCharMap INT_INT_CONSTANT = new TCharCharHashMap();
}
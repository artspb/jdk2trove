// "Use Trove TCharCharHashMap (may change semantics)"

import java.lang.Character;
import java.util.HashMap;
import java.util.Map;

public class THashMapExample {
    <caret>private static final Map<Character, Character> INT_INT_CONSTANT = new HashMap<>();
}
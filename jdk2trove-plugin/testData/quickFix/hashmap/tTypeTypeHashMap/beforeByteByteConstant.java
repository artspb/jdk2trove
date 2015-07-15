// "Use Trove TByteByteHashMap (may change semantics)"

import java.lang.Byte;
import java.util.HashMap;
import java.util.Map;

public class THashMapExample {
    <caret>private static final Map<Byte, Byte> INT_INT_CONSTANT = new HashMap<>();
}
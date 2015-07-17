package me.artspb.idea.jdk2trove.hashmap;

import com.intellij.codeInspection.BaseJavaLocalInspectionTool;
import me.artspb.idea.jdk2trove.TroveTestCase;

/**
 * @author Artem Khvastunov
 */
public class TCustomHashMapQuickFixTest extends TroveTestCase {

    public void testTCustomHashMap() throws Exception {
        doAllTests("quickFix/hashmap/tCustomHashMap");
    }

    @Override
    public void setUp() throws Exception {
        super.setUp();
    }

    @Override
    protected BaseJavaLocalInspectionTool[] getInspections() {
        return new BaseJavaLocalInspectionTool[] {new THashMapCreationInspection()};
    }

    @Override
    protected String[] getUserClasses() {
        return new String[] {
                "package gnu.trove.map.hash;" +
                "import gnu.trove.map.TMap;" +
                "import gnu.trove.strategy.HashingStrategy;" +
                "public class TCustomHashMap<K, V> implements TMap<K, V> {" +
                    "public TCustomHashMap(HashingStrategy<? super K> strategy) {}" +
                    "public TCustomHashMap(HashingStrategy<? super K> strategy, int capacity) {}" +
                "}",

                "package gnu.trove.strategy;" +
                "public interface HashingStrategy<T> {}",

                "package gnu.trove.strategy;" +
                "public class IdentityHashingStrategy<K> implements HashingStrategy<K> {" +
                    "public static final IdentityHashingStrategy<Object> INSTANCE = new IdentityHashingStrategy<Object>();" +
                "}"
        };
    }
}
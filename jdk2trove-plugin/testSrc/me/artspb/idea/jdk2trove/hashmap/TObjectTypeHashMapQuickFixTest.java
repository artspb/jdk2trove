package me.artspb.idea.jdk2trove.hashmap;

import com.intellij.codeInspection.BaseJavaLocalInspectionTool;
import junit.framework.TestCase;
import me.artspb.idea.jdk2trove.TroveTestCase;

/**
 * @author Artem Khvastunov
 */
public class TObjectTypeHashMapQuickFixTest extends TroveTestCase {

    public void testTObjectTypeHashMap() throws Exception {
        doAllTests("quickFix/hashmap/tObjectTypeHashMap");
    }

    @Override
    public void setUp() throws Exception {
        super.setUp();
    }

    @Override
    protected BaseJavaLocalInspectionTool[] getInspections() {
        return new BaseJavaLocalInspectionTool[] {new THashMapInspection()};
    }

    @Override
    protected String[] getUserClasses() {
        return new String[] {
                "package gnu.trove.map;" +
                "public interface TObjectIntMap<K> {}",

                "package gnu.trove.map.hash;" +
                "import gnu.trove.map.TObjectIntMap;" +
                "public class TObjectIntHashMap<K> implements TObjectIntMap<K> {}"
        };
    }
}
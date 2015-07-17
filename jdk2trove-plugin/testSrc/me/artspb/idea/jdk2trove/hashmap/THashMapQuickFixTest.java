package me.artspb.idea.jdk2trove.hashmap;

import com.intellij.codeInspection.BaseJavaLocalInspectionTool;
import me.artspb.idea.jdk2trove.TroveTestCase;

/**
 * @author Artem Khvastunov
 */
public class THashMapQuickFixTest extends TroveTestCase {

    public void testTHashMap() throws Exception {
        doAllTests("quickFix/hashmap/tHashMap");
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    @Override
    protected BaseJavaLocalInspectionTool[] getInspections() {
        return new BaseJavaLocalInspectionTool[]{new THashMapCreationInspection()};
    }

    @Override
    protected String[] getUserClasses() {
        return new String[]{
                "package gnu.trove.map.hash;" +
                "import gnu.trove.map.TMap;" +
                "public class THashMap<K, V> implements TMap<K, V>{}"
        };
    }
}
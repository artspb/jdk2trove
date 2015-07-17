package me.artspb.idea.jdk2trove.hashmap;

import com.intellij.codeInspection.BaseJavaLocalInspectionTool;
import me.artspb.idea.jdk2trove.TroveTestCase;

/**
 * @author Artem Khvastunov
 */
public class TTypeObjectHashMapQuickFixTest extends TroveTestCase {

    public void testTTypeObjectHashMap() throws Exception {
        doAllTests("quickFix/hashmap/tTypeObjectHashMap");
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
        return new String[]{
                "package gnu.trove.map;" +
                "public interface TIntObjectMap<V> {}",

                "package gnu.trove.map.hash;" +
                "import gnu.trove.map.TIntObjectMap;" +
                "public class TIntObjectHashMap<V> implements TIntObjectMap<V> {}"
        };
    }
}
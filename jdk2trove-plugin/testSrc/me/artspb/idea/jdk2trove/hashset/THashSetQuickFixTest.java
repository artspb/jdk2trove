package me.artspb.idea.jdk2trove.hashset;

import com.intellij.codeInspection.BaseJavaLocalInspectionTool;
import me.artspb.idea.jdk2trove.TroveTestCase;

/**
 * @author Artem Khvastunov
 */
public class THashSetQuickFixTest extends TroveTestCase {

    public void testTHashSet() throws Exception {
        doAllTests("quickFix/hashset/tHashSet");
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    @Override
    protected BaseJavaLocalInspectionTool[] getInspections() {
        return new BaseJavaLocalInspectionTool[]{new THashSetInspection()};
    }

    @Override
    protected String[] getUserClasses() {
        return new String[]{
                "package gnu.trove.set.hash;" +
                "import gnu.trove.set.TSet;" +
                "public class THashSet<K, V> implements TSet<K, V>{}"
        };
    }
}
package me.artspb.idea.jdk2trove.hashset;

import com.intellij.codeInspection.BaseJavaLocalInspectionTool;
import junit.framework.TestCase;
import me.artspb.idea.jdk2trove.TroveTestCase;

/**
 * @author Artem Khvastunov
 */
public class TTypeHashSetQuickFixTest extends TroveTestCase {

    public void testTTypeHashSet() throws Exception {
        doAllTests("quickFix/hashset/tTypeHashSet");
    }

    @Override
    public void setUp() throws Exception {
        super.setUp();
    }

    @Override
    protected BaseJavaLocalInspectionTool[] getInspections() {
        return new BaseJavaLocalInspectionTool[] {new THashSetInspection()};
    }

    @Override
    protected String[] getUserClasses() {
        return new String[] {
                "package gnu.trove.set;" +
                "public interface TIntSet {}",

                "package gnu.trove.set.hash;" +
                "import gnu.trove.set.TIntSet;" +
                "public class TIntHashSet implements TIntSet {}"
        };
    }
}
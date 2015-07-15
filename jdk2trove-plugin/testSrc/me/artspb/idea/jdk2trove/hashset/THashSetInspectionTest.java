package me.artspb.idea.jdk2trove.hashset;

import com.intellij.codeInspection.BaseJavaLocalInspectionTool;
import me.artspb.idea.jdk2trove.TroveTestCase;

/**
 * @author Artem Khvastunov
 */
public class THashSetInspectionTest extends TroveTestCase {

    public void testRegisterProblem() {
        myFixture.configureByFile("THashSetExample.java");
        myFixture.checkHighlighting(true, false, false, false);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    @Override
    protected BaseJavaLocalInspectionTool[] getInspections() {
        return new BaseJavaLocalInspectionTool[]{new THashSetInspection()};
    }
}
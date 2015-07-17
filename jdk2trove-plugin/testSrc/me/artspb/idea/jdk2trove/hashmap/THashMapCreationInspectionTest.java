package me.artspb.idea.jdk2trove.hashmap;

import com.intellij.codeInspection.BaseJavaLocalInspectionTool;
import me.artspb.idea.jdk2trove.TroveTestCase;

/**
 * @author Artem Khvastunov
 */
public class THashMapCreationInspectionTest extends TroveTestCase {

    public void testRegisterProblem() {
        myFixture.configureByFile("THashMapExample.java");
        myFixture.checkHighlighting(true, false, false, false);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    @Override
    protected BaseJavaLocalInspectionTool[] getInspections() {
        return new BaseJavaLocalInspectionTool[]{new THashMapCreationInspection()};
    }
}
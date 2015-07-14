package me.artspb.idea.jdk2trove.hashset;

import com.intellij.pom.java.LanguageLevel;
import com.intellij.testFramework.builders.JavaModuleFixtureBuilder;
import com.intellij.testFramework.fixtures.JavaCodeInsightFixtureTestCase;

/**
 * @author Artem Khvastunov
 */
public class THashSetInspectionTest extends JavaCodeInsightFixtureTestCase {

    @Override
    protected String getTestDataPath() {
        return "testData";
    }

    @Override
    protected void tuneFixture(JavaModuleFixtureBuilder moduleBuilder) throws Exception {
        moduleBuilder.setLanguageLevel(LanguageLevel.JDK_1_7);
    }

    @Override
    public void setUp() throws Exception {
        super.setUp();
        myFixture.enableInspections(new THashSetInspection());
        myFixture.addClass(
                "package java.util;" +
                "public interface Set<E> {}"
        );
        myFixture.addClass(
                "package java.util;" +
                "public class HashSet<E> implements Set<E>{}"
        );
        myFixture.addClass(
                "package java.util;" +
                "public class LinkedHashSet<E> implements Set<E>{}"
        );
        myFixture.addClass(
                "package java.lang;" +
                "public final class Integer {}"
        );
        myFixture.addClass(
                "package java.lang;" +
                "public final class String {}"
        );
    }

    public void testRegisterProblem() {
        myFixture.configureByFiles("THashSetExample.java");
        myFixture.checkHighlighting(true, false, false, false);
    }
}
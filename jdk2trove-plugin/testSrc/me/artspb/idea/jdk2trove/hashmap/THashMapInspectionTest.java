package me.artspb.idea.jdk2trove.hashmap;

import com.intellij.pom.java.LanguageLevel;
import com.intellij.testFramework.builders.JavaModuleFixtureBuilder;
import com.intellij.testFramework.fixtures.JavaCodeInsightFixtureTestCase;

/**
 * @author Artem Khvastunov
 */
public class THashMapInspectionTest extends JavaCodeInsightFixtureTestCase {

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
        myFixture.enableInspections(new THashMapInspection());
        myFixture.addClass(
                "package java.util;" +
                "public interface Map<K,V> {}"
        );
        myFixture.addClass(
                "package java.util;" +
                "public class HashMap<K,V> implements Map<K,V>{}"
        );
        myFixture.addClass(
                "package java.util;" +
                "public class IdentityHashMap<K,V> implements Map<K,V>{}"
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
        myFixture.configureByFiles("THashMapExample.java");
        myFixture.checkHighlighting(true, false, false, false);
    }
}
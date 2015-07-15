package me.artspb.idea.jdk2trove;

import com.intellij.codeInsight.intention.IntentionAction;
import com.intellij.codeInspection.BaseJavaLocalInspectionTool;
import com.intellij.openapi.util.io.FileUtil;
import com.intellij.openapi.vfs.CharsetToolkit;
import com.intellij.pom.java.LanguageLevel;
import com.intellij.testFramework.builders.JavaModuleFixtureBuilder;
import com.intellij.testFramework.fixtures.JavaCodeInsightFixtureTestCase;
import com.intellij.util.ArrayUtil;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Artem Khvastunov
 */
abstract public class TroveTestCase extends JavaCodeInsightFixtureTestCase {

    private static final Pattern HINT_PATTERN = Pattern.compile("// \"(.*)\"");

    private static final String BEFORE = "before";
    private static final String AFTER = "after";

    private static final String[] ENVIRONMENT_CLASSES = new String[]{
            "package java.lang;" +
            "public final class Integer {}",

            "package java.lang;" +
            "public final class Byte {}",

            "package java.lang;" +
            "public final class Character {}",

            "package java.lang;" +
            "public final class Double {}",

            "package java.lang;" +
            "public final class Float {}",

            "package java.lang;" +
            "public final class Long {}",

            "package java.lang;" +
            "public final class Short {}",

            "package java.lang;" +
            "public final class String {}",

            "package java.util;" +
            "public interface Map<K,V> {}",

            "package java.util;" +
            "public class HashMap<K,V> implements Map<K,V>{}",

            "package java.util;" +
            "public class IdentityHashMap<K,V> implements Map<K,V>{" +
                "public IdentityHashMap() {}" +
                "public IdentityHashMap(int size) {}" +
            "}",

            "package java.util;" +
            "public interface Set<E> {}",

            "package java.util;" +
            "public class HashSet<E> implements Set<E>{}",

            "package java.util;" +
            "public class LinkedHashSet<E> implements Set<E>{}"
    };

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        for (String environmentClass : ENVIRONMENT_CLASSES) {
            myFixture.addClass(environmentClass);
        }
        for (String environmentClass : getUserClasses()) {
            myFixture.addClass(environmentClass);
        }
        myFixture.enableInspections(getInspections());
    }

    protected String[] getUserClasses() {
        return ArrayUtil.EMPTY_STRING_ARRAY;
    }

    abstract protected BaseJavaLocalInspectionTool[] getInspections();

    protected void doAllTests(@NotNull String relativePath) throws Exception {
        File testDir = new File(getFullPath(relativePath));
        File[] files = testDir.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, @NonNls String name) {
                return name.startsWith(BEFORE);
            }
        });
        if (files == null || files.length == 0) {
            fail("Test files not found in " + relativePath);
        }
        for (File file : files) {
            String testName = file.getName().substring(BEFORE.length());
            doTest(relativePath, testName);
        }
    }

    protected void doTest(@NotNull String relativePath, @NotNull String testName) throws Exception {
        myFixture.configureByFile(relativePath + "/" + BEFORE + testName);
        IntentionAction action = findAction(relativePath, testName);
        myFixture.launchAction(action);
        myFixture.checkResultByFile(relativePath + "/" + AFTER + testName);
    }

    @NotNull
    private IntentionAction findAction(@NotNull String relativePath, @NotNull String testName) throws IOException {
        String hint = parseHint(relativePath, testName);
        List<IntentionAction> actions = findIntention(hint);
        if (actions.isEmpty()) {
            fail("\"" + hint + "\" is not found for " + testName);
        } else if (actions.size() > 1) {
            fail("Too many quick fixes found for \"" + hint + "\": " + actions + "] " + testName);
        }
        return actions.get(0);
    }

    @NotNull
    private String parseHint(@NotNull String relativePath, @NotNull String testName) throws IOException {
        String testFullPath = getFullPath(relativePath) + "/" + BEFORE + testName;
        File testFile = new File(testFullPath);
        List<String> lines = FileUtil.loadLines(testFile, CharsetToolkit.UTF8);
        assertFalse("Test file " + testFullPath + " must not be empty", lines.isEmpty());
        Matcher matcher = HINT_PATTERN.matcher(lines.get(0));
        if (!matcher.matches()) {
            fail("Test file " + testFullPath + " has incorrect format, hint has not been found");
        }
        return matcher.group(1);
    }

    @NotNull
    private String getFullPath(@NotNull String relativePath) {
        return getTestDataPath() + "/" + relativePath;
    }

    protected List<IntentionAction> findIntention(@NotNull final String hint) {
        return myFixture.filterAvailableIntentions(hint);
    }

    @Override
    protected void tuneFixture(JavaModuleFixtureBuilder moduleBuilder) throws Exception {
        moduleBuilder.setLanguageLevel(LanguageLevel.JDK_1_7);
    }

    @Override
    protected String getTestDataPath() {
        return "testData";
    }
}

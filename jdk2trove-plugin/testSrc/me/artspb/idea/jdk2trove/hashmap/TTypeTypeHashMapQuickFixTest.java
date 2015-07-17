package me.artspb.idea.jdk2trove.hashmap;

import com.intellij.codeInspection.BaseJavaLocalInspectionTool;
import me.artspb.idea.jdk2trove.TroveTestCase;

/**
 * @author Artem Khvastunov
 */
public class TTypeTypeHashMapQuickFixTest extends TroveTestCase {

    public void testTTypeTypeHashMap() throws Exception {
        doAllTests("quickFix/hashmap/tTypeTypeHashMap");
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
        return new String[] {
                "package gnu.trove.map;" +
                "public interface TIntIntMap {}",

                "package gnu.trove.map.hash;" +
                "import gnu.trove.map.TIntIntMap;" +
                "public class TIntIntHashMap implements TIntIntMap {}",

                "package gnu.trove.map;" +
                "public interface TByteByteMap {}",

                "package gnu.trove.map.hash;" +
                "import gnu.trove.map.TByteByteMap;" +
                "public class TByteByteHashMap implements TByteByteMap {}",

                "package gnu.trove.map;" +
                "public interface TCharCharMap {}",

                "package gnu.trove.map.hash;" +
                "import gnu.trove.map.TCharCharMap;" +
                "public class TCharCharHashMap implements TCharCharMap {}",

                "package gnu.trove.map;" +
                "public interface TDoubleDoubleMap {}",

                "package gnu.trove.map.hash;" +
                "import gnu.trove.map.TDoubleDoubleMap;" +
                "public class TDoubleDoubleHashMap implements TDoubleDoubleMap {}",

                "package gnu.trove.map;" +
                "public interface TFloatFloatMap {}",

                "package gnu.trove.map.hash;" +
                "import gnu.trove.map.TFloatFloatMap;" +
                "public class TFloatFloatHashMap implements TFloatFloatMap {}",

                "package gnu.trove.map;" +
                "public interface TLongLongMap {}",

                "package gnu.trove.map.hash;" +
                "import gnu.trove.map.TLongLongMap;" +
                "public class TLongLongHashMap implements TLongLongMap {}",

                "package gnu.trove.map;" +
                "public interface TShortShortMap {}",

                "package gnu.trove.map.hash;" +
                "import gnu.trove.map.TShortShortMap;" +
                "public class TShortShortHashMap implements TShortShortMap {}"
        };
    }
}
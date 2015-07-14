package me.artspb.idea.jdk2trove;

import com.intellij.codeInspection.InspectionToolProvider;
import me.artspb.idea.jdk2trove.hashmap.THashMapInspection;
import me.artspb.idea.jdk2trove.hashset.THashSetInspection;

/**
 * @author Artem Khvastunov
 */
public class InspectionProvider implements InspectionToolProvider {

    public static final String GROUP_DISPLAY_NAME = "Trove issues";

    @Override
    public Class[] getInspectionClasses() {
        return new Class[]{THashMapInspection.class, THashSetInspection.class};
    }
}

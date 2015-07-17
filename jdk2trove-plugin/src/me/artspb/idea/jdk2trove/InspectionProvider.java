package me.artspb.idea.jdk2trove;

import com.intellij.codeInspection.InspectionToolProvider;
import me.artspb.idea.jdk2trove.hashmap.THashMapCreationInspection;
import me.artspb.idea.jdk2trove.hashset.THashSetCreationInspection;

/**
 * @author Artem Khvastunov
 */
public class InspectionProvider implements InspectionToolProvider {

    public static final String GROUP_DISPLAY_NAME = "Trove issues";

    @Override
    public Class[] getInspectionClasses() {
        return new Class[]{THashMapCreationInspection.class, THashSetCreationInspection.class};
    }
}

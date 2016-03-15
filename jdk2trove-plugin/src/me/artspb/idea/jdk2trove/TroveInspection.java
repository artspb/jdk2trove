package me.artspb.idea.jdk2trove;

import com.intellij.codeInspection.BaseJavaLocalInspectionTool;
import org.jetbrains.annotations.NotNull;

import static me.artspb.idea.jdk2trove.InspectionProvider.GROUP_DISPLAY_NAME;

/**
 * @author Artem Khvastunov
 */
abstract public class TroveInspection extends BaseJavaLocalInspectionTool {

    @NotNull
    public String getGroupDisplayName() {
        return GROUP_DISPLAY_NAME;
    }

    @Override
    public boolean isEnabledByDefault() {
        return true;
    }
}

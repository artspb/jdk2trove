package me.artspb.idea.jdk2trove.hashmap;

import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiJavaCodeReferenceElement;
import com.intellij.psi.util.PsiTreeUtil;
import com.siyeh.ig.PsiReplacementUtil;
import me.artspb.idea.jdk2trove.TroveQuickFix;
import org.jetbrains.annotations.NotNull;

import static me.artspb.idea.jdk2trove.TroveUtils.TROVE_HASH_MAP;
import static me.artspb.idea.jdk2trove.TroveUtils.TROVE_MAP;

/**
 * @author Artem Khvastunov
 */
public class TTypeTypeHashMapQuickFix extends TroveQuickFix {

    public TTypeTypeHashMapQuickFix(String type1, String type2) {
        super(String.format(TROVE_MAP, type1 + type2), String.format(TROVE_HASH_MAP, type1 + type2));
    }

    @NotNull
    @Override
    protected String replace(@NotNull PsiElement element, String name) {
        PsiJavaCodeReferenceElement reference = PsiTreeUtil.getChildOfType(element, PsiJavaCodeReferenceElement.class);
        assert reference != null;
        return PsiReplacementUtil.getElementText(element, reference, name);
    }
}

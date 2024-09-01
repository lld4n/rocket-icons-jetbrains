package com.github.lld4n.rocketiconsjetbrains

import com.intellij.ide.IconProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.util.PsiUtilCore
import javax.swing.Icon

class IconProvider : IconProvider() {
    private var icons = IconPack.instance.icons

    override fun getIcon(element: PsiElement, flag: Int): Icon? {
        val virtualFile = PsiUtilCore.getVirtualFile(element)

        if (virtualFile?.isDirectory == true) {
            val name = virtualFile.name

            return icons.folder_filled_common;
        }

        return null;
    }
}
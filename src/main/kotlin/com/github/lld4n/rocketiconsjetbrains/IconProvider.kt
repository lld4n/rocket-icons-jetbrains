package com.github.lld4n.rocketiconsjetbrains

import com.intellij.ide.IconProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.util.PsiUtilCore
import java.util.*
import javax.swing.Icon

class IconProvider : IconProvider() {
    private var icons = IconPack.instance.icons

    override fun getIcon(element: PsiElement, flag: Int): Icon? {
        val virtualFile = PsiUtilCore.getVirtualFile(element)

        var name = virtualFile?.name?.lowercase(Locale.getDefault())

        if (name == null) {
            name = ""
        }

        if (virtualFile?.isDirectory == true) {

            if (icons.folders.contains(name)) {
                return icons.folders[name]
            }

            return icons.folder_common;
        }

        val file = icons.files[name]

        if (file != null) {
            return file
        }

        for (entry in icons.ext) {
            if (name.contains(entry.key)) {
                return entry.value
            }
        }

        return icons.file_common;
    }
}
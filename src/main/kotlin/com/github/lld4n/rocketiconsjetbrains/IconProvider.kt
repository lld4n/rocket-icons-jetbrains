package com.github.lld4n.rocketiconsjetbrains

import com.github.lld4n.rocketiconsjetbrains.settings.PluginSettingsState
import com.intellij.ide.IconProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.util.PsiUtilCore
import java.util.*
import javax.swing.Icon

class IconProvider : IconProvider() {
    private var icons = IconPack.instance.icons
    private var state = PluginSettingsState.instance

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

            return if (state.subtype == "folder") {
                icons.folder_common
            } else {
                icons.rectangle_common;
            }

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
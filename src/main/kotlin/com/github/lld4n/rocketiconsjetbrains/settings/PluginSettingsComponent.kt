package com.github.lld4n.rocketiconsjetbrains.settings

import com.github.lld4n.rocketiconsjetbrains.settings.views.SettingsIconPackView
import com.intellij.ui.TitledSeparator
import com.intellij.util.ui.FormBuilder
import javax.swing.*

enum class Variant(val id: String, private val label: String) {
    DUO("duo", "Duo Icons"),
    OUTLINE("outline", "Outline Icons"),
    FILLED("filled", "Filled Icons");

    override fun toString(): String {
        return label
    }
}

class PluginSettingsComponent(currentVariant: String) {
    var view = JPanel()
        private set

    var iconPack = SettingsIconPackView(currentVariant)
        private set

    init {
        view = FormBuilder.createFormBuilder()
            .addComponent(TitledSeparator("Variant"))
            .addComponent(iconPack)
            .addComponentFillVertically(JPanel(), 0)
            .panel
    }
}

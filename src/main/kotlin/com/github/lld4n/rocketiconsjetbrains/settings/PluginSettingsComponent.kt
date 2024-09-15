package com.github.lld4n.rocketiconsjetbrains.settings

import com.github.lld4n.rocketiconsjetbrains.settings.views.SettingsIconSubtypeView
import com.github.lld4n.rocketiconsjetbrains.settings.views.SettingsIconVariantView
import com.intellij.ui.TitledSeparator
import com.intellij.util.ui.FormBuilder
import javax.swing.*

enum class Variant(val id: String, private val label: String) {
    DUO("duo", "Duo Icons"),
    OUTLINE("outline", "Outline Icons"),
    FILLED("filled", "Filled Icons"),
    REVERSE("reverse", "Reverse Icons");

    override fun toString(): String {
        return label
    }
}


enum class Subtype(val id: String, private val label: String) {
    FOLDERS("folders", "Folder"),
    RECTANGLE("rectangle", "Rectangle");

    override fun toString(): String {
        return label
    }
}

class PluginSettingsComponent(currentVariant: String, currentSubtype: String) {
    var view = JPanel()
        private set

    var variantView = SettingsIconVariantView(currentVariant)
        private set

    var subtypeView = SettingsIconSubtypeView(currentSubtype)
        private set

    init {
        view = FormBuilder
            .createFormBuilder()
            .addComponent(TitledSeparator("Variant"))
            .addComponent(variantView)
            .addComponent(TitledSeparator("Subtype"))
            .addComponent(subtypeView)
            .addComponentFillVertically(JPanel(), 0).panel
    }
}

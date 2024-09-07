package com.github.lld4n.rocketiconsjetbrains.settings.views

import com.github.lld4n.rocketiconsjetbrains.settings.Variant
import com.intellij.openapi.ui.ComboBox
import com.intellij.ui.components.JBLabel
import com.intellij.util.ui.FormBuilder
import java.awt.Component
import java.awt.FlowLayout
import javax.swing.JPanel

class SettingsIconVariantView(private val currentVariant: String) : JPanel() {
    private val dropdown = ComboBox<Variant>()

    val variant: String
        get() = (dropdown.selectedItem as Variant).id

    init {
        drawDropdown()

        val form = FormBuilder.createFormBuilder()
            .addLabeledComponent(JBLabel("Variant:"), dropdown, 1, false)
            .addTooltip("Restart IDE to apply changes")
            .panel

        add(form)

        layout = FlowLayout(FlowLayout.LEADING)
    }

    private fun drawDropdown() {
        for (variant in Variant.entries) {
            dropdown.addItem(variant)
        }
        dropdown.selectedItem = Variant.entries.find { it.id == currentVariant }
        dropdown.alignmentY = Component.CENTER_ALIGNMENT
    }
}

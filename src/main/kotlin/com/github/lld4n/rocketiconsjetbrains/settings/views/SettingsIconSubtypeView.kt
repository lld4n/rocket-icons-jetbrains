package com.github.lld4n.rocketiconsjetbrains.settings.views

import com.github.lld4n.rocketiconsjetbrains.settings.Subtype
import com.intellij.openapi.ui.ComboBox
import com.intellij.ui.components.JBLabel
import com.intellij.util.ui.FormBuilder
import java.awt.Component
import java.awt.FlowLayout
import javax.swing.JPanel

class SettingsIconSubtypeView(private val currentVariant: String) : JPanel() {
    private val dropdown = ComboBox<Subtype>()

    val variant: String
        get() = (dropdown.selectedItem as Subtype).id

    init {
        drawDropdown()

        val form = FormBuilder.createFormBuilder()
            .addLabeledComponent(JBLabel("Subtype:"), dropdown, 1, false)
            .addTooltip("Restart IDE to apply changes")
            .panel

        add(form)

        layout = FlowLayout(FlowLayout.LEADING)
    }

    private fun drawDropdown() {
        for (variant in Subtype.entries) {
            dropdown.addItem(variant)
        }
        dropdown.selectedItem = Subtype.entries.find { it.id == currentVariant }
        dropdown.alignmentY = Component.CENTER_ALIGNMENT
    }
}

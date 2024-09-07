package com.github.lld4n.rocketiconsjetbrains

import com.github.lld4n.rocketiconsjetbrains.settings.PluginSettingsState
import com.intellij.openapi.project.Project
import com.intellij.openapi.util.IconLoader
import com.intellij.openapi.wm.StatusBarWidget
import com.intellij.openapi.wm.StatusBarWidgetFactory
import javax.swing.Icon

class RocketStatusBarWidgetFactory : StatusBarWidgetFactory {

    override fun getId(): String = "Rocket Icons"

    override fun getDisplayName(): String = "Rocket Icons"

    override fun createWidget(project: Project): StatusBarWidget {
        return RocketStatusBarWidget()
    }

    class RocketStatusBarWidget : StatusBarWidget, StatusBarWidget.IconPresentation {
        companion object {
            private const val ID = "Rocket Icons"
        }

        override fun getPresentation(): StatusBarWidget.WidgetPresentation? {
            return this
        }

        override fun ID(): String = ID

        override fun getIcon(): Icon {
            val variant = PluginSettingsState.instance.variant
            return IconLoader.getIcon("/icons/logo/$variant.svg", javaClass)
        }

        override fun getTooltipText(): String = "Current Variant"
    }

}



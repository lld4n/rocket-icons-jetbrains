package com.github.lld4n.rocketiconsjetbrains.settings

import com.intellij.ide.GeneralSettings
import com.intellij.ide.IdeBundle
import com.intellij.ide.projectView.ProjectView
import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.application.ex.ApplicationEx
import com.intellij.openapi.options.Configurable
import com.intellij.openapi.project.ProjectManager
import com.intellij.openapi.ui.Messages
import javax.swing.JComponent


class PluginSettings : Configurable {
    private val component =
        PluginSettingsComponent(PluginSettingsState.instance.variant, PluginSettingsState.instance.subtype)

    override fun createComponent(): JComponent {
        return component.view
    }

    private fun packChanged(): Boolean {
        val state = PluginSettingsState.instance
        return component.variantView.variant != state.variant
                || component.subtypeView.variant != state.subtype
    }

    override fun isModified(): Boolean {
        return packChanged()
    }

    override fun apply() {
        val state = PluginSettingsState.instance

        if (packChanged()) {
            state.variant = component.variantView.variant
            state.subtype = component.subtypeView.variant
            restart()
        }

        val projects = ProjectManager.getInstance().openProjects
        for (project in projects) {
            val projectView = ProjectView.getInstance(project)
            projectView?.refresh()
            projectView?.currentProjectViewPane?.updateFromRoot(true)
        }
    }

    override fun getDisplayName(): String {
        return "Rocket Icons"
    }

    private fun restart() {
        val result = if (GeneralSettings.getInstance().isConfirmExit) {
            Messages.showYesNoDialog(
                "The IDE needs to be restarted for the changes to take effect. Restart now?",
                IdeBundle.message("dialog.title.restart.ide"),
                IdeBundle.message("dialog.action.restart.yes"),
                IdeBundle.message("dialog.action.restart.cancel"),
                Messages.getWarningIcon()
            ) == Messages.YES
        } else {
            true
        }

        if (result) {
            val app = ApplicationManager.getApplication() as ApplicationEx
            app.restart(true)
        }
    }
}

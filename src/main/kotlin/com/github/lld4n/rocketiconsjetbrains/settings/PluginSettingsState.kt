package com.github.lld4n.rocketiconsjetbrains.settings

import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.components.PersistentStateComponent
import com.intellij.openapi.components.State
import com.intellij.openapi.components.Storage
import com.intellij.util.xmlb.XmlSerializerUtil

@State(
    name = "com.github.lld4n.rocketiconsjetbrains.settings.PluginSettingsState",
    storages = [Storage("RocketIcons.xml")]
)
class PluginSettingsState : PersistentStateComponent<PluginSettingsState> {
    var variant = Variant.DUO.id

    companion object {
        val instance: PluginSettingsState
            get() = ApplicationManager.getApplication().getService(PluginSettingsState::class.java)
    }

    override fun getState(): PluginSettingsState {
        return this
    }

    override fun loadState(state: PluginSettingsState) {
        XmlSerializerUtil.copyBean(state, this)
    }
}

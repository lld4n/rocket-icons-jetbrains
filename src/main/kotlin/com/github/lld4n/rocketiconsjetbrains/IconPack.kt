package com.github.lld4n.rocketiconsjetbrains

import com.github.lld4n.rocketiconsjetbrains.settings.PluginSettingsState


class IconPack {
    val icons: Icons by lazy {
        Icons(PluginSettingsState.instance.variant)
    }

    companion object {
        val instance = IconPack()
    }
}
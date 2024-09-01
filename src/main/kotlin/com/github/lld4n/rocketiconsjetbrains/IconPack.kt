package com.github.lld4n.rocketiconsjetbrains

class IconPack {
    val icons: Icons by lazy {
        Icons()
    }

    companion object {
        val instance = IconPack()
    }
}
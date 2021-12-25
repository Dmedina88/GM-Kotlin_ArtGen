// Copyright 2000-2021 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import data.configs.config_1
import data.configs.config_2
import data.configs.config_3
import ui.renderer.workGen1
import java.awt.Dimension


fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        this.window.size = Dimension(2000, 1000)
        this.window.isResizable = false

        repeat(8) {
            workGen1(config_1)

        }


    }

}

// Copyright 2000-2021 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.ImageComposeScene
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asDesktopBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.toComposeImageBitmap
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import data.Config
import data.Folders
import data.configTest
import org.jetbrains.skia.Image
import ui.renderer.rendererWild
import util.bitmapToFile
import java.awt.Dimension
import java.io.File
import java.io.FileOutputStream
import java.time.LocalDateTime
import java.util.*
import kotlin.math.absoluteValue
import kotlin.random.Random



fun main() = application {
   Window(onCloseRequest = ::exitApplication) {
        this.window.size = Dimension(2000, 1000)
        this.window.isResizable = false
      // (1..10).forEach {
           rendererWild(configTest)

     //  }


    }

}

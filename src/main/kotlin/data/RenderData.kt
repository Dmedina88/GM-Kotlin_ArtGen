package data

import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.IntSize

data class RenderData (val image: ImageBitmap,
                      val srcOffset: IntOffset = IntOffset.Zero,
                      val  srcSize: IntSize = IntSize(image.width, image.height),
                     val  dstOffset: IntOffset = IntOffset.Zero,
                      val dstSize: IntSize = srcSize,
                     val  alpha: Float = 1.0f)
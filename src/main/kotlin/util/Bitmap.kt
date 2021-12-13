package util

import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.unit.IntSize

fun ImageBitmap.scaleOnMax(maxHight: Int = Int.MAX_VALUE , maxWidth : Int = Int.MAX_VALUE): IntSize {
 var newSize =IntSize(width,height)

   if (newSize.height > maxHight ) {
        val rateo  : Double  =newSize.height  / maxHight.toDouble()
        val newWidth = newSize.width  / rateo

        newSize = IntSize(newWidth.toInt(), maxHight)
    }

    if (newSize.width > maxWidth ) {
        val rateo  : Double  = newSize.width  / maxWidth.toDouble()
        val newHight = newSize.height / rateo

        newSize = IntSize(maxWidth, newHight.toInt())
    }


    return newSize
}
package util

import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.unit.IntSize
import org.jetbrains.skia.Bitmap

fun ImageBitmap.scaleOnMaxHight(maxHight: Int) : IntSize{

    if(this.height > maxHight){
        val rateo = this.height/maxHight
        val newWidth = this.width/rateo

        return IntSize(newWidth,maxHight)
    }

    return IntSize(this.width,this.height)
}
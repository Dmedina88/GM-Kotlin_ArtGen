package util

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.unit.IntOffset
import data.Point
import data.randomX
import data.randomY

fun Point.toOffSet()=

    IntOffset(
       this.x,
        this.y
    )

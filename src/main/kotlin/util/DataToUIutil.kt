package util

import androidx.compose.ui.unit.IntOffset
import data.Point

fun Point.toOffSet() =

    IntOffset(
        this.x,
        this.y
    )


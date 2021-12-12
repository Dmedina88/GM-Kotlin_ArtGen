package util

import java.time.LocalDateTime
import kotlin.random.Random

object Rand {
   val random= Random(LocalDateTime.now().nano)

}
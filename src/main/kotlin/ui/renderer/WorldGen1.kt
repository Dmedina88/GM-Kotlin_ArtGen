package ui.renderer

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.ImageComposeScene
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.toComposeImageBitmap
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.IntSize
import data.*
import util.bitmapToFile
import util.imageFromFile
import util.scaleOnMaxHight
import util.toOffSet
import java.io.File
import java.time.LocalDateTime
import java.util.*
import kotlin.math.absoluteValue
import kotlin.math.min
import kotlin.random.Random


@OptIn(ExperimentalComposeUiApi::class)
@Composable
@Preview()
fun workGen1(config: Config) {

    val image = ImageComposeScene(2000, 1000) {


        Canvas(Modifier.fillMaxSize()) {


//backgorund
            backGroud()
            val rand = Random(LocalDateTime.now().nano)

            //get items
            config.zonesWithFolders.forEach() { zoneConfig ->

                //get files as one list
                val files = zoneConfig.folders.map { File(it.path) }.map { it.listFiles()!!.toMutableList() }.flatten()
                    .toMutableList()
                files.shuffle()

                // gut subist
                val sublist = when (zoneConfig.viority) {
                    Variety.Unlimited -> {
                        files
                    }
                    is Variety.Limited -> files.subList(0, min(files.size, zoneConfig.viority.count))
                }

                //draw count
                (0 until zoneConfig.count).forEach {

                    val bitmapFile = sublist.random()
                    if (bitmapFile != null && bitmapFile.name.endsWith(".png")) {
                        val newBitmap = imageFromFile(bitmapFile)
                      val  offset = zoneConfig.zone.randomPoint().toOffSet()
                        println(zoneConfig.folders.toString() + offset.toString())

                        val size = newBitmap.scaleOnMaxHight(zoneConfig.maxHight)
                        this.drawImage(
                            newBitmap,
                            dstOffset = offset,
                            dstSize = size
                        )
                    }


                }


            }

        }
    }.render()

    Canvas(Modifier.fillMaxSize()) {
        drawImage(image.toComposeImageBitmap())
    }


    LaunchedEffect("COOL") {
        bitmapToFile(image)

    }
}

private fun DrawScope.backGroud() {
    val directory = File(Folders.SKY.path)
    val file = directory.listFiles().random()
    val bitmap = imageFromFile(file)
    val background = imageFromFile(File(Folders.BACKGROUND.path).listFiles().random())
    this.drawImage(background, dstSize = IntSize(this.size.width.toInt(), (this.size.height).toInt()))
    this.drawImage(
        bitmap,
        IntOffset(100, 100),
        dstSize = IntSize(this.size.width.toInt(), (this.size.height / 2).toInt())
    )


    //   this.drawImage(randomBitmap,Offset(599f,600f))
    //   this.drawImage(randomBitmap,dstOffset = IntOffset(599,600), dstSize = IntSize(20,200))

}

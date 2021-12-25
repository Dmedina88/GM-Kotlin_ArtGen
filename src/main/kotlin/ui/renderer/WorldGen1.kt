package ui.renderer

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.ImageComposeScene
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.toComposeImageBitmap
import androidx.compose.ui.unit.IntSize
import data.*
import util.bitmapToFile
import util.imageFromFile
import util.scaleOnMax
import util.toOffSet
import java.io.File
import kotlin.math.min


@OptIn(ExperimentalComposeUiApi::class)
@Composable
@Preview()
fun workGen1(config: Config) {

    val image = ImageComposeScene(2000, 1000) {


        Canvas(Modifier.fillMaxSize()) {


//backgorund
            backGroud()

            //get items
            config.zonesWithFolders.forEach { zoneConfig ->

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

                val renderData = mutableListOf<RenderData>()
                (0 until zoneConfig.count).forEach() {

                    val bitmapFile = sublist.random()
                    if (bitmapFile != null && bitmapFile.name.endsWith(".png")) {
                        //i want to move these calculatons to static fuctions fit in screen mainly
                        val newBitmap = imageFromFile(bitmapFile)
                        val size = newBitmap.scaleOnMax(zoneConfig.maxHight, zoneConfig.maxWidth)
                        val offset = zoneConfig.zone.randomPoint().toOffSet()

                        //fit to screen make function

                    val newX =     if (size.width + offset.x > config.canvisWidth   ){
                        offset.x - size.width
                        }else offset.x

                        val newY =     if (size.height + offset.y > config.canvisHight ){
                            println(size.height + offset.y)
                            println(offset.y - ((size.height + offset.y) - config.canvisHight ) + size.height )
                            offset.y - ((size.height + offset.y) - config.canvisHight )

                        }else offset.y



                        println(zoneConfig.folders.toString() + offset.toString())

                        renderData.add( RenderData(
                            newBitmap,
                            dstOffset = IntOffset(newX,newY),
                            dstSize = size
                        )
                        )
                    }


                }

                // sort by x or render like wild
                renderData.sortBy { it.dstOffset.y + it.dstSize.height}
                renderData.forEach{ renderData ->
                    this.drawImage(renderData.image, dstOffset = renderData.dstOffset, dstSize = renderData.dstSize, alpha = renderData.alpha)
                }

            }

        }
    }.render()




    LaunchedEffect("COOL") {
        bitmapToFile(image)

    }

    Canvas(Modifier.fillMaxSize()) {
        drawImage(image.toComposeImageBitmap())
    }
}

private fun DrawScope.backGroud() {


    val sky = imageFromFile(File(Folders.SKY.path).listFiles().random())
    val background = imageFromFile(File(Folders.BACKGROUND.path).listFiles().random())
    val ground = imageFromFile(File(Folders.GROUND.path).listFiles().random())

    this.drawImage(background, dstSize = IntSize(this.size.width.toInt(), (this.size.height).toInt()))
    this.drawImage(
        sky, dstSize = IntSize(this.size.width.toInt(), (this.size.height / 2).toInt())
    )

    //should probably be max size
    this.drawImage(
        ground,
        dstOffset = IntOffset(0, (this.size.height / 2).toInt()),
        dstSize = IntSize(this.size.width.toInt(), (this.size.height / 2).toInt())
    )


    //   this.drawImage(randomBitmap,Offset(599f,600f))
    //   this.drawImage(randomBitmap,dstOffset = IntOffset(599,600), dstSize = IntSize(20,200))

}

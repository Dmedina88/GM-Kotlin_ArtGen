package ui.renderer

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.ImageComposeScene
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.toComposeImageBitmap
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.IntSize
import data.Config
import data.Folders
import util.bitmapToFile
import util.imageFromFile
import util.scaleOnMaxHight
import java.io.File
import java.time.LocalDateTime
import kotlin.math.absoluteValue
import kotlin.random.Random


@OptIn(ExperimentalComposeUiApi::class)
@Composable
@Preview()
fun rendererWild(configTest: Config) {

  val image =  ImageComposeScene(2000, 1000) {
        Canvas(Modifier.fillMaxSize()) {
            val directory = File(Folders.SKY.path)
            //todo null safty
            val file = directory.listFiles().random()
            //  Log.debug(file.name)
            print(file.name)
            val random = File(Folders.GROUNDCREATURES.path).listFiles().random()
            //  Log.debug(file.name)
            print(random.name)
            val bitmap = imageFromFile(file)

//backgorund
            val background = imageFromFile(File(Folders.BACKGROUND.path).listFiles().random())

            this.drawImage(background, dstSize = IntSize(this.size.width.toInt(), (this.size.height).toInt()))
            this.drawImage(
                bitmap,
                IntOffset(100, 100),
                dstSize = IntSize(this.size.width.toInt(), (this.size.height / 2).toInt())
            )


            //   this.drawImage(randomBitmap,Offset(599f,600f))
            //   this.drawImage(randomBitmap,dstOffset = IntOffset(599,600), dstSize = IntSize(20,200))
            val rand = Random(LocalDateTime.now().nano)




            Folders.values().forEach {
                println(it.path)
                File(it.path).listFiles().apply { this.shuffle() }.forEach {
                    if (it != null && it.name.endsWith(".png")) {
                        println(it.name)

                        var newBitmap = imageFromFile(it)
 val size = newBitmap.scaleOnMaxHight(200)
                        this.drawImage(
                            newBitmap,
                            dstOffset = IntOffset(
                                rand.nextInt(this.size.width.toInt() - size.width).absoluteValue,
                                rand.nextInt(this.size.height.toInt() - size.height).absoluteValue
                            ),
                            dstSize = size
                        )
                    }

                }

                //  bitmapToFile(bitmap.asDesktopBitmap())
            }


        }



    }.render()
    
    Canvas(Modifier.fillMaxSize()) {
        drawImage(image.toComposeImageBitmap())
    }


    LaunchedEffect("COOL"){
        bitmapToFile(image)

    }
}

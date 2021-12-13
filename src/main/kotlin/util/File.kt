package util

import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.toComposeImageBitmap
import org.jetbrains.skia.Image
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.io.OutputStream
import java.util.*

fun imageFromFile(file: File): ImageBitmap {
    return Image.makeFromEncoded(file.readBytes()).toComposeImageBitmap()
}


fun bitmapToFile(image: Image) {
    // Get the context wrapper

    // Initialize a new file instance to save bitmap object
    //

    var file = File("C:\\Users\\dynam\\Desktop\\Backup")
    file = File(file, "${UUID.randomUUID()}.jpg")

    try {
        // Compress the bitmap and save in jpg format
        val stream: OutputStream = FileOutputStream(file)

        stream.write(image.encodeToData()!!.bytes)
        stream.flush()
        stream.close()
    } catch (e: IOException) {
        e.printStackTrace()
    }

    // Return the saved bitmap uri

}
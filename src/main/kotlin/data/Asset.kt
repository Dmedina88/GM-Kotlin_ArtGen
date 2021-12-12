package data

import util.Rand
import java.time.LocalDateTime
import kotlin.random.Random


// the range that something can be rendered from a point
data class Zone(val corner1 : Point , val corner2 : Point = corner1)

val Zone.center get() =  Point((corner1.x +corner2.x)/2, (corner1.x +corner2.x)/2)

fun Zone.randomPoint() = Point(randomX(),randomY())

//todo refacter
fun Zone.randomX()  : Int {
    if(corner1.x != corner2.x){

    val x1   = Math.min(corner1.x, corner2.x)
    val x2 = Math.max(corner1.x, corner2.x)
    val deltaX = x2 - x1
    val offsetX =   Rand.random.nextInt(deltaX)
    return x1 + offsetX}
    else return corner1.x
    }

fun Zone.randomY()  : Int {
    if(corner1.y != corner2.y){
    val y1   = Math.min(corner1.y, corner2.y)
    val y2 = Math.max(corner1.y, corner2.y)
    val deltaX = y2 - y1
    val offsetX  = Rand.random.nextInt(deltaX)
    return y1 + offsetX}
        else return corner1.y
}

data class Point(val x : Int =0, val y :Int=0)

//data class Folder(val path: String)

sealed class Variety{
    object Unlimited: Variety()
    data class Limited(val count: Int): Variety()
}

data class ZoneConfig(val zone: Zone, val folders : List<Folders> , val count : Int  = 1 , val viority  : Variety = Variety.Unlimited, val maxHight  : Int = Int.MAX_VALUE,val maxWidth : Int = Int.MAX_VALUE)
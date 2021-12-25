package data.configs

import data.*

val sizeX = 2000
val sizeY = 1000


val clouad = ZoneConfig(
    zone = Zone(Point(0, 0), Point(sizeX, sizeY / 3)),
    folders = listOf(Folders.cloads), count = 50, maxHight = 70
)
val floutingBacksgrounds = ZoneConfig(
    zone = Zone(Point(0, 0), Point(sizeX, sizeY / 3)),
    folders = listOf(Folders.cloads), count = 50, maxHight = 70
)

val buildings = ZoneConfig(
    zone = Zone(Point(0, 250), Point(0, 400)),
    folders = listOf(Folders.STRUCTURES), count = 1, maxHight = 300
)

val landFeatures = ZoneConfig(
    zone = Zone(Point(0, sizeY / 2), Point(sizeX, sizeY)),
    folders = listOf(Folders.LAND_TRAITS), count = 3, maxHight = 300
)

val flayers = ZoneConfig(
    zone = Zone(Point(0, 0), Point(sizeX, 400)),
    folders = listOf(Folders.FLYING), count = 3, maxHight = 250 , maxWidth = 250
)

val groupGrund = ZoneConfig(
    zone = Zone(Point(0, sizeY / 2), Point(sizeX, sizeY)),
    folders = listOf(Folders.GROUNDCREATURES, Folders.SCATER), count = 7, maxHight = 200 ,maxWidth = 158
)

val flowers = ZoneConfig(
    zone = Zone(Point(0, sizeY / 2 ), Point(sizeX, sizeY)),
    folders = listOf(Folders.FlOWER), count = 200, maxHight = 100 , viority = Variety.Limited(5)
)

val centerItem = ZoneConfig(
    zone = Zone(Point(sizeX / 2, sizeY / 2)),
    folders = listOf(Folders.CENTER),
    maxHight = 500
)

val landFeaturesLeft = ZoneConfig(
    zone = Zone(Point(0, sizeY / 2), Point(sizeX/2, sizeY)),
    folders = listOf(Folders.LAND_TRAITS), count = 2, maxHight = 300
)
val landFeaturesRight = ZoneConfig(
    zone = Zone(Point((sizeX/2) +100, sizeY /3), Point(sizeX, sizeY)),
    folders = listOf(Folders.LAND_TRAITS), count = 1, maxHight = 300
)

val groupGrundLeft = ZoneConfig(
    zone =Zone(Point(0, sizeY / 3), Point((sizeX/2 - 160), sizeY)),
    folders = listOf(Folders.GROUNDCREATURES, Folders.SCATER), count = 4, maxHight = 200 ,maxWidth = 150
)
val groupGrundRight = ZoneConfig(
    zone =Zone(Point((sizeX/2) +100, sizeY/3), Point(sizeX, sizeY)),
    folders = listOf(Folders.GROUNDCREATURES, Folders.SCATER), count = 3, maxHight = 200 ,maxWidth = 150
)
val flowersLeft = ZoneConfig(
    zone = Zone(Point(0, sizeY / 2),  Point((sizeX/2 - 160), sizeY)),
    folders = listOf(Folders.FlOWER), count = 34, maxHight = 100
)
val flowersRight = ZoneConfig(
    zone = Zone(Point((sizeX/2) +100, sizeY/3), Point(sizeX, sizeY)),
    folders = listOf(Folders.FlOWER), count = 12, maxHight = 100
)

val all = ZoneConfig(
    zone = Zone(Point(0, sizeY / 2), Point(sizeX, sizeY)),
    folders = Folders.values().toList(), count = 120, maxHight = 200 ,maxWidth = 158
)


//val sky =    ZoneConfig(
//    zone = Zone(Point(sizeX/2 ,sizeY/2)),
//    folders = listOf( Folders.SKY))


val config_1 = Config(
    2000,
    1000,
    zonesWithFolders = listOf(
        clouad,
        buildings,
        flayers,
        flowers,
        landFeatures,
        groupGrund,
        centerItem
    )
)

val config_2 = Config(
    2000,
    1000,
    zonesWithFolders = listOf(
        clouad,
        buildings,
       // landFeatures,
        flayers,
        landFeaturesLeft,
        landFeaturesRight,
        flowersLeft,
        flowersRight,
        groupGrundLeft,
        groupGrundRight,
        centerItem
    )
)
 //Flowers
fun config3(   canvisWidth: Int,
                              canvisHight: Int) : List<ZoneConfig> {
     val list = mutableListOf<ZoneConfig>(     clouad,
         buildings,
         // landFeatures,
         flayers,
         landFeaturesLeft,
         landFeaturesRight)
     val hight = 100
     val witdh = 100
     val startY = (canvisHight / 2) + 200
     val endX = canvisWidth

     var startX = witdh
     (1..4).forEach { x ->

         (1..1).forEach { y ->
             startX += (witdh * x)

             val start = Point(startX, startY * y)
             val end = Point(start.x + witdh, start.y + hight)
             list.add(
                 ZoneConfig(
                     zone = Zone(start, end),
                     folders = listOf(Folders.FlOWER), count = 20, maxHight = 100, viority = Variety.Limited(2)
                 )
             )
             startX += 300
         }

     }

     list.addAll(
         listOf( groupGrund,
         centerItem))
 return list

}
val config_3 =  Config(
    2000,
    1000,
config3(2000,1000)
    )

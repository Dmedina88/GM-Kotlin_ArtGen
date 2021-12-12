package data.configs

import data.*
val sizeX = 2000
val sizeY = 1000




val clouad =   ZoneConfig(
    zone = Zone(Point(0,0),Point(sizeX ,sizeY/3) ),
    folders = listOf( Folders.cloads), count = 50,maxHight = 70)

val buildings =   ZoneConfig(
    zone = Zone(Point(0,0),Point(sizeX ,sizeY/4)  ),
    folders = listOf( Folders.STRUCTURES), count = 1,maxHight = 300)

val landFeatures =   ZoneConfig(
    zone = Zone(Point(0 ,sizeY/2) ,Point(sizeX ,sizeY )),
    folders = listOf( Folders.LAND_TRAITS), count = 3, maxHight = 300)

val flayers =   ZoneConfig(
    zone = Zone(Point(0,0),Point(sizeX ,sizeY/2) ),
    folders = listOf( Folders.FLYING) , count = 3 ,    maxHight = 250)

val groupGrund =   ZoneConfig(
    zone = Zone(Point(0 ,sizeY/2) ,Point(sizeX ,sizeY) ),
    folders = listOf( Folders.GROUNDCREATURES,Folders.SCATER), count = 7,maxHight = 200)


val flowers =   ZoneConfig(
    zone = Zone(Point(0 ,sizeY/2) ,Point(sizeX ,sizeY) ),
    folders = listOf( Folders.FlOWER) , count = 34, maxHight = 100)



val centerItem =   ZoneConfig(
    zone = Zone(Point(sizeX/2 ,sizeY/2)),
    folders = listOf( Folders.CENTER),
    maxHight = 500
)

//val sky =    ZoneConfig(
//    zone = Zone(Point(sizeX/2 ,sizeY/2)),
//    folders = listOf( Folders.SKY))



        val configTest = Config(
            2000,
            1000 ,
            zonesWithFolders=   listOf(
           clouad,
         //       buildings,
         //       landFeatures,
                flayers,
                flowers,
                groupGrund,
                centerItem
            )
        )

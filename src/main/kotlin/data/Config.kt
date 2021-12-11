package data
data class Config(
    val canvisWidth : Int,
    val canvisHight : Int,

    //zones with folders
     val zonesWithFolders: List<ZoneWithFolders>

)


val centerItem =   ZoneWithFolders(
    zone = Zone(Point(2241/2 ,1354/2)),
    folders = listOf( Folders.CENTER))



val sky =    ZoneWithFolders(
    zone = Zone(Point(2241/2 ,1354/2)),
    folders = listOf( Folders.SKY))


val ground =     ZoneWithFolders(
    zone = Zone(Point(2241/2 ,1354/2)),
    folders = listOf( Folders.GROUND))



        val configTest = Config(
            2241,
            1354 ,
            zonesWithFolders=   listOf(
            centerItem,
            sky,
            ground
            )
        )


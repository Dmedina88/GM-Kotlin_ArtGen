package data


// the range that something can be rendered from a point
data class Zone(val point : Point , val wiggle :Int =0)

val Zone.placement  : Point get() { return this.point }

data class Point(val x : Int =0, val y :Int=0)

//data class Folder(val path: String)


data class ZoneWithFolders(val zone: Zone, val folders : List<Folders> )
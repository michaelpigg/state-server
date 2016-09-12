package net.michaelpigg

// Lightly Scalaified version of Point in Polygon algorithm presented at http://alienryderflex.com/polygon/
object PointFinder {

  def pointInPolygon(point: Point, polygon: Seq[Point]): Boolean = {
    val polyY = polygon.map(_.longitude).toArray
    val polyX = polygon.map(_.latitude).toArray
    val x = point.latitude
    val y = point.longitude
    var j = polygon.size - 1

    var oddNodes = false
    (0 until polygon.size).foreach(i => {
      if (polyY(i) < y && polyY(j) >= y
        ||  polyY(j) < y && polyY(i) >= y) {
        if (polyX(i) + (y - polyY(i)) / (polyY(j)-polyY(i)) * (polyX(j) - polyX(i)) < x) {
          oddNodes = !oddNodes
        }
      }
      j = i
    })
    oddNodes
  }
}

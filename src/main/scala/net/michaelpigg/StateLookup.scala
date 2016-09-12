package net.michaelpigg

/**
  * Created by michaelpigg on 9/11/16.
  */
trait StateLookup {

  val states: Seq[State]

  def findStateByPoint(point: Point): Option[State] = {
    states.find(state => PointFinder.pointInPolygon(point, state.border.init))
  }
}

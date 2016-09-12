package net

/**
  * Created by michaelpigg on 9/11/16.
  */
package object michaelpigg {
  val VermontBorder = Seq(Point(-73.25806, 42.746058), Point(-73.344723, 45.006138), Point(-71.505372, 45.013351), Point(-73.25806, 42.746058))
  val MarylandBorder = Seq(Point(-75.710712, 38.649665), Point(-79.480971, 39.720274), Point(-75.791094, 39.723866), Point(-75.710712, 38.649665))
  val Vermont = State("Vermont", VermontBorder)
  val States = Seq(Vermont, State("Maryland", MarylandBorder))
  val VermontPoint = Point(-72.574310, 44.247382)
  val PennsylvaniaPoint = Point(-77.335510, 40.415260)
}

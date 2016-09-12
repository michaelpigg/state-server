package net.michaelpigg

import play.api.libs.json.Json

import scala.io.Source

case class Point(longitude: Double, latitude: Double)

case class State(name: String, border: Seq[Point])

object StateReader {
  def loadStates: Seq[State] = {
    Source.fromInputStream(this.getClass.getClassLoader.getResourceAsStream("states.json")).getLines().map { line =>
      val stateJson = Json.parse(line)
      val state = (stateJson \ "state").as[String]
      val border = (stateJson \ "border").as[Seq[Seq[Double]]]
      State(state, border.map(p => Point(p(0), p(1))))
    }.toSeq
  }
}

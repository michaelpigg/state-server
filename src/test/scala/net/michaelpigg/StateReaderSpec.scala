package net.michaelpigg

import org.scalatest.{FreeSpec, Matchers}

/**
  * Created by michaelpigg on 9/11/16.
  */
class StateReaderSpec extends FreeSpec with Matchers {

  "StateReader should load data from states.json" in {
    val states = StateReader.loadStates
    states.size shouldBe 43
    val vermontMaybe = states.find(state => state.name == "Vermont")
    val vermont = vermontMaybe.get
    vermont.border shouldBe Seq(Point(-73.25806, 42.746058), Point(-73.344723, 45.006138), Point(-71.505372, 45.013351), Point(-73.25806, 42.746058))
  }

}

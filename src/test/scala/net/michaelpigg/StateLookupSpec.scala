package net.michaelpigg

import org.scalatest.{FreeSpec, Matchers}

/**
  * Created by michaelpigg on 9/11/16.
  */
class StateLookupSpec extends FreeSpec with Matchers {
  trait Test extends StateLookup {
    override val states: Seq[State] = States
  }

  "StateLookup should" - {
    "return state when point is inside border" in new Test {
      findStateByPoint(VermontPoint) shouldBe Some(Vermont)
    }
    "return None when point is outside border" in new Test {
      findStateByPoint(PennsylvaniaPoint) shouldBe None
    }
  }
}

package net.michaelpigg

import org.scalatest.{FreeSpec, Matchers}

/**
  * Created by michaelpigg on 9/11/16.
  */
class PointFinderSpec extends FreeSpec with Matchers {
  "PointFinder should" - {
    "return true when point inside polygon" in {
      PointFinder.pointInPolygon(VermontPoint, VermontBorder.init) shouldBe true
    }
    "return false when point outside polygon" in {
      PointFinder.pointInPolygon(PennsylvaniaPoint, VermontBorder.init) shouldBe false
    }
  }
}

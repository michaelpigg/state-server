package net.michaelpigg

import akka.http.scaladsl.testkit.ScalatestRouteTest
import org.scalatest.{FreeSpec, FreeSpecLike, Matchers}
import play.api.libs.json.{JsArray, JsString, JsValue}

/**
  * Created by michaelpigg on 9/11/16.
  */
class StateServerSpec extends StateServer with FreeSpecLike with Matchers with ScalatestRouteTest {
  import de.heikoseeberger.akkahttpplayjson.PlayJsonSupport._
  "StateServer should" - {
    "return JSON array containing state name when given latitude and longitude in state boundary" in {
      Get("/?latitude=40.513799&longitude=-77.036133") ~> route ~> check {
        entityAs[JsValue] shouldBe JsArray(Seq(JsString("Pennsylvania")))
      }
    }
    "return emtpy JSON array when given point not in any state" in {
      Get("/?latitude=37.9971794&longitude=23.6856313") ~> route ~> check {
        entityAs[JsValue] shouldBe JsArray(Seq.empty)
      }
    }
  }
}

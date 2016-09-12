package net.michaelpigg

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Directives._
import akka.stream.ActorMaterializer
import play.api.libs.json.Json

import scala.io.StdIn

class StateServer extends StateLookup {

  import de.heikoseeberger.akkahttpplayjson.PlayJsonSupport._

  override val states: Seq[State] = StateReader.loadStates

  val route = get {
      parameters('longitude.as[Double], 'latitude.as[Double]).as(Point) { point =>
        findStateByPoint(point) match {
          case Some(state) => complete(Json.toJson(List(state.name)))
          case None => complete(Json.toJson(List.empty[String]))
        }
      }
    }
}

object StateServer extends StateServer {
  def main(args: Array[String]): Unit = {

    implicit val system = ActorSystem("state-server")
    implicit val materializer = ActorMaterializer()
    implicit val executionContext = system.dispatcher

    val bindingFuture = Http().bindAndHandle(route, "localhost", 8080)

    println(s"Server online at http://localhost:8080/\nPress RETURN to stop...")
    StdIn.readLine() // let it run until user presses return
    bindingFuture
      .flatMap(_.unbind())
      .onComplete(_ => system.terminate())
  }
}

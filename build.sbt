name := "state-server"

version := "1.0"

scalaVersion := "2.11.8"
libraryDependencies ++= {
  val akkaVersion = "2.4.8"
  Seq(
  "com.typesafe.akka" %% "akka-http-core" % akkaVersion,
  "com.typesafe.akka" %% "akka-http-experimental" % akkaVersion,
  "com.typesafe.play" %% "play-json" % "2.5.6",
  "de.heikoseeberger" %% "akka-http-play-json" % "1.9.0",

  "com.typesafe.akka" %% "akka-http-testkit" % akkaVersion % Test,
  "org.scalatest" %% "scalatest" % "3.0.0" % Test
  )
}
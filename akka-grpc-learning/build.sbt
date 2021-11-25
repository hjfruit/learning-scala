
scalaVersion := "2.13.7"

enablePlugins(AkkaGrpcPlugin)

akkaGrpcCodeGeneratorSettings += "server_power_apis"

libraryDependencies ++= Seq(
  "ch.megard" %% "akka-http-cors" % "0.4.2",
  "com.typesafe.akka" %% "akka-protobuf-v3" % "2.6.17",
  "com.typesafe.akka" %% "akka-discovery" % "2.6.17",
  "com.typesafe.akka" %% "akka-stream" % "2.6.17",
  "com.typesafe.akka" %% "akka-actor-typed" % "2.6.17"
)

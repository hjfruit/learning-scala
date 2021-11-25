ThisBuild / scalaVersion := "2.13.7"

name := "scala-learning"

ThisBuild / version := "1.0.0-SNAPSHOT"

val AkkaVersion = "2.6.17"
val AkkaHttpVersion = "10.2.7"
val ScalatestVersion = "3.1.4"

lazy val `scala-learning` = (project in file(".")).aggregate(
  `learning-start`,
  `learning-http`,
  `learning-grpc`,
  `learning-service`,
  `learning-common`
)

lazy val `learning-start` = (project in file("learning-start"))
  .enablePlugins(JavaAppPackaging)
  .dependsOn(
    `learning-service`,
    `learning-common` % "compile->compile;test->test"
  )
  .settings(
    libraryDependencies ++= Seq(
      "com.typesafe.akka" %% "akka-cluster-typed" % "2.6.17"
    )
  )

lazy val `learning-http` = (project in file("learning-http"))
  .enablePlugins(JavaAppPackaging)
  .dependsOn(`learning-common` % "compile->compile;test->test")
  .settings(
    libraryDependencies ++= Seq(
      "com.typesafe.akka" %% "akka-actor-typed" % AkkaVersion,
      "com.typesafe.akka" %% "akka-stream" % AkkaVersion,
      "com.typesafe.akka" %% "akka-http" % AkkaHttpVersion,
      "com.typesafe.akka" %% "akka-http-testkit" % AkkaHttpVersion % Test
    )
  )

lazy val `learning-grpc` = (project in file("learning-grpc"))
  .enablePlugins(JavaAppPackaging, AkkaGrpcPlugin)
  .dependsOn(`learning-common` % "compile->compile;test->test")
  .settings(akkaGrpcCodeGeneratorSettings += "server_power_apis")

lazy val `learning-service` = (project in file("learning-service"))
  .dependsOn(`learning-common` % "compile->compile;test->test")
  .settings()

lazy val `learning-common` = (project in file("learning-common"))
  .settings(
    libraryDependencies ++= Seq(
      "org.scala-lang" % "scala-library" % scalaVersion.value,
      "com.typesafe.akka" %% "akka-stream-testkit" % AkkaVersion % Test,
      "org.scalatest" %% "scalatest" % ScalatestVersion % Test
    )
  )

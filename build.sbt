name := "filmes-java-play"

version := "1.0"

lazy val `filmes-java-play` = (project in file(".")).enablePlugins(PlayJava, PlayEbean)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  javaJdbc ,
  cache ,
  javaWs ,
  "postgresql" % "postgresql" % "9.1-901-1.jdbc4" ,
  "org.scalatestplus.play" %% "scalatestplus-play" % "1.5.1" % "test",
  "ws.securesocial" %% "securesocial" % "3.0-M8"
)

unmanagedResourceDirectories in Test <+=  baseDirectory ( _ /"target/web/public/test" )

resolvers += "scalaz-bintray" at "https://dl.bintray.com/scalaz/releases"

routesGenerator := StaticRoutesGenerator
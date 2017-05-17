name := "filmes-java-play"

version := "1.0"

lazy val `filmes-java-play` = (project in file(".")).enablePlugins(PlayJava, PlayEbean)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  javaJdbc ,
  cache ,
  javaWs ,
  "org.scalatestplus.play" %% "scalatestplus-play" % "1.5.1" % "test"
)

unmanagedResourceDirectories in Test <+=  baseDirectory ( _ /"target/web/public/test" )  

resolvers += "scalaz-bintray" at "https://dl.bintray.com/scalaz/releases"

routesGenerator := StaticRoutesGenerator
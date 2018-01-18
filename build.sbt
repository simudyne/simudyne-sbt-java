name := "simudyne-sbt-java"

version := "0.1"

scalaVersion := "2.11.12"
logLevel := Level.Info

resolvers += "Artifactory Realm" at "https://simudyne.jfrog.io/simudyne/releases"
credentials += Credentials(file(".credentials"))

javacOptions ++= Seq("-source", "1.8", "-target", "1.8", "-encoding", "UTF-8")

lazy val simudyneVersion = "2.0.0-alpha.7"
libraryDependencies ++= Seq(
  "simudyne" %% "simudyne-nexus-server" % simudyneVersion,
  "simudyne" %% "simudyne-core" % simudyneVersion,
  "simudyne" %% "simudyne-core-abm" % simudyneVersion
)

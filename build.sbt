name := "simudyne-sbt-java"

version := "0.1"

scalaVersion := "2.12.8"
logLevel := Level.Info

resolvers += "Artifactory Realm" at "https://simudyne.jfrog.io/simudyne/releases"
credentials += Credentials(file(".credentials"))

javacOptions ++= Seq("-source", "1.8", "-target", "1.8", "-encoding", "UTF-8")
scalacOptions ++= Seq("-target:jvm-1.8", "-deprecation", "-feature", "-unchecked")

lazy val simudyneVersion = "2.5.0"
libraryDependencies ++= Seq(
  "simudyne" %% "simudyne-nexus-server" % simudyneVersion,
  "simudyne" %% "simudyne-core" % simudyneVersion,
  "simudyne" %% "simudyne-core-abm" % simudyneVersion,
  "simudyne" %% "simudyne-core-graph" % simudyneVersion,
  "simudyne" %% "simudyne-core-abm-testkit" % simudyneVersion
)

libraryDependencies += "org.codehaus.jettison" % "jettison" % "1.4.1"

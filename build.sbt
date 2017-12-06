name := "providence-sbt-example"

version := "0.1"

scalaVersion := "2.11.12"

resolvers += "Artifactory Realm" at "https://simudyne.jfrog.io/simudyne/sbt-dev"
credentials += Credentials(file(".credentials"))

lazy val providenceVersion = "2.0.0-alpha.1"
libraryDependencies ++= Seq(
  "simudyne" %% "providence-simucom" % providenceVersion,
  "simudyne" %% "providence-simucore" % providenceVersion,
  "simudyne" %% "providence-simucore-abm" % providenceVersion
)
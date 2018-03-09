name := "simudyne-sbt-java"

version := "0.1"

scalaVersion := "2.11.12"
logLevel := Level.Info

resolvers += "Artifactory Realm" at "https://simudyne.jfrog.io/simudyne/releases"
credentials += Credentials(file(".credentials"))

javacOptions ++= Seq("-source", "1.8", "-target", "1.8", "-encoding", "UTF-8")
scalacOptions ++= Seq("-target:jvm-1.8", "-deprecation", "-feature", "-unchecked")

lazy val simudyneVersion = "2.0.0-beta.2"
libraryDependencies ++= Seq(
  "simudyne" %% "simudyne-nexus-server" % simudyneVersion,
  "simudyne" %% "simudyne-core" % simudyneVersion,
  "simudyne" %% "simudyne-core-abm" % simudyneVersion
)

//*** SBT ASSEMBLY ***

assemblyMergeStrategy in assembly := {
  case PathList("META-INF", xs @ _*) => MergeStrategy.discard
  //akka configuration files
  case PathList("reference.conf") => MergeStrategy.concat
  case _ => MergeStrategy.first
}
assemblyJarName in assembly := "simudyne-sbt-docker.jar"


//*** SBT DOCKER ***

enablePlugins(sbtdocker.DockerPlugin)
// Generating docker file
dockerfile in docker := {
  val artifact: File = assembly.value
  val artifactTargetPath = s"/${artifact.name}"

  new Dockerfile {
    from("simudyne/scala-sbt:2.11.12.1.0.4")
	copy(baseDirectory(_ / "simudyneSDK.properties" ).value, s"/simudyneSDK.properties")
    copy(artifact, artifactTargetPath)
    entryPoint("java", "-jar", artifactTargetPath)
  }
}
imageNames in docker := Seq(
  ImageName(s"${name.value}-$simudyneVersion:latest")
)
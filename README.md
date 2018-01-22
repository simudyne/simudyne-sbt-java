# Simudyne SBT Java Skeleton

This repository serves as a simple working example of using Simudyne from Java using the SBT build tool.

You need to have SBT installed, or provided through an IDE such as Eclipse or IntelliJ. Because Simudyne jars are
served from an authenticated artifact repository, you will need to provide information to SBT on where this repository
is located and your credentials.

These settings are located in `.credentials` file.

### Running the project
* Update .credentials with your simudyne credentials
* Open a terminal at the project directory, and run `sbt run`

## Distributing the project with Spark

You can start your distributed project from the preconfigured project for SBT and Spark : [https://bitbucket.org/simudyne/simudyne-sbt-java-spark](https://bitbucket.org/simudyne/simudyne-sbt-java-spark)

Or you can follow [those instructions](https://docs.simudyne.com/v2.0/docs/adding-spark-to-your-simudyne-sbt-java-project) to distribute an existing Simudyne SBT Java project. 
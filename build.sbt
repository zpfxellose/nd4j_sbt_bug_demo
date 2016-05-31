name := "indLearner"

version := "1.0"

scalaVersion := "2.11.8"


resolvers ++= Seq(
  "Sonatype Snapshots" at "http://oss.sonatype.org/content/repositories/snapshots",
  "Sonatype Releases" at "http://oss.sonatype.org/content/repositories/releases"//,
  // "Jzy3d Snapshots" at "http://maven.jzy3d.org/snapshots",
  // "Jzy3d Releases" at "http://maven.jzy3d.org/releases"
)

libraryDependencies += "io.lamma" %% "lamma" % "2.2.2"
//libraryDependencies += "org.slf4j" % "slf4j-log4j12" % "1.7.19"
//libraryDependencies += "com.github.nscala-time" %% "nscala-time" % "1.8.0"

libraryDependencies ++= Seq(
  "org.scala-saddle" %% "saddle-core" % "1.3.4",
  "com.quantifind" %% "wisp" % "0.0.4",
//  "org.nd4j" % "nd4j-x86" % "0.4-rc3.8",
//  "org.nd4j" % "nd4j-api" % "0.4-rc3.8",
//  "org.nd4j" % "nd4j-native" % "0.4-rc3.9" % "provided",
  "org.nd4j" % "nd4s_2.11" % "0.4-rc3.8",
  "org.nd4j" % "canova-api" % "0.0.0.15",
  "org.deeplearning4j" % "deeplearning4j-core" % "0.4-rc3.9"
)

classpathTypes += "maven-plugin"
libraryDependencies += "org.nd4j" % "nd4j-native" % "0.4-rc3.9" classifier "macosx-x86_64"



initialCommands in console :=
  """import org.zhangyu.quant._
    |    import io.lamma._
    |    import com.quantifind.charts.Highcharts._
    |    import IndicatorFactory._
  """.stripMargin

libraryDependencies ++= Seq(
  "org.scalikejdbc" %% "scalikejdbc"       % "2.3.5",
  "ch.qos.logback"  %  "logback-classic"   % "1.1.3"
)


assemblyMergeStrategy in assembly := {
  case x if x.endsWith("io.netty.versions.properties") => MergeStrategy.first
  case x =>
    val oldStrategy = (assemblyMergeStrategy in assembly).value
    oldStrategy(x)
}



// libraryDependencies += "org.jzy3d" % "jzy3d-api" % "1.0.0-SNAPSHOT"
mainClass in assembly := Some("org.zhangyu.quant.IndicatorLearner")

libraryDependencies += "mysql" % "mysql-connector-java" % "5.1.6"

//libraryDependencies += "io.continuum.bokeh" % "bokeh_2.11" % "0.7"

//libraryDependencies += "org.payphone" %% "sbokeh" % "0.1-SNAPSHOT"



cancelable in Global := true
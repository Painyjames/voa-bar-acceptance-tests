import play.core.PlayVersion

name := "voa-bar-acceptance-tests"

version := "0.0.1"

scalaVersion := "2.11.11"

val ScalatestVersion = "3.0.4"
val seleniumVersion = "3.6.0"
val seleniumHtmlUnitVersion = "2.33.0"
val guavaVersion = "23.0"
val CucumberVersion = "1.2.5"

credentials += Credentials(Path.userHome / ".sbt" / ".credentials")

val hmrcRepoHost = java.lang.System.getProperty("hmrc.repo.host", throw new Exception())

scalacOptions ++= Seq("-unchecked", "-deprecation")

resolvers ++= Seq(
  "hmrc-snapshots" at hmrcRepoHost + "/content/repositories/hmrc-snapshots",
  "hmrc-releases" at hmrcRepoHost + "/content/repositories/hmrc-releases",
  "typesafe-releases" at hmrcRepoHost + "/content/repositories/typesafe-releases")

resolvers += "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/"


libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % ScalatestVersion % "test",
  "org.seleniumhq.selenium" % "selenium-java" % seleniumVersion % "test",
  "org.seleniumhq.selenium" % "htmlunit-driver" % seleniumHtmlUnitVersion % "test",
  "com.google.guava" % "guava" % guavaVersion % "test",
  "info.cukes" % "cucumber-junit" % CucumberVersion % "test",
  "info.cukes" % "cucumber-picocontainer" % CucumberVersion % "test",
  "info.cukes" %% "cucumber-scala" % CucumberVersion % "test",
  "com.typesafe.play" %% "play-test" % PlayVersion.current
)

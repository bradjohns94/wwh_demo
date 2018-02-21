name := "Demo API"
description := "A Scala REST API for the Arbor Networks Winter Wonder Hack Demo"

scalaVersion := "2.11.12"

assemblyJarName in assembly := "demo-api.jar"

libraryDependencies ++= {
	val akkaV = "2.3.9"
  val sprayV = "1.3.4"
  Seq(
    "io.spray"            %%  "spray-can"     % sprayV,
		"io.spray"						%%	"spray-json"		%	sprayV,
    "io.spray"            %%  "spray-routing" % sprayV,
    "io.spray"            %%  "spray-testkit" % sprayV  % "test",
    "com.typesafe.akka"   %%  "akka-actor"    % akkaV,
    "com.typesafe.akka"   %%  "akka-testkit"  % akkaV   % "test",
		"org.apache.kafka" 		%% 	"kafka" 				% "1.0.0"
  )
}

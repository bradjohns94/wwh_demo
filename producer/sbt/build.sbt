name := "Kafka Producer"
description := "Producer to Generate Data to Displayed in the WWH Demo UI"

scalaVersion := "2.11.12"

assemblyJarName in assembly := "producer.jar"

libraryDependencies ++= Seq(
	"org.apache.kafka" %% "kafka" % "1.0.0"
)

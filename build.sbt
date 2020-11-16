name := "KafkaProducer"

version := "0.1"

scalaVersion := "2.11.12"

val kafkaVersion = "2.1.0"
val gson = "1.7.1"


// Kafka for testing
libraryDependencies += "org.apache.kafka" %% "kafka" % kafkaVersion
libraryDependencies += "com.google.code.gson" % "gson" % gson


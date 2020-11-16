package ru.dayneko

import java.util.{Collections, Properties}
import org.apache.kafka.clients.consumer.KafkaConsumer
import scala.collection.JavaConverters._

object KafkaConsumer {

  def main(args: Array[String]): Unit = {

    val props = new Properties()

    props.put("bootstrap.servers", "localhost:9092")
    props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
    props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
    props.put("group.id", "my-group")

    val consumer = new KafkaConsumer[String, String](props)

    consumer.subscribe(Collections.singleton("esf.streaming_1"))

    while(true) {
      val records = consumer.poll(java.time.Duration.ofMillis(100))

      for (item <- records.asScala) {
        println(item.value())
      }
    }
  }
}

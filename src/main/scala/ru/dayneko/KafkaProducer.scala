package ru.dayneko

import java.util.Properties

import org.apache.kafka.clients.producer.{Callback, KafkaProducer, ProducerRecord, RecordMetadata}

object KafkaProducer {

  def main(args: Array[String]): Unit = {
    val props = new Properties()

    props.put("bootstrap.servers", "localhost:9092")
    props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer")
    props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer")

    val producer = new KafkaProducer[String, String](props)

    val record = new ProducerRecord[String, String]("esf.streaming_1", "0492834098230948209342",  " 4324982340923")

      producer.send(record, new Callback {
        override def onCompletion(metadata: RecordMetadata, exception: Exception): Unit = {
          println("--------------")

          println(metadata.offset)
          println(metadata.partition)
          println(metadata.topic)

          println("--------------")
        }
      })

    producer.close()
  }
}


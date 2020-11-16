package ru.dayneko

import java.io.{ByteArrayOutputStream, ObjectOutputStream}
import java.util

import org.apache.kafka.common.serialization.Serializer

case class MaObject(id: String, name: String)

class MyObjectSerializer extends Serializer[MaObject] {
  override def configure(configs: util.Map[String, _], isKey: Boolean): Unit = { }

  override def serialize(topic: String, data: MaObject): Array[Byte] = {
    val byteOut = new ByteArrayOutputStream()
    val objOut = new ObjectOutputStream(byteOut)
    objOut.writeObject(data)
    objOut.close()
    byteOut.close()
    byteOut.toByteArray
  }

  override def close(): Unit = { }

}

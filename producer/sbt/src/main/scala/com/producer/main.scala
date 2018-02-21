import org.apache.kafka.clients.producer._

import java.util.Properties

object Main {
	val props = new Properties()
  props.put("bootstrap.servers", "bootstrap.kafka.svc.cluster.local:9092")
	props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer")
	props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer")

	val producer = new KafkaProducer[String, String](props)
	val TOPIC = "test"

	def main(args: Array[String]): Unit = {
		while (true) {
			// Send a message every 5 seconds
			producer.send(new ProducerRecord(TOPIC, "sample key", "sample value"))
			Thread.sleep(5000)
		}
	}
}

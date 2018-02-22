import org.apache.kafka.clients.producer._

import java.util.Properties
import scala.util.Random

object Main {
	val props = new Properties()
  props.put("bootstrap.servers", "bootstrap.kafka.svc.cluster.local:9092")
	props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer")
	props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer")

	val producer = new KafkaProducer[String, Int](props)
	val topic = "indicators"
	val rand = new Random()

	def main(args: Array[String]): Unit = {
		while (true) { // Send Indicators at Random Intervals
			producer.send(new ProducerRecord(topic, sys.env("POD_NAME"), 1))
			Thread.sleep(rand.nextInt(500))
		}
	}
}

import org.apache.kafka.clients.consumer.KafkaConsumer

import java.util
import java.util.Properties
import scala.collection.JavaConverters._

class Consumer(topic: String) {
	val  props = new Properties()
  props.put("bootstrap.servers", "bootstrap.kafka.svc.cluster.local:9092")
  props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
  props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
  props.put("group.id", "something")

	val consumer = new KafkaConsumer[String, Int](props)
	consumer.subscribe(util.Collections.singletonList(topic))

	def poll(timeout: Int): Iterable[(String, Int)] = {
		consumer.poll(timeout).asScala.map{ x => (x.key(), x.value()) }
	}
}

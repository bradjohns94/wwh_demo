import akka.actor.Actor
import akka.actor.ActorSystem
import spray.routing._
import spray.http._
import spray.json._
import spray.routing.SimpleRoutingApp
import DefaultJsonProtocol._
import MediaTypes._

import scala.util.{Try, Success, Failure}

object Main extends App with SimpleRoutingApp {
	implicit val system = ActorSystem("wwh-demo")
	val consumer = new Consumer("indicators")

	startServer(interface = "localhost", port = 80) {
		path("") {
			get {
				respondWithMediaType(`application/json`) {
					complete {
						poll.prettyPrint
					}
				}
			}
		}
	}

	def poll: JsValue = {
		consumer.poll(100).foldLeft(Map[String, Int]()) { (dict, pair) =>
			dict + (pair._1 -> (pair._2 + dict.getOrElse(pair._1, 0)))
		}.toJson
	}
}

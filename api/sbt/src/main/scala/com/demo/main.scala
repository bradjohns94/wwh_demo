import akka.actor.Actor
import spray.routing._
import spray.http._
import spray.json._
import MediaTypes._

import akka.actor.ActorSystem
import spray.routing.SimpleRoutingApp

object Main extends App with SimpleRoutingApp {
	implicit val system = ActorSystem("wwh-demo")

	startServer(interface = "localhost", port = 80) {
		path("") {
			get {
				respondWithMediaType(`application/json`) {
					complete {
						getData.prettyPrint
					}
				}
			}
		}
	}

	def getData: JsValue = {
		try {
			JsObject(
				"val" -> JsString("Success"),
				"err" -> JsBoolean(false)
			)
		}
		catch {
				case e: Throwable => JsObject(
					"val" -> JsString("Failure"),
					"err" -> JsBoolean(true)
				)
		}
	}

	/*
	def main(args: Array[String]): Unit = {
		val consumer = new Consumer("test")
		while (true) {
			consumer.poll(100).foreach{msg =>
				println(msg)
			}
		}
	}
	*/
}

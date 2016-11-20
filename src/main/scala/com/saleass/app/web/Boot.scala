package com.saleass.app.web

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.model._
import akka.http.scaladsl.server.Directives._
import akka.stream.ActorMaterializer
import scala.io.StdIn

object Boot extends App {
  implicit val system = ActorSystem("saleass")
  implicit val mat = ActorMaterializer()
  implicit val ec = system.dispatcher

  val route = path("hello") {
    get {
      complete(HttpEntity(ContentTypes.`text/html(UTF-8)`, "<h1>Damn you av!"))
    }
  }

  val httpBindFuture = Http().bindAndHandle(route, "localhost", 8080)
  StdIn.readLine()
  httpBindFuture.flatMap(_.unbind()).onComplete(_ => system.terminate())
}

package example.myapp.helloworld

/**
 * @author Yang Jing <a href="mailto:yang.xunjing@qq.com">yangbajing</a>
 * @since 2021-11-25 15:04:04
 */

import akka.actor.typed.ActorSystem
import akka.actor.typed.scaladsl.Behaviors
import akka.grpc.scaladsl.{ServerReflection, ServiceHandler, WebHandler}
import akka.http.scaladsl.Http
import akka.http.scaladsl.model.{HttpRequest, HttpResponse}
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import com.typesafe.config.ConfigFactory
import example.myapp.helloworld.grpc._

import scala.concurrent.Future

object GreeterServer {
  def main(args: Array[String]): Unit = {
    // Important: enable HTTP/2 in ActorSystem's config
    // We do it here programmatically, but you can also set it in the application.conf
    val conf = ConfigFactory
      .parseString("akka.http.server.preview.enable-http2 = on")
      .withFallback(ConfigFactory.defaultApplication())
    val system = ActorSystem[Nothing](Behaviors.empty, "HelloWorld", conf)
    new GreeterServer()(system).run()
    // ActorSystem threads will keep the app alive until `system.terminate()` is called
  }
}

class GreeterServer()(implicit val system: ActorSystem[_]) {
  def run(): Future[Http.ServerBinding] = {
    import system.executionContext

    // Create service handlers

    val greeterService: PartialFunction[HttpRequest, Future[HttpResponse]] = GreeterServicePowerApiHandler.partial(new GreeterServiceImpl())

    val reflectionService = ServerReflection.partial(List(GreeterService))

    val grpcWebServiceHandlers: HttpRequest => Future[HttpResponse] = WebHandler.grpcWebHandler(greeterService)

    val serviceHandlers: HttpRequest => Future[HttpResponse] =
      ServiceHandler.concatOrNotFound(greeterService, reflectionService)

    val route: Route = {
      extractRequest { request =>
        complete(serviceHandlers(request))
      } ~
        extractRequest { request =>
          complete(grpcWebServiceHandlers(request))
        }
    }

    // Bind service handler servers to localhost:8080/8081
    val binding = Http().newServerAt("127.0.0.1", 8080).bind(route)

    // report successful binding
    binding.foreach { binding => println(s"gRPC server bound to: ${binding.localAddress}") }

    binding
  }
}
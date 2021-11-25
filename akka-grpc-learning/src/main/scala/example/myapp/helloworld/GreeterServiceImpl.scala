package example.myapp.helloworld

/**
 * @author Yang Jing <a href="mailto:yang.xunjing@qq.com">yangbajing</a>
 * @since 2021-11-25 14:57:13
 */

import akka.NotUsed
import akka.actor.typed.ActorSystem
import akka.grpc.scaladsl.Metadata
import akka.stream.scaladsl.{Sink, Source}
import com.google.protobuf.timestamp.Timestamp
import example.myapp.helloworld.grpc._

import scala.concurrent.Future

class GreeterServiceImpl(implicit val system: ActorSystem[_]) extends GreeterServicePowerApi {
  import system.executionContext

  override def sayHello(in: HelloRequest, metadata: Metadata): Future[HelloReply] = {
    println(s"sayHello to ${in.name}")
    Future.successful(HelloReply(s"Hello, ${in.name}", Some(Timestamp.apply(123456, 123))))
  }

  override def itKeepsTalking(in: Source[HelloRequest, NotUsed], metadata: Metadata): Future[HelloReply] = {
    println(s"sayHello to in stream...")
    in.runWith(Sink.seq).map(elements => HelloReply(s"Hello, ${elements.map(_.name).mkString(", ")}"))
  }

  override def itKeepsReplying(in: HelloRequest, metadata: Metadata): Source[HelloReply, NotUsed] = {
    println(s"sayHello to ${in.name} with stream of chars...")
    Source(s"Hello, ${in.name}".toList).map(character => HelloReply(character.toString))
  }

  override def streamHellos(in: Source[HelloRequest, NotUsed], metadata: Metadata): Source[HelloReply, NotUsed] = {
    println(s"sayHello to stream...")


    in.map(request => HelloReply(s"Hello, ${request.name}"))
  }
}
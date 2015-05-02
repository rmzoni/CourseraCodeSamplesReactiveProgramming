package coursera.socket.safe {

import scala.concurrent.{ExecutionContext, Future}
import ExecutionContext.Implicits.global

  object Request {
     def apply(bytes: Array[Byte]): Request = new Request{
       val data = bytes
     }
  }

  trait Request{}

  object Response {
    def apply(bytes: Array[Byte]): Response = new Response{
      def isOK: Boolean = bytes.length > 0
      def body: Array[Byte] = bytes
    }
  }

  trait Response{
    def isOK: Boolean
    def body: Array[Byte]
  }

  object Http {
   def apply(url: String, request: Request): Future[Response] = Future{
     Response(url.getBytes)
   }
  }

}

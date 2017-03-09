import play.api.http.HttpErrorHandler
import play.api.mvc._
import play.api.mvc.Results._

import scala.concurrent._
import javax.inject.Singleton

import controllers.routes;

@Singleton
class ErrorHandler extends HttpErrorHandler {

  def onClientError(request: RequestHeader, statusCode: Int, message: String) = {
    statusCode match {
      case 404 => Future.successful(Status(statusCode)("Page Not Found Error"))
      case 400 => Future.successful(Redirect(routes.LoginController.index()))
      case _ => Future.successful(BadRequest)
    }
  }
  def onServerError(request: RequestHeader, exception: Throwable) = {
    Future.successful(
      InternalServerError("A server error occurred: " + exception.getMessage)
    )
  }
}

package controllers
import services.{Login, bufferService}
import javax.inject.Inject

import play.api.data.Form
import play.api.data.Forms._
import play.api.mvc.{Action, Controller}
import play.http._
import scala.collection.mutable.ListBuffer

/**
  * Created by knoldus on 3/6/17.
  */
class Logout @Inject() extends Controller{
  def logout = Action{ implicit request=>

    Redirect(routes.LoginController.index()).withNewSession
  }

}

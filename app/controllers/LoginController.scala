package controllers
import services.{Login, SignUp, bufferService}
import javax.inject.Inject

import play.api.data.Form
import play.api.data.Forms._
import play.api.mvc.{Action, Controller}
import play.http._

import scala.collection.mutable.ListBuffer


class LoginController @Inject() extends Controller {

  val logIn:Form[Login]= Form (
    mapping(
      "username" -> nonEmptyText ,
      "password"  -> nonEmptyText
    )(Login.apply)(Login.unapply)
  )

def index = Action { implicit request=>
  Ok(views.html.Login())
}
  def userProfile(username:String)= Action { implicit  request =>

    val users = bufferService.getAllUsers
    val result = users.map(user=>if(user.username == username) Some(user) else None)
    val res:List[SignUp]=result.flatten.toList
    Ok(views.html.profile(res,request))
  }


  def login = Action { implicit  request =>
    logIn.bindFromRequest.fold(
      formWithErrors => {
        BadRequest(views.html.Login())
      },
      loginData => {
        val user = bufferService.getUser(loginData.username)
        Console.println(user)
        if(user.password == loginData.pswd && user.username == loginData.username)

          Redirect(routes.LoginController.userProfile(loginData.username)).withSession("currentUser"->loginData.username).flashing("message"->"Login Successful :)")
        else
          Redirect(routes.LoginController.index()).flashing("msg"->"Incorrect username or password")
      })
  }

}

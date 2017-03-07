package controllers
import services.{Login, bufferService}
import javax.inject.Inject
import services._
import play.api.data.Form
import play.api.data.Forms._
import play.api.mvc.{Action, Controller}

import scala.collection.mutable.ListBuffer

class SignupController @Inject() extends Controller{

  def index = Action { implicit request=>
    Ok(views.html.signup())
  }


  val signUp:Form[SignUp]= Form (
    mapping(
      "username" -> nonEmptyText ,
      "email"  -> nonEmptyText,
      "password" ->nonEmptyText,
      "re_password"->nonEmptyText,
      "dob" ->nonEmptyText,
      "country"->nonEmptyText,
      "gender"-> nonEmptyText
    )(SignUp.apply)(SignUp.unapply)
  )
  def signingUp = Action { implicit  request =>
    signUp.bindFromRequest.fold(
      formWithErrors => {
        Redirect(routes.LoginController.index()).flashing("message"->"Sorry something Went Wrong,Try Again Later")
      },
      signinData => {
        val user = signUp.bindFromRequest.get
   bufferService.addUser(user)
        Console.println("Its Working")
        Redirect(routes.LoginController.userProfile(signinData.username)).withSession("currentUser"->signinData.username).flashing("message"->"Login Successful :)")

      })
  }
}

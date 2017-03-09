package controllers
import services.{bufferService}
import javax.inject.Inject

import play.api.Configuration
import play.api.cache._
import services._
import play.api.data.Form
import play.api.data.Forms._
import play.api.mvc.{Action, Controller}
import models._
import scala.collection.mutable.ListBuffer

class SignupController @Inject() (cache: CacheApi, cacheService: CacheTrait , configuration: Configuration) extends Controller{

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
      "gender"-> nonEmptyText,
      "isRole"->boolean,
      "isAllow"->boolean
    )(SignUp.apply)(SignUp.unapply)
  )
  def signingUp = Action { implicit  request =>
    signUp.bindFromRequest.fold(
      formWithErrors => {
        Redirect(routes.LoginController.index()).flashing("message"->"Sorry something Went Wrong,Try Again Later")
      },
      signupData => {
        val user =  cacheService.getCache(signupData.username)

       // val user =  cache.get[services.SignUp](signinData.username)
        //val users=user.get
        if(user!=None) {
          Redirect(routes.SignupController.index()).flashing("msg"->"Username already exist")
        }
        else {
          if (signupData.password != signupData.re_password) {
            Redirect(routes.SignupController.index()).flashing("msg"->"passwsord not match")
          } else {
            val encrypterUser = signupData.copy(password = Encrypter.hash(signupData.password))
            bufferService.addUser(signupData.username)
            cacheService.setCache(signupData.username, encrypterUser)
            Redirect(routes.LoginController.userProfile(signupData.username)).withSession("currentUser" -> signupData.username).flashing("message" -> "Login Successful :)")
          }
        }
        })
  }
}

package controllers
import services.{Login, bufferService}
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
      signinData => {
        val user =  cacheService.getCache(signinData.username)

       // val user =  cache.get[services.SignUp](signinData.username)
        //val users=user.get
        if(user!=None) {
          Redirect(routes.SignupController.index()).flashing("msg"->"Username already exist")
        }
        else {
          val encrypterUser=signinData.copy(password = Encrypter.hash(signinData.password))
          println(encrypterUser)
          cacheService.setCache(signinData.username, encrypterUser)
          Console.println("Its Working")
          Redirect(routes.LoginController.userProfile(signinData.username)).withSession("currentUser" -> signinData.username).flashing("message" -> "Login Successful :)")
        }
        })
  }
}

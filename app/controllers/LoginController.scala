package controllers
import services._
import javax.inject.Inject
import models._
import play.api.Configuration
import play.api.data.Form
import play.api.data.Forms._
import play.api.mvc.{Action, Controller}
import play.http._
import play.api.cache._

import scala.collection.mutable.ListBuffer


class LoginController @Inject()(cache: CacheApi, cacheService:CacheTrait, configuration: Configuration) extends Controller {

  val logIn:Form[Login]= Form (
    mapping(
      "username" -> nonEmptyText ,
      "password"  -> nonEmptyText
    )(Login.apply)(Login.unapply)
  )

def index = Action { implicit request=>
  Ok(views.html.Login())
}
  def userProfile(username:String)= Action { implicit request =>
    val users = cache.get[services.SignUp](username)
        val result = users.map(user=>if(user.username == username) Some(user) else None)

    val res: List[SignUp] = result.flatten.toList
    Ok(views.html.profile(res,request))
  }
//    val users = bufferService.getAllUsers
//    val result = users.map(user=>if(user.username == username) Some(user) else None)
//    val res:List[SignUp]=result.flatten.toList
//    Ok(views.html.profile(res,request))


  def login = Action { implicit  request =>
    logIn.bindFromRequest.fold(
      formWithErrors => {
        BadRequest(views.html.Login())
      },
      loginData => {
        val user =  cacheService.getCache(loginData.username)

        //val user =  cache.get[services.SignUp](loginData.username)
        //        val user = bufferService.getUser(loginData.username)
        Console.println(user)
        val users=user.get
//        if(users.password == loginData.password && users.username == loginData.username)
          if(users.password == Encrypter.hash(loginData.password) && users.username == loginData.username)
            Redirect(routes.LoginController.userProfile(loginData.username)).withSession("currentUser"->loginData.username).flashing("message"->"Login Successful :)")
        else
          Redirect(routes.LoginController.index()).flashing("msg"->"Incorrect username or password")
      })
  }

}

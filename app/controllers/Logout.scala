package controllers
import javax.inject.Inject

import play.api.mvc.{Action, Controller}

/**
  * Created by knoldus on 3/6/17.
  */
class Logout @Inject() extends Controller{
  def logout = Action{ implicit request=>

    Redirect(routes.LoginController.index()).withNewSession
  }

}

package ControllerSpec

import org.scalatestplus.play._
import play.api.test.Helpers._
import play.api.test._

/**
  * Created by akash on 29/2/16.
  */
class LoginControllerSpec extends PlaySpec with OneAppPerTest {


  "index in LoginController" should {

    "render the index page" in {
      val login = route(app, FakeRequest(GET, "/login")).get

      status(login) mustBe OK
      contentType(login) mustBe Some("text/html")
      contentAsString(login) must include("Login Form")
    }
  }
  "index in LoginController" should {

    "render the logout controller" in {
      val logout = route(app, FakeRequest(GET, "/logout")).get

      status(logout) equals 303

    }
  }

}
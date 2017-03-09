package router

import org.scalatestplus.play.{OneAppPerTest, PlaySpec}
import play.api.test.FakeRequest
import play.api.test.Helpers._

class RouterSpec extends PlaySpec with OneAppPerTest {

  "Routes" should {

    "respond to the index Action" in new App() {
      val Some(result) = route(app, FakeRequest(GET, "/"))
      status(result) mustBe OK
      contentType(result) mustBe ("text/html")
      charset(result) mustBe ("utf-8")
      contentAsString(result) must contain("Welcome Page")
    }

    "respond to the signUp Action" in new App() {
      val Some(result) = route(app, FakeRequest(GET, "/signup"))
      status(result) mustBe OK
      contentType(result) mustBe ("text/html")
      charset(result) mustBe ("utf-8")
      contentAsString(result) must contain("Register Form")
    }

    "respond to the signIn Action" in new App() {
      val Some(result) = route(app, FakeRequest(GET, "/login"))
      status(result) mustBe OK
      contentType(result) mustBe ("text/html")
      charset(result) mustBe ("utf-8")
      contentAsString(result) must contain("Login Form")
    }

    "respond to the signUp Form Action" in new App() {
      val Some(result) = route(app, FakeRequest(POST, "/userlogin"))
      status(result) mustBe OK
      contentType(result) mustBe ("text/html")
      charset(result) mustBe ("utf-8")
      contentAsString(result) must contain("User Profile")
    }

    "respond to the signIn Form Action" in new App() {
      val Some(result) = route(app, FakeRequest(POST, "/adduser"))
      status(result) mustBe OK
      contentType(result) mustBe ("text/html")
      charset(result) mustBe ("utf-8")
      contentAsString(result) must contain("UserName")
    }

    "respond to the profile Action" in new App() {
      val Some(result) = route(app, FakeRequest(GET, "/logout"))
      status(result) mustBe OK
      contentType(result) mustBe ("text/html")
      charset(result) mustBe ("utf-8")
      contentAsString(result) must contain("Login Form")
    }

    "respond to the Logout Action" in new App() {
      val Some(result) = route(app, FakeRequest(GET, "/manage"))
      status(result) mustBe OK
      contentType(result) mustBe ("text/html")
      charset(result) mustBe ("utf-8")
      contentAsString(result) must contain("This is Management Page")
    }

    "respond to the home Action" in new App() {
      val Some(result) = route(app, FakeRequest(GET, "/suspend"))
      status(result) mustBe OK
      contentType(result) mustBe ("text/html")
      charset(result) mustBe ("utf-8")
      contentAsString(result) must contain("Admin Users")
    }

    "respond to the management/resume Action" in new App() {
      val Some(result) = route(app, FakeRequest(GET, "/resume"))
      status(result) mustBe OK
      contentType(result) mustBe ("text/html")
      charset(result) mustBe ("utf-8")
      contentAsString(result) must contain("users")
    }
  }
}
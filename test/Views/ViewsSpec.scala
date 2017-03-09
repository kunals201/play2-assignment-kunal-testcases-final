package Views
import models.SignUp
import org.scalatest.mock.MockitoSugar
import play.api.mvc.Flash
import play.api.test.Helpers._
import org.scalatestplus.play.{OneAppPerTest, PlaySpec}
import play.api.test.FakeRequest

class ViewsSpec extends PlaySpec with MockitoSugar {
  "Rending landing / index page================================" in new App {
    val fakeFlash = mock[Flash]
    val html = views.html.index()(fakeFlash)
    contentAsString(html) must include("Play Application")
  }
  "Rending profile page================================" in new App {
    val fakeFlash = mock[Flash]
    val html = views.html.profile(

      List(SignUp("aa", "aa", "aa", "aa", "aa", "aa", "", true, true)), FakeRequest(GET, "/profilepage")

    )(fakeFlash)
    contentAsString(html) must include("aa")

  }
  "Rending manage page================================" in new App {
      val fakeFlash = mock[Flash]
      val html = views.html.Manage(List(SignUp("aa","aa","aa","aa","aa","aa","aa",true,true)))(fakeFlash)

      contentAsString(html) must include ("Admin Users")

  }
  "Rending signup page================================" in new App {
    val fakeFlash = mock[Flash]
    val html = views.html.signup()(fakeFlash)

    contentAsString(html) must include ("Registration Form")

  }
  "Rending login page================================" in new App {
    val fakeFlash = mock[Flash]
    val html = views.html.Login()(fakeFlash)

    contentAsString(html) must include ("Login Form")

  }
  "Rending welcome page================================" in new App {
    val fakeFlash = mock[Flash]
    val html = views.html.welcome(fakeFlash)

    contentAsString(html) must include ("Welcome")
  }
  "Rending main page================================" in new App {
    val fakeFlash = mock[Flash]
    val html = views.html.main("")(views.html.Login()(fakeFlash))

    contentAsString(html) must include ("Welcome")
  }
}
//import org.scalatestplus.play._
//import play.api.test._
//import play.api.test.Helpers._
//
///**
// * Add your spec here.
// * You can mock out a whole application including requests, plugins etc.
// * For more information, consult the wiki.
// */
//class ApplicationSpec extends PlaySpec with OneAppPerTest {
//
//  "Routes" should {
//
//    "send 404 on a bad request" in  {
//      route(app, FakeRequest(GET, "/boum")).map(status(_)) mustBe Some(NOT_FOUND)
//    }
//
//  }
//
//  "HomeController" should {
//
//    "render the index page" in {
//      val home = route(app, FakeRequest(GET, "/")).get
//
//      status(home) mustBe OK
//      contentType(home) mustBe Some("text/html")
//      contentAsString(home) must include ("Your new application is ready.")
//    }
//
//  }
//
//  "CountController" should {
//
//    "return an increasing count" in {
//      contentAsString(route(app, FakeRequest(GET, "/count")).get) mustBe "0"
//      contentAsString(route(app, FakeRequest(GET, "/count")).get) mustBe "1"
//      contentAsString(route(app, FakeRequest(GET, "/count")).get) mustBe "2"
//    }
//
//  }
//
//}

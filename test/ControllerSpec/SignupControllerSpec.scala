package ControllerSpec

import org.scalatestplus.play._
import play.api.test.Helpers._
import play.api.test._

/**
  * Created by akash on 29/2/16.
  */
class SignupControllerSpec extends PlaySpec with OneAppPerTest {


  "index in SignupController" should {

    "render the index page" in {
      val signup = route(app, FakeRequest(GET, "/signup")).get

      status(signup) mustBe OK
      contentType(signup) mustBe Some("text/html")
      contentAsString(signup) must include("Registration Form")
    }
  }
  "suspendUser in SigningupControllerMethod" should {

    "render the signUp page" in {
      val result = route(app, FakeRequest(POST,"/adduser")).get
      status(result) equals 303
    }
  }


}
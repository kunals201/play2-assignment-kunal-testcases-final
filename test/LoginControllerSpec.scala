//import controllers.LoginController
//import org.specs2.mutable._
//import org.specs2.runner._
//import org.junit.runner._
//import org.scalatest.junit.JUnitRunner
//import play.api.cache.CacheApi
//import play.api.test._
//import play.api.test.Helpers._
//import play.test.WithApplication
//import play.api.libs.concurrent.Execution.Implicits.defaultContext
//
//import scala.concurrent.Future
//import scala.concurrent.duration.Duration
///**
//  * Created by akash on 29/2/16.
//  */
//class LoginSpec extends Specification {
//
//  "Example Page#index" should {
//    "should be valid" in {
//      val cache=new CacheApi {override def set(key: String, value: Any, expiration: Duration) = ???
//
//        override def get[T](key: String)(implicit evidence$2: ClassManifest[T]) = ???
//
//        override def getOrElse[A](key: String, expiration: Duration)(orElse: => A)(implicit evidence$1: ClassManifest[A]) = ???
//
//        override def remove(key: String) = ???
//      }
//      val controller = new LoginController(cache)
//      val result = controller.index().apply(FakeRequest())
//      contentType(result) must beSome.which(_ == "text/html")
//      contentAsString(result) must contain("Login")
//      status(result) must equalTo(OK)
//    }
//    "render the login page with Sessions" in new WithApplication {
//            val home = route(FakeRequest(GET, "/login").withSession("email" -> "some@email.com")).get
//            status(home) must equalTo(OK)
//            contentType(home) must beSome.which(_ == "text/html")
//            contentAsString(home) must contain("Home Page")
//    }
//      //
//  }
////  "Login" should {
////
////    "render the login page" in new WithApplication {
////      val home = route(FakeRequest(GET, "/login")).get
////      status(home) must equalTo(OK)
////      contentType(home) must beSome.which(_ == "text/html")
////      contentAsString(home) must contain("Login")
////    }
////
////    "render the login page with Sessions" in new WithApplication {
////      val home = route(FakeRequest(GET, "/login").withSession("email" -> "some@email.com")).get
////      status(home) must equalTo(OK)
////      contentType(home) must beSome.which(_ == "text/html")
////      contentAsString(home) must contain("Home Page")
////    }
////
////    "Login the Form using Valid Fields" in new WithApplication {
////      val login = route(FakeRequest(POST, "/submit").withFormUrlEncodedBody("email" -> "akash.sethi@knoldus.in", "password" -> "akash")).get
////      status(login) must equalTo(303)
////    }
////
////    "Login the Form using InValid Fields" in new WithApplication {
////      val login = route(FakeRequest(POST, "/submit").withFormUrlEncodedBody("email" -> "aksh.sethi@knoldus.in", "password" -> "akash")).get
////      status(login) must equalTo(303)
////    }
////
////    "Login the Form using Empty Fields" in new WithApplication {
////      val login = route(FakeRequest(POST, "/submit").withFormUrlEncodedBody("email" -> "", "password" -> "")).get
////      status(login) must equalTo(400)
////    }
////
////  }
//}
package service

import models._
import org.mockito.Mockito._
import org.scalatest.mock.MockitoSugar
import org.scalatestplus.play.PlaySpec
import play.api.cache.CacheApi
import services._

class ServiceSpec extends PlaySpec with MockitoSugar {

  "UserService" should {
    "set list" in {
      val cacheService = mock[CacheTrait]
      val cache = mock[CacheApi]
      cacheService.setCache("kunal", SignUp("", "", "", "", "", "", "", false, false))
      when(cache.get[SignUp]("kunal")) thenReturn (Option(SignUp("", "", "", "", "", "", "", false, false)))
    }

    "get list" in {
      val cacheService = mock[CacheTrait]
      val cache = mock[CacheApi]
      cache.set("kunal", SignUp("", "", "", "", "", "", "", false, false))
      when(cacheService.getCache("kunal")) thenReturn (Option(SignUp("", "", "", "", "", "", "", false, false)))
    }

    "remove list" in {
      val cacheService = mock[CacheTrait]
      val cache = mock[CacheApi]
      cache.set("kunal", SignUp("kunal", "", "", "", "", "", "", false, false))
      cacheService.removeFromCache("kunal")
      when(cache.get("kunal")) thenReturn (None)

    }
  }
}
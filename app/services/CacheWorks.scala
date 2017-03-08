package services

import javax.inject.Inject
import com.sun.corba.se.impl.ior.NewObjectKeyTemplateBase
import play.api.cache
import play.api.cache.CacheApi

trait CacheTrait {

  def setCache(value:String,newObject:SignUp)
  def getCache(value:String):Option[SignUp]
}


class CacheWorks @Inject() (cache: CacheApi) extends CacheTrait {
  def setCache(value:String,newObject:SignUp)={

    cache.set(value, newObject)
  }
  def getCache(value:String)={

    cache.get[SignUp](value)
  }

}


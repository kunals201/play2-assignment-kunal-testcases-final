package models

/**
  * Created by knoldus on 3/9/17.
  */

  case class Login(username:String,password:String)

//package models
//import com.google.inject.AbstractModule
//import play.api.{Configuration, Environment}
//import services.{CacheWorks, CacheTrait}
//
//class GuiceBinding (environment: Environment,configuration: Configuration) extends AbstractModule{
//  override def configure() = {
//    bind(classOf[CacheTrait]).to(classOf[CacheWorks])
//  }
//}
//
//
//
//


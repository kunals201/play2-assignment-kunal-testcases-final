package services

import java.math.BigInteger

import scala.collection.mutable.ListBuffer
import java.util.Date
/**
  * Created by knoldus on 3/5/17.
  */
case class Login(username:String,password:String)

case class SignUp(username:String,email:String,password:String,re_password:String,dob:String,country:String,gender:String,isUserRole:Boolean,isAllow:Boolean)


object bufferService{
  val listOfUsers=ListBuffer[SignUp]()
   def getUser(username: String):SignUp = {
    def local(list:ListBuffer[SignUp]):SignUp = {

      val userData=list.filter(_.username==username)
      if (userData.isEmpty)
        SignUp("","","","","","","",false,false)
      else
      userData(0)
    }
    local(listOfUsers)
  }

  def addUser(user:SignUp) = listOfUsers.append(user)

  def getAllUsers:ListBuffer[SignUp]= listOfUsers

}

object Encrypter{
  def hash(s:String)={
val m=java.security.MessageDigest.getInstance("MD5")
val b=s.getBytes("UTF-8")
m.update(b,0,b.length)
  new BigInteger(1,m.digest()).toString(16)
  }
}
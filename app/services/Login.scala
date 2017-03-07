package services

import scala.collection.mutable.ListBuffer
import java.util.Date
/**
  * Created by knoldus on 3/5/17.
  */
case class Login(username:String,pswd:String)

case class SignUp(username:String,email:String,password:String,re_password:String,dob:String,country:String,gender:String)

object bufferService{
  val listOfUsers=ListBuffer[SignUp]()
   def getUser(username: String):SignUp = {
    def local(list:ListBuffer[SignUp]):SignUp = {

      val userData=list.filter(_.username==username)
      if (userData.isEmpty)
        SignUp("","","","","","","")
      else
      userData(0)
    }
    local(listOfUsers)
  }

  def addUser(user:SignUp) = listOfUsers.append(user)

  def getAllUsers:ListBuffer[SignUp]= listOfUsers

}


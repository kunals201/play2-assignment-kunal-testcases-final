package services

import java.math.BigInteger

import scala.collection.mutable.ListBuffer
import java.util.Date
/**
  * Created by knoldus on 3/5/17.
  */



object bufferService{
  val listOfUsers=ListBuffer[String]()

  def addUser(user:String) = listOfUsers.append(user)

  def getAllUsers:ListBuffer[String]= listOfUsers

}

object Encrypter{
  def hash(s:String)={
val m=java.security.MessageDigest.getInstance("MD5")
val b=s.getBytes("UTF-8")
m.update(b,0,b.length)
  new BigInteger(1,m.digest()).toString(16)
  }
}
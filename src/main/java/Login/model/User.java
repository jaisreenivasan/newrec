package Login.model;

import Login.dao.UserDaoImpl;

public class User extends UserDaoImpl{
	  private String userid;
	  private String password;
	  private String firstname;
	  private String lastname;
	  private String email;
	  private String desig;
	  private int phone;
	  public String printme()
	    {String sing;
	    sing="* "+"FirstName:"+this.getFirstname()+" LastName:"+this.getLastname()+" Phone:"+this.getPhone()+" Designation:"+this.getDesig()+" Email:"+this.getEmail();
	    return sing;
	    }
	  public String getUserid() {
	  return userid;
	  }
	  public void setUserid(String userid) {
	  this.userid = userid;
	  }
	  public String getPassword() {
	  return password;
	  }
	  public void setPassword(String password) {
	  this.password = password;
	  }
	  public String getFirstname() {
	  return firstname;
	  }
	  public void setFirstname(String firstname) {
	  this.firstname = firstname;
	  }
	  public String getLastname() {
	  return lastname;
	  }
	  public void setLastname(String lastname) {
	  this.lastname = lastname;
	  }
	  public String getEmail() {
	  return email;
	  }
	  public void setEmail(String email) {
	  this.email = email;
	  }
	  public String getDesig() {
	  return desig;
	  }
	  public void setDesig(String desig) {
	  this.desig = desig;
	  }
	  public int getPhone() {
	  return phone;
	  }
	  public void setPhone(int phone) {
	  this.phone = phone;
	  }
	}
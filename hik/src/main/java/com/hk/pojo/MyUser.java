package com.hk.pojo;

import java.util.Date;

import org.apache.ibatis.type.Alias;
public class MyUser {
private String uid;
private String uname;
private int uage;
private Date birth;
public String getUid() {
	return uid;
}
public void setUid(String uid) {
	this.uid = uid;
}
public String getUname() {
	return uname;
}
public void setUname(String uname) {
	this.uname = uname;
}
public int getUage() {
	return uage;
}
public void setUage(int uage) {
	this.uage = uage;
}
public Date getBirth() {
	return birth;
}
public void setBirth(Date birth) {
	this.birth = birth;
}
@Override
public String toString() {
	return "MyUser [uid=" + uid + ", uname=" + uname + ", uage=" + uage + ", birth=" + birth + "]";
}

}

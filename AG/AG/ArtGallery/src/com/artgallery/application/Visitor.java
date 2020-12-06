package com.artgallery.application;

public class Visitor {
private int visitorId;
private String visitorName;
private String email;
public int getVisitorId() {
	return visitorId;
}
public void setVisitorId(int visitorId) {
	this.visitorId = visitorId;
}
public String getVisitorName() {
	return visitorName;
}
public void setVisitorName(String visitorName) {
	this.visitorName = visitorName;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
@Override
public String toString() {
	return "Visitor [visitorId=" + visitorId + ", visitorName=" + visitorName + ", email=" + email + "]";
}

}

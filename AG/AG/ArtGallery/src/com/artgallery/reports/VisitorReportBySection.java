package com.artgallery.reports;

import java.sql.Date;

public class VisitorReportBySection {
private String gsName;
private int noOfVisitors;
private Date date;
public String getGsName() {
	return gsName;
}
public void setGsName(String gsName) {
	this.gsName = gsName;
}
public int getNoOfVisitors() {
	return noOfVisitors;
}
public void setNoOfVisitors(int noOfVisitors) {
	this.noOfVisitors = noOfVisitors;
}
public Date getDate() {
	return date;
}

	public void setDate(Date date) {
	this.date = date;
}
@Override
public String toString() {
	return "VisitorReportBySection [gsName=" + gsName + ", noOfVisitors=" + noOfVisitors + ", date=" + date + "]";
}

}

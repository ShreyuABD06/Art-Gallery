package com.artgallery.application;

import java.sql.Date;

public class Visits {
	private int visitId;
	private int galleryId;
	private int artId;
	private Date date;
	private int noOfVisitors;
	
	public int getVisitId() {
		return visitId;
	}
	public void setVisitId(int visitId) {
		this.visitId = visitId;
	}
	
	public int getGalleryId() {
		return galleryId;
	}
	public void setGalleryId(int galleryId) {
		this.galleryId = galleryId;
	}
	public int getArtId() {
		return artId;
	}
	public void setArtId(int artId) {
		this.artId = artId;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getNoOfVisitors() {
		return noOfVisitors;
	}
	public void setNoOfVisitors(int noOfVisitors) {
		this.noOfVisitors = noOfVisitors;
	}
	@Override
	public String toString() {
		return "Visits [visitId=" + visitId + ", galleryId=" + galleryId + ", artId=" + artId + ", date=" + date
				+ ", noOfVisitors=" + noOfVisitors + "]";
	}
	
}

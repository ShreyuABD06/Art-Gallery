package com.artgallery.reports;

import java.sql.Date;

public class VisitorReport {
	private int galleryId;
	private String galleryname;
	private String gsName;
	private String artName;
	private Date date;
	private int noOfVisitors;

	public int getGalleryId() {
		return galleryId;
	}

	public void setGalleryId(int galleryId) {
		this.galleryId = galleryId;
	}

	public String getGalleryname() {
		return galleryname;
	}

	public void setGalleryname(String galleryname) {
		this.galleryname = galleryname;
	}

	public String getGsName() {
		return gsName;
	}

	public void setGsName(String gsName) {
		this.gsName = gsName;
	}

	public String getArtName() {
		return artName;
	}

	public void setArtName(String artName) {
		this.artName = artName;
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
		return "VisitorReport [galleryId=" + galleryId + ", galleryname=" + galleryname + ", gsName=" + gsName
				+ ", artName=" + artName + ", date=" + date + ", noOfVisitors=" + noOfVisitors + "]";
	}
}

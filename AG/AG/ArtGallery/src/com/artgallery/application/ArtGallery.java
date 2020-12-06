package com.artgallery.application;

import java.sql.Time;

public class ArtGallery {
	private int galleryId;
	private String galleryName;
	private String location;
	private double entranceFee;
	private String phoneNo;
	private Time openTime;
	private Time closeTime;

	public int getGalleryId() {
		return galleryId;
	}

	public void setGalleryId(int galleryId) {
		this.galleryId = galleryId;
	}

	public String getGalleryName() {
		return galleryName;
	}

	public void setGalleryName(String galleryName) {
		this.galleryName = galleryName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public double getEntranceFee() {
		return entranceFee;
	}

	public void setEntranceFee(double entranceFee) {
		this.entranceFee = entranceFee;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public Time getOpenTime() {
		return openTime;
	}

	public void setOpenTime(Time openTime) {
		this.openTime = openTime;
	}

	public Time getCloseTime() {
		return closeTime;
	}

	public void setCloseTime(Time closeTime) {
		this.closeTime = closeTime;
	}

	@Override
	public String toString() {
		return "ArtGallery [galleryId=" + galleryId + ", galleryName=" + galleryName + ", location=" + location
				+ ", entranceFee=" + entranceFee + ", phoneNo=" + phoneNo + ", openTime=" + openTime + ", closeTime="
				+ closeTime + "]";
	}

}

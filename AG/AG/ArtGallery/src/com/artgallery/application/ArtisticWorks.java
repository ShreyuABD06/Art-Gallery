package com.artgallery.application;

public class ArtisticWorks {
	private int artId;
	private int galleryId;
	private String artName;
	private String artistname;
	private STATUS photoFlag;
	private String typeOfArt;
	private double price;
	private int gsId;

	public int getArtId() {
		return artId;
	}

	public void setArtId(int artId) {
		this.artId = artId;
	}

	public int getGalleryId() {
		return galleryId;
	}

	public void setGalleryId(int galleryId) {
		this.galleryId = galleryId;
	}

	public String getArtName() {
		return artName;
	}

	public void setArtName(String artName) {
		this.artName = artName;
	}

	public String getArtistname() {
		return artistname;
	}

	public void setArtistname(String artistname) {
		this.artistname = artistname;
	}

	public STATUS getPhotoFlag() {
		return photoFlag;
	}

	public void setPhotoFlag(STATUS photoFlag) {
		this.photoFlag = photoFlag;
	}

	public String getTypeOfArt() {
		return typeOfArt;
	}

	public void setTypeOfArt(String typeOfArt) {
		this.typeOfArt = typeOfArt;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getGsId() {
		return gsId;
	}

	public void setGsId(int gsId) {
		this.gsId = gsId;
	}

	@Override
	public String toString() {
		return "ArtisticWorks [artId=" + artId + ", galleryId=" + galleryId + ", artName=" + artName + ", artistname="
				+ artistname + ", photoFlag=" + photoFlag + ", typeOfArt=" + typeOfArt + ", price=" + price + ", gsId="
				+ gsId + "]";
	}

}

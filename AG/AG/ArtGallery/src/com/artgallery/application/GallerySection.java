package com.artgallery.application;

public class GallerySection {
	private int gsId;
	private String gsName;

	public int getGsId() {
		return gsId;
	}

	public void setGsId(int gsId) {
		this.gsId = gsId;
	}

	public String getGsName() {
		return gsName;
	}

	public void setGsName(String gsName) {
		this.gsName = gsName;
	}

	@Override
	public String toString() {
		return "GallerySection [gsId=" + gsId + ", gsName=" + gsName + "]";
	}

}

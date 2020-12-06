package com.artgallery.service;

import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.Scanner;

import com.artgallery.application.ArtGallery;
import com.artgallery.application.ArtisticWorks;
import com.artgallery.application.GallerySection;
import com.artgallery.application.STATUS;
import com.artgallery.application.Visits;
import com.artgallery.application.dbutil.DBUtil;
import com.artgallery.reports.VisitorReport;
import com.artgallery.reports.VisitorReportBySection;

public class ArtGalleryApplication {
	DBUtil db = new DBUtil();
	Scanner sc = new Scanner(System.in);

	public String addGallery(ArtGallery r) {
		System.out.println("Enter Gallery Name");
		String name = sc.next();
		r.setGalleryName(name);
		System.out.println("Enter Gallery Location");
		String location = sc.next();
		r.setLocation(location);
		System.out.println("Enter Entrance Fee");
		double yoe = sc.nextDouble();
		r.setEntranceFee(yoe);
		System.out.println("EnterPhoneNo");
		String phoneNo = sc.next();
		r.setPhoneNo(phoneNo);
		System.out.println("Enter Gallery Open time ");
		Time openTime = java.sql.Time.valueOf(sc.next());
		r.setOpenTime(openTime);
		System.out.println("Enter Gallery Close time ");
		Time closeTime = java.sql.Time.valueOf(sc.next());
		r.setOpenTime(closeTime);
		String s = db.addGallery(r);
		if (s != null) {
			System.out.println("gallery successfuly Added");
			return s;
		} else {
			return null;
		}
	}

	public List<ArtGallery> getGalleries() {
		List<ArtGallery> List = db.getGalleries();
		if (List != null) {
			return List;
		} else {
			System.out.println("NO data avialable");
			return null;
		}
	}

	public ArtGallery updateGallery(ArtGallery updatedValue) {
		System.out.println("Enter Id of Gallery to be Updated");
		int Id = sc.nextInt();
		updatedValue = getGalleryById(Id);
		System.out.println("Enter the fee to be updated");
		double c = sc.nextDouble();
		updatedValue.setEntranceFee(c);
		return updatedValue = db.updateGallery(updatedValue);
	}

	public String addArt(ArtisticWorks p) {

		System.out.println("Enter Gallery id");
		int galleryId = sc.nextInt();
		p.setGalleryId(galleryId);
		System.out.println("Enter Art Name");
		String title = sc.next();
		p.setArtName(title);
		System.out.println("Enter Artist Name");
		String loc = sc.next();
		p.setArtistname(loc);
		System.out.println("Enter photography flag(YES/NO)");
		STATUS status = STATUS.valueOf(sc.next());
		p.setPhotoFlag(status);

		System.out.println("Enter Type Of Art");
		String type = sc.next();
		p.setTypeOfArt(type);

		System.out.println("Enter Price");
		double price = sc.nextDouble();
		p.setPrice(price);

		System.out.println("Enter Gallery Section Id");
		int gsId = sc.nextInt();
		p.setGsId(gsId);

		String s = db.addArt(p);
		if (s != null) {
			System.out.println("Adding Art Details");
			return s;
		} else {
			return null;
		}
	}

	public ArtisticWorks updateArt(ArtisticWorks prog) {
		System.out.println("Enter Id of art  to be Updated");
		int Id = sc.nextInt();
		prog = getArtById(Id);
		System.out.println("Enter the Cost to be Updated");
		double price = sc.nextDouble();
		prog.setPrice(price);
		return prog = db.updateArt(prog);

	}

	public List<ArtisticWorks> getArts() {
		List<ArtisticWorks> List = db.getArts();
		if (List != null) {
			return List;
		} else {
			System.out.println("NO data avialable");
			return null;
		}
	}

	public String addVisits(Visits p) {

		System.out.println("Enter Gallery id");
		int galleryId = sc.nextInt();
		p.setGalleryId(galleryId);

		System.out.println("Enter Art Id");
		int artId = sc.nextInt();
		p.setArtId(artId);

		System.out.println("Enter Date");
		Date date = java.sql.Date.valueOf(sc.next());
		p.setDate(date);

		System.out.println("Enter no of Visitors");
		int noOfVisitors = sc.nextInt();
		p.setNoOfVisitors(noOfVisitors);

		String s = db.addVisits(p);
		if (s != null) {
			System.out.println("Visit Details of a date Entered successfuly Added");
			return s;
		} else {
			return null;
		}
	}

	public Visits updateVisits(Visits g) {
		System.out.println("Enter visits id to be Updated");
		int Id = sc.nextInt();
		g = getVisitsById(Id);
		System.out.println("Enter the no of visitors to be Updated");
		int n = sc.nextInt();
		g.setNoOfVisitors(n);
		return g = db.updateVisits(g);

	}

	public List<Visits> getAllVisits() {
		List<Visits> List = db.getAllVisits();
		if (List != null) {
			return List;
		} else {
			System.out.println("NO data avialable");
			return null;
		}
	}

	public String addGallerySection(GallerySection p) {
		System.out.println("Enter Gallery Section Name");
		String gsName = sc.next();
		p.setGsName(gsName);

		String s = db.addGallerySections(p);
		if (s != null) {
			System.out.println("Gallery Section Details successfuly Added");
			return s;
		} else {
			return null;
		}
	}

	public List<GallerySection> getAllGalleySections() {
		List<GallerySection> List = db.getAllGallerySections();
		if (List != null) {
			return List;
		} else {
			System.out.println("NO data avialable");
			return null;
		}
	}

	public List<VisitorReport> getAllVisitorsByGalleryId(Date date, int galleryId) {
		List<VisitorReport> report = db.getAllVisitorsByGalleryId(date, galleryId);
		if (report != null) {
			return report;
		} else {
			System.out.println("NO data avialable");
			return null;
		}

	}

	public List<VisitorReportBySection> getAllVisitorsToGallerySection(Date date, int galleryId) {
		List<VisitorReportBySection> report = db.getAllVisitorsToGallerySection(date, galleryId);
		if (report != null) {
			return report;
		} else {
			System.out.println("NO data avialable");
			return null;
		}

	}

	public List<ArtisticWorks> getDetailsOfArtWork(Date date, int galleryId) {
		List<ArtisticWorks> report = db.getDetailsOfArtWork(date, galleryId);
		if (report != null) {
			return report;
		} else {
			System.out.println("NO data avialable");
			return null;
		}

	}

	public ArtGallery getGalleryById(int id) {
		ArtGallery t = db.getArtGalleryById(id);
		if (t != null) {
			return t;
		} else {
			return null;
		}
	}

	public ArtisticWorks getArtById(int id) {
		ArtisticWorks t = db.getArtById(id);
		if (t != null) {
			return t;
		} else {
			return null;
		}
	}

	public Visits getVisitsById(int id) {
		Visits t = db.getVisitsById(id);
		if (t != null) {
			return t;
		} else {
			return null;
		}
	}

	public GallerySection getGallerySectionsById(int id) {
		GallerySection t = db.getGallerySectionsById(id);
		if (t != null) {
			return t;
		} else {
			return null;
		}
	}
}

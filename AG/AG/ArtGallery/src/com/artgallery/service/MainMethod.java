package com.artgallery.service;

import java.sql.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.artgallery.application.ArtGallery;
import com.artgallery.application.ArtisticWorks;
import com.artgallery.application.GallerySection;
import com.artgallery.application.Visits;
import com.artgallery.reports.VisitorReport;
import com.artgallery.reports.VisitorReportBySection;

public class MainMethod {
	public static void main(String[] args) {
		MainMethod n = new MainMethod();
		n.start();

	}

	private void start() {
		while (true) {
			System.out.println("-----------------------------------------------------------------");
			System.out.println("***********************WELCOME TO ART GALLERY********************");
			System.out.println("-----------------------------------------------------------------");
			System.out.println("1:ADD ArtGallery");
			System.out.println("2:View Art Galleries");
			System.out.println("3:Update Art gallery Entrance Fee");
			System.out.println("4:Add Gallery Section");
			System.out.println("5:View Gallery Sections");
			System.out.println("6:ADD Art");
			System.out.println("7:Update Artistic works Cost");
			System.out.println("8:View Artistic Works");	
			System.out.println("9:Add Visits Data");
			System.out.println("10:View all Visits");
			System.out.println("11:Get Visits Report to GalleryId and Date");
			System.out.println("12:get Visits Report to GallerySection By date and GalleryId");
			System.out.println("13:Get Artistic Works Details by Visits");
			System.out.println("14:GEt Gallery By Id");
			System.out.println("15:Get Artistic Work By Id");
			System.out.println("16:Gallery Section By Id");
			System.out.println("17:Get Visits By Id");
			System.out.println("18:Exit");
			Scanner sc = new Scanner(System.in);
			ArtGalleryApplication c = new ArtGalleryApplication();
			System.out.println("Enter your choice");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				ArtGallery i = new ArtGallery();
				String s = c.addGallery(i);
				System.out.println("Please wait Adding Art Gallery ");
				if (s != null) {
					System.out.println("ArtGallery : " + s);
				} else {
					System.out.println("Art Gallery could nOt Be Added");
				}
				break;
			case 2:
				List<ArtGallery> list = c.getGalleries();
				System.out.println("Loading Galleries ");
				if (list != null) {
					Iterator<ArtGallery> itr = list.iterator();
					while (itr.hasNext()) {
						System.out.println(itr.next());
					}
				} else {
					System.out.println("No Galleries Available");
				}
				break;
			case 3:
				ArtGallery i1 = new ArtGallery();
				i1 = c.updateGallery(i1);
				System.out.println("Completing updations for entrance Fee ");
				System.out.println(i1);
				break;
	
			case 4:
				GallerySection t = new GallerySection();
				String stu = c.addGallerySection(t);
				System.out.println("Adding New Gallery Section ");
				if (stu != null) {
					System.out.println("Gallery Section : " + stu);
				} else {
					System.out.println("Could nOt adD Gallery SEction");
				}
				break;

			case 5:
				List<GallerySection> sm = c.getAllGalleySections();
				System.out.println("Loading All Gallery SEctions ");
				if (sm != null) {
					Iterator<GallerySection> itr = sm.iterator();
					while (itr.hasNext()) {
						System.out.println(itr.next());
					}
				} else {
					System.out.println("No GalleryS Sections to Display");
				}
				break;

			case 6:
				ArtisticWorks co = new ArtisticWorks();
				String cr = c.addArt(co);
				System.out.println("Please wait Adding New Artistic Work ");
				if (cr != null) {
					System.out.println("ArtName = " + cr);
				} else {
					System.out.println("Artistic Work Not Added");
				}
				break;

			case 7:
				ArtisticWorks art = new ArtisticWorks();
				art = c.updateArt(art);
				System.out.println("updating Artistic Work's Cost");
				if (art != null) {
					System.out.println(art);
				} else {
					System.out.println("Could NOt Update artistic works cost ");
				}
				break;

			case 8:
				List<ArtisticWorks> st = c.getArts();
				System.out.println("Loading All Artistic Works ");
				if (st != null) {
					Iterator<ArtisticWorks> itr = st.iterator();
					while (itr.hasNext()) {
						System.out.println(itr.next());
					}
				} else {
					System.out.println("No ArtisticWorks to Display");
				}
				break;

			case 9:
				Visits z = new Visits();
				String q = c.addVisits(z);
				System.out.println("Please wait Adding Details Of A Visit ");
				if (q != null) {
					System.out.println(q);
				} else {
					System.out.println("Got an error while adding Visit");
				}
				break;
			case 10:
				List<Visits> sm1 = c.getAllVisits();
				System.out.println("Loading All Visits DEtails ");
				if (sm1 != null) {
					Iterator<Visits> itr = sm1.iterator();
					while (itr.hasNext()) {
						System.out.println(itr.next());
					}
				} else {
					System.out.println("No Visits");
				}
				break;
			case 11:
				System.out.println("Enter the Gallery Id To Get Visits ");
				int cId = sc.nextInt();
				System.out.println("Enter the date to get all Visits");
				Date date = java.sql.Date.valueOf(sc.next());
				List<VisitorReport> st1 = c.getAllVisitorsByGalleryId(date, cId);
				System.out.println("Please Wait Getting Visits Report ");
				if (st1 != null) {
					Iterator<VisitorReport> itr = st1.iterator();
					while (itr.hasNext()) {
						System.out.println(itr.next());
					}
				} else {
					System.out.println("No Visitor to Gallery with gallery id " + cId + " on " + date);
				}
				break;
			case 12:
				System.out.println("Enter the Gallery Id To Get Visitors to gallery section ");
				int gId = sc.nextInt();
				System.out.println("Enter the date to get all Visitors to Gallery Section");
				Date date1 = java.sql.Date.valueOf(sc.next());
				List<VisitorReportBySection> st2 = c.getAllVisitorsToGallerySection(date1, gId);
				System.out.println("Please Wait Getting Visitor Details To A Gallery Section ");
				if (st2 != null) {
					Iterator<VisitorReportBySection> itr = st2.iterator();
					while (itr.hasNext()) {
						System.out.println(itr.next());
					}
				} else {
					System.out.println("No Visitor to GallerySection with gallery id " + gId + " on " + date1);
				}
				break;
			case 13:
				System.out.println("Enter the Gallery Id To Get Details of An art visited by most People");
				int gId1 = sc.nextInt();
				System.out.println("Enter the date to get all details of an art");
				Date date2 = java.sql.Date.valueOf(sc.next());
				List<ArtisticWorks> st3 = c.getDetailsOfArtWork(date2, gId1);
				System.out.println("Please Wait Getting Visitor Details To an art visiited by most people");
				if (st3 != null) {
					Iterator<ArtisticWorks> itr = st3.iterator();
					while (itr.hasNext()) {
						System.out.println(itr.next());
					}
				} else {
					System.out.println("No Art visited with gallery id " + gId1 + " on " + date2);
				}
				break;
			case 14:
				ArtGallery r3 = new ArtGallery();
				System.out.println("Enter Gallery Id to getGallery");
				int Id = sc.nextInt();
				r3 = c.getGalleryById(Id);
				System.out.println("Loading Gallery Details ");
				if (r3 != null) {
					System.out.println(r3);
				} else {
					System.out.println("ArtGallery with id " + Id + " Not Found");
				}
				break;
			case 15:
				ArtisticWorks r4 = new ArtisticWorks();
				System.out.println("Enter Art Id to get Art");
				int Id1 = sc.nextInt();
				r4 = c.getArtById(Id1);
				System.out.println("Loading ARtistic Works Details Details ");
				if (r4 != null) {
					System.out.println(r4);
				} else {
					System.out.println("Artistic work with id " + Id1 + " Not Found");
				}
				break;
			case 16:
				GallerySection r5 = new GallerySection();
				System.out.println("Enter Gallery Section Id to getGallery");
				int Id2 = sc.nextInt();
				r5 = c.getGallerySectionsById(Id2);
				System.out.println("Loading Gallery Section Details ");
				if (r5 != null) {
					System.out.println(r5);
				} else {
					System.out.println("GallerySection with id " + Id2 + " Not Found");
				}
				break;
			case 17:
				Visits r6 = new Visits();
				System.out.println("Enter Visit Id to getGallery");
				int Id3 = sc.nextInt();
				r6 = c.getVisitsById(Id3);
				System.out.println("Loading Visit Details ");
				if (r6 != null) {
					System.out.println(r6);
				} else {
					System.out.println("ArtGallery with id " + Id3 + " Not Found");
				}
				break;
			case 18:
				System.out.println("Exiting");
				System.out.println("Thank You");
				System.exit(0);

			}
		}

	}
}

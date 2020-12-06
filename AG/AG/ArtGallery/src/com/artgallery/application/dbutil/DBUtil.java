package com.artgallery.application.dbutil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.artgallery.application.ArtGallery;
import com.artgallery.application.ArtisticWorks;
import com.artgallery.application.GallerySection;
import com.artgallery.application.STATUS;
import com.artgallery.application.Visitor;
import com.artgallery.application.Visits;
import com.artgallery.reports.VisitorReport;
import com.artgallery.reports.VisitorReportBySection;

public class DBUtil {
	Connection con = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	Statement stmt = null;

	private Connection getConnection() {
		String url = "jdbc:mysql://localhost:3306/artgallery";
		try {
			con = DriverManager.getConnection(url, "root", "mysql123");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return con;
	}

	public void close() {
		if (con != null)
			try {
				con.close();
			} catch (SQLException s1) {
				System.out.println(s1.getMessage());
			}
		if (stmt != null)
			try {
				stmt.close();
			} catch (SQLException s1) {
				System.out.println(s1.getMessage());
			}
		if (pst != null)
			try {
				pst.close();
			} catch (SQLException s1) {
				System.out.println(s1.getMessage());
			}
		if (rs != null)
			try {
				rs.close();
			} catch (SQLException s1) {
				System.out.println(s1.getMessage());
			}

	}

	// public String registerVisitor(Visitor t) {
	// Connection con = null;
	// PreparedStatement pst = null;
	// try {
	// con = getConnection();
	// String n = "insert into visitor(name,email) values(?,?)";
	// pst = con.prepareStatement(n);
	// pst.setString(1, t.getVisitorName());
	//
	// pst.setString(2, t.getEmail());
	// int isExecuted = pst.executeUpdate();
	// if (isExecuted != 0)
	// return t.getVisitorName();
	// } catch (SQLException e) {
	// System.out.println(e.getMessage());
	// } finally {
	// close();
	// }
	// return null;
	// }
	//
	// public Visitor updateVisitor(Visitor t) {
	// try {
	// con = getConnection();
	// String query = "update visitor set email=? where visitorId=?";
	// pst = con.prepareStatement(query);
	// pst.setString(1, t.getEmail());
	// pst.setInt(2, t.getVisitorId());
	// pst.executeUpdate();
	// con.commit();
	// } catch (SQLException e) {
	// System.out.println(e.getMessage());
	// } finally {
	// close();
	// }
	// return t;
	// }
	//
	// public List<Visitor> getAllVisiors() {
	// Visitor t = null;
	// List<Visitor> list = new ArrayList<Visitor>();
	// try {
	// con = getConnection();
	// stmt = con.createStatement();
	// String view = "select * from visitors";
	// rs = stmt.executeQuery(view);
	// while (rs.next()) {
	// t = new Visitor();
	// t.setVisitorId(rs.getInt(1));
	// t.setVisitorName(rs.getString(2));
	// t.setEmail(rs.getString(3));
	// list.add(t);
	// }
	// } catch (SQLException e) {
	// System.out.println(e.getMessage());
	// } finally {
	// close();
	// }
	// return list;
	// }

	public String addGallery(ArtGallery t) {
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = getConnection();
			String sql = "insert into gallery(galleryName,location,entranceFee,phoneNo,openTime,closeTime) values(?,?,?,?,?,?)";
			pst = con.prepareStatement(sql);
			pst.setString(1, t.getGalleryName());
			pst.setString(2, t.getLocation());
			pst.setDouble(3, t.getEntranceFee());
			pst.setString(4, t.getPhoneNo());
			pst.setTime(5, t.getOpenTime());
			pst.setTime(6, t.getCloseTime());
			int isExecuted = pst.executeUpdate();
			if (isExecuted != 0)
				return t.getGalleryName();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			close();
		}
		return null;
	}

	public List<ArtGallery> getGalleries() {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArtGallery t = null;
		List<ArtGallery> List = new ArrayList<ArtGallery>();
		try {
			con = getConnection();
			stmt = con.createStatement();
			String view = "select * from gallery";
			rs = stmt.executeQuery(view);
			while (rs.next()) {
				t = new ArtGallery();
				t.setGalleryId(rs.getInt(1));
				t.setGalleryName(rs.getString(2));
				t.setLocation(rs.getString(3));
				t.setEntranceFee(rs.getDouble(4));
				t.setPhoneNo(rs.getString(5));
				t.setOpenTime(rs.getTime(6));
				t.setCloseTime(rs.getTime(7));
				List.add(t);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			close();
		}
		return List;
	}

	public ArtGallery updateGallery(ArtGallery updatedValue) {
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = getConnection();
			String query = "update gallery set entranceFee=? where galleryId=?";
			pst = con.prepareStatement(query);
			pst.setDouble(1, updatedValue.getEntranceFee());
			pst.setInt(2, updatedValue.getGalleryId());
			pst.executeUpdate();
			con.commit();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			close();
		}
		return updatedValue;
	}

	public String addArt(ArtisticWorks i) {
		try {
			con = getConnection();
			String query = "insert into Arts(galleryId,artName,artistName,photoFlag,typeOfArt,price,gsId) values(?,?,?,?,?,?,?)";
			pst = con.prepareStatement(query);
			pst.setInt(1, i.getGalleryId());
			pst.setString(2, i.getArtName());
			pst.setString(3, i.getArtistname());
			pst.setString(4, i.getPhotoFlag().name());
			pst.setString(5, i.getTypeOfArt());
			pst.setDouble(6, i.getPrice());
			pst.setInt(7, i.getGsId());
			int isExecuted = pst.executeUpdate();
			if (isExecuted != 0)
				return i.getArtName();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			close();
		}
		return null;
	}

	public List<ArtisticWorks> getArts() {
		ArtisticWorks t = null;
		List<ArtisticWorks> list = new ArrayList<ArtisticWorks>();
		try {
			con = getConnection();
			stmt = con.createStatement();
			String view = "Select * from Arts";
			rs = stmt.executeQuery(view);
			while (rs.next()) {
				t = new ArtisticWorks();
				t.setArtId(rs.getInt(1));
				t.setGalleryId(rs.getInt(2));
				t.setArtName(rs.getString(3));
				t.setArtistname(rs.getString(4));
				t.setPhotoFlag(STATUS.valueOf(rs.getString(5)));
				t.setTypeOfArt(rs.getString(6));
				t.setPrice(rs.getDouble(7));
				t.setGsId(rs.getInt(8));
				list.add(t);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			close();
		}
		return list;
	}

	public ArtisticWorks updateArt(ArtisticWorks value) {
		try {
			con = getConnection();
			String query = "update Arts set price=? where artId=?";
			pst = con.prepareStatement(query);
			pst.setDouble(1, value.getPrice());
			pst.setInt(2, value.getArtId());

			pst.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			close();
		}
		return value;
	}

	public String addVisits(Visits g) {
		try {
			con = getConnection();
			String s = "insert into visits(galleryId,artId,date,noOfVisitors)values(?,?,?,?)";
			pst = con.prepareStatement(s);
			pst.setInt(1, g.getGalleryId());
			pst.setInt(2, g.getArtId());
			pst.setDate(3, g.getDate());
			pst.setDouble(4, g.getNoOfVisitors());
			int isExecuted = pst.executeUpdate();
			if (isExecuted != 0)
				return "Visits Added";
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			close();
		}
		return null;
	}

	public List<Visits> getAllVisits() {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		Visits g = null;
		List<Visits> list = new ArrayList<Visits>();
		try {
			con = getConnection();
			stmt = con.createStatement();
			String view = "select *from visits";
			rs = stmt.executeQuery(view);
			while (rs.next()) {
				g = new Visits();
				g.setVisitId(rs.getInt(1));
				g.setGalleryId(rs.getInt(2));
				g.setArtId(rs.getInt(3));
				g.setDate(rs.getDate(4));
				g.setNoOfVisitors(rs.getInt(5));
				list.add(g);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			close();
		}
		return list;
	}

	public Visits updateVisits(Visits g) {
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = getConnection();
			String query = "update visits set noOfVisitors=? where visitId=?";
			pst = con.prepareStatement(query);
			pst.setInt(1, g.getNoOfVisitors());
			pst.setInt(2, g.getVisitId());
			pst.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			close();
		}
		return g;
	}

	public String addGallerySections(GallerySection g) {
		try {
			con = getConnection();
			String s = "insert into GallerySections(gsName)values(?)";
			pst = con.prepareStatement(s);
			pst.setString(1, g.getGsName());

			int isExecuted = pst.executeUpdate();
			if (isExecuted != 0)
				return "GallerysectionAdded";
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			close();
		}
		return null;
	}

	public List<GallerySection> getAllGallerySections() {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		GallerySection g = null;
		List<GallerySection> list = new ArrayList<GallerySection>();
		try {
			con = getConnection();
			stmt = con.createStatement();
			String view = "select *from gallerySections";
			rs = stmt.executeQuery(view);
			while (rs.next()) {
				g = new GallerySection();
				g.setGsId(rs.getInt(1));
				g.setGsName(rs.getString(2));
				list.add(g);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			close();
		}
		return list;
	}

	public List<VisitorReport> getAllVisitorsByGalleryId(Date date, int galleryId) {
		VisitorReport tr = null;
		List<VisitorReport> tList = new ArrayList<VisitorReport>();
		try {
			con = getConnection();
			stmt = con.createStatement();
			String view = " select g.galleryId,g.galleryname,gs.gsName,a.artName,v.date,v.noOfVisitors from visits v"
					+ " inner join arts a on v.artId=a.artId"
					+ " inner join gallerySections gs on a.gsId=gs.gsId"
					+ " inner join gallery g on a.galleryId=g.galleryId "
					+ "where v.date=date and v.galleryId=" + galleryId;
			rs = stmt.executeQuery(view);
			while (rs.next()) {
				tr = new VisitorReport();
				tr.setGalleryId(rs.getInt(1));
				tr.setGalleryname(rs.getString(2));
				tr.setGsName(rs.getString(3));
				tr.setArtName(rs.getString(4));
				tr.setDate(rs.getDate(5));
				tr.setNoOfVisitors(rs.getInt(6));
				tList.add(tr);

			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			close();
		}
		return tList;
	}

	public List<VisitorReportBySection> getAllVisitorsToGallerySection(Date date, int galleryId) {
		VisitorReportBySection vRp = null;
		List<VisitorReportBySection> reportList = new ArrayList<VisitorReportBySection>();
		try {
			con = getConnection();
			stmt = con.createStatement();
			String view = " select gs.gsName,v.noOfVisitors,v.date from visits v "
					+ "inner join arts a on v.artId=a.artId "
					+ "inner join gallerySections gs on a.gsId=gs.gsId "
					+ "where v.date=date and v.galleryId=" + galleryId;
			rs = stmt.executeQuery(view);
			while (rs.next()) {
				vRp = new VisitorReportBySection();
				vRp.setGsName(rs.getString(1));
				vRp.setNoOfVisitors(rs.getInt(2));
				vRp.setDate(rs.getDate(3));
				reportList.add(vRp);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			close();
		}
		return reportList;
	}

	public List<ArtisticWorks> getDetailsOfArtWork(Date date, int galleryId) {
		ArtisticWorks t = null;
		List<ArtisticWorks> reportList = new ArrayList<ArtisticWorks>();
		try {
			con = getConnection();
			stmt = con.createStatement();
			String view = "select a.artId,a.galleryId,a.artName,a.artistName,a.photoFlag,a.typeOfArt,a.price,a.gsId from visits v "
					+ "inner join arts a on v.artId=a.artId "
					+ "inner join gallerySections gs on a.gsId=gs.gsId "
					+ "inner join gallery g on a.galleryId=g.galleryId "
					+ "where v.date=date and v.galleryId=" + galleryId;
			rs = stmt.executeQuery(view);
			while (rs.next()) {
				t = new ArtisticWorks();
				t.setArtId(rs.getInt(1));
				t.setGalleryId(rs.getInt(2));
				t.setArtName(rs.getString(3));
				t.setArtistname(rs.getString(4));
				t.setPhotoFlag(STATUS.valueOf(rs.getString(5)));
				t.setTypeOfArt(rs.getString(6));
				t.setPrice(rs.getDouble(7));
				t.setGsId(rs.getInt(8));
				reportList.add(t);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			close();
		}
		return reportList;
	}

	public ArtGallery getArtGalleryById(int id) {
		ArtGallery t = null;
		try {
			con = getConnection();
			String sql = "select * from gallery where galleryId=" + id;
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				t = new ArtGallery();
				t.setGalleryId(rs.getInt(1));
				t.setGalleryName(rs.getString(2));
				t.setLocation(rs.getString(3));
				t.setEntranceFee(rs.getDouble(4));
				t.setPhoneNo(rs.getString(5));
				t.setOpenTime(rs.getTime(6));
				t.setCloseTime(rs.getTime(7));

			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			close();
		}
		return t;
	}

	public ArtisticWorks getArtById(int tId) {
		ArtisticWorks t = null;
		try {
			con = getConnection();
			String sql = "select * from arts where artId=" + tId;
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				t = new ArtisticWorks();
				t.setArtId(rs.getInt(1));
				t.setGalleryId(rs.getInt(2));
				t.setArtName(rs.getString(3));
				t.setArtistname(rs.getString(4));
				t.setPhotoFlag(STATUS.valueOf(rs.getString(5)));
				t.setTypeOfArt(rs.getString(6));
				t.setPrice(rs.getDouble(7));
				t.setGsId(rs.getInt(8));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			close();
			System.out.println("Connections Closed");
		}
		return t;
	}

	public Visits getVisitsById(int Id) {
		Visits g = null;
		try {
			con = getConnection();
			String sql = "select * from visits where visitId=" + Id;
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				g = new Visits();
				g.setVisitId(rs.getInt(1));
				g.setGalleryId(rs.getInt(2));
				g.setArtId(rs.getInt(3));
				g.setDate(rs.getDate(4));
				g.setNoOfVisitors(rs.getInt(5));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			close();
		}
		return g;
	}

	public GallerySection getGallerySectionsById(int id) {
		GallerySection g = null;
		try {
			con = getConnection();
			String sql = "select * from gallerySections where gsId=" + id;
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				g = new GallerySection();
				g.setGsId(rs.getInt(1));
				g.setGsName(rs.getString(2));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			close();
		}
		return g;
	}

}
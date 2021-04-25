package DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import DTO.ChiTieuPMDTO;

public class chitietpmDAL {
	public static ArrayList<ChiTieuPMDTO> getdanhsachphieumuon() {
		try {
			String sql = "select * from chitietphieumuon";
			Connection conn = DBConnect.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			ArrayList<ChiTieuPMDTO> dsl = new ArrayList<ChiTieuPMDTO>();
			while (rs.next()) {
				ChiTieuPMDTO ctpm = new ChiTieuPMDTO();
				ctpm.setMaChiTietPhieuMuon(rs.getInt("MaCTPM"));
				ctpm.setMaPhieuMuon(rs.getInt("MaPM"));
				ctpm.setMaSach(rs.getInt("MaSach"));
				String ngaytra = rs.getString("NgayTra");
				ctpm.setNgayTra(ngaytra);
				String ghichu = null ;
				
				if(CompareTwoDatesTest(ngaytra) == -1) {
					ghichu = "Đã Hết Hạn" ;
				}
				else if(CompareTwoDatesTest(ngaytra) == 1) {
					ghichu ="Chưa hết hạn" ;
				}
				else {
					ghichu ="Hôm nay là hạn cuối"; 
				}
				ctpm.setGhichu(ghichu);
				dsl.add(ctpm);

			}

			return dsl;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	// @SuppressWarnings("null")
	public static int themctpm(ChiTieuPMDTO ke) {
		int i = -1;
		String sql = "insert into chitietphieumuon (MaPM,MaSach,NgayTra,GhiChu) values(?,?,?,?)";
		try {

			Connection conn = DBConnect.getConnection();
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, ke.getMaPhieuMuon());
			pstm.setInt(2, ke.getMaSach());
			pstm.setString(3, ke.getNgayTra());
			pstm.setString(4, ke.getGhichu());
			i = pstm.executeUpdate();
			if(i>0) {
				String sql1 = "update sach set soluong = ? where masach = ?" ;
				PreparedStatement pstm2 = conn.prepareStatement(sql1);
				pstm2.setInt(1, SachDAL.getsoluongsach(ke.getMaSach()) -1);
				pstm2.setInt(2, ke.getMaSach());
				pstm2.executeUpdate();
				System.out.println("Đã Cập Nhật Số Lượng Sách");
			}
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
			// dreturn null;
		}

		return i;
	}

	public static int suactpm(ChiTieuPMDTO ke) {
		int i = -1;
		String sql = "update chitietphieumuon set MaPM = ? , MaSach = ?, NgayTra =? , GhiChu =?  where mactpm = ?";

		try {

			Connection conn = DBConnect.getConnection();
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, ke.getMaPhieuMuon());
			pstm.setInt(2, ke.getMaSach());
			pstm.setString(3, ke.getNgayTra());
			pstm.setString(4, ke.getGhichu());
			pstm.setInt(5, ke.getMaChiTietPhieuMuon());

			// System.out.println(ke.getViTri());
			i = pstm.executeUpdate();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
			// dreturn null;
		}

		return i;
	}

	public static int xoactpm(ChiTieuPMDTO ke) {
		int i = -1;
		String sql = "delete from chitietphieumuon where mactpm = ?";

		try {

			Connection conn = DBConnect.getConnection();
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, ke.getMaChiTietPhieuMuon());
			// System.out.println(ke.getViTri());
			i = pstm.executeUpdate();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
			// dreturn null;
		}

		return i;
	}
	public static int CompareTwoDatesTest(String date) {

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDateTime now = LocalDateTime.now();

		SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");
		Date d1 = null;
		try {
			d1 = sdformat.parse(date);
		} catch (ParseException ex) {
			ex.printStackTrace();
		}
		Date d2 = null;
		try {
			d2 = sdformat.parse(dtf.format(now));
		} catch (ParseException ex) {
			ex.printStackTrace();
		}

		if (d1.compareTo(d2) > 0) {
			return 1;
		} else if (d1.compareTo(d2) < 0) {
			return -1;
		} else if (d1.compareTo(d2) == 0) {
			return 2;
		}
		return 0;

	}
	
}

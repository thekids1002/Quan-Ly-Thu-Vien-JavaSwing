package GUI;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import java.awt.CardLayout;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.DefaultCategoryItemRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import BUS.ChiTietPhieuNhapBUS;
import BUS.DocGiaBUS;
import BUS.KeSachBus;
import BUS.LoaiBUS;
import BUS.NhaCungcapbus;
import BUS.NhaXuatBanBUS;
import BUS.NhanVienBus;
import BUS.PhieuMuonBus;
import BUS.PhieuNhapBUS;
import BUS.SachBus;
import BUS.TacGiaBUS;
import BUS.TaiKhoanBus;
import BUS.chitietpmbus;
import DAL.PhieuMuonDAL;
import DAL.SachDAL;
import DTO.ChiTietPhieuNhap;
import DTO.ChiTieuPMDTO;
import DTO.DocGia;
import DTO.KeSachDTO;
import DTO.LoaisachDTO;

import DTO.NhaCungCapDTO;
import DTO.NhaXuatBan;
import DTO.NhanVien;
import DTO.PhieuMuon;
import DTO.PhieuNhap;
import DTO.SachDTO;
import DTO.TacGiaDTO;
import Export.ExportExcel;
import Export.ImportExcel;
import Export.WritePDF;

import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JMenuItem;
import com.toedter.calendar.JDateChooser;
import javax.swing.border.LineBorder;
import javax.swing.JRadioButton;
import java.awt.FlowLayout;
import javax.swing.JTabbedPane;
import com.toedter.components.JSpinField;

public class MainFrame extends JFrame {
	public static String Ma;
	TacGiaDTO tacgiasl;
	LoaisachDTO loaisl;
	NhaXuatBan nxbsl;
	KeSachDTO kesl;
	NhanVien nvsl;
	DocGia dgsl;
	private JPanel contentPane;
	private JLabel iconsgu;
	private JLabel exit;
	private JLabel lblTitle;
	private JLabel title;
	private JPanel menuleft;
	private JLabel ThuVienSgu;
	private JLabel lblthuviensgu;
	private JPanel PanelChinh;
	private JPanel CardLayout;

	private JPanel SachPanel;
	private JPanel LoaiSach;
	private JPanel Sach;
	public static JPanel pnSach;
	private JPanel pndocgia;
	private JPanel pnnhaxuatban;
	private JPanel pntacgia;
	private JPanel pnTrangChu;
	private JPanel pnnhanvien;
	private JLabel lblTenSach;
	private JLabel lblMaLoai;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblHinhAnh;
	private JLabel lbltitlepnSach;
	private JLabel lblnamxuatban;
	private JLabel lblSLng;
	private JLabel lblMaKeSach;
	private JTextField txttensach;
	private JTextField txtsoluongsach;
	private JTextField txtnamxbsach;
	private JTable tablesach;
	private DefaultTableModel dtmsach;
	private JLabel lblNewLabel;
	private JLabel lblTrangchu;
	private JLabel lblSach;
	private JLabel lbldocgia;
	private JLabel lbltacgia;
	private JLabel lblnhaxuatban;
	private JLabel lblnhanvien;
	private JPanel panelthongtindocgia;
	private JLabel lblTendocgia;
	private JLabel lbldiachidocgia;
	private JLabel lblgioitinhdocgia;
	private JLabel lblSdtdocgia;
	private JTextField txtTendocgia;
	private JTextField txtdiachidocgia;
	private JTextField txtgioitinhdocgia;
	private JTextField txtsdtdocgia;
	private JTextField txtTimkiemdocgia;
	private JButton btnTimkiemdocgia;
	private JLabel lblTimKiem;
	private JScrollPane scrollPane_1;
	private JTable tabledocgia;
	private DefaultTableModel dtmdocgia;
	private JPanel pnthongtintacgia;
	private JLabel lblTentacgia;
	private JTextField txtTentacgia;
	private JLabel lblnamsinh;
	private JTextField txtnamsinhtacgia;
	private JLabel lblTentacgia_2;
	private JTextField txtQueQuan;
	private JScrollPane scrollPane_2;
	private JTable tabletacgia;
	private DefaultTableModel dtmtacgia;
	private JButton btnThemTacgia;
	private JButton btnsuatacgia;
	private JButton btnreloadtacgia;
	private JButton btnxoatacgia;
	private JPanel panel_1;
	private JLabel lblTennhaxuatban;
	private JLabel lblaCh;
	private JLabel lblTennhaxuatban_2;
	private JTextField txtTennhaxuatban;
	private JTextField txtdiachinxb;
	private JTextField txtsdtnxb;
	private JButton btnThemnxb;
	private JButton btnsuanxb;
	private JButton btnxoanxb;
	private JButton btnreloadnxb;
	private JLabel lblTimKiemnxb;
	private JTextField textField_3;
	private JScrollPane scrollPane_3;
	private JTable tablenhaxuatban;
	private DefaultTableModel dtmnhaxuatban;
	public static JPanel pnPhieumuon;
	private JPanel pnPhieuNhap;
	private JPanel panel_2;
	private JLabel lbltennv;
	private JLabel lblnamsinhnv;
	private JLabel lblaCh_1;
	private JLabel lbltennv_3;
	private JLabel lbltennv_4;
	private JTextField txttennv;
	private JTextField txtnamsinhnv;
	private JTextField txtdiachinv;
	private JTextField txtsodienthoainv;
	private JTextField txtgioitinhnv;
	private JButton btnthemnv;
	private JButton btnsuanv;
	private JButton btnxoanv;
	private JButton btnreloadnv;
	private JLabel lbltimkiem;
	private JTextField txtTimKiemnv;
	private JScrollPane scrollPane_4;
	private JTable tablenhanvien;
	private DefaultTableModel dtmnhanvien;
	protected int y_mouse;
	protected int x_mouse;
	private JPanel pnchung;
	private JPanel panel_3;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JTextField txtmapm;
	private JButton btnthemphieumuon;
	private JButton btnsuaphieumuon;
	private JButton btnxoaphieumuon;
	private JButton btnreloadphieumuon;
	private JScrollPane scrollPane_5;
	private DefaultTableModel dtmmuon;
	private JLabel lblphieumuon;
	private JLabel lbltimkiempm;
	private JTextField textField_9;
	private JScrollPane scrollPane_6;
	private JTable tablectpm;
	private DefaultTableModel dtmctpm;
	public static JTextField txtmasachmuon;
	private JTextField txtghichuctpm;
	private JTextField txttenloai;
	private JTable tableloai;
	private JButton btnsualoai;
	private JButton btnxoaloai;
	private DefaultTableModel dtmloai;
	private JLabel lbltenncc;
	private JTextField txtNcc;
	private JButton btnThemncc;
	private JButton btnsuancc;
	private JButton btnxoancc;
	private JScrollPane scrollPane_7;
	private JTable tablencc;
	private DefaultTableModel dtmncc;
	private JLabel lblNewLabel_10;
	private JTextField txtKeSach;
	private JButton btnthemkesach;
	private JButton btnsuakesach;
	private JButton btnxoakesach;
	private JScrollPane scrollPane_8;
	private JTable tablekesach;
	private JLabel lblchung;
	private JLabel lbldangxuat;
	private DefaultTableModel dtmke;
	private JButton btnThemloai;
	private JButton btnthemdocgia;
	private JButton btnsuadocgia;
	private JButton btnxoadocgia;
	private JComboBox cmbmaloai;
	private JComboBox cmbmanhaxuatban;
	private JComboBox cmbmatg;
	private JComboBox cmbmakesach;
	private String hinhanh = null;
	private JComboBox cmbnhanvienpm;
	private JComboBox cmbmadocgiaphieumuon;
	private JDateChooser dateChooser;
	private JButton btnthemctpm;
	private JButton btnsuactpm;
	private JButton btnxoactpm;
	private JButton bnttailaictpm;
	private JDateChooser dateChooser_ngaytra;
	private JLabel lblthongke;
	private JTable tablephieunhap;
	private DefaultTableModel dtmphieunhap;
	private DefaultTableModel dtmchitietphieunhap;
	private JDateChooser NgayNhapPhieuNhap;
	private JLabel lblphieunhap;
	private JButton btnmanvphieunhap;
	private JButton btnmanccphieunhap;
	private JRadioButton rdmuon;
	private JRadioButton rdtra;
	private JButton btnthemphieuphat;
	private JButton btndanhsachphat;
	private JButton btnthemphieunhap;
	private JButton btnsuaphieunhap;
	private JButton btnxoaphieunhap;
	protected int mapn;
	private JPopupMenu popupThemtaikhoanv;
	private JMenuItem mnthemtaikhoan;
	private DefaultTableModel dtmthongkesachmuon;
	private DefaultTableModel dtmthongkenhaphang;
	public static JLabel lblUser;

	public static int idtaikhoan;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		setBounds(100, 100, 1280, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		thanhtitle();
		menuleft();
		addEvent();
		loadloaisach();
		loadnhacungcap();
		loadkesach();
		loadnhanvien();
		loadnxb();
		loadtacgia();
		loaddocgia();
		loadsach();
		loadphieumuon();
		loadctphieumuon();
		loadphieunhap();
		loadctphieunhap();
		loadthongkephieunhap();
	}

	public void thanhtitle() {
		iconsgu = new JLabel("");
		iconsgu.setIcon(new ImageIcon("C:\\Users\\asus\\Desktop\\img_javaswing\\iconsgu.png"));
		iconsgu.setBounds(0, 0, 30, 34);
		contentPane.add(iconsgu);

		exit = new JLabel("");

		exit.setIcon(new ImageIcon("C:\\Users\\asus\\Desktop\\img_javaswing\\exit.png"));
		exit.setBounds(1244, 7, 24, 24);
		contentPane.add(exit);

		lblTitle = new JLabel("Qu\u1EA3n L\u00FD Th\u01B0 Vi\u1EC7n");
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTitle.setForeground(new Color(255, 255, 255));
		lblTitle.setBounds(535, 0, 170, 34);
		contentPane.add(lblTitle);

		title = new JLabel("");
		title.setOpaque(true);
		title.setBackground(new Color(64, 64, 64));
		title.setBounds(0, 0, 1280, 34);
		contentPane.add(title);

	}

	public void menuleft() {

		PanelChinh = new JPanel();
		PanelChinh.setBounds(187, 33, 1093, 735);
		contentPane.add(PanelChinh);
		PanelChinh.setLayout(new CardLayout(0, 0));
		pnsach();
		/* PN ĐỘC GIẢ */
		docgia();
		/* PANEL NHÀ XUẤT BẢN */
		nhaxuatban();
		/* PANEL TÁC GIẢ */
		pntacgia();
		/*
		 * // PANEL TRANG CHỦ
		 */
		trangchu();

		nhanvien();

		pnPhieumuon = new JPanel();

		pnPhieuNhap = new JPanel();

		menuleft = new JPanel();
		menuleft.setBounds(0, 33, 187, 734);
		menuleft.setBackground(new Color(64, 64, 64));
		contentPane.add(menuleft);
		menuleft.setLayout(null);

		lblthuviensgu = new JLabel("Th\u01B0 Vi\u1EC7n SGU");
		lblthuviensgu.setForeground(Color.WHITE);
		lblthuviensgu.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblthuviensgu.setIcon(new ImageIcon("C:\\Users\\asus\\Desktop\\img_javaswing\\iconthuvien.png"));
		lblthuviensgu.setBounds(0, 13, 187, 40);
		menuleft.add(lblthuviensgu);

		ThuVienSgu = new JLabel("");
		ThuVienSgu.setBackground(new Color(255, 127, 80));
		ThuVienSgu.setOpaque(true);
		ThuVienSgu.setIcon(null);
		ThuVienSgu.setBounds(0, 0, 187, 62);
		menuleft.add(ThuVienSgu);

		lblTrangchu = new JLabel("  Trang Chủ");
		lblTrangchu.setBackground(new Color(64, 64, 64));
		lblTrangchu.setOpaque(true);
		lblTrangchu.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTrangchu.setIcon(new ImageIcon("C:\\Users\\asus\\Desktop\\img_javaswing\\catory 1.png"));
		lblTrangchu.setForeground(Color.WHITE);
		lblTrangchu.setBounds(0, 74, 187, 46);

		menuleft.add(lblTrangchu);

		lblSach = new JLabel("  Sách");
		lblSach.setIcon(new ImageIcon("img\\bookicon.png"));
		lblSach.setBackground(new Color(64, 64, 64));
		lblSach.setOpaque(true);
		lblSach.setForeground(Color.WHITE);
		lblSach.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblSach.setBounds(0, 133, 187, 46);

		menuleft.add(lblSach);

		lbldocgia = new JLabel("  Độc Giả");
		lbldocgia.setIcon(new ImageIcon("img\\Readericon.png"));
		lbldocgia.setBackground(new Color(64, 64, 64));
		lbldocgia.setOpaque(true);
		lbldocgia.setForeground(Color.WHITE);
		lbldocgia.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbldocgia.setBounds(0, 192, 187, 46);

		menuleft.add(lbldocgia);

		lbltacgia = new JLabel("Tác Giả");
		lbltacgia.setIcon(new ImageIcon("img\\Tacgia.png"));
		lbltacgia.setBackground(new Color(64, 64, 64));
		lbltacgia.setOpaque(true);
		lbltacgia.setForeground(Color.WHITE);
		lbltacgia.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbltacgia.setBounds(0, 251, 187, 46);

		menuleft.add(lbltacgia);

		lblnhaxuatban = new JLabel("Nhà Xuất Bản");
		lblnhaxuatban.setIcon(new ImageIcon("img\\Company.png"));
		lblnhaxuatban.setBackground(new Color(64, 64, 64));
		lblnhaxuatban.setOpaque(true);
		lblnhaxuatban.setForeground(Color.WHITE);
		lblnhaxuatban.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblnhaxuatban.setBounds(0, 310, 187, 46);

		menuleft.add(lblnhaxuatban);

		lblnhanvien = new JLabel("Nhân Viên");
		lblnhanvien.setIcon(new ImageIcon("img\\Staff.png"));
		lblnhanvien.setBackground(new Color(64, 64, 64));
		lblnhanvien.setOpaque(true);
		lblnhanvien.setForeground(Color.WHITE);
		lblnhanvien.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblnhanvien.setBounds(0, 369, 187, 46);

		menuleft.add(lblnhanvien);

		lblphieumuon = new JLabel(" Phiếu Mượn");
		lblphieumuon.setIcon(new ImageIcon("img\\Note.png"));
		lblphieumuon.setOpaque(true);
		lblphieumuon.setForeground(Color.WHITE);
		lblphieumuon.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblphieumuon.setBackground(Color.DARK_GRAY);
		lblphieumuon.setBounds(0, 428, 187, 46);
		menuleft.add(lblphieumuon);

		lblchung = new JLabel(" Chung");
		lblchung.setIcon(new ImageIcon("img\\chungpng.png"));
		lblchung.setOpaque(true);
		lblchung.setForeground(Color.WHITE);
		lblchung.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblchung.setBackground(Color.DARK_GRAY);
		lblchung.setBounds(0, 601, 187, 46);
		menuleft.add(lblchung);

		lbldangxuat = new JLabel("Đăng Xuất");
		lbldangxuat.setIcon(new ImageIcon("img\\Exit.png"));
		lbldangxuat.setOpaque(true);
		lbldangxuat.setForeground(Color.WHITE);
		lbldangxuat.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbldangxuat.setBackground(Color.DARK_GRAY);
		lbldangxuat.setBounds(0, 675, 187, 46);
		menuleft.add(lbldangxuat);

		lblthongke = new JLabel("Thống Kê");
		lblthongke.setIcon(new ImageIcon("img\\Combo Chart.png"));
		lblthongke.setOpaque(true);
		lblthongke.setForeground(Color.WHITE);
		lblthongke.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblthongke.setBackground(Color.DARK_GRAY);
		lblthongke.setBounds(0, 542, 187, 46);
		menuleft.add(lblthongke);

		lblphieunhap = new JLabel("   Phiếu Nhập");
		lblphieunhap.setIcon(new ImageIcon("img\\phieunhap.png"));
		lblphieunhap.setOpaque(true);
		lblphieunhap.setForeground(Color.WHITE);
		lblphieunhap.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblphieunhap.setBackground(Color.DARK_GRAY);
		lblphieunhap.setBounds(0, 487, 187, 46);
		menuleft.add(lblphieunhap);
		PanelChinh.add(pnTrangChu, "name_890335498390600");

		JLabel lblNewLabel_17 = new JLabel("");
		lblNewLabel_17
				.setIcon(new ImageIcon("C:\\Users\\asus\\git\\repository\\QuanLyThuVien_3Layer\\img\\iconsgu 3.png"));
		lblNewLabel_17.setBounds(346, 177, 401, 397);
		pnTrangChu.add(lblNewLabel_17);

		lblUser = new JLabel("");
		lblUser.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblUser.setForeground(Color.RED);
		lblUser.setBounds(458, 594, 159, 83);
		pnTrangChu.add(lblUser);
		lblUser.setText("Hi  " + LoginForm.username);
		PanelChinh.add(pnSach, "name_890193837575500");

		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new TitledBorder(null, "H\u00ECnh \u1EA2nh", TitledBorder.LEADING, TitledBorder.ABOVE_BOTTOM,
				null, null));
		panel_5.setBounds(856, 71, 177, 279);
		pnSach.add(panel_5);
		panel_5.setLayout(null);

		lblhinhanhpre = new JLabel("");
		lblhinhanhpre.setOpaque(true);
		lblhinhanhpre.setBounds(864, 77, 158, 252);
		pnSach.add(lblhinhanhpre);

		PanelChinh.add(pndocgia, "name_890203323464100");
		PanelChinh.add(pntacgia, "name_890226525489300");
		PanelChinh.add(pnnhaxuatban, "name_890210577532500");

		JButton btnTimnxb = new JButton("Tìm");
		btnTimnxb.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnTimnxb.setBounds(770, 415, 108, 47);
		pnnhaxuatban.add(btnTimnxb);
		PanelChinh.add(pnnhanvien, "name_890389477283600");

		JLabel lblNewLabel_15 = new JLabel("");
		lblNewLabel_15.setIcon(new ImageIcon("img\\searchbar-removebg-preview.png"));
		lblNewLabel_15.setBounds(268, 392, 532, 52);
		pnnhanvien.add(lblNewLabel_15);
		PanelChinh.add(pnPhieumuon, "name_901238608974900");
		pnPhieumuon.setLayout(null);

		panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(12, 13, 516, 294);
		pnPhieumuon.add(panel_3);
		panel_3.setLayout(null);

		lblNewLabel_1 = new JLabel("Mã PM");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(12, 13, 82, 36);
		panel_3.add(lblNewLabel_1);

		lblNewLabel_4 = new JLabel("Mã NV");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_4.setBounds(12, 61, 82, 36);
		panel_3.add(lblNewLabel_4);

		lblNewLabel_5 = new JLabel("Mã Đọc Giả");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_5.setBounds(12, 110, 97, 36);
		panel_3.add(lblNewLabel_5);

		lblNewLabel_6 = new JLabel("Ngày Mượn");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_6.setBounds(12, 171, 97, 36);
		panel_3.add(lblNewLabel_6);

		lblNewLabel_7 = new JLabel("Tình Trạng");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_7.setBounds(12, 227, 82, 36);
		panel_3.add(lblNewLabel_7);

		txtmapm = new JTextField();
		txtmapm.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtmapm.setEditable(false);
		txtmapm.setBounds(111, 14, 236, 36);
		panel_3.add(txtmapm);
		txtmapm.setColumns(10);

		btnthemphieumuon = new JButton("Thêm");
		btnthemphieumuon.setIcon(new ImageIcon("img\\Add.png"));
		btnthemphieumuon.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnthemphieumuon.setBounds(380, 13, 117, 49);
		panel_3.add(btnthemphieumuon);

		btnsuaphieumuon = new JButton("Sửa");
		btnsuaphieumuon.setIcon(new ImageIcon("img\\Edit.png"));
		btnsuaphieumuon.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnsuaphieumuon.setBounds(380, 83, 117, 49);
		panel_3.add(btnsuaphieumuon);

		btnxoaphieumuon = new JButton("Xoá");
		btnxoaphieumuon.setIcon(new ImageIcon("img\\Delete.png"));
		btnxoaphieumuon.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnxoaphieumuon.setBounds(380, 155, 117, 49);
		panel_3.add(btnxoaphieumuon);

		btnreloadphieumuon = new JButton("Tải Lại");
		btnreloadphieumuon.setIcon(new ImageIcon("img\\update.png"));
		btnreloadphieumuon.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnreloadphieumuon.setBounds(380, 228, 117, 49);
		panel_3.add(btnreloadphieumuon);

		cmbnhanvienpm = new JComboBox();
		cmbnhanvienpm.setBounds(111, 62, 236, 36);
		cmbnhanvienpm.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (cmbnhanvienpm.getSelectedItem() == null) {
					return;
				}

				nvsl = (NhanVien) cmbnhanvienpm.getSelectedItem();

			}
		});
		panel_3.add(cmbnhanvienpm);

		cmbmadocgiaphieumuon = new JComboBox();
		cmbmadocgiaphieumuon.setBounds(111, 114, 236, 32);
		cmbmadocgiaphieumuon.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (cmbmadocgiaphieumuon.getSelectedItem() == null) {
					return;
				}
				dgsl = (DocGia) cmbmadocgiaphieumuon.getSelectedItem();

			}
		});
		panel_3.add(cmbmadocgiaphieumuon);

		dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("yyyy-MM-dd");
		dateChooser.setBounds(111, 171, 236, 36);
		panel_3.add(dateChooser);

		rdmuon = new JRadioButton("Mượn\r\n");
		rdmuon.setFont(new Font("Tahoma", Font.BOLD, 15));
		rdmuon.setBounds(142, 233, 88, 25);
		panel_3.add(rdmuon);

		rdtra = new JRadioButton("Đã Trả");
		rdtra.setFont(new Font("Tahoma", Font.BOLD, 15));
		rdtra.setBounds(245, 233, 127, 25);
		panel_3.add(rdtra);
		ButtonGroup g = new ButtonGroup();
		g.add(rdmuon);
		g.add(rdtra);

		scrollPane_5 = new JScrollPane();
		scrollPane_5.setBounds(540, 13, 553, 294);
		pnPhieumuon.add(scrollPane_5);
		dtmmuon = new DefaultTableModel();
		dtmmuon.addColumn("Mã Phiếu Mượn");
		dtmmuon.addColumn("Mã Nhân Viên");
		dtmmuon.addColumn("Mã Đọc Giả");
		dtmmuon.addColumn("Ngày Mượn");
		dtmmuon.addColumn("Tình Trạng");

		tablemuon = new MyTable(dtmmuon);

		scrollPane_5.setViewportView(tablemuon);

		lbltimkiempm = new JLabel("Tìm Kiếm");
		lbltimkiempm.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbltimkiempm.setBounds(12, 331, 97, 39);
		pnPhieumuon.add(lbltimkiempm);

		textField_9 = new JTextField();
		textField_9.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_9.setBounds(127, 340, 317, 30);
		pnPhieumuon.add(textField_9);
		textField_9.setColumns(10);

		scrollPane_6 = new JScrollPane();
		scrollPane_6.setBounds(22, 391, 736, 331);
		pnPhieumuon.add(scrollPane_6);

		dtmctpm = new DefaultTableModel();
		dtmctpm.addColumn("Mã CTPM");
		dtmctpm.addColumn("Mã PM");
		dtmctpm.addColumn("Mã Sách");
		dtmctpm.addColumn("Ngày Trả");
		dtmctpm.addColumn("Ghi Chú");
		tablectpm = new MyTable(dtmctpm);
		scrollPane_6.setViewportView(tablectpm);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(770, 391, 323, 331);
		pnPhieumuon.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_8 = new JLabel("Mã Sách");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_8.setBounds(12, 13, 91, 49);
		panel.add(lblNewLabel_8);

		txtmasachmuon = new JTextField();
		txtmasachmuon.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtmasachmuon.setBounds(96, 21, 142, 35);
		panel.add(txtmasachmuon);
		txtmasachmuon.setColumns(10);

		JButton btnNewButton_5 = new JButton("...");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new TableSach().setVisible(true);
			}
		});
		btnNewButton_5.setBounds(263, 26, 54, 25);
		panel.add(btnNewButton_5);

		JLabel lblNewLabel_8_1 = new JLabel("Ngày Trả");
		lblNewLabel_8_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_8_1.setBounds(12, 74, 91, 49);
		panel.add(lblNewLabel_8_1);

		JLabel lblNewLabel_8_1_1 = new JLabel("Ghi Chú");
		lblNewLabel_8_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_8_1_1.setBounds(12, 140, 91, 49);
		panel.add(lblNewLabel_8_1_1);

		txtghichuctpm = new JTextField();
		txtghichuctpm.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtghichuctpm.setColumns(10);
		txtghichuctpm.setBounds(96, 148, 142, 35);
		panel.add(txtghichuctpm);

		btnthemctpm = new JButton("Thêm");
		btnthemctpm.setIcon(new ImageIcon("img\\Add.png"));
		btnthemctpm.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnthemctpm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnthemctpm.setBounds(12, 227, 124, 41);
		panel.add(btnthemctpm);

		btnsuactpm = new JButton("Sửa");
		btnsuactpm.setIcon(new ImageIcon("img\\Edit.png"));
		btnsuactpm.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnsuactpm.setBounds(193, 227, 124, 41);
		panel.add(btnsuactpm);

		btnxoactpm = new JButton("Xoá");
		btnxoactpm.setIcon(new ImageIcon("img\\Delete.png"));
		btnxoactpm.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnxoactpm.setBounds(12, 280, 124, 41);
		panel.add(btnxoactpm);

		bnttailaictpm = new JButton("Tải Lại");
		bnttailaictpm.setIcon(new ImageIcon("img\\update.png"));
		bnttailaictpm.setFont(new Font("Tahoma", Font.BOLD, 13));
		bnttailaictpm.setBounds(193, 280, 121, 41);
		panel.add(bnttailaictpm);

		dateChooser_ngaytra = new JDateChooser();
		dateChooser_ngaytra.setDateFormatString("yyyy-MM-dd");

		dateChooser_ngaytra.setBounds(96, 79, 142, 35);
		panel.add(dateChooser_ngaytra);

		btnthemphieuphat = new JButton("Phạt");
		btnthemphieuphat.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnthemphieuphat.setBounds(823, 335, 117, 30);
		btnthemphieuphat.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				new Phat().setVisible(true);
			}
		});
		pnPhieumuon.add(btnthemphieuphat);

		btndanhsachphat = new JButton("Danh Sách Phạt");
		btndanhsachphat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new DanhSachPhat().setVisible(true);
			}
		});
		btndanhsachphat.setFont(new Font("Tahoma", Font.BOLD, 15));
		btndanhsachphat.setBounds(964, 335, 117, 30);
		pnPhieumuon.add(btndanhsachphat);

		JButton btnTm = new JButton("Tìm");
		btnTm.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnTm.setBounds(472, 340, 117, 30);
		pnPhieumuon.add(btnTm);
		PanelChinh.add(pnPhieuNhap, "name_901242535638200");
		pnPhieuNhap.setLayout(null);

		JPanel panel_6 = new JPanel();
		panel_6.setBorder(
				new TitledBorder(null, "Phi\u1EBFu Nh\u1EADp", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_6.setBounds(22, 13, 422, 304);
		pnPhieuNhap.add(panel_6);
		panel_6.setLayout(null);

		JLabel lblNewLabel_11 = new JLabel("Mã Nhân Viên");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_11.setBounds(12, 42, 102, 33);
		panel_6.add(lblNewLabel_11);

		txtManhanvienphieunhap = new JTextField();
		txtManhanvienphieunhap.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtManhanvienphieunhap.setBounds(144, 43, 91, 33);
		panel_6.add(txtManhanvienphieunhap);
		txtManhanvienphieunhap.setColumns(10);

		btnmanvphieunhap = new JButton("...");
		btnmanvphieunhap.setBounds(241, 48, 48, 25);
		panel_6.add(btnmanvphieunhap);

		JLabel lblNewLabel_11_1 = new JLabel("Mã NCC");
		lblNewLabel_11_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_11_1.setBounds(12, 104, 102, 33);
		panel_6.add(lblNewLabel_11_1);

		txtManccPhieuNhap = new JTextField();
		txtManccPhieuNhap.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtManccPhieuNhap.setColumns(10);
		txtManccPhieuNhap.setBounds(144, 104, 91, 33);
		panel_6.add(txtManccPhieuNhap);

		btnmanccphieunhap = new JButton("...");

		btnmanccphieunhap.setBounds(241, 109, 48, 25);
		panel_6.add(btnmanccphieunhap);

		NgayNhapPhieuNhap = new JDateChooser();
		NgayNhapPhieuNhap.setBounds(144, 174, 145, 33);
		NgayNhapPhieuNhap.setDateFormatString("yyyy-MM-dd");
		panel_6.add(NgayNhapPhieuNhap);

		JLabel lblNewLabel_11_1_1 = new JLabel("Ngày Nhập");
		lblNewLabel_11_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_11_1_1.setBounds(12, 174, 102, 33);
		panel_6.add(lblNewLabel_11_1_1);

		btnthemphieunhap = new JButton("Thêm");
		btnthemphieunhap.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnthemphieunhap.setBounds(12, 242, 97, 46);
		panel_6.add(btnthemphieunhap);

		btnsuaphieunhap = new JButton("Sửa");
		btnsuaphieunhap.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnsuaphieunhap.setBounds(138, 242, 97, 46);
		panel_6.add(btnsuaphieunhap);

		btnxoaphieunhap = new JButton("Xoá");
		btnxoaphieunhap.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnxoaphieunhap.setBounds(261, 242, 97, 46);
		panel_6.add(btnxoaphieunhap);

		JScrollPane scrollPane_9 = new JScrollPane();
		scrollPane_9.setBounds(456, 13, 625, 304);
		pnPhieuNhap.add(scrollPane_9);
		dtmphieunhap = new DefaultTableModel();
		dtmphieunhap.addColumn("Mã PN");
		dtmphieunhap.addColumn("Mã NV");
		dtmphieunhap.addColumn("Mã NCC");
		dtmphieunhap.addColumn("Mã Ngày Nhập");

		tablephieunhap = new MyTable(dtmphieunhap);

		scrollPane_9.setViewportView(tablephieunhap);

		JPanel panel_6_1 = new JPanel();
		panel_6_1.setBorder(new TitledBorder(null, "Chi Ti\u1EBFt Phi\u1EBFu Nh\u1EADp", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));

		panel_6_1.setBounds(22, 418, 422, 304);
		pnPhieuNhap.add(panel_6_1);
		panel_6_1.setLayout(null);

		lblNewLabel_12 = new JLabel("Mã Sách");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_12.setBounds(12, 60, 102, 33);
		panel_6_1.add(lblNewLabel_12);

		txtMaSachctpn = new JTextField();
		txtMaSachctpn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtMaSachctpn.setColumns(10);
		txtMaSachctpn.setBounds(152, 60, 91, 33);
		panel_6_1.add(txtMaSachctpn);

		btnmanvphieunhap_1 = new JButton("...");
		btnmanvphieunhap_1.setBounds(278, 65, 48, 25);
		panel_6_1.add(btnmanvphieunhap_1);

		lblNewLabel_13 = new JLabel("Số Lượng");
		lblNewLabel_13.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_13.setBounds(12, 122, 102, 33);
		panel_6_1.add(lblNewLabel_13);

		txtsoluongctpn = new JTextField();
		txtsoluongctpn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtsoluongctpn.setColumns(10);
		txtsoluongctpn.setBounds(152, 122, 91, 33);
		panel_6_1.add(txtsoluongctpn);

		lblNewLabel_14 = new JLabel("Giá Nhập");
		lblNewLabel_14.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_14.setBounds(12, 183, 102, 33);
		panel_6_1.add(lblNewLabel_14);

		txtgianhap = new JTextField();
		txtgianhap.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtgianhap.setColumns(10);
		txtgianhap.setBounds(152, 183, 91, 33);
		panel_6_1.add(txtgianhap);

		lblmaphieunhap = new JLabel("Mã Phiếu Nhập");
		lblmaphieunhap.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblmaphieunhap.setBounds(12, 13, 127, 33);
		panel_6_1.add(lblmaphieunhap);

		btnthemchitietphieunhap = new JButton("Thêm");
		btnthemchitietphieunhap.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnthemchitietphieunhap.setBounds(12, 245, 97, 46);
		panel_6_1.add(btnthemchitietphieunhap);

		btnsuactpn = new JButton("Sửa");
		btnsuactpn.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnsuactpn.setBounds(138, 245, 97, 46);
		panel_6_1.add(btnsuactpn);

		btnxoactpn = new JButton("Xoá");
		btnxoactpn.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnxoactpn.setBounds(261, 245, 97, 46);
		panel_6_1.add(btnxoactpn);

		JScrollPane scrollPane_9_1 = new JScrollPane();
		scrollPane_9_1.setBounds(456, 418, 625, 304);
		pnPhieuNhap.add(scrollPane_9_1);

		dtmchitietphieunhap = new DefaultTableModel();
		dtmchitietphieunhap.addColumn("Mã CTPN");
		dtmchitietphieunhap.addColumn("Mã PN");
		dtmchitietphieunhap.addColumn("Mã Sách");
		dtmchitietphieunhap.addColumn("Số Lượng");
		dtmchitietphieunhap.addColumn("Đơn Giá");
		dtmchitietphieunhap.addColumn("Thành Tiền");
		tablechitietphieunhap = new MyTable(dtmchitietphieunhap);

		scrollPane_9_1.setViewportView(tablechitietphieunhap);

		panel_7 = new JPanel();
		panel_7.setBorder(new LineBorder(new Color(253, 245, 230), 2));
		panel_7.setBounds(22, 330, 1059, 68);
		pnPhieuNhap.add(panel_7);
		panel_7.setLayout(null);

		lblNewLabel_16 = new JLabel("Tìm Kiếm");
		lblNewLabel_16.setToolTipText("Tìm Kiếm Theo Mã Phiếu Nhập");
		lblNewLabel_16.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_16.setBounds(12, 17, 127, 33);
		panel_7.add(lblNewLabel_16);

		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_4.setBounds(141, 13, 425, 42);
		panel_7.add(textField_4);
		textField_4.setColumns(10);

		btninphieunhap = new JButton("In");
		btninphieunhap.setFont(new Font("Tahoma", Font.BOLD, 15));
		btninphieunhap.setBounds(599, 10, 97, 46);
		panel_7.add(btninphieunhap);

		btnxuatexcel = new JButton("Xuất\r\n");
		btnxuatexcel.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnxuatexcel.setBounds(729, 10, 97, 46);
		panel_7.add(btnxuatexcel);

		btnnhapexcel = new JButton("Nhập");
		btnnhapexcel.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnnhapexcel.setBounds(873, 10, 97, 46);
		panel_7.add(btnnhapexcel);

		pnchung();

		pnthongke();
	}

	private void pnchung() {
		pnchung = new JPanel();
		PanelChinh.add(pnchung, "name_903253398621700");
		pnchung.setLayout(null);

		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(null, "Lo\u1EA1i", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_4.setBounds(69, 33, 389, 292);
		pnchung.add(panel_4);
		panel_4.setLayout(null);

		JLabel lblNewLabel_9 = new JLabel("Tên Loại");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_9.setForeground(new Color(0, 0, 0));
		lblNewLabel_9.setBounds(12, 13, 79, 41);
		panel_4.add(lblNewLabel_9);

		txttenloai = new JTextField();
		txttenloai.setFont(new Font("Tahoma", Font.BOLD, 15));
		txttenloai.setBounds(120, 13, 225, 41);
		panel_4.add(txttenloai);
		txttenloai.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 142, 365, 137);
		panel_4.add(scrollPane);
		dtmloai = new DefaultTableModel();
		dtmloai.addColumn("Mã Loại");
		dtmloai.addColumn("Tên Loại");
		tableloai = new MyTable(dtmloai);
		scrollPane.setViewportView(tableloai);

		btnThemloai = new JButton("Thêm");
		btnThemloai.setBounds(12, 93, 97, 25);
		panel_4.add(btnThemloai);

		btnsualoai = new JButton("Sửa");
		btnsualoai.setBounds(149, 93, 97, 25);
		panel_4.add(btnsualoai);

		btnxoaloai = new JButton("Xoá");
		btnxoaloai.setBounds(280, 93, 97, 25);
		panel_4.add(btnxoaloai);

		JPanel panel_4_1 = new JPanel();
		panel_4_1.setBorder(
				new TitledBorder(null, "Nh\u00E0 Cung C\u1EA5p", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_4_1.setBounds(660, 33, 389, 292);
		pnchung.add(panel_4_1);
		panel_4_1.setLayout(null);

		lbltenncc = new JLabel("Tên NCC");
		lbltenncc.setForeground(Color.BLACK);
		lbltenncc.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbltenncc.setBounds(12, 13, 79, 41);
		panel_4_1.add(lbltenncc);

		txtNcc = new JTextField();
		txtNcc.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtNcc.setColumns(10);
		txtNcc.setBounds(120, 13, 225, 41);
		panel_4_1.add(txtNcc);

		btnThemncc = new JButton("Thêm");
		btnThemncc.setBounds(12, 93, 97, 25);
		panel_4_1.add(btnThemncc);

		btnsuancc = new JButton("Sửa");
		btnsuancc.setBounds(149, 93, 97, 25);
		panel_4_1.add(btnsuancc);

		btnxoancc = new JButton("Xoá");
		btnxoancc.setBounds(280, 93, 97, 25);
		panel_4_1.add(btnxoancc);

		scrollPane_7 = new JScrollPane();
		scrollPane_7.setBounds(12, 147, 365, 132);
		panel_4_1.add(scrollPane_7);
		dtmncc = new DefaultTableModel();
		dtmncc.addColumn("Mã NCC");
		dtmncc.addColumn("Tên Nhà Cung Cấp");
		tablencc = new MyTable(dtmncc);
		scrollPane_7.setViewportView(tablencc);

		JPanel panel_4_2 = new JPanel();
		panel_4_2.setBorder(new TitledBorder(null, "K\u1EC7 S\u00E1ch", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(255, 127, 80)));
		panel_4_2.setBounds(352, 408, 389, 292);
		pnchung.add(panel_4_2);
		panel_4_2.setLayout(null);

		lblNewLabel_10 = new JLabel("Tên Kệ");
		lblNewLabel_10.setForeground(Color.BLACK);
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_10.setBounds(12, 23, 79, 41);
		panel_4_2.add(lblNewLabel_10);

		txtKeSach = new JTextField();
		txtKeSach.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtKeSach.setColumns(10);
		txtKeSach.setBounds(120, 23, 225, 41);
		panel_4_2.add(txtKeSach);

		btnthemkesach = new JButton("Thêm");
		btnthemkesach.setBounds(12, 86, 97, 25);
		panel_4_2.add(btnthemkesach);

		btnsuakesach = new JButton("Sửa");
		btnsuakesach.setBounds(149, 86, 97, 25);
		panel_4_2.add(btnsuakesach);

		btnxoakesach = new JButton("Xoá");
		btnxoakesach.setBounds(280, 86, 97, 25);
		panel_4_2.add(btnxoakesach);

		scrollPane_8 = new JScrollPane();
		scrollPane_8.setBounds(12, 143, 365, 136);
		panel_4_2.add(scrollPane_8);
		dtmke = new DefaultTableModel();
		dtmke.addColumn("Mã Kệ");
		dtmke.addColumn("Tên Kệ");
		tablekesach = new MyTable(dtmke);
		scrollPane_8.setViewportView(tablekesach);

	}

	private void pnthongke() {
		panelThongKe = new JPanel();

		DefaultPieDataset p = new DefaultPieDataset();

		int tongsach = SachBus.gI().soluongsach() + chitietpmbus.gI().getsoluongsachdamuon();
		System.out.println("Tổng Sách" + tongsach);
		System.out.println("Sách Đã Mượn " + chitietpmbus.gI().getsoluongsachdamuon());
		int sachdamuon = chitietpmbus.gI().getsoluongsachdamuon();
		System.out.println(sachdamuon);
		float phantramsachdamuon = (float) (sachdamuon * 1.0 / tongsach * 100);
		System.out.println("Phần Trăm Sách đã mươn :" + phantramsachdamuon);

		p.setValue("Sách Đã Mượn", phantramsachdamuon);
		p.setValue("Sách Còn Lại", 100 - phantramsachdamuon);

		JFreeChart chart = ChartFactory.createPieChart3D("Thống Kê Sách Đã Mượn", p);

		TextTitle tt = new TextTitle("Thống Kê Sách Đã Mượn", new Font("Arial", Font.BOLD, 15));

		tt.setPadding(5, 5, 5, 5);
		chart.setTitle(tt);

		final PiePlot3D plot = (PiePlot3D) chart.getPlot();
		plot.setLabelFont(new Font("Arial", Font.PLAIN, 12));
		PanelChinh.add(panelThongKe, "name_8485672922600");
		panelThongKe.setLayout(null);

		btnthongkesachmuon = new JButton("Danh Sách ");
		btnthongkesachmuon.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnthongkesachmuon.setBounds(155, 347, 138, 36);
		panelThongKe.add(btnthongkesachmuon);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		tabbedPane.setBounds(397, 13, 684, 709);
		panelThongKe.add(tabbedPane);

		JPanel panel = new JPanel();
		tabbedPane.addTab("Nhập Hàng", null, panel, null);
		panel.setLayout(null);
		dtmthongkenhaphang = new DefaultTableModel();
		dtmthongkenhaphang.addColumn("Mã CTPN");
		dtmthongkenhaphang.addColumn("Mã PN");
		dtmthongkenhaphang.addColumn("Mã Sách");

		dtmthongkenhaphang.addColumn("Giá Nhập");
		dtmthongkenhaphang.addColumn("Số Lượng");
		dtmthongkenhaphang.addColumn("Thành Tiền");
		dtmthongkenhaphang.addColumn("Ngày Nhập");
		dtmthongkenhaphang.addColumn("Tên Sách");
		JScrollPane scrollPane = new JScrollPane();

		scrollPane.setBounds(12, 13, 651, 418);
		panel.add(scrollPane);

		tablethongkenhaphang = new MyTable(dtmthongkenhaphang);

		scrollPane.setViewportView(tablethongkenhaphang);

		lblNewLabel_18 = new JLabel("Lọc Theo");
		lblNewLabel_18.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_18.setForeground(new Color(0, 0, 0));
		lblNewLabel_18.setBounds(27, 487, 76, 16);
		panel.add(lblNewLabel_18);

		lblNewLabel_19 = new JLabel("Năm");
		lblNewLabel_19.setForeground(Color.BLACK);
		lblNewLabel_19.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_19.setBounds(128, 484, 76, 23);
		panel.add(lblNewLabel_19);

		JSpinField spinField = new JSpinField();
		spinField.setBounds(230, 484, 52, 22);
		panel.add(spinField);

		JButton btnNewButton_1 = new JButton("Lọc");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.setBounds(321, 484, 64, 23);
		panel.add(btnNewButton_1);

		JLabel lblNewLabel_20 = new JLabel("Số Sách Đã Nhập");
		lblNewLabel_20.setForeground(Color.RED);
		lblNewLabel_20.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_20.setBounds(410, 487, 149, 20);
		panel.add(lblNewLabel_20);

		lblsosachdanhap = new JLabel("");
		lblsosachdanhap.setBounds(552, 487, 64, 20);
		panel.add(lblsosachdanhap);

		JLabel lblNewLabel_20_1 = new JLabel("Tổng Tiền");
		lblNewLabel_20_1.setForeground(Color.RED);
		lblNewLabel_20_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_20_1.setBounds(410, 537, 149, 20);
		panel.add(lblNewLabel_20_1);

		JLabel lbltongtien = new JLabel("");
		lbltongtien.setBounds(552, 537, 64, 20);
		panel.add(lbltongtien);

		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("Chưa Biết", null, panel_4, null);

		ChartPanel panel1 = new ChartPanel(chart);
		panel1.setBounds(12, 25, 385, 302);
		panelThongKe.add(panel1);

		panel1.setPreferredSize(new Dimension(311, 302));
		panel1.setBackground(new Color(0, 0, 0, 0));

	}

	private void nhanvien() {

		pnnhanvien = new JPanel();
		pnnhanvien.setLayout(null);

		panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(118, 51, 866, 311);
		pnnhanvien.add(panel_2);
		panel_2.setLayout(null);

		lbltennv = new JLabel("Tên");
		lbltennv.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbltennv.setBounds(12, 13, 138, 39);
		panel_2.add(lbltennv);

		lblnamsinhnv = new JLabel("Năm Sinh");
		lblnamsinhnv.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblnamsinhnv.setBounds(12, 83, 138, 39);
		panel_2.add(lblnamsinhnv);

		lblaCh_1 = new JLabel("Địa Chỉ");
		lblaCh_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblaCh_1.setBounds(12, 158, 138, 39);
		panel_2.add(lblaCh_1);

		lbltennv_3 = new JLabel("Giới Tính");
		lbltennv_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbltennv_3.setBounds(472, 13, 138, 39);
		panel_2.add(lbltennv_3);

		lbltennv_4 = new JLabel("Số Điện Thoại");
		lbltennv_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbltennv_4.setBounds(472, 83, 138, 39);
		panel_2.add(lbltennv_4);

		txttennv = new JTextField();
		txttennv.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txttennv.setBounds(162, 13, 199, 39);
		panel_2.add(txttennv);
		txttennv.setColumns(10);

		txtnamsinhnv = new JTextField();
		txtnamsinhnv.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtnamsinhnv.setColumns(10);
		txtnamsinhnv.setBounds(162, 83, 199, 39);
		panel_2.add(txtnamsinhnv);

		txtdiachinv = new JTextField();
		txtdiachinv.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtdiachinv.setColumns(10);
		txtdiachinv.setBounds(162, 158, 199, 39);
		panel_2.add(txtdiachinv);

		txtsodienthoainv = new JTextField();
		txtsodienthoainv.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtsodienthoainv.setColumns(10);
		txtsodienthoainv.setBounds(608, 83, 199, 39);
		panel_2.add(txtsodienthoainv);

		txtgioitinhnv = new JTextField();
		txtgioitinhnv.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtgioitinhnv.setColumns(10);
		txtgioitinhnv.setBounds(608, 13, 199, 39);
		panel_2.add(txtgioitinhnv);

		btnthemnv = new JButton("Thêm");
		btnthemnv.setIcon(new ImageIcon("img\\Add.png"));
		btnthemnv.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnthemnv.setBounds(58, 245, 126, 53);
		panel_2.add(btnthemnv);

		btnsuanv = new JButton("Sửa");
		btnsuanv.setIcon(new ImageIcon("img\\Edit.png"));
		btnsuanv.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnsuanv.setBounds(259, 245, 126, 53);
		panel_2.add(btnsuanv);

		btnxoanv = new JButton("Xoá\r\n");
		btnxoanv.setIcon(new ImageIcon("img\\Delete.png"));
		btnxoanv.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnxoanv.setBounds(467, 245, 126, 53);
		panel_2.add(btnxoanv);

		btnreloadnv = new JButton("Tải Lại");
		btnreloadnv.setIcon(new ImageIcon("img\\update.png"));
		btnreloadnv.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnreloadnv.setBounds(688, 245, 126, 53);
		panel_2.add(btnreloadnv);

		lbltimkiem = new JLabel("Tìm kiếm");
		lbltimkiem.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbltimkiem.setBounds(118, 405, 138, 39);
		pnnhanvien.add(lbltimkiem);

		txtTimKiemnv = new JTextField();
		txtTimKiemnv.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtTimKiemnv.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtTimKiemnv.setBackground(new Color(214, 217, 223));
		txtTimKiemnv.setBounds(290, 399, 425, 39);
		pnnhanvien.add(txtTimKiemnv);
		txtTimKiemnv.setColumns(10);

		scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(118, 469, 866, 253);
		pnnhanvien.add(scrollPane_4);
		dtmnhanvien = new DefaultTableModel();
		dtmnhanvien.addColumn("Mã");
		dtmnhanvien.addColumn("Họ Tên");
		dtmnhanvien.addColumn("Năm Sinh");
		dtmnhanvien.addColumn("Giới Tính");
		dtmnhanvien.addColumn("Địa Chi");
		dtmnhanvien.addColumn("SĐT");

		tablenhanvien = new MyTable(dtmnhanvien);
		scrollPane_4.setViewportView(tablenhanvien);
		popupThemtaikhoanv = new JPopupMenu();
		mnthemtaikhoan = new JMenuItem("Thêm Tài Khoản");
		mnthemtaikhoan.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				int i = tablenhanvien.getSelectedRow();
				if (i > -1) {
					idtaikhoan = Integer.parseInt(dtmnhanvien.getValueAt(i, 0).toString());
					new TaiKhoan().setVisible(true);
				} else {
					JOptionPane.showMessageDialog(contentPane, "Bạn chưa chọn vào nhân viên để thêm tài khoản");
				}

			}
		});
		mnthemtaikhoan.setBounds(0, 0, 113, 19);
		popupThemtaikhoanv.add(mnthemtaikhoan);

		addPopup(tablenhanvien, popupThemtaikhoanv);

	}

	private void nhaxuatban() {

		pnnhaxuatban = new JPanel();
		pnnhaxuatban.setLayout(null);

		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(216, 64, 708, 327);
		pnnhaxuatban.add(panel_1);
		panel_1.setLayout(null);

		lblTennhaxuatban = new JLabel("Tên Nhà Xuất Bản");
		lblTennhaxuatban.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTennhaxuatban.setBounds(43, 38, 145, 43);
		panel_1.add(lblTennhaxuatban);

		lblaCh = new JLabel("Địa Chỉ");
		lblaCh.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblaCh.setBounds(43, 104, 145, 43);
		panel_1.add(lblaCh);

		lblTennhaxuatban_2 = new JLabel("Số Điện Thoại");
		lblTennhaxuatban_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTennhaxuatban_2.setBounds(43, 172, 145, 43);
		panel_1.add(lblTennhaxuatban_2);

		txtTennhaxuatban = new JTextField();
		txtTennhaxuatban.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtTennhaxuatban.setBounds(321, 44, 282, 37);
		panel_1.add(txtTennhaxuatban);
		txtTennhaxuatban.setColumns(10);

		txtdiachinxb = new JTextField();
		txtdiachinxb.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtdiachinxb.setColumns(10);
		txtdiachinxb.setBounds(321, 110, 282, 37);
		panel_1.add(txtdiachinxb);

		txtsdtnxb = new JTextField();
		txtsdtnxb.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtsdtnxb.setColumns(10);
		txtsdtnxb.setBounds(321, 172, 282, 37);
		panel_1.add(txtsdtnxb);

		btnThemnxb = new JButton("Thêm");
		btnThemnxb.setIcon(new ImageIcon("img\\Add.png"));
		btnThemnxb.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnThemnxb.setBounds(45, 252, 108, 47);
		panel_1.add(btnThemnxb);

		btnsuanxb = new JButton("Sửa");
		btnsuanxb.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnsuanxb.setIcon(new ImageIcon("img\\Edit.png"));
		btnsuanxb.setBounds(221, 252, 108, 47);
		panel_1.add(btnsuanxb);

		btnxoanxb = new JButton("Xoá");
		btnxoanxb.setIcon(new ImageIcon("img\\Delete.png"));
		btnxoanxb.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnxoanxb.setBounds(387, 252, 108, 47);
		panel_1.add(btnxoanxb);

		btnreloadnxb = new JButton("Tải Lại");
		btnreloadnxb.setIcon(new ImageIcon("img\\update.png"));
		btnreloadnxb.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnreloadnxb.setBounds(562, 252, 108, 47);
		panel_1.add(btnreloadnxb);

		lblTimKiemnxb = new JLabel("Tìm Kiếm");
		lblTimKiemnxb.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTimKiemnxb.setBounds(260, 419, 145, 43);
		pnnhaxuatban.add(lblTimKiemnxb);

		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_3.setColumns(10);
		textField_3.setBounds(427, 419, 282, 37);
		pnnhaxuatban.add(textField_3);

		scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(211, 473, 713, 249);
		pnnhaxuatban.add(scrollPane_3);
		dtmnhaxuatban = new DefaultTableModel();
		dtmnhaxuatban.addColumn("Mã Nhà Xuất Bản");
		dtmnhaxuatban.addColumn("Tên Nhà Xuất Bản");
		dtmnhaxuatban.addColumn("Địa Chỉ");
		dtmnhaxuatban.addColumn("Số Điện Thoại");
		tablenhaxuatban = new MyTable(dtmnhaxuatban);
		scrollPane_3.setViewportView(tablenhaxuatban);

	}

	private void docgia() {

		pndocgia = new JPanel();
		pndocgia.setLayout(null);

		panelthongtindocgia = new JPanel();
		panelthongtindocgia.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelthongtindocgia.setBounds(130, 39, 837, 252);
		pndocgia.add(panelthongtindocgia);
		panelthongtindocgia.setLayout(null);

		lblTendocgia = new JLabel("Tên Đọc Giả");
		lblTendocgia.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTendocgia.setBounds(91, 13, 91, 36);
		panelthongtindocgia.add(lblTendocgia);

		lbldiachidocgia = new JLabel("Địa Chỉ");
		lbldiachidocgia.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbldiachidocgia.setBounds(91, 119, 91, 36);
		panelthongtindocgia.add(lbldiachidocgia);

		lblgioitinhdocgia = new JLabel("Giới Tính");
		lblgioitinhdocgia.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblgioitinhdocgia.setBounds(453, 119, 91, 36);
		panelthongtindocgia.add(lblgioitinhdocgia);

		lblSdtdocgia = new JLabel("Số điện thoại");
		lblSdtdocgia.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSdtdocgia.setBounds(453, 13, 109, 36);
		panelthongtindocgia.add(lblSdtdocgia);

		txtTendocgia = new JTextField();
		txtTendocgia.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtTendocgia.setBounds(192, 13, 208, 36);
		panelthongtindocgia.add(txtTendocgia);
		txtTendocgia.setColumns(10);

		txtdiachidocgia = new JTextField();
		txtdiachidocgia.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtdiachidocgia.setColumns(10);
		txtdiachidocgia.setBounds(192, 119, 208, 36);
		panelthongtindocgia.add(txtdiachidocgia);

		txtgioitinhdocgia = new JTextField();
		txtgioitinhdocgia.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtgioitinhdocgia.setColumns(10);
		txtgioitinhdocgia.setBounds(569, 119, 208, 36);
		panelthongtindocgia.add(txtgioitinhdocgia);

		txtsdtdocgia = new JTextField();
		txtsdtdocgia.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtsdtdocgia.setColumns(10);
		txtsdtdocgia.setBounds(569, 13, 208, 36);
		panelthongtindocgia.add(txtsdtdocgia);

		btnthemdocgia = new JButton("Thêm");
		btnthemdocgia.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnthemdocgia.setIcon(new ImageIcon("img\\Add.png"));
		btnthemdocgia.setBounds(84, 190, 119, 49);
		panelthongtindocgia.add(btnthemdocgia);

		btnsuadocgia = new JButton("Sửa");
		btnsuadocgia.setIcon(new ImageIcon("img\\Edit.png"));
		btnsuadocgia.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnsuadocgia.setBounds(375, 190, 119, 49);
		panelthongtindocgia.add(btnsuadocgia);

		btnxoadocgia = new JButton("Xoá");
		btnxoadocgia.setIcon(new ImageIcon("img\\Delete.png"));
		btnxoadocgia.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnxoadocgia.setBounds(658, 190, 119, 49);
		panelthongtindocgia.add(btnxoadocgia);

		txtTimkiemdocgia = new JTextField();
		txtTimkiemdocgia.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtTimkiemdocgia.setBounds(251, 322, 442, 42);
		pndocgia.add(txtTimkiemdocgia);
		txtTimkiemdocgia.setColumns(10);

		btnTimkiemdocgia = new JButton("Tìm");
		btnTimkiemdocgia.setIcon(new ImageIcon("img\\Search.png"));
		btnTimkiemdocgia.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnTimkiemdocgia.setBounds(765, 316, 120, 53);
		pndocgia.add(btnTimkiemdocgia);

		lblTimKiem = new JLabel("Tìm Kiếm");
		lblTimKiem.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTimKiem.setBounds(98, 322, 91, 36);
		pndocgia.add(lblTimKiem);

		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(47, 404, 1005, 308);
		pndocgia.add(scrollPane_1);
		dtmdocgia = new DefaultTableModel();
		dtmdocgia.addColumn("Mã Đọc Giả");
		dtmdocgia.addColumn("Họ Và Tên");
		dtmdocgia.addColumn("Giới Tính");
		dtmdocgia.addColumn("Số Điện Thạoi");
		dtmdocgia.addColumn("Địa Chỉ");
		tabledocgia = new MyTable(dtmdocgia);
		scrollPane_1.setViewportView(tabledocgia);

	}

	private void pntacgia() {

		pntacgia = new JPanel();
		pntacgia.setLayout(null);

		pnthongtintacgia = new JPanel();
		pnthongtintacgia.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnthongtintacgia.setBounds(158, 78, 607, 281);
		pntacgia.add(pnthongtintacgia);
		pnthongtintacgia.setLayout(null);

		lblTentacgia = new JLabel("Tên Tác Giả");
		lblTentacgia.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTentacgia.setBounds(24, 51, 152, 37);
		pnthongtintacgia.add(lblTentacgia);

		txtTentacgia = new JTextField();
		txtTentacgia.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtTentacgia.setBounds(287, 51, 224, 37);
		pnthongtintacgia.add(txtTentacgia);
		txtTentacgia.setColumns(10);

		lblnamsinh = new JLabel("Năm Sinh");
		lblnamsinh.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblnamsinh.setBounds(24, 116, 152, 37);
		pnthongtintacgia.add(lblnamsinh);

		txtnamsinhtacgia = new JTextField();
		txtnamsinhtacgia.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtnamsinhtacgia.setColumns(10);
		txtnamsinhtacgia.setBounds(287, 117, 224, 37);
		pnthongtintacgia.add(txtnamsinhtacgia);

		lblTentacgia_2 = new JLabel("Quê Quán");
		lblTentacgia_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTentacgia_2.setBounds(24, 189, 152, 37);
		pnthongtintacgia.add(lblTentacgia_2);

		txtQueQuan = new JTextField();
		txtQueQuan.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtQueQuan.setColumns(10);
		txtQueQuan.setBounds(287, 189, 224, 37);
		pnthongtintacgia.add(txtQueQuan);

		scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(158, 395, 792, 316);
		pntacgia.add(scrollPane_2);

		dtmtacgia = new DefaultTableModel();
		dtmtacgia.addColumn("Mã Tác Giả");
		dtmtacgia.addColumn("Tên Tác Giả");
		dtmtacgia.addColumn("Năm Sinh");
		dtmtacgia.addColumn("Quê Quán");
		tabletacgia = new MyTable(dtmtacgia);
		scrollPane_2.setViewportView(tabletacgia);

		btnThemTacgia = new JButton("Thêm");
		btnThemTacgia.setIcon(new ImageIcon("img\\Add.png"));
		btnThemTacgia.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnThemTacgia.setBounds(819, 78, 126, 54);
		pntacgia.add(btnThemTacgia);

		btnsuatacgia = new JButton("Sửa");
		btnsuatacgia.setIcon(new ImageIcon("img\\Edit.png"));
		btnsuatacgia.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnsuatacgia.setBounds(819, 144, 126, 47);
		pntacgia.add(btnsuatacgia);

		btnxoatacgia = new JButton("Xoá");
		btnxoatacgia.setIcon(new ImageIcon("img\\Delete.png"));
		btnxoatacgia.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnxoatacgia.setBounds(819, 203, 126, 47);
		pntacgia.add(btnxoatacgia);

		btnreloadtacgia = new JButton("Tải Lại");
		btnreloadtacgia.setIcon(new ImageIcon("img\\update.png"));
		btnreloadtacgia.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnreloadtacgia.setBounds(819, 262, 126, 47);
		pntacgia.add(btnreloadtacgia);

	}

	private void pnsach() {

		pnSach = new JPanel();

		pnSach.setLayout(null);

		lbltitlepnSach = new JLabel("Sách");
		lbltitlepnSach.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbltitlepnSach.setBounds(502, 0, 76, 77);
		pnSach.add(lbltitlepnSach);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(66, 77, 788, 273);
		pnSach.add(panel);
		panel.setLayout(null);

		lblTenSach = new JLabel("Tên Sách");
		lblTenSach.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTenSach.setBounds(12, 13, 112, 34);
		panel.add(lblTenSach);

		lblMaLoai = new JLabel("Mã Loại");
		lblMaLoai.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMaLoai.setBounds(12, 64, 112, 34);
		panel.add(lblMaLoai);

		lblNewLabel_2 = new JLabel("Mã Nhà Xuất Bản");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(12, 111, 132, 34);
		panel.add(lblNewLabel_2);

		lblNewLabel_3 = new JLabel("Mã Tác Giả");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3.setBounds(12, 160, 112, 34);
		panel.add(lblNewLabel_3);

		lblHinhAnh = new JLabel("Hình Ảnh");
		lblHinhAnh.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblHinhAnh.setBounds(398, 13, 112, 34);
		panel.add(lblHinhAnh);

		lblnamxuatban = new JLabel("Năm Xuất Bản");
		lblnamxuatban.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblnamxuatban.setBounds(398, 64, 112, 34);
		panel.add(lblnamxuatban);

		lblSLng = new JLabel("Số Lượng");
		lblSLng.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSLng.setBounds(398, 111, 112, 34);
		panel.add(lblSLng);

		lblMaKeSach = new JLabel("Mã Kệ Sách");
		lblMaKeSach.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMaKeSach.setBounds(398, 160, 112, 34);
		panel.add(lblMaKeSach);

		txttensach = new JTextField();
		txttensach.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txttensach.setBounds(156, 14, 203, 34);
		panel.add(txttensach);
		txttensach.setColumns(10);

		cmbmaloai = new JComboBox();
		cmbmaloai.setBounds(156, 71, 203, 27);
		cmbmaloai.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (cmbmaloai.getSelectedItem() == null) {
					return;
				}
				loaisl = (LoaisachDTO) cmbmaloai.getSelectedItem();

			}
		});
		panel.add(cmbmaloai);

		cmbmanhaxuatban = new JComboBox();
		cmbmanhaxuatban.setBounds(156, 118, 203, 27);
		cmbmanhaxuatban.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (cmbmanhaxuatban.getSelectedItem() == null) {
					return;
				}
				nxbsl = (NhaXuatBan) cmbmanhaxuatban.getSelectedItem();
			}
		});
		panel.add(cmbmanhaxuatban);

		cmbmatg = new JComboBox();
		cmbmatg.setBounds(156, 160, 203, 27);
		cmbmatg.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (cmbmatg.getSelectedItem() == null) {
					return;
				}
				tacgiasl = (TacGiaDTO) cmbmatg.getSelectedItem();
			}
		});
		panel.add(cmbmatg);

		cmbmakesach = new JComboBox();
		cmbmakesach.setBounds(522, 160, 207, 27);
		cmbmakesach.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (cmbmakesach.getSelectedItem() == null) {
					return;
				}
				kesl = (KeSachDTO) cmbmakesach.getSelectedItem();
			}
		});
		panel.add(cmbmakesach);

		txtsoluongsach = new JTextField();
		txtsoluongsach.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtsoluongsach.setBounds(522, 111, 207, 34);
		panel.add(txtsoluongsach);
		txtsoluongsach.setColumns(10);

		txtnamxbsach = new JTextField();
		txtnamxbsach.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtnamxbsach.setColumns(10);
		txtnamxbsach.setBounds(522, 64, 207, 34);
		panel.add(txtnamxbsach);

		JButton btnNewButton = new JButton("Chọn Ảnh");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				xuLyChonAnh();
			}
		});
		btnNewButton.setBounds(522, 19, 112, 28);
		panel.add(btnNewButton);

		btnthemsach = new JButton("Thêm");
		btnthemsach.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnthemsach.setIcon(new ImageIcon("img\\Add.png"));
		btnthemsach.setBounds(32, 206, 112, 53);
		panel.add(btnthemsach);

		btnsuasach = new JButton("Sửa");
		btnsuasach.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnsuasach.setIcon(new ImageIcon("img\\Edit.png"));
		btnsuasach.setBounds(213, 206, 112, 51);
		panel.add(btnsuasach);

		btnxoasach = new JButton("Xoá");
		btnxoasach.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnxoasach.setIcon(new ImageIcon("img\\Delete.png"));
		btnxoasach.setBounds(408, 206, 112, 51);
		panel.add(btnxoasach);

		btnloadlaitrang = new JButton("Tải Lại");
		btnloadlaitrang.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnloadlaitrang.setIcon(new ImageIcon("img\\update.png"));
		btnloadlaitrang.setBounds(620, 204, 112, 53);
		panel.add(btnloadlaitrang);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(39, 413, 1024, 316);
		pnSach.add(scrollPane);
		dtmsach = new DefaultTableModel();
		dtmsach.addColumn("Mã Sách");
		dtmsach.addColumn("Tên Sách");
		dtmsach.addColumn("Mã Tác Giả");
		dtmsach.addColumn("Mã Nhà Xuất Bản");
		dtmsach.addColumn("Mã Loại");
		dtmsach.addColumn("Năm Xuất Bản");
		dtmsach.addColumn("Số Lượng");
		dtmsach.addColumn("Mã Kệ");
		dtmsach.addColumn("Ảnh");

		tablesach = new MyTable(dtmsach);
		scrollPane.setViewportView(tablesach);
		JPopupMenu popupMenu = new JPopupMenu();
		mntmNewMenuItem = new JMenuItem("Thông tin chi tiết");
		mntmNewMenuItem.setBounds(0, 0, 113, 19);
		popupMenu.add(mntmNewMenuItem);

		addPopup(tablesach, popupMenu);

	}

	private void trangchu() {

		pnTrangChu = new JPanel();

		pnTrangChu.setLayout(null);

		/* PANEL NHÂN VIÊN */

		lblNewLabel = new JLabel("CHÀO MỪNG BẠN ĐẾN VỚI THƯ VIỆN TRƯỜNG ĐH SÀI GÒN");
		lblNewLabel.setForeground(new Color(255, 20, 147));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(75, 41, 945, 185);
		pnTrangChu.add(lblNewLabel);
	}

	public void addEvent() {
		btnloadlaitrang.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				loadsach();

			}
		});
		btnthongkesachmuon.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				new TableThongKePhieuMuon().setVisible(true);

			}
		});
		tablectpm.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent arg0) {
				int i = tablectpm.getSelectedRow();
				if (i >= 0) {
					Date date2;
					try {
						date2 = new SimpleDateFormat("yyyy-MM-dd").parse((String) dtmctpm.getValueAt(i, 3).toString());
						dateChooser_ngaytra.setDate(date2);
						txtmasachmuon.setText(dtmctpm.getValueAt(i, 2).toString());
						txtghichuctpm.setText(dtmctpm.getValueAt(i, 4).toString());
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});

		btninphieunhap.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int i = tablephieunhap.getSelectedRow();
				if (i > -1) {
					int ma = Integer.parseInt(dtmphieunhap.getValueAt(i, 0).toString());

					Export.WritePDF wpdf = new WritePDF();
					wpdf.xuatPDFPhieuNhap(tablechitietphieunhap, ma);

				} else {
					JOptionPane.showMessageDialog(null, "Bạn Chưa Click Vào Table Để Xuất Hoá Đơn");
				}

			}
		});
		btnxuatexcel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Export.ExportExcel ex = new ExportExcel();
				ex.xuatExcel(tablephieunhap);

			}
		});
		btnnhapexcel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Export.ImportExcel ix = new ImportExcel();
				ix.nhapExcel(tablephieunhap);

			}
		});

		btnmanvphieunhap.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				new TableNhanVien().setVisible(true);

			}
		});

		btnmanccphieunhap.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new TableNCC().setVisible(true);

			}
		});
		btnmanvphieunhap_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new TableSach().setVisible(true);

			}
		});
		tablephieunhap.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				int i = tablephieunhap.getSelectedRow();
				if (i >= 0) {
					mapn = Integer.parseInt(dtmphieunhap.getValueAt(i, 0).toString());
					lblmaphieunhap.setText("Mã Phiếu Nhập " + mapn);
					txtManhanvienphieunhap.setText(dtmphieunhap.getValueAt(i, 0).toString());
					txtManccPhieuNhap.setText(dtmphieunhap.getValueAt(i, 1).toString());
					Date date2;
					try {
						date2 = new SimpleDateFormat("yyyy-MM-dd")
								.parse((String) dtmphieunhap.getValueAt(i, 3).toString());
						NgayNhapPhieuNhap.setDate(date2);

					} catch (ParseException ex) {
						// TODO Auto-generated catch block
						ex.printStackTrace();
					}
					int maphieunhap = mapn;
					dtmchitietphieunhap.setRowCount(0);
					for (ChiTietPhieuNhap ct : ctphieunhap) {

						if (ct.getMaPhieuNhap() == maphieunhap) {
							Vector vec = new Vector();
							vec.add(ct.getMaCTPN());
							vec.add(ct.getMaPhieuNhap());
							vec.add(ct.getMaSach());
							vec.add(ct.getGia());
							vec.add(ct.getSoLuong());
							vec.add(ct.getThanhTien());
							dtmchitietphieunhap.addRow(vec);
						}
					}
				}

			}
		});

		tablechitietphieunhap.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				int i = tablechitietphieunhap.getSelectedRow();
				if (i >= 0) {
					lblmaphieunhap.setText("Mã Phiếu Nhập " + dtmchitietphieunhap.getValueAt(i, 1).toString());
					txtMaSachctpn.setText(dtmchitietphieunhap.getValueAt(i, 2).toString());
					txtsoluongctpn.setText(dtmchitietphieunhap.getValueAt(i, 3).toString());
					txtgianhap.setText(dtmchitietphieunhap.getValueAt(i, 4).toString());

				}

			}
		});
		tablemuon.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {

			}

			@Override
			public void mouseClicked(MouseEvent arg0) {
				int i = tablemuon.getSelectedRow();
				if (i >= 0) {
					try {
						Date date = new SimpleDateFormat("yyyy-MM-dd")
								.parse((String) dtmmuon.getValueAt(i, 3).toString());

						dateChooser.setDate(date);
					} catch (ParseException e) {
						e.printStackTrace();
					}
					txtmapm.setText(dtmmuon.getValueAt(i, 0).toString());
					Ma = (dtmmuon.getValueAt(i, 0).toString());
					String tinhtrang = dtmmuon.getValueAt(i, 4).toString();
					if (tinhtrang.equals("Đang Mượn")) {
						rdmuon.setSelected(true);
					} else {
						rdtra.setSelected(true);
					}
					String ngay = dtmmuon.getValueAt(i, 3).toString();

					for (int j = 0; j < nv.size(); j++) {
						if (nv.get(j).getMaNV() == Integer.parseInt(dtmmuon.getValueAt(i, 1).toString())) {
							cmbnhanvienpm.setSelectedIndex(j);
							break;
						}
					}
					for (int j = 0; j < dg.size(); j++) {
						if (dg.get(j).getMaDocGia() == Integer.parseInt(dtmmuon.getValueAt(i, 2).toString())) {
							cmbmadocgiaphieumuon.setSelectedIndex(j);
							break;
						}
					}
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					dtmctpm.setRowCount(0);
					for (int k = 0; k < ctpm.size(); k++) {
						if (ctpm.get(k).getMaPhieuMuon() == Integer.parseInt(dtmmuon.getValueAt(i, 0).toString())) {
							Vector<Object> vec = new Vector<Object>();
							vec.add(ctpm.get(k).getMaChiTietPhieuMuon());
							vec.add(ctpm.get(k).getMaPhieuMuon());
							vec.add(ctpm.get(k).getMaSach());
							vec.add(ctpm.get(k).getNgayTra());
							vec.add(ctpm.get(k).getGhichu());
							dtmctpm.addRow(vec);

						}

					}
					Date date2;
					try {
						date2 = new SimpleDateFormat("yyyy-MM-dd").parse((String) dtmctpm.getValueAt(0, 3).toString());
						dateChooser_ngaytra.setDate(date2);
						txtmasachmuon.setText(dtmctpm.getValueAt(0, 2).toString());
						txtghichuctpm.setText(dtmctpm.getValueAt(0, 3).toString());
					} catch (Exception e) {

					}
				}

			}
		});
		tabledocgia.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent arg0) {

			}

			@Override
			public void mousePressed(MouseEvent arg0) {

			}

			@Override
			public void mouseExited(MouseEvent arg0) {

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {

			}

			@Override
			public void mouseClicked(MouseEvent arg0) {

				int i = tabledocgia.getSelectedRow();
				if (i >= 0) {
					txtTendocgia.setText(dtmdocgia.getValueAt(i, 1).toString());
					txtgioitinhdocgia.setText(dtmdocgia.getValueAt(i, 2).toString());

					txtdiachidocgia.setText(dtmdocgia.getValueAt(i, 3).toString());
					txtsdtdocgia.setText(dtmdocgia.getValueAt(i, 4).toString());
				}

			}
		});
		tabletacgia.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				int i = tabletacgia.getSelectedRow();
				if (i >= 0) {
					txtTentacgia.setText(dtmtacgia.getValueAt(i, 1).toString());
					txtnamsinhtacgia.setText(dtmtacgia.getValueAt(i, 2).toString());
					txtQueQuan.setText(dtmtacgia.getValueAt(i, 3).toString());
				}

			}
		});

		lbldangxuat.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent arg0) {

			}

			@Override
			public void mousePressed(MouseEvent arg0) {

			}

			@Override
			public void mouseExited(MouseEvent arg0) {

				lbldangxuat.setBackground(new Color(64, 64, 64));
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {

				lbldangxuat.setBackground(Color.blue);
			}

			@Override
			public void mouseClicked(MouseEvent arg0) {

				setVisible(false);
				LoginForm.dangnhap = false;
				LoginForm.isdangnhap = false;
				TaiKhoanBus bus = new TaiKhoanBus();
				LoginForm.taikhoan = bus.getDanhSachTL();
				new LoginForm().setVisible(true);
				return;

			}
		});
		lblchung.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent arg0) {

			}

			@Override
			public void mousePressed(MouseEvent arg0) {

			}

			@Override
			public void mouseExited(MouseEvent arg0) {

				lblchung.setBackground(new Color(64, 64, 64));
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {

				lblchung.setBackground(Color.blue);
			}

			@Override
			public void mouseClicked(MouseEvent arg0) {

				pnTrangChu.show(false);
				pnSach.show(false);
				pndocgia.show(false);
				pntacgia.show(false);
				pnnhaxuatban.show(false);
				pnnhanvien.show(false);
				pnPhieumuon.show(false);
				pnchung.show();
				panelThongKe.show(false);
				pnPhieuNhap.show(false);
			}
		});
		exit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});

		lblnhanvien.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {

				lblnhanvien.setBackground(new Color(64, 64, 64));
			}

			@Override
			public void mouseEntered(MouseEvent e) {

				lblnhanvien.setBackground(Color.blue);
			}

			@Override
			public void mouseClicked(MouseEvent e) {

				pnTrangChu.show(false);
				pnSach.show(false);
				pndocgia.show(false);
				pntacgia.show(false);
				pnnhaxuatban.show(false);
				pnnhanvien.show(true);
				pnPhieumuon.show(false);
				pnchung.show(false);
				panelThongKe.show(false);
				pnPhieuNhap.show(false);
			}
		});

		lblnhaxuatban.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {

				lblnhaxuatban.setBackground(new Color(64, 64, 64));
			}

			@Override
			public void mouseEntered(MouseEvent e) {

				lblnhaxuatban.setBackground(Color.blue);
			}

			@Override
			public void mouseClicked(MouseEvent e) {

				pnTrangChu.show(false);
				pnSach.show(false);
				pndocgia.show(false);
				pntacgia.show(false);
				pnnhaxuatban.show(true);
				pnnhanvien.show(false);
				pnPhieumuon.show(false);
				pnchung.show(false);
				panelThongKe.show(false);
				pnPhieuNhap.show(false);
			}

		});
		lbldocgia.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {

				lbldocgia.setBackground(new Color(64, 64, 64));
			}

			@Override
			public void mouseEntered(MouseEvent e) {

				lbldocgia.setBackground(Color.blue);
			}

			@Override
			public void mouseClicked(MouseEvent e) {

				pnTrangChu.show(false);
				pnSach.show(false);
				pndocgia.show(true);
				pntacgia.show(false);
				pnnhaxuatban.show(false);
				pnnhanvien.show(false);
				pnPhieumuon.show(false);
				pnchung.show(false);
				panelThongKe.show(false);
				pnPhieuNhap.show(false);
			}
		});
		lblTrangchu.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent arg0) {

			}

			@Override
			public void mousePressed(MouseEvent arg0) {

			}

			@Override
			public void mouseExited(MouseEvent arg0) {

				lblTrangchu.setBackground(new Color(64, 64, 64));
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {

				lblTrangchu.setBackground(Color.BLUE);
			}

			@Override
			public void mouseClicked(MouseEvent arg0) {

				pnTrangChu.show();
				pnSach.show(false);
				pndocgia.show(false);
				pntacgia.show(false);
				pnnhaxuatban.show(false);
				pnnhanvien.show(false);
				pnPhieumuon.show(false);
				pnchung.show(false);
				pnPhieuNhap.show(false);
				panelThongKe.show(false);
			}
		});

		lblSach.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {

				lblSach.setBackground(new Color(64, 64, 64));
			}

			@Override
			public void mouseEntered(MouseEvent e) {

				lblSach.setBackground(Color.blue);
			}

			@Override
			public void mouseClicked(MouseEvent e) {

				pnTrangChu.show(false);
				pnSach.show(true);
				pndocgia.show(false);
				pntacgia.show(false);
				pnnhaxuatban.show(false);
				pnnhanvien.show(false);
				pnPhieumuon.show(false);
				pnchung.show(false);
				panelThongKe.show(false);
				pnPhieuNhap.show(false);
			}
		});
		lbltacgia.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {

				lbltacgia.setBackground(new Color(64, 64, 64));
			}

			@Override
			public void mouseEntered(MouseEvent e) {

				lbltacgia.setBackground(Color.blue);
			}

			@Override
			public void mouseClicked(MouseEvent e) {

				// lblTitle.setText("Tác Giả");
				pnTrangChu.show(false);
				pnSach.show(false);
				pndocgia.show(false);
				pntacgia.show(true);
				pnnhaxuatban.show(false);
				pnnhanvien.show(false);
				pnPhieumuon.show(false);

				pnchung.show(false);
				panelThongKe.show(false);
				pnPhieuNhap.show(false);
			}
		});

		lblthongke.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				pnTrangChu.show(false);
				pnSach.show(false);
				pndocgia.show(false);
				pntacgia.show(false);
				pnnhaxuatban.show(false);
				pnnhanvien.show(false);
				pnPhieumuon.show(false);
				pnchung.show(false);

				panelThongKe.show();

				pnPhieuNhap.show(false);
			}
		});

		lblphieumuon.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {

				lblphieumuon.setBackground(new Color(64, 64, 64));
			}

			@Override
			public void mouseEntered(MouseEvent e) {

				lblphieumuon.setBackground(Color.blue);
			}

			@Override
			public void mouseClicked(MouseEvent e) {

				pnTrangChu.show(false);
				pnSach.show(false);
				pndocgia.show(false);
				pntacgia.show(false);
				pnnhaxuatban.show(false);
				pnnhanvien.show(false);
				pnPhieumuon.show();
				pnPhieuNhap.show(false);
				pnchung.show(false);
				panelThongKe.show(false);
			}
		});
		lblphieunhap.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				lblphieunhap.setBackground(new Color(64, 64, 64));
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				lblphieunhap.setBackground(Color.blue);
			}

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub

				pnTrangChu.show(false);
				pnSach.show(false);
				pndocgia.show(false);
				pntacgia.show(false);
				pnnhaxuatban.show(false);
				pnnhanvien.show(false);
				pnPhieumuon.show(false);
				pnPhieuNhap.show();
				pnchung.show(false);
				panelThongKe.show(false);
			}
		});

		this.addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseMoved(MouseEvent arg0) {

				x_mouse = arg0.getX();
				y_mouse = arg0.getY();

			}

			@Override
			public void mouseDragged(MouseEvent arg0) {

				moveFrame(arg0.getXOnScreen(), arg0.getYOnScreen());

			}

		});
		tableloai.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {

			}

			@Override
			public void mouseClicked(MouseEvent e) {

				int i = -1;
				i = tableloai.getSelectedRow();
				if (i >= 0) {
					txttenloai.setText(dtmloai.getValueAt(i, 1).toString());
				}
			}
		});
		;
		tablesach.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent arg0) {
				int i = tablesach.getSelectedRow();
				if (i > -1) {
					txttensach.setText(dtmsach.getValueAt(i, 1).toString());
					int maloai = Integer.parseInt(dtmsach.getValueAt(i, 2).toString());
					int manxb = Integer.parseInt(dtmsach.getValueAt(i, 3).toString());
					int matg = Integer.parseInt(dtmsach.getValueAt(i, 4).toString());
					int make = Integer.parseInt(dtmsach.getValueAt(i, 7).toString());
					txtnamxbsach.setText(dtmsach.getValueAt(i, 5).toString());
					txtsoluongsach.setText(dtmsach.getValueAt(i, 6).toString());
					hinhanh = dtmsach.getValueAt(i, 8).toString();
					lblhinhanhpre.setIcon(getAnhSP(hinhanh));
				}

			}
		});
		tablencc.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {

			}

			@Override
			public void mouseClicked(MouseEvent e) {

				int i = -1;
				i = tablencc.getSelectedRow();
				if (i >= 0) {
					txtNcc.setText(dtmncc.getValueAt(i, 1).toString());
				}
			}
		});

		tablekesach.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {

			}

			@Override
			public void mouseClicked(MouseEvent e) {

				int i = -1;
				i = tablekesach.getSelectedRow();
				if (i >= 0) {
					txtKeSach.setText("" + dtmke.getValueAt(i, 1));
				}
			}
		});

		btnthemkesach.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				KeSachDTO ke = new KeSachDTO(2, txtKeSach.getText());
				if (KeSachBus.gI().themke(ke) >= 0) {
					loadkesach();
					JOptionPane.showMessageDialog(contentPane, "Thêm Thành Công");

				} else {
					JOptionPane.showMessageDialog(contentPane, "Thêm Thất bại");
				}
			}
		});
		btnsuakesach.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				int i = tablekesach.getSelectedRow();
				int vitri = Integer.parseInt(dtmke.getValueAt(i, 0).toString());
				KeSachDTO ke = new KeSachDTO(vitri, txtKeSach.getText());
				if (KeSachBus.gI().suake(ke) >= 0) {
					loadkesach();
					JOptionPane.showMessageDialog(contentPane, "Sửa Thành Công");

				} else {
					JOptionPane.showMessageDialog(contentPane, "Sửa Thất bại");
				}
			}
		});
		btnxoakesach.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				int i = tablekesach.getSelectedRow();
				int vitri = Integer.parseInt(dtmke.getValueAt(i, 0).toString());
				KeSachDTO ke = new KeSachDTO(vitri, txtKeSach.getText());
				if (KeSachBus.gI().xoake(ke) >= 0) {
					loadkesach();
					JOptionPane.showMessageDialog(contentPane, "Xoá Thành Công");

				} else {
					JOptionPane.showMessageDialog(contentPane, "Xoá Thất bại");
				}
			}
		});

		btnxoaloai.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				int i = tableloai.getSelectedRow();
				int vitri = Integer.parseInt(dtmloai.getValueAt(i, 0).toString());
				LoaisachDTO ke = new LoaisachDTO(vitri, txttenloai.getText());
				if (LoaiBUS.gI().xoaloai(ke) >= 0) {
					loadloaisach();
					JOptionPane.showMessageDialog(contentPane, "Xoá Thành Công");

				} else {
					JOptionPane.showMessageDialog(contentPane, "Xoá Thất bại");
				}
			}
		});
		btnThemloai.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				LoaisachDTO ke = new LoaisachDTO(2, txttenloai.getText());
				if (LoaiBUS.gI().themloai(ke) >= 0) {
					loadloaisach();
					JOptionPane.showMessageDialog(contentPane, "Thêm Thành Công");

				} else {
					JOptionPane.showMessageDialog(contentPane, "Thêm Thất bại");
				}
			}
		});

		btnsualoai.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				int i = tableloai.getSelectedRow();
				int vitri = Integer.parseInt(dtmloai.getValueAt(i, 0).toString());
				LoaisachDTO ke = new LoaisachDTO(vitri, txttenloai.getText());
				if (LoaiBUS.gI().sualoai(ke) >= 0) {
					loadloaisach();
					JOptionPane.showMessageDialog(contentPane, "Sửa Thành Công");

				} else {
					JOptionPane.showMessageDialog(contentPane, "Sửa Thất bại");
				}
			}
		});

		btnxoancc.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				int i = tablencc.getSelectedRow();
				int vitri = Integer.parseInt(dtmncc.getValueAt(i, 0).toString());
				NhaCungCapDTO ke = new NhaCungCapDTO(vitri, txtNcc.getText());
				if (NhaCungcapbus.gI().xoancc(ke) >= 0) {
					loadnhacungcap();
					JOptionPane.showMessageDialog(contentPane, "Xoá Thành Công");

				} else {
					JOptionPane.showMessageDialog(contentPane, "Xoá Thất bại");
				}
			}
		});
		btnThemncc.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				NhaCungCapDTO ke = new NhaCungCapDTO(0, txtNcc.getText());
				if (NhaCungcapbus.gI().themncc(ke) >= 0) {
					loadnhacungcap();
					JOptionPane.showMessageDialog(contentPane, "Thêm Thành Công");

				} else {
					JOptionPane.showMessageDialog(contentPane, "Thêm Thất bại");
				}
			}
		});

		btnsuancc.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				int i = tablencc.getSelectedRow();
				int vitri = Integer.parseInt(dtmncc.getValueAt(i, 0).toString());
				NhaCungCapDTO ke = new NhaCungCapDTO(vitri, txtNcc.getText());
				if (NhaCungcapbus.gI().suancc(ke) >= 0) {
					loadnhacungcap();
					JOptionPane.showMessageDialog(contentPane, "Sửa Thành Công");

				} else {
					JOptionPane.showMessageDialog(contentPane, "Sửa Thất bại");
				}
			}
		});
		tablenhanvien.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent arg0) {

			}

			@Override
			public void mousePressed(MouseEvent arg0) {

			}

			@Override
			public void mouseExited(MouseEvent arg0) {

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {

			}

			@Override
			public void mouseClicked(MouseEvent arg0) {

				int i = tablenhanvien.getSelectedRow();
				if (i >= 0) {
					txttennv.setText(dtmnhanvien.getValueAt(i, 1).toString());
					txtnamsinhnv.setText(dtmnhanvien.getValueAt(i, 2).toString());
					txtgioitinhnv.setText(dtmnhanvien.getValueAt(i, 3).toString());
					txtdiachinv.setText(dtmnhanvien.getValueAt(i, 4).toString());
					txtsodienthoainv.setText(dtmnhanvien.getValueAt(i, 5).toString());
					// txtngaybatdau.setText(dtmnhanvien.getValueAt(i, 6).toString());

				}
			}
		});

		btnsuanv.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				int i = tablenhanvien.getSelectedRow();
				int vitri = Integer.parseInt(dtmnhanvien.getValueAt(i, 0).toString());
				// JOptionPane.showMessageDialog(contentPane, vitri);
				SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
				NhanVien nv;
				nv = new NhanVien(vitri, txttennv.getText(), txtnamsinhnv.getText(), txtgioitinhnv.getText(),
						txtsodienthoainv.getText(), txtdiachinv.getText());

				if (NhanVienBus.gI().suanhanvien(nv) >= 0) {
					loadnhanvien();
					JOptionPane.showMessageDialog(contentPane, "Sửa Thành Công");

				} else {
					JOptionPane.showMessageDialog(contentPane, "Sửa Thất bại");
				}

			}
		});

		btnthemnv.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (txttennv.getText().isEmpty()) {
					thongbao("Tên tác giả");
					return;
				}
				if (txtnamsinhnv.getText().isEmpty() || !isNumber(txtnamsinhnv.getText())) {
					thongbao("Năm sinh tác giả");
					return;
				}
				if (txtgioitinhnv.getText().isEmpty()) {
					thongbao("Giới tính");
					return;
				}
				if (txtsodienthoainv.getText().isEmpty()) {
					thongbao("SĐT");
					return;
				}
				if (txtdiachinv.getText().isEmpty()) {
					thongbao("Địa chỉ");
					return;
				}
				NhanVien nv;
				nv = new NhanVien(0, txttennv.getText(), txtnamsinhnv.getText(), txtgioitinhnv.getText(),
						txtsodienthoainv.getText(), txtdiachinv.getText());

				if (NhanVienBus.gI().themnhanvien(nv) >= 0) {
					loadnhanvien();

					try {

						idtaikhoan = Integer
								.parseInt(dtmnhanvien.getValueAt(tablenhanvien.getRowCount() - 1, 0).toString());
						System.out.println(idtaikhoan);
					} catch (Exception e2) {
						// TODO: handle exception
						e2.printStackTrace();
					}

					JOptionPane.showMessageDialog(contentPane, "Thêm Thành Công");

				} else {
					JOptionPane.showMessageDialog(contentPane, "Thêm Thất bại");
				}

			}
		});
		btnxoanv.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				int i = tablenhanvien.getSelectedRow();
				if (i >= 0) {
					int vitri = Integer.parseInt(dtmnhanvien.getValueAt(i, 0).toString());
					SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
					NhanVien nv;
					nv = new NhanVien(vitri, txttennv.getText(), txtnamsinhnv.getText(), txtgioitinhnv.getText(),
							txtsodienthoainv.getText(), txtdiachinv.getText());

					if (NhanVienBus.gI().xoanhanvien(nv) >= 0) {
						loadnhanvien();
						JOptionPane.showMessageDialog(contentPane, "Xoá Thành Công");

					} else {
						JOptionPane.showMessageDialog(contentPane, "Xoá Thất bại");
					}

				} else {
					JOptionPane.showMessageDialog(contentPane, "Bạn Chưa Chọn vào table");
				}
			}
		});

		txtTimKiemnv.getDocument().addDocumentListener(new DocumentListener() {
			// text field tìm kiếm nhân viên
			@Override
			public void removeUpdate(DocumentEvent arg0) {
				// text field thay đổi gọi lại search
				searchNv();
			}

			@Override
			public void insertUpdate(DocumentEvent arg0) {
				// text field thay đổi gọi lại search
				searchNv();
			}

			@Override
			public void changedUpdate(DocumentEvent arg0) {
				// text field thay đổi gọi lại search
				searchNv();
			}

			public void searchNv() {
				// JOptionPane.showMessageDialog(contentPane, "Chạy tới đáy");
				try {
					dtmnhanvien.setRowCount(0);
					////// mỗi lần gọi lại xoá mịa cái table đi
					if (txtTimKiemnv.getText().isEmpty()) {
						// nếu txtfield rỗng thì hiển thị lại cái bảng đầy đủ
						loadnhanvien(); // hàm đẩy từ csdl vào bảng //
						return;
					}
					String s = txtTimKiemnv.getText().toLowerCase(); // chuyển chữ trong txtfield về chữ thường
					// nhờ v mà seach chữ thường chữ hoa gì cũng ra hết
					for (NhanVien nv : nv) {
						if (nv.getTenNV().toLowerCase().contains(s)) {
							// đúng điều kiện thì đẩy nó vào table
							Vector<Object> vec = new Vector<Object>();
							vec.add(nv.getMaNV());
							vec.add(nv.getTenNV());
							vec.add(nv.getNamSinh());
							vec.add(nv.getGioiTinh());
							vec.add(nv.getDiaChi());
							vec.add(nv.getSdt());
							dtmnhanvien.addRow(vec);
						}
						// .DesignLai.dtm.addRow(vec);
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		});
		tablenhaxuatban.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent arg0) {

			}

			@Override
			public void mousePressed(MouseEvent arg0) {

			}

			@Override
			public void mouseExited(MouseEvent arg0) {

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {

				int i = tablenhaxuatban.getSelectedRow();
				if (i >= 0) {
					txtTennhaxuatban.setText(dtmnhaxuatban.getValueAt(i, 1).toString());
					txtdiachinxb.setText(dtmnhaxuatban.getValueAt(i, 2).toString());
					txtsdtnxb.setText(dtmnhaxuatban.getValueAt(i, 3).toString());
				}
			}

			@Override
			public void mouseClicked(MouseEvent arg0) {

			}
		});
		///////////////////////////////////////////////////////////////////////////////////////
		////////////////////////// THEM SUA XOA NHÀ XUẤT
		/////////////////////////////////////////////////////////////////////////////////////// BẢN////////////////////////////////////
		//////////////////////////////////////////////////////////////////////////////////////

		btnThemnxb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (txtTennhaxuatban.getText().isEmpty()) {
					thongbao("Tên nhà xuất bản");
					return;
				}
				if (txtdiachinxb.getText().isEmpty()) {
					thongbao("Địa chỉ nxb");
					return;
				}
				if (txtsdtnxb.getText().isEmpty()) {
					thongbao("SĐT NXB ");
					return;
				}
				NhaXuatBan nxb = new NhaXuatBan(0, txtTennhaxuatban.getText(), txtdiachinxb.getText(),
						txtsdtnxb.getText());

				if (NhaXuatBanBUS.gI().themnxb(nxb) >= 0) {
					loadnxb();
					JOptionPane.showMessageDialog(contentPane, "Thêm Thành Công");

				} else {
					JOptionPane.showMessageDialog(contentPane, "Thêm Thất bại");
				}

			}
		});
		btnsuanxb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				int i = tablenhaxuatban.getSelectedRow();
				if (i > -1) {
					if (txtTennhaxuatban.getText().isEmpty()) {
						thongbao("Tên nhà xuất bản");
						return;
					}
					if (txtdiachinxb.getText().isEmpty()) {
						thongbao("Địa chỉ nxb");
						return;
					}
					if (txtsdtnxb.getText().isEmpty()) {
						thongbao("SĐT NXB ");
						return;
					}
					int vitri = Integer.parseInt(dtmnhaxuatban.getValueAt(i, 0).toString());
					// JOptionPane.showMessageDialog(contentPane, vitri);
					NhaXuatBan nxb = new NhaXuatBan(vitri, txtTennhaxuatban.getText(), txtdiachinxb.getText(),
							txtsdtnxb.getText());

					if (NhaXuatBanBUS.gI().suanxb(nxb) >= 0) {
						loadnxb();
						JOptionPane.showMessageDialog(contentPane, "Sửa Thành Công");

					} else {
						JOptionPane.showMessageDialog(contentPane, "Sửa Thất bại");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Bạn chưa chọn vào table");
				}

			}
		});

		btnxoanxb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				int i = tablenhaxuatban.getSelectedRow();
				if (i >= 0) {
					int vitri = Integer.parseInt(dtmnhaxuatban.getValueAt(i, 0).toString());
					NhaXuatBan nxb = new NhaXuatBan(vitri, txtTennhaxuatban.getText(), txtdiachinxb.getText(),
							txtsdtnxb.getText());
					if (NhaXuatBanBUS.gI().xoanxb(nxb) >= 0) {
						loadnxb();
						JOptionPane.showMessageDialog(contentPane, "Xoá Thành Công");

					} else {
						JOptionPane.showMessageDialog(contentPane, "Xoá Thất bại");
					}

				} else {
					JOptionPane.showMessageDialog(contentPane, "Bạn Chưa Chọn vào table");
				}
			}
		});

		/* THÊM SỬA XOÁ TÁC GIẢ *///
		/////////////////////////////////
		/////////////////////////////////

		btnThemTacgia.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (txtTentacgia.getText().isEmpty()) {
					thongbao("Tên tác giả");
					return;
				}
				if (txtnamsinhtacgia.getText().isEmpty()) {
					thongbao("Năm sinh tác giả");
					return;
				}
				if (txtQueQuan.getText().isEmpty()) {
					thongbao("Quê Qua tác giả");
					return;
				}
				TacGiaDTO tg = new TacGiaDTO(0, txtTentacgia.getText(), txtnamsinhtacgia.getText(),
						txtQueQuan.getText());

				if (TacGiaBUS.gI().themtacgia(tg) >= 0) {
					loadtacgia();
					JOptionPane.showMessageDialog(contentPane, "Thêm Thành Công");

				} else {
					JOptionPane.showMessageDialog(contentPane, "Thêm Thất bại");
				}

			}
		});
		btnsuatacgia.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				int i = tabletacgia.getSelectedRow();
				if (i >= 0) {
					if (txtTentacgia.getText().isEmpty()) {
						thongbao("Tên tác giả");
						return;
					}
					if (txtnamsinhtacgia.getText().isEmpty()) {
						thongbao("Năm sinh tác giả");
						return;
					}
					if (txtQueQuan.getText().isEmpty()) {
						thongbao("Quê Qua tác giả");
						return;
					}
					int vitri = Integer.parseInt(dtmtacgia.getValueAt(i, 0).toString());
					TacGiaDTO tg = new TacGiaDTO(vitri, txtTentacgia.getText(), txtnamsinhtacgia.getText(),
							txtQueQuan.getText());

					if (TacGiaBUS.gI().suatacgia(tg) >= 0) {
						loadtacgia();
						JOptionPane.showMessageDialog(contentPane, "Sửa Thành Công");

					} else {
						JOptionPane.showMessageDialog(contentPane, "Sửa Thất bại");
					}
				} else {
					JOptionPane.showMessageDialog(contentPane, "Bạn chưa chọn vào table");
				}

			}
		});

		btnxoatacgia.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				int i = tabletacgia.getSelectedRow();
				if (i >= 0) {
					int vitri = Integer.parseInt(dtmtacgia.getValueAt(i, 0).toString());
					TacGiaDTO tg = new TacGiaDTO(vitri, txtTentacgia.getText(), txtnamsinhtacgia.getText(),
							txtQueQuan.getText());
					if (TacGiaBUS.gI().xoatacgia(tg) >= 0) {
						loadtacgia();
						JOptionPane.showMessageDialog(contentPane, "Xoá Thành Công");

					} else {
						JOptionPane.showMessageDialog(contentPane, "Xoá Thất bại");
					}

				} else {
					JOptionPane.showMessageDialog(contentPane, "Bạn Chưa Chọn vào table");
				}
			}
		});
		///////////////////////////////////////////////////
		//////////////// THÊM SỬA XOÁ ĐỌC GIẢ //////////////////////////
		/////////////////////////////////////////////////
		btnthemdocgia.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				if (txtTendocgia.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Tên đọc giả không được bỏ trống");
					return;
				}
				if (txtsdtdocgia.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "SĐT đọc giả không được bỏ trống");
					return;
				}
				if (txtdiachidocgia.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Địa chỉ không được bỏ trống");
					return;
				}
				if (txtgioitinhdocgia.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Giới tính không được bỏ trống");
					return;
				}
				DocGia docgia = new DocGia(0, txtTendocgia.getText(), txtgioitinhdocgia.getText(),
						txtdiachidocgia.getText(), txtsdtdocgia.getText());
				DocGiaBUS docgiabus = new DocGiaBUS();
				if (docgiabus.themdocgia(docgia) >= 0) {
					loaddocgia();
					JOptionPane.showMessageDialog(contentPane, "Thêm Thành Công");

				} else {
					JOptionPane.showMessageDialog(contentPane, "Thêm Thất bại");
				}

			}
		});

		btnsuadocgia.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				int i = tabledocgia.getSelectedRow();
				if (i >= 0) {
					if (txtTendocgia.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Tên đọc giả không được bỏ trống");
						return;
					}
					if (txtsdtdocgia.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "SĐT đọc giả không được bỏ trống");
						return;
					}
					if (txtdiachidocgia.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Địa chỉ không được bỏ trống");
						return;
					}
					if (txtgioitinhdocgia.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Giới tính không được bỏ trống");
						return;
					}
					int vitri = Integer.parseInt(dtmdocgia.getValueAt(i, 0).toString());
					DocGia docgia = new DocGia(vitri, txtTendocgia.getText(), txtgioitinhdocgia.getText(),
							txtdiachidocgia.getText(), txtsdtdocgia.getText());
					if (DocGiaBUS.gI().suadocgia(docgia) >= 0) {
						loaddocgia();
						JOptionPane.showMessageDialog(contentPane, "Sửa Thành Công");

					} else {
						JOptionPane.showMessageDialog(contentPane, "Sứa Thất bại");
					}

				} else {
					JOptionPane.showMessageDialog(contentPane, "Bạn Chưa Chọn vào table");
				}
			}
		});

		btnxoadocgia.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				int i = tabledocgia.getSelectedRow();
				if (i >= 0) {
					int vitri = Integer.parseInt(dtmdocgia.getValueAt(i, 0).toString());
					DocGia docgia = new DocGia(vitri, txtTendocgia.getText(), txtgioitinhdocgia.getText(),
							txtdiachidocgia.getText(), txtsdtdocgia.getText());
					if (DocGiaBUS.gI().xoadocgia(docgia) >= 0) {
						loaddocgia();
						JOptionPane.showMessageDialog(contentPane, "Xoá Thành Công");

					} else {
						JOptionPane.showMessageDialog(contentPane, "Xoá Thất Bại");
					}

				} else {
					JOptionPane.showMessageDialog(contentPane, "Bạn Chưa Chọn vào table");
				}
			}
		});
		/////////////////////////// THÊM SỬA XOÁ SÁCH///////////////////////////
		//////////////////////////////////////////////////////////////////////
		/////////////////////////////////////////////////////////////////////

		btnthemsach.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				// Bắt sự kiện khi nhập không đúng;

				if (txttensach.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Tên sách không được để trống hoặc là số");
					return;

				}
				if (!isNumber(txtsoluongsach.getText()) || txtsoluongsach.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Số lượng phải nhập số");
					return;
				}
				if (!isNumber(txtnamxbsach.getText()) || txtnamxbsach.getText().isEmpty()
						|| txtnamxbsach.getText().length() != 4) {
					JOptionPane.showMessageDialog(null, "Không được bỏ trống, năm xuất bản phải là số");
					return;
				}

				int makesach = kesl.getMaKeSach();
				int manxb = nxbsl.getMaNXB();
				int matg = tacgiasl.getMaTacGia();
				int loai = loaisl.getMaloai();

				String tensach = txttensach.getText();
				int namxb = Integer.parseInt(txtnamxbsach.getText());
				int soluong = Integer.parseInt(txtsoluongsach.getText());

				SachDTO sach = new SachDTO(0, tensach, matg, manxb, loai, namxb, soluong, "", hinhanh, makesach);

				if (SachDAL.themsach(sach) >= 0) {
					loadsach();
					JOptionPane.showMessageDialog(contentPane, "Thêm Thành Công");

				} else {
					JOptionPane.showMessageDialog(contentPane, "Thêm Thất bại");
				}

			}
		});

		btnsuasach.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				int i = tablesach.getSelectedRow();
				if (i > -1) {
					if (txttensach.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Tên sách không được để trống hoặc là số");
						return;

					}
					if (!isNumber(txtsoluongsach.getText()) || txtsoluongsach.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Số lượng phải nhập số");
						return;
					}
					if (!isNumber(txtnamxbsach.getText()) || txtnamxbsach.getText().isEmpty()
							|| txtnamxbsach.getText().length() != 4) {
						JOptionPane.showMessageDialog(null, "Không được bỏ trống, năm xuất bản phải là số");
						return;
					}

					int makesach = kesl.getMaKeSach();
					int manxb = nxbsl.getMaNXB();
					int matg = tacgiasl.getMaTacGia();
					int loai = loaisl.getMaloai();

					String tensach = txttensach.getText();
					int namxb = Integer.parseInt(txtnamxbsach.getText());
					int soluong = Integer.parseInt(txtsoluongsach.getText());
					int masach = Integer.parseInt(dtmsach.getValueAt(i, 0).toString());
					SachDTO sach = new SachDTO(masach, tensach, matg, manxb, loai, namxb, soluong, "", hinhanh,
							makesach);

					if (SachBus.gI().suapm(sach) > 0) {
						loadsach();
						JOptionPane.showMessageDialog(contentPane, "Sửa Thành Công");

					} else {
						JOptionPane.showMessageDialog(contentPane, "Sửa Thất bại");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Bạn Chưa Chọn Vào Bảng");
				}

			}
		});

		btnxoasach.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				int i = tablesach.getSelectedRow();
				if (i > -1) {
					int makesach = kesl.getMaKeSach();
					int manxb = nxbsl.getMaNXB();
					int matg = tacgiasl.getMaTacGia();
					int loai = loaisl.getMaloai();

					String tensach = txttensach.getText();
					int namxb = Integer.parseInt(txtnamxbsach.getText());
					int soluong = Integer.parseInt(txtsoluongsach.getText());
					int masach = Integer.parseInt(dtmsach.getValueAt(i, 0).toString());
					SachDTO sach = new SachDTO(masach, tensach, matg, manxb, loai, namxb, soluong, "", hinhanh,
							makesach);

					if (SachBus.gI().xoapm(sach) > 0) {
						loadsach();
						JOptionPane.showMessageDialog(contentPane, "Xoá Thành Công");

					} else {
						JOptionPane.showMessageDialog(contentPane, "Xoá Thất bại");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Bạn Chưa Chọn Vào Bảng");
				}

			}
		});

		////////////////////////////////////////////////////////////
		////////////////// * THEM SUA XOA PHIEU MUON *///////////////
		///////////////////////////////////////////////////////////

		btnthemphieumuon.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int manv = nvsl.getMaNV();
				int madocgia = dgsl.getMaDocGia();
				String tinhtrang = "Đã Trả";

				if (rdmuon.isSelected()) {
					tinhtrang = "Đang Mượn";

				}
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				// String ngaymuon = ((JTextField)
				// dateChooser.getDateEditor().getUiComponent()).getText();
				String ngaymuon = sdf.format(dateChooser.getDate());
				PhieuMuon pm = new PhieuMuon(0, manv, madocgia, ngaymuon, tinhtrang);
				if (PhieuMuonBus.gI().thempm(pm) >= 0) {
					loadphieumuon();
					JOptionPane.showMessageDialog(contentPane, "Thêm Phiếu Mượn Thành Công");

				} else
					JOptionPane.showMessageDialog(contentPane, "Thêm Phiếu Mượn Không Thành Công");
			}
		});

		btnsuaphieumuon.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				int i = tablemuon.getSelectedRow();
				if (i >= 0) {
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					// String ngaymuon = ((JTextField)
					// dateChooser.getDateEditor().getUiComponent()).getText();
					String ngaymuon = sdf.format(dateChooser.getDate());
					int vitri = Integer.parseInt(dtmmuon.getValueAt(i, 0).toString());
					String tinhtrang = tinhtrangmuon();
					PhieuMuon pm = new PhieuMuon(vitri, nvsl.getMaNV(), dgsl.getMaDocGia(), ngaymuon, tinhtrang);
					if (PhieuMuonBus.gI().suapm(pm) >= 0) {
						loadphieumuon();
						JOptionPane.showMessageDialog(contentPane, "Sửa Phiếu Mượn Thành Công");

					} else
						JOptionPane.showMessageDialog(contentPane, "Sửa Phiếu Mượn Không Thành Công");
				}

				else {
					JOptionPane.showMessageDialog(contentPane, "Bạn Chưa Chọn vào table");
				}
			}
		});

		btnxoaphieumuon.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				int i = tablemuon.getSelectedRow();
				if (i >= 0) {
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					String ngaymuon = sdf.format(dateChooser.getDate());
					int vitri = Integer.parseInt(dtmmuon.getValueAt(i, 0).toString());
					String tinhtrang = tinhtrangmuon();
					PhieuMuon pm = new PhieuMuon(vitri, nvsl.getMaNV(), dgsl.getMaDocGia(), ngaymuon, tinhtrang);
					if (PhieuMuonBus.gI().xoapm(pm) >= 0) {
						loadphieumuon();
						JOptionPane.showMessageDialog(contentPane, "Xoá Phiếu Mượn Thành Công");

					} else
						JOptionPane.showMessageDialog(contentPane, "Xoá Phiếu Mượn Không Thành Công");
				}

				else {
					JOptionPane.showMessageDialog(contentPane, "Bạn Chưa Chọn vào table");
				}
			}
		});

		////////////////////////////////////////////////////////////
		////////////////// * THEM SUA XOA CHI TIET PHIEU MUON *///////////////
		///////////////////////////////////////////////////////////
		btnthemctpm.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				// String ngaymuon = ((JTextField)
				// dateChooser.getDateEditor().getUiComponent()).getText();
				String ngaytra = sdf.format(dateChooser_ngaytra.getDate());

				ChiTieuPMDTO ctpm = new ChiTieuPMDTO(0, Integer.parseInt(txtmapm.getText()),
						Integer.parseInt(txtmasachmuon.getText()), ngaytra, txtghichuctpm.getText());
				if (chitietpmbus.gI().thempm(ctpm) > 0) {
					loadctphieumuon();
					JOptionPane.showMessageDialog(contentPane, "Thêm CT Phiếu Mượn Thành Công");

				} else
					JOptionPane.showMessageDialog(contentPane, "Thêm CT Phiếu Mượn Không Thành Công");
			}

		});
		btnsuactpm.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				int i = tablectpm.getSelectedRow();
				if (i >= 0) {
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					// String ngaymuon = ((JTextField)
					// dateChooser.getDateEditor().getUiComponent()).getText();
					String ngaytra = sdf.format(dateChooser_ngaytra.getDate());
					int mactpm = Integer.parseInt(dtmctpm.getValueAt(i, 0).toString());
					ChiTieuPMDTO ctpm = new ChiTieuPMDTO(mactpm, Integer.parseInt(txtmapm.getText()),
							Integer.parseInt(txtmasachmuon.getText()), ngaytra, txtghichuctpm.getText());
					if (chitietpmbus.gI().suapm(ctpm) > 0) {
						loadctphieumuon();
						JOptionPane.showMessageDialog(contentPane, "Sửa CT Phiếu Mượn Thành Công");

					} else
						JOptionPane.showMessageDialog(contentPane, "Sửa CT Phiếu Mượn Không Thành Công");
				}

				else {
					JOptionPane.showMessageDialog(contentPane, "Bạn Chưa Chọn vào table");
				}
			}
		});

		btnxoactpm.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				int i = tablectpm.getSelectedRow();
				if (i >= 0) {
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					// String ngaymuon = ((JTextField)
					// dateChooser.getDateEditor().getUiComponent()).getText();
					String ngaytra = sdf.format(dateChooser_ngaytra.getDate());
					int mactpm = Integer.parseInt(dtmctpm.getValueAt(i, 0).toString());
					ChiTieuPMDTO ctpm = new ChiTieuPMDTO(mactpm, Integer.parseInt(txtmapm.getText()),
							Integer.parseInt(txtmasachmuon.getText()), ngaytra, txtghichuctpm.getText());
					if (chitietpmbus.gI().xoapm(ctpm) > 0) {
						loadctphieumuon();
						JOptionPane.showMessageDialog(contentPane, "Xoá CT Phiếu Mượn Thành Công");

					} else
						JOptionPane.showMessageDialog(contentPane, "Xoá CT Phiếu Mượn Không Thành Công");
				}

				else {
					JOptionPane.showMessageDialog(contentPane, "Bạn Chưa Chọn vào table");
				}
			}
		});
		///////////////////////////////////////////////////////////////////////////////////////////////
		///////// THÊM SỬA XOÁ PHIẾU
		/////////////////////////////////////////////////////////////////////////////////////////////// NHẬP/////////////////////////////////////////////////
		/////////////////////////////////////////////////////////////////

		btnthemphieunhap.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				// String ngaymuon = ((JTextField)
				// dateChooser.getDateEditor().getUiComponent()).getText();
				String ngaynhap = sdf.format(NgayNhapPhieuNhap.getDate());
				int Manv = Integer.parseInt(txtManhanvienphieunhap.getText());
				int Mancc = Integer.parseInt(txtManccPhieuNhap.getText());
				PhieuNhap pn = new PhieuNhap(0, Mancc, Manv, ngaynhap);
				if (PhieuNhapBUS.gI().thempm(pn) > 0) {
					loadphieunhap();
					JOptionPane.showMessageDialog(null, "Thêm Phiếu Nhập Thành Công");

				} else {
					JOptionPane.showMessageDialog(null, "Thêm Phiếu Nhập Thất Bại");

				}

			}
		});
		btnsuaphieunhap.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				int i = tablephieunhap.getSelectedRow();
				if (i >= 0) {

					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					int vitri = Integer.parseInt(dtmphieunhap.getValueAt(i, 0).toString());
					String ngaynhap = sdf.format(NgayNhapPhieuNhap.getDate());
					int Manv = Integer.parseInt(txtManhanvienphieunhap.getText());
					int Mancc = Integer.parseInt(txtManccPhieuNhap.getText());
					PhieuNhap pn = new PhieuNhap(vitri, Mancc, Manv, ngaynhap);
					if (PhieuNhapBUS.gI().suapm(pn) > 0) {
						loadphieunhap();
						JOptionPane.showMessageDialog(null, "Sửa Phiếu Nhập Thành Công");

					} else {
						JOptionPane.showMessageDialog(null, "Sửa Phiếu Nhập Thất Bại");

					}
				} else {
					JOptionPane.showMessageDialog(contentPane, "Bạn Chưa Chọn vào table");
				}

			}
		});

		btnxoaphieunhap.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				int i = tablephieunhap.getSelectedRow();
				if (i >= 0) {

					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					int vitri = Integer.parseInt(dtmphieunhap.getValueAt(i, 0).toString());
					String ngaynhap = sdf.format(NgayNhapPhieuNhap.getDate());
					int Manv = Integer.parseInt(txtManhanvienphieunhap.getText());
					int Mancc = Integer.parseInt(txtManccPhieuNhap.getText());
					PhieuNhap pn = new PhieuNhap(vitri, Mancc, Manv, ngaynhap);
					if (PhieuNhapBUS.gI().xoapm(pn) > 0) {
						loadphieunhap();
						JOptionPane.showMessageDialog(null, "Xoá Phiếu Nhập Thành Công");

					} else {
						JOptionPane.showMessageDialog(null, "Xoá Phiếu Nhập Thất Bại");

					}
				} else {
					JOptionPane.showMessageDialog(contentPane, "Bạn Chưa Chọn vào table");
				}
			}
		});
		////////////////////////////////////////////////////////////////////////////////////////////////
		////////////////////// THÊM SỬA XOÁ CHI TIẾT PHIẾU
		//////////////////////////////////////////////////////////////////////////////////////////////// NHẬP/////////////////////////////////////////
		//////////////////////////////////////////////////////////////////////////////////////////////
		btnthemchitietphieunhap.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				int masach = Integer.parseInt(txtMaSachctpn.getText());
				int sl = Integer.parseInt(txtsoluongctpn.getText());
				int gia = Integer.parseInt(txtgianhap.getText());
				ChiTietPhieuNhap ct = new ChiTietPhieuNhap(0, mapn, masach, gia, sl, sl * gia);
				if (ChiTietPhieuNhapBUS.gI().thempm(ct) >= 0) {
					loadctphieunhap();
					JOptionPane.showMessageDialog(contentPane, "Thêm Thành Công");
				} else {
					JOptionPane.showMessageDialog(contentPane, "Thêm Thất Bại");

				}
			}
		});

		btnxoactpn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				int i = tablechitietphieunhap.getSelectedRow();
				if (i >= 0) {

					int masach = Integer.parseInt(txtMaSachctpn.getText());
					int sl = Integer.parseInt(txtsoluongctpn.getText());
					int gia = Integer.parseInt(txtgianhap.getText());
					int mactpn = Integer.parseInt(dtmchitietphieunhap.getValueAt(i, 0).toString());
					ChiTietPhieuNhap ct = new ChiTietPhieuNhap(mactpn, mapn, masach, gia, sl, sl * gia);
					if (ChiTietPhieuNhapBUS.gI().xoapm(ct) > 0) {
						loadctphieunhap();
						JOptionPane.showMessageDialog(null, "Xoá CT Phiếu Nhập Thành Công");

					} else {
						JOptionPane.showMessageDialog(null, "Xoá CT Phiếu Nhập Thất Bại");

					}
				} else {
					JOptionPane.showMessageDialog(contentPane, "Bạn Chưa Chọn vào table");
				}
			}
		});

		btnsuactpn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				int i = tablechitietphieunhap.getSelectedRow();
				if (i >= 0) {

					int masach = Integer.parseInt(txtMaSachctpn.getText());
					int sl = Integer.parseInt(txtsoluongctpn.getText());
					int gia = Integer.parseInt(txtgianhap.getText());
					int mactpn = Integer.parseInt(dtmchitietphieunhap.getValueAt(i, 0).toString());
					ChiTietPhieuNhap ct = new ChiTietPhieuNhap(mactpn, mapn, masach, gia, sl, sl * gia);
					if (ChiTietPhieuNhapBUS.gI().suapm(ct) > 0) {
						loadctphieunhap();
						JOptionPane.showMessageDialog(null, "Xoá CT Phiếu Nhập Thành Công");

					} else {
						JOptionPane.showMessageDialog(null, "Xoá CT Phiếu Nhập Thất Bại");

					}
				} else {
					JOptionPane.showMessageDialog(contentPane, "Bạn Chưa Chọn vào table");
				}
			}
		});
	}

	private void moveFrame(int x, int y) {

		this.setLocation(x - x_mouse, y - y_mouse);
	}

	public static ArrayList<LoaisachDTO> loaisacharr;

	public void loadloaisach() {
		loaisacharr = null;
		LoaiBUS loaiBUS = new LoaiBUS();
		loaisacharr = loaiBUS.getLoaisachLoai();
		dtmloai.setRowCount(0);
		cmbmaloai.removeAllItems();
		for (LoaisachDTO loaisachDTO : loaisacharr) {
			Vector<Object> vec = new Vector<Object>();
			vec.add(loaisachDTO.getMaloai());
			vec.add(loaisachDTO.getTenloai());
			dtmloai.addRow(vec);
			cmbmaloai.addItem(loaisachDTO);

		}
	}

	public static ArrayList<NhaXuatBan> nxb;

	public void loadnxb() {
		nxb = null;
		NhaXuatBanBUS nxbbus = new NhaXuatBanBUS();
		nxb = nxbbus.getdanhsachnxb();
		dtmnhaxuatban.setRowCount(0);
		cmbmanhaxuatban.removeAllItems();
		for (NhaXuatBan loaisachDTO : nxb) {
			Vector<Object> vec = new Vector<Object>();
			vec.add(loaisachDTO.getMaNXB());
			vec.add(loaisachDTO.getTenNXB());
			vec.add(loaisachDTO.getDiaChi());
			vec.add(loaisachDTO.getSdt());
			cmbmanhaxuatban.addItem(loaisachDTO);
			dtmnhaxuatban.addRow(vec);

		}
	}

	public static ArrayList<NhaCungCapDTO> ncc;

	public void loadnhacungcap() {
		ncc = null;
		NhaCungcapbus nccbus = new NhaCungcapbus();
		ncc = nccbus.getdanhsachncc();
		dtmncc.setRowCount(0);
		for (NhaCungCapDTO nhaCungCapDTO : ncc) {
			Vector<Object> vec = new Vector<Object>();
			vec.add(nhaCungCapDTO.getMaNCC());

			vec.add(nhaCungCapDTO.getTenNCC());
			dtmncc.addRow(vec);
		}

	}

	public static ArrayList<KeSachDTO> ke = new ArrayList<KeSachDTO>();

	public void loadkesach() {
		ke = null;
		KeSachBus keSachBus = new KeSachBus();
		ke = keSachBus.getdanhsachncc();
		dtmke.setRowCount(0);
		cmbmakesach.removeAllItems();
		for (KeSachDTO kesach : ke) {
			Vector<Object> vec = new Vector<Object>();
			vec.add(kesach.getMaKeSach());

			vec.add(kesach.getViTri());
			cmbmakesach.addItem(kesach);
			dtmke.addRow(vec);

			// .DesignLai.dtm.addRow(vec);
		}
		/*
		 * for (NhaCungCap ncc1 : ncc) { Vector<Object> vec = new Vector<Object>();
		 * vec.add(ncc1.getMaNCC()); vec.add(ncc1.getTenNCC()); dtmncc.addRow(vec); }
		 */
	}

	public static ArrayList<NhanVien> nv = new ArrayList<NhanVien>();

	public void loadnhanvien() {
		nv = null;
		NhanVienBus nvbuss = new NhanVienBus();
		nv = nvbuss.getdanhsachnv();
		dtmnhanvien.setRowCount(0);
		for (NhanVien nv : nv) {
			Vector<Object> vec = new Vector<Object>();
			vec.add(nv.getMaNV());
			vec.add(nv.getTenNV());
			vec.add(nv.getNamSinh());
			vec.add(nv.getGioiTinh());
			vec.add(nv.getDiaChi());
			vec.add(nv.getSdt());
			dtmnhanvien.addRow(vec);
			cmbnhanvienpm.addItem(nv);
			// .DesignLai.dtm.addRow(vec);
		}
		/*
		 * for (NhaCungCap ncc1 : ncc) { Vector<Object> vec = new Vector<Object>();
		 * vec.add(ncc1.getMaNCC()); vec.add(ncc1.getTenNCC()); dtmncc.addRow(vec); }
		 */
	}

	public static ArrayList<TacGiaDTO> tg = new ArrayList<TacGiaDTO>();

	public void loadtacgia() {
		tg = null;
		TacGiaBUS tgbus = new TacGiaBUS();
		tg = tgbus.getdanhsachtacgia();
		dtmtacgia.setRowCount(0);
		cmbmatg.removeAllItems();
		for (TacGiaDTO tg : tg) {
			Vector<Object> vec = new Vector<Object>();
			vec.add(tg.getMaTacGia());
			vec.add(tg.getTenTacGia());
			vec.add(tg.getNamSinh());
			vec.add(tg.getQueQuan());

			dtmtacgia.addRow(vec);
			cmbmatg.addItem(tg);
			// .DesignLai.dtm.addRow(vec);
		}

	}

	private JLabel lblhinhanhpre;
	private JButton btnthemsach;
	private JButton btnsuasach;
	private JButton btnxoasach;
	private JButton btnloadlaitrang;
	public static ArrayList<DocGia> dg = new ArrayList<DocGia>();

	public void loaddocgia() {
		dg = null;
		DocGiaBUS dgbus = new DocGiaBUS();
		dg = dgbus.getdanhsachdocgia();

		dtmdocgia.setRowCount(0);

		for (DocGia dg1 : dg) {
			Vector<Object> vec = new Vector<Object>();
			vec.add(dg1.getMaDocGia());
			vec.add(dg1.getTenDocGia());
			vec.add(dg1.getGioiTinh());
			vec.add(dg1.getSdt());
			vec.add(dg1.getDiachi());

			dtmdocgia.addRow(vec);
			cmbmadocgiaphieumuon.addItem(dg1);
			// .DesignLai.dtm.addRow(vec);
		}

	}

	public static ArrayList<SachDTO> sach = new ArrayList<SachDTO>();

	public void loadsach() {
		sach = null;
		SachBus sachbus = new SachBus();
		sach = sachbus.getLoaisachLoai();

		dtmsach.setRowCount(0);
		for (SachDTO sachitem : sach) {
			Vector<Object> vec = new Vector<Object>();
			vec.add(sachitem.getMasosach());
			vec.add(sachitem.getTensach());
			vec.add(sachitem.getMaloai());
			vec.add(sachitem.getMaNXB());
			vec.add(sachitem.getMatacgia());
			vec.add(sachitem.getNamxb());
			vec.add(sachitem.getSoluong());
			vec.add(sachitem.getMake());
			vec.add(sachitem.getHinhanh());
			dtmsach.addRow(vec);
		}
	}

	private JTable tablemuon;
	public static ArrayList<PhieuMuon> dspm = new ArrayList<PhieuMuon>();

	public void loadphieumuon() {
		dspm = null;
		PhieuMuonBus pmbus = new PhieuMuonBus();
		dspm = PhieuMuonDAL.getdanhsachphieumuon();
		dtmmuon.setRowCount(0);

		for (PhieuMuon pm : dspm) {

			Vector<Object> vec = new Vector<Object>();
			vec.add(pm.getMaPhieuMuon());
			vec.add(pm.getMaNV());
			vec.add(pm.getMaDocGia());
			vec.add(pm.getNgayMuon());
			vec.add(pm.getTinhtrang());

			dtmmuon.addRow(vec);
		}
	}

	public static ArrayList<ChiTieuPMDTO> ctpm = new ArrayList<ChiTieuPMDTO>();

	public void loadctphieumuon() {
		ctpm = null;
		chitietpmbus ctpmbus = new chitietpmbus();
		ctpm = ctpmbus.getdanhsachpm();
		dtmctpm.setRowCount(0);

		for (ChiTieuPMDTO pm : ctpm) {

			Vector<Object> vec = new Vector<Object>();
			vec.add(pm.getMaChiTietPhieuMuon());
			vec.add(pm.getMaPhieuMuon());
			vec.add(pm.getMaSach());
			vec.add(pm.getNgayTra());
			vec.add(pm.getGhichu());

			// dtmctpm.addRow(vec);
		}
	}

	public static ArrayList<PhieuNhap> phieunhap = new ArrayList<PhieuNhap>();

	public void loadphieunhap() {
		phieunhap = null;
		phieunhap = PhieuNhapBUS.gI().getdanhsachphieunhap();

		dtmphieunhap.setRowCount(0);

		for (PhieuNhap pn : phieunhap) {

			Vector<Object> vec = new Vector<Object>();
			vec.add(pn.getMaPhieuNhap());
			vec.add(pn.getMaNhaCung());
			vec.add(pn.getMaNhanVien());
			vec.add(pn.getNgayNhap());
			dtmphieunhap.addRow(vec);

			// dtmctpm.addRow(vec);
		}
	}

	public static ArrayList<ChiTietPhieuNhap> thongkectphieunhap = new ArrayList<ChiTietPhieuNhap>();

	public void loadthongkephieunhap() {
		thongkectphieunhap = null;
		thongkectphieunhap = ChiTietPhieuNhapBUS.gI().thongkephieunhap();

		dtmthongkenhaphang.setRowCount(0);

		for (ChiTietPhieuNhap pn : thongkectphieunhap) {

			Vector<Object> vec = new Vector<Object>();
			vec.add(pn.getMaCTPN());
			vec.add(pn.getMaPhieuNhap());
			vec.add(pn.getMaSach());
			vec.add(pn.getGia());
			vec.add(pn.getSoLuong());
			vec.add(pn.getThanhTien());
			vec.add(pn.getNgaynhap());
			vec.add(pn.getTensach());
			dtmthongkenhaphang.addRow(vec);

			// dtmctpm.addRow(vec);
		}
	}

	public static ArrayList<ChiTietPhieuNhap> ctphieunhap = new ArrayList<ChiTietPhieuNhap>();

	public void loadctphieunhap() {
		ctphieunhap = null;
		ctphieunhap = ChiTietPhieuNhapBUS.gI().getdanhsachpm();

		dtmchitietphieunhap.setRowCount(0);

		for (ChiTietPhieuNhap pn : ctphieunhap) {

			Vector<Object> vec = new Vector<Object>();
			vec.add(pn.getMaCTPN());
			vec.add(pn.getMaPhieuNhap());
			vec.add(pn.getMaSach());
			vec.add(pn.getSoLuong());
			vec.add(pn.getGia());
			vec.add(pn.getThanhTien());

			dtmchitietphieunhap.addRow(vec);

			// dtmctpm.addRow(vec);
		}
	}

	private JMenuItem mntmNewMenuItem;
	private JPanel panelThongKe;
	private JTable table_1;
	private JTable tablechitietphieunhap;
	public static JTextField txtManhanvienphieunhap;
	public static JTextField txtManccPhieuNhap;
	private JLabel lblNewLabel_12;
	public static JTextField txtMaSachctpn;
	private JButton btnmanvphieunhap_1;
	private JLabel lblNewLabel_13;
	private JTextField txtsoluongctpn;
	private JLabel lblNewLabel_14;
	private JTextField txtgianhap;
	private JLabel lblmaphieunhap;
	private JButton btnthemchitietphieunhap;
	private JButton btnsuactpn;
	private JButton btnxoactpn;
	private JPanel panel_7;
	private JLabel lblNewLabel_16;
	private JTextField textField_4;
	private JButton btninphieunhap;
	private JButton btnxuatexcel;
	private JButton btnnhapexcel;

	public String tinhtrangmuon() {
		if (rdmuon.isSelected()) {
			return "Đang Mượn";
		}
		return "Đã Trả";
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}

	private void xuLyChonAnh() {
		JFileChooser fileChooser = new JFileChooser("img/sach/");
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Tệp hình ảnh", "jpg", "png", "jpeg");
		fileChooser.setFileFilter(filter);
		int returnVal = fileChooser.showOpenDialog(null);

		if (returnVal == JFileChooser.APPROVE_OPTION) {
			String name = fileChooser.getSelectedFile().getName();
			hinhanh = name;
			lblhinhanhpre.setIcon(getAnhSP(name));
			System.out.println(name);
		}
	}

	File fileAnhSP;
	private JButton btnthongkesachmuon;
	private JTable tablethongkenhaphang;
	private JLabel lblNewLabel_18;
	private JLabel lblNewLabel_19;
	private JLabel lblsosachdanhap;

	private ImageIcon getAnhSP(String src) {
		src = src.trim().equals("") ? "default.png" : src;
		// Xử lý ảnh
		BufferedImage img = null;
		File fileImg = new File("img/sach/" + src);

		if (!fileImg.exists()) {
			src = "default.png";
			fileImg = new File("img/sach/" + src);
		}

		try {
			img = ImageIO.read(fileImg);
			fileAnhSP = new File("img/sach/" + src);
		} catch (IOException e) {
			fileAnhSP = new File("img/sach/default.png");
		}

		if (img != null) {
			Image dimg = img.getScaledInstance(200, 200, Image.SCALE_SMOOTH);

			return new ImageIcon(dimg);
		}
		return null;
	}

	public static void thongbao(String s) {
		JOptionPane.showMessageDialog(null, s + " không được bỏ trống");
	}

	public static boolean isNumber(String s) {
		try {
			Double.parseDouble(s);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
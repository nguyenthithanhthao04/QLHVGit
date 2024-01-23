package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class QLHV extends JFrame{
	
	private static final long serialVersionUID = 1L;
	DefaultTableModel ds;


	public QLHV() {
		this.setTitle("Trang chủ");
		this.setSize(800, 600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Font font = new Font("Tahoma", Font.BOLD, 40);	
		
		JPanel jPanel_nhapan = new JPanel();
		jPanel_nhapan.setLayout(new BorderLayout());		
		Dimension preferredSize = new Dimension(70, 70);
		JLabel jLabel_title = new JLabel("QUẢN LÝ HỌC VIÊN TẠI TRUNG TÂM ĐÀO TẠO ILA",SwingConstants.CENTER);
		jLabel_title.setPreferredSize(preferredSize);
		jLabel_title.setForeground(new Color(225,20,60));
		jLabel_title.setFont(new Font("Tahoma", Font.BOLD, 42));	
		jLabel_title.setFont(font);
		jLabel_title.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(QLHV.class.getResource("note.png"))));
		jLabel_title.setAlignmentX(Component.CENTER_ALIGNMENT); 
		
    	JPanel jPanel_nhapthongtin = new JPanel();
		jPanel_nhapthongtin.setLayout(null);
		jPanel_nhapthongtin.setBounds(100,100,400,250);
		jPanel_nhapthongtin.setBackground(new Color(224,255,255));

		Font labelFont = new Font("Arial", Font.BOLD, 14);
		Font textFieldFont = new Font("Arial", Font.BOLD, 14);

		JLabel jLabel_ID = new JLabel("ID ");
		jLabel_ID.setFont(labelFont);
		
		JLabel jLabel_hoTen = new JLabel("Họ tên ");
		jLabel_hoTen.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JLabel jLabel_lop = new JLabel("Lớp ");
		jLabel_lop.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JLabel jLabel_namSinh = new JLabel("Năm sinh ");
		jLabel_namSinh.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JLabel jLabel_gioiTinh = new JLabel("Giới Tính");
		jLabel_gioiTinh.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JLabel jLabel_queQuan = new JLabel("Quê quán ");
		jLabel_queQuan.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JLabel jLabel_Sdt = new JLabel("Số điện thoại ");
		jLabel_Sdt.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JLabel jLabel_email = new JLabel("Email ");
		jLabel_email.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JLabel jLabel_diemTongKet = new JLabel("Điểm tổng kết ");
		jLabel_diemTongKet.setFont(new Font("Tahoma", Font.BOLD, 18));

		JTextField jTextField_iD = new JTextField(20);
		jTextField_iD.setFont(textFieldFont);
		jTextField_iD.setEnabled(false);
		JTextField jTextField_hoTen = new JTextField(20);
		jTextField_hoTen.setFont(textFieldFont);
		JTextField jTextField_gioiTinh = new JTextField(20);
		jTextField_gioiTinh.setFont(textFieldFont);
		JTextField jTextField_namSinh = new JTextField(20);
		jTextField_namSinh.setFont(textFieldFont);
		JTextField jTextField_queQuan = new JTextField(20);
		jTextField_queQuan.setFont(textFieldFont);
		JTextField jTextField_Sdt = new JTextField(10);
		jTextField_Sdt.setFont(textFieldFont);
		JTextField jTextField_email = new JTextField(10);
		jTextField_email.setFont(textFieldFont);
		JTextField jTextField_diemTongKet = new JTextField(10);
		jTextField_diemTongKet.setFont(textFieldFont);
		JTextField jTextField_lop = new JTextField(20);
		jTextField_lop.setFont(textFieldFont);
		JTextField jTextField_search = new JTextField(20);
		jTextField_search.setFont(textFieldFont);
		
		jPanel_nhapthongtin.setLayout(new GridLayout(6, 3, 10, 10));
		jPanel_nhapthongtin.add(jLabel_hoTen);
		jPanel_nhapthongtin.add(jTextField_hoTen);
		jPanel_nhapthongtin.add(jLabel_gioiTinh);
		jPanel_nhapthongtin.add(jTextField_gioiTinh);
		jPanel_nhapthongtin.add(jLabel_namSinh);
		jPanel_nhapthongtin.add(jTextField_namSinh);
		jPanel_nhapthongtin.add(jLabel_queQuan);
		jPanel_nhapthongtin.add(jTextField_queQuan);
		jPanel_nhapthongtin.add(jLabel_Sdt);
		jPanel_nhapthongtin.add(jTextField_Sdt);
		jPanel_nhapthongtin.add(jLabel_email);
		jPanel_nhapthongtin.add(jTextField_email);
		jPanel_nhapthongtin.add(jLabel_diemTongKet);
		jPanel_nhapthongtin.add(jTextField_diemTongKet);
		jPanel_nhapthongtin.add(jLabel_lop);
		jPanel_nhapthongtin.add(jTextField_lop);
		jPanel_nhapan.add(jPanel_nhapthongtin,BorderLayout.CENTER);

		JPanel jPanel_button = new JPanel();
		jPanel_button.setLayout(new BoxLayout(jPanel_button, BoxLayout.Y_AXIS));
		jPanel_button.setBackground(new Color(255,255,240));
		
		//them icon
		JButton jButton_them = new JButton("Thêm");
		jButton_them.setFont(new Font("Tahoma", Font.BOLD, 18));
		jButton_them.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(QLHV.class.getResource("them.png"))));
		
		JButton jButton_sua = new JButton("Sửa");
		jButton_sua.setFont(new Font("Tahoma", Font.BOLD, 18));
		jButton_sua.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(QLHV.class.getResource("sua.png"))));
		
		JButton jButton_xoa = new JButton("Xóa");
		jButton_xoa.setFont(new Font("Tahoma", Font.BOLD, 18));
		jButton_xoa.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(QLHV.class.getResource("xoa.png"))));
		
		JButton jButton_timkiem = new JButton("Tìm Kiếm");
		jButton_timkiem.setFont(new Font("Tahoma", Font.BOLD, 18));
		jButton_timkiem.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(QLHV.class.getResource("tk.png"))));
		
		JButton jButton_datlai = new JButton("Đặt Lại");
		jButton_datlai.setFont(new Font("Tahoma", Font.BOLD, 18));
		jButton_datlai.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(QLHV.class.getResource("reset.png"))));
		
		jPanel_nhapthongtin.add(jButton_them);
		jPanel_nhapthongtin.add(jButton_xoa);
		jPanel_nhapthongtin.add(jButton_timkiem);
		jPanel_nhapthongtin.add(jTextField_search);
		jPanel_nhapthongtin.add(jButton_sua);
		jPanel_nhapthongtin.add(jButton_datlai);
					
		// table
		ds = new DefaultTableModel();
		ds.addColumn("ID");
		ds.addColumn("Họ Tên");
		ds.addColumn("Giới tính");
		ds.addColumn("Năm Sinh");
		ds.addColumn("Quê Quán");
		ds.addColumn("SĐT");
		ds.addColumn("Email");
		ds.addColumn("Điểm Tổng Kết");
		ds.addColumn("Lớp");
        inDuLieuRaBang();
	
		JTable bang = new JTable(ds);
		JScrollPane hocvien = new JScrollPane(bang);
		jPanel_button.add(hocvien,BorderLayout.CENTER);
		hocvien.getViewport().add(bang);
		bang.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
		    @Override
		    public void valueChanged(ListSelectionEvent e) {
		        if (e.getValueIsAdjusting()) {
		            return;
		        }

		        int selectedRow = bang.getSelectedRow();
		        if (selectedRow >= 0 && selectedRow < bang.getRowCount()) {
		            String id = bang.getValueAt(selectedRow, 0).toString();
		            String hoten = bang.getValueAt(selectedRow, 1).toString();
		            String gioitinh = bang.getValueAt(selectedRow, 2).toString();
		            String namsinh = bang.getValueAt(selectedRow, 3).toString();
		            String quequan = bang.getValueAt(selectedRow, 4).toString();
		            String sdt = bang.getValueAt(selectedRow, 5).toString();
		            String email = bang.getValueAt(selectedRow, 6).toString();
		            String diemtongket = bang.getValueAt(selectedRow, 7).toString();
		            String lop = bang.getValueAt(selectedRow, 8).toString();
		            jTextField_iD.setText(id);
		            jTextField_hoTen.setText(hoten);
		            jTextField_gioiTinh.setText(gioitinh);
		            jTextField_namSinh.setText(namsinh);
		            jTextField_queQuan.setText(quequan);
		            jTextField_Sdt.setText(sdt);
		            jTextField_email.setText(email);
		            jTextField_diemTongKet.setText(diemtongket);
		            jTextField_lop.setText(lop);
		            
		        }
		    }
		});
		
		
		
	
		JPanel jptong = new JPanel();
		jptong.setLayout(new BoxLayout(jptong, BoxLayout.Y_AXIS));
		jptong.add(jLabel_title);
		jptong.add(jPanel_button);
		jptong.add(jPanel_nhapthongtin);

       
        
		 this.setVisible(true);
	     this.setLayout(new BorderLayout());
	     this.add(jptong,BorderLayout.CENTER);
	        
	     jButton_them.addActionListener(new ActionListener() {
	    	    @Override
	    	    public void actionPerformed(ActionEvent e) {
	    	        try {
	    	            Class.forName("com.mysql.cj.jdbc.Driver");
	    	            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hocvien.db","root","123456789");
	    	            java.sql.Statement stmt = conn.createStatement();
	    	            String sql = "INSERT INTO hocvien (ID, `Họ Tên`, `Năm Sinh`, `Giới tính`, `Quê Quán`, `SĐT`, Email, `Điểm Tổng Kết`, `Lớp`) VALUES (0, '"+jTextField_hoTen.getText()+"', '"+jTextField_namSinh.getText()+"', '"+jTextField_gioiTinh.getText()+"', '"+jTextField_queQuan.getText()+"', '"+jTextField_Sdt.getText()+"', '"+jTextField_email.getText()+"', '"+jTextField_diemTongKet.getText()+"', '"+jTextField_lop.getText()+"')";
	    	            int result = stmt.executeUpdate(sql);
	    	            stmt.close();
	    	            conn.close();
	    	            inDuLieuRaBang();
	    	            JOptionPane.showMessageDialog(null, "Success");
	    	            System.out.println("Câu lệnh sql đã chạy: " + sql + "\nCó " + result + " hàng được cập nhật.");
	    	        } catch (Exception e2) {
	    	            e2.printStackTrace();
	    	        }
	    	    }
	    	});
	     jButton_xoa.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					 Class.forName("com.mysql.cj.jdbc.Driver");
	    	            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hocvien.db","root","123456789");
	    	            java.sql.Statement stmt = conn.createStatement();
	    	            String sql = "DELETE FROM hocvien WHERE `ID`=" + jTextField_iD.getText();
			            
			            int results = stmt.executeUpdate(sql);
			            System.out.println("Dòng lệnh sẽ bị xóa: " + results);
			            
			            stmt.close();
			            conn.close();
			            inDuLieuRaBang();
			        
				} catch (Exception e2) {
					// TODO: handle exception
				}
				
			}
		});
	
	 jButton_sua.addActionListener(new ActionListener() {

 	    @Override
 	    public void actionPerformed(ActionEvent e) {
 	        try {
 	            ds.setRowCount(0);
 	           Class.forName("com.mysql.cj.jdbc.Driver");
	            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hocvien.db","root","123456789");
 	            String sql = "UPDATE hocvien SET `Họ Tên`=?, `Giới tính`=?, `Năm sinh`=?, `Quê Quán`=?, `SĐT`=?, `Email`=?, `Điểm Tổng Kết`=?, `Lớp`=? WHERE ID=?";
 	            PreparedStatement stmt = conn.prepareStatement(sql);
 	            stmt.setString(1, jTextField_hoTen.getText());
 	            stmt.setString(2, jTextField_gioiTinh.getText());
 	            stmt.setString(3, jTextField_namSinh.getText());
 	            stmt.setString(4, jTextField_queQuan.getText());
 	            stmt.setString(5, jTextField_Sdt.getText());
 	            stmt.setString(6, jTextField_email.getText());
 	            stmt.setString(7, jTextField_diemTongKet.getText());
 	            stmt.setString(8, jTextField_lop.getText());
	            stmt.setString(9, jTextField_iD.getText());
 	            

 	            int rowsUpdated = stmt.executeUpdate();
 	            if (rowsUpdated > 0) {
 	                System.out.println("Cập nhật thành công");
 	            } else {
 	                System.out.println("Không tìm thấy bản ghi để cập nhật");
 	            }
 	            inDuLieuRaBang();
 	            

 	            stmt.close();
 	            conn.close();

 	        } catch (Exception e2) {
 	            e2.printStackTrace();
 	        }
 	    }

 	});

	 jButton_timkiem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
	         try {
		    Class.forName("com.mysql.cj.jdbc.Driver");
		     Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hocvien.db", "root", "123456789");
		     String sql = "SELECT * FROM `hocvien.db`.hocvien Where "
		     		+ "`ID` LIKE ? OR "
		     		+ "`Họ Tên` LIKE ? OR "
		     		+ "`Giới Tính` LIKE ? OR " 
		     		+ "`Năm Sinh` LIKE ? OR "
		     		+ "`Quê Quán` LIKE ? OR "
		     		+ "`SĐT` LIKE ? OR"
		     		+ "`Email` LIKE ? OR "
		     		+ "`Điểm Tổng Kết` LIKE ? OR "
		     		+ "`Lớp` LIKE ? ";
		     
		     
		          PreparedStatement stmt = conn.prepareStatement(sql);
		          stmt.setString(1, jTextField_search.getText());
		          stmt.setString(2, jTextField_search.getText());
		          stmt.setString(3, jTextField_search.getText());
		          stmt.setString(4, jTextField_search.getText());
		          stmt.setString(5, jTextField_search.getText());
		          stmt.setString(6, jTextField_search.getText());
		          stmt.setString(7, jTextField_search.getText());
		          stmt.setString(8, jTextField_search.getText());
		          stmt.setString(9, jTextField_search.getText());
		          
		            ResultSet rs = stmt.executeQuery();
			     	ds.setRowCount(0);
		         while (rs.next()) {
		        	 String id = rs.getString("ID");
		 				String hoten = rs.getString("Họ Tên");
		 				String gioitinh = rs.getString("Giới tính");
		 				String namsinh = rs.getString("Năm sinh");
		 				String quequan = rs.getString("Quê Quán");
		 				String sdt = rs.getString("SĐT");
		 				String email = rs.getString("Email");
		 				String diemtongket = rs.getString("Điểm Tổng Kết");
		 				String lop = rs.getString("Lớp");
		 				
		 				ds.addRow(new String[] { id, hoten, gioitinh, namsinh, quequan, sdt,email,diemtongket,lop });
		         }
		         
		stmt.close();
		conn.close();
		
		System.out.println("Câu lệnh tìm kiếm đã chạy ");
		
	} catch (Exception e2) {
		// TODO: handle exception
	}
				
			}
		});
	
	 jButton_datlai.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				jTextField_iD.setText(" ");
	            jTextField_hoTen.setText(" ");
	            jTextField_gioiTinh.setText(" ");
	            jTextField_namSinh.setText(" ");
	            jTextField_queQuan.setText(" ");
	            jTextField_Sdt.setText(" ");
	            jTextField_email.setText(" ");
	            jTextField_diemTongKet.setText(" ");
	            jTextField_lop.setText(" ");
			 inDuLieuRaBang();
			}
	 
		});
		}
    
	public void inDuLieuRaBang() {
	 		ds.setRowCount(0);
	 		
	 		
	 		try {
	 			 Class.forName("com.mysql.cj.jdbc.Driver");
 	            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hocvien.db","root","123456789");
	 			String sql = "SELECT * FROM `hocvien.db`.hocvien ";
	 			PreparedStatement stmt = conn.prepareStatement(sql);
	 			ResultSet rs = stmt.executeQuery();
	 			while (rs.next()) {
	 				String id = rs.getString("ID");
	 				String hoten = rs.getString("Họ Tên");
	 				String gioitinh = rs.getString("Giới tính");
	 				String namsinh = rs.getString("Năm sinh");
	 				String quequan = rs.getString("Quê Quán");
	 				String sdt = rs.getString("SĐT");
	 				String email = rs.getString("Email");
	 				String diemtongket = rs.getString("Điểm Tổng Kết");
	 				String lop = rs.getString("Lớp");
	 				
	 				ds.addRow(new String[] { id, hoten, gioitinh, namsinh, quequan, sdt,email,diemtongket,lop });
	 			}
	 			stmt.close();
	 			conn.close();
	 			System.out.println("Câu lệnh sql đã chạy: ");
	 		} catch (Exception e2) {
	 			e2.printStackTrace(); 
	 		}
	 
	 	
	}	 
	public static void main(String[] args) {
		new QLHV();
	}
	}

			
				
		

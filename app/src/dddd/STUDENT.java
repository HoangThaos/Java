package dddd;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import sever.InterFace;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.UIManager;
import javax.swing.border.MatteBorder;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.rmi.Naming;

public class STUDENT extends JFrame {
	connect cnn = new connect();
	Connection con = cnn.conect();
	private JTextField hvt;
	private JPasswordField mkhau;
	FORMSV form = new FORMSV();
	CHANGEPASS ch = new CHANGEPASS();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					STUDENT frame = new STUDENT();
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
	public STUDENT() {
		setAlwaysOnTop(true);
		getContentPane().setBackground(new Color(245, 255, 250));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 542, 515);
		getContentPane().setLayout(null);
		
		JLabel lblHVTn = new JLabel("HỌ VÀ TÊN");
		Image img3 = new ImageIcon(this.getClass().getResource("/user_group.png")).getImage();
		lblHVTn.setIcon(new ImageIcon(img3));
		lblHVTn.setForeground(Color.BLACK);
		lblHVTn.setBackground(Color.RED);
		lblHVTn.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblHVTn.setBounds(23, 252, 133, 26);
		getContentPane().add(lblHVTn);
		
		hvt = new JTextField();
		hvt.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER) {
//					try {
//						String sql="select * from student where [TÊN]=? and PASS=?";
//						PreparedStatement pt =con.prepareStatement(sql);
//						pt.setString(1, hvt.getText());
//						pt.setString(2, mkhau.getText());
//						ResultSet rs = pt.executeQuery();
//						int count =0;
//						while(rs.next()) {
//							count=count+1;
//							form.JTEN.setText(rs.getString("TÊN"));
//							form.JLOP.setText(rs.getString("LỚP"));
//							form.JDT.setText(rs.getString("toan"));
//							form.JDLY.setText(rs.getString("ly"));
//						form.JDHO.setText(rs.getString("hoa"));	
//							
//						}
//						if(count ==1) {
//							
//							JOptionPane.showMessageDialog(null, "đăng nhập thành công");
//							dispose();
//							form.setVisible(true);
//						
//				
//						}
//						else if(hvt.getText().equals("")||mkhau.getText().equals("")) {
//							
//							JOptionPane.showMessageDialog(null, "vui lòng nhập tên đăng nhập và mật khẩu");
//						}
//						else {
//							JOptionPane.showMessageDialog(null, "tên đăng nhập hoặc mật khẩu không đúng,thử lại!");
//							
//						}
//						rs.close();
//						pt.close();
//					} catch (SQLException e1) {
//						// TODO Auto-generated catch block
//						JOptionPane.showMessageDialog(null, e1);
//					}
					try {
						InterFace c = (InterFace)Naming.lookup("//localhost/Cal");
						String sql="select * from student where [TÊN]=? and PASS=?";
						int count = c.STUDENT(hvt.getText(), mkhau.getText());
						PreparedStatement pt =con.prepareStatement(sql);
						ResultSet rs = pt.executeQuery();
						while(rs.next()) {
							count=count+1;
							form.JTEN.setText(rs.getString("TÊN"));
							form.JLOP.setText(rs.getString("LỚP"));
							form.JDT.setText(rs.getString("toan"));
							form.JDLY.setText(rs.getString("ly"));
						form.JDHO.setText(rs.getString("hoa"));	
							
						}
						if(count ==1) {
							
							JOptionPane.showMessageDialog(null, "đăng nhập thành công");
							dispose();
							form.setVisible(true);
						
				
						}
						else if(hvt.getText().equals("")||mkhau.getText().equals("")) {
							
							JOptionPane.showMessageDialog(null, "vui lòng nhập tên đăng nhập và mật khẩu");
						}
						else {
							JOptionPane.showMessageDialog(null, "tên đăng nhập hoặc mật khẩu không đúng,thử lại!");
							
						}
						rs.close();
						pt.close();
					} catch (Exception e2) {
						// TODO: handle exception
					}
				}
			}
		});
		hvt.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		hvt.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		hvt.setForeground(Color.RED);
		hvt.setBounds(180, 246, 167, 41);
		getContentPane().add(hvt);
		hvt.setColumns(10);
		
		JLabel lblMtKhu = new JLabel("MẬT KHẨU");
		Image img4 = new ImageIcon(this.getClass().getResource("/key.png")).getImage();
		lblMtKhu.setIcon(new ImageIcon(img4));
		lblMtKhu.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMtKhu.setForeground(Color.BLACK);
		lblMtKhu.setBounds(23, 314, 133, 35);
		getContentPane().add(lblMtKhu);
		
		mkhau = new JPasswordField();
		mkhau.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER) {
					try {
						String sql="select * from student where [TÊN]=? and PASS=?";
						PreparedStatement pt =con.prepareStatement(sql);
						pt.setString(1, hvt.getText());
						pt.setString(2, mkhau.getText());
						ResultSet rs = pt.executeQuery();
						int count =0;
						while(rs.next()) {
							count=count+1;
							form.JTEN.setText(rs.getString("TÊN"));
							form.JLOP.setText(rs.getString("LỚP"));
							form.JDT.setText(rs.getString("toan"));
							form.JDLY.setText(rs.getString("ly"));
						form.JDHO.setText(rs.getString("hoa"));	
							
						}
						if(count ==1) {
							
							JOptionPane.showMessageDialog(null, "đăng nhập thành công");
							dispose();
							form.setVisible(true);
						
				
						}
						else if(hvt.getText().equals("")||mkhau.getText().equals("")) {
							
							JOptionPane.showMessageDialog(null, "vui lòng nhập tên đăng nhập và mật khẩu");
						}
						else {
							JOptionPane.showMessageDialog(null, "tên đăng nhập hoặc mật khẩu không đúng,thử lại!");
							
						}
						rs.close();
						pt.close();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, e1);
					}
			}}
		});
		mkhau.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		mkhau.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		mkhau.setForeground(Color.RED);
		mkhau.setBounds(180, 310, 167, 41);
		getContentPane().add(mkhau);
		
		JButton btnngNhp = new JButton("ĐĂNG NHẬP");
		Image img5 = new ImageIcon(this.getClass().getResource("/check-icon.png")).getImage();
		btnngNhp.setIcon(new ImageIcon(img5));
		btnngNhp.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnngNhp.setForeground(Color.RED);
		btnngNhp.setBackground(new Color(255, 245, 238));
		btnngNhp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String sql="select * from student where [TÊN]=? and PASS=?";
					PreparedStatement pt =con.prepareStatement(sql);
					pt.setString(1, hvt.getText());
					pt.setString(2, mkhau.getText());
					ResultSet rs = pt.executeQuery();
					int count =0;
					while(rs.next()) {
						count=count+1;
						form.JTEN.setText(rs.getString("TÊN"));
						form.JLOP.setText(rs.getString("LỚP"));
						form.JDT.setText(rs.getString("toan"));
						form.JDLY.setText(rs.getString("ly"));
					form.JDHO.setText(rs.getString("hoa"));	
						
					}
					if(count ==1) {
						
						JOptionPane.showMessageDialog(null, "đăng nhập thành công");
						dispose();
						form.setVisible(true);
					
			
					}
					else if(hvt.getText().equals("")||mkhau.getText().equals("")) {
						
						JOptionPane.showMessageDialog(null, "vui lòng nhập tên đăng nhập và mật khẩu");
					}
					else {
						JOptionPane.showMessageDialog(null, "tên đăng nhập hoặc mật khẩu không đúng,thử lại!");
						
					}
					rs.close();
					pt.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		btnngNhp.setBounds(162, 378, 205, 59);
		getContentPane().add(btnngNhp);
		
		JLabel label = new JLabel("");
		Image im = new ImageIcon(this.getClass().getResource("/ssss.png")).getImage();
		label.setIcon(new ImageIcon(im));
		label.setBounds(131, 51, 291, 188);
		getContentPane().add(label);
		
	}
}

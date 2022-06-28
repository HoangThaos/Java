package dddd;

import java.awt.BorderLayout;
import sever.InterFace;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.rmi.Naming;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.MatteBorder;

import java.awt.event.KeyAdapter;
public class ADMIIN extends JFrame {

	private JPanel contentPane;
	private JTextField amdname;
	private JPasswordField amdpass;
	connect cnn = new connect();
	
	
	Connection con = cnn.conect();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ADMIIN frame = new ADMIIN();
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
	public ADMIIN() {
		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 644, 445);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 255, 250));
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTnngNhp = new JLabel("TÊN ĐĂNG NHẬP");
		Image img1 = new ImageIcon(this.getClass().getResource("/Admin-icon.png")).getImage();
		lblTnngNhp.setIcon(new ImageIcon(img1));
		lblTnngNhp.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTnngNhp.setBounds(10, 237, 163, 22);
		contentPane.add(lblTnngNhp);
		
		amdname = new JTextField();
		amdname.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER) {
//					try {
//						String sql="select * from admin where username=? and password=?";
//						PreparedStatement pt =con.prepareStatement(sql);
//						pt.setString(1, amdname.getText());
//						pt.setString(2, amdpass.getText());
//						ResultSet rs = pt.executeQuery();
//						int count =0;
//						while(rs.next()) {
//							count=count+1;
//							
//						}
//						if(count ==1) {
//							JOptionPane.showMessageDialog(null, "đăng nhập thành công");
//							dispose();
//							LISTSV list = new LISTSV();
//							list.setVisible(true);
//							
//							
//						}
//						else if(amdname.getText().equals("")||amdpass.getText().equals("")) {
//							JOptionPane.showMessageDialog(null, "vui lòng điền tên đăng nhập và mật khẩu");
//						}
//						else {
//							JOptionPane.showMessageDialog(null, "tên đăng nhập hoặc mật khẩu không đúng,thử lại!");
//							
//						}
//						rs.close();
//						pt.close();
//					} catch (SQLException e1) {
//						// TODO Auto-generated catch block
//						JOptionPane.showMessageDialog(null, e);
//					}
					
				}
			}
		});
		amdname.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		amdname.setBackground(new Color(255, 255, 255));
		amdname.setForeground(Color.RED);
		amdname.setFont(new Font("Sitka Small", Font.PLAIN, 16));
		amdname.setBounds(185, 233, 251, 32);
		contentPane.add(amdname);
		amdname.setColumns(10);
		
		JLabel lblMtKhu = new JLabel("MẬT KHẨU");
		Image img0 = new ImageIcon(this.getClass().getResource("/keyring-icon.png")).getImage();
		lblMtKhu.setIcon(new ImageIcon(img0));
		lblMtKhu.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMtKhu.setBounds(10, 281, 167, 22);
		contentPane.add(lblMtKhu);
		
		amdpass = new JPasswordField();
		amdpass.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER) {
//					try {
//						String sql="select * from admin where username=? and password=?";
//						PreparedStatement pt =con.prepareStatement(sql);
//						pt.setString(1, amdname.getText());
//						pt.setString(2, amdpass.getText());
//						ResultSet rs = pt.executeQuery();
//						int count =0;
//						while(rs.next()) {
//							count=count+1;
//							
//						}
//						if(count ==1) {
//							JOptionPane.showMessageDialog(null, "đăng nhập thành công");
//							dispose();
//							LISTSV list = new LISTSV();
//							list.setVisible(true);
//							
//							
//						}
//						else if(amdname.getText().equals("")||amdpass.getText().equals("")) {
//							JOptionPane.showMessageDialog(null, "vui lòng điền tên đăng nhập và mật khẩu");
//						}
//						else {
//							JOptionPane.showMessageDialog(null, "tên đăng nhập hoặc mật khẩu không đúng,thử lại!");
//							
//						}
//						rs.close();
//						pt.close();
//					} catch (SQLException e1) {
//						// TODO Auto-generated catch block
//						JOptionPane.showMessageDialog(null, e);
//					}
					try {
						InterFace c = (InterFace)Naming.lookup("//localhost/Cal");
						int count = c.ADMIIN(amdname.getText(), amdpass.getText());
						if(count==1)
						{
							JOptionPane.showMessageDialog(null, "đăng nhập thành công");
							dispose();
							LISTSV list = new LISTSV();
							list.setVisible(true);
						}
						else if(amdname.getText().equals("")||amdpass.getText().equals("")) {
							JOptionPane.showMessageDialog(null, "vui lòng điền tên đăng nhập và mật khẩu");
						}
						else {
							JOptionPane.showMessageDialog(null, "tên đăng nhập hoặc mật khẩu không đúng,thử lại!");
							
						}
					} catch (Exception e2) {
						// TODO: handle exception
						
					}
				}
			}
		});
	
		amdpass.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		amdpass.setForeground(Color.RED);
		amdpass.setFont(new Font("Sitka Small", Font.PLAIN, 16));
		amdpass.setBounds(185, 277, 251, 32);
		contentPane.add(amdpass);
		
		JButton btnngK = new JButton("ĐĂNG NHẬP");
		
		
		
		btnngK.setBackground(new Color(204, 255, 204));
		btnngK.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnngK.setForeground(new Color(204, 0, 0));
		Image img2 = new ImageIcon(this.getClass().getResource("/user-login-icon.png")).getImage();
		btnngK.setIcon(new ImageIcon(img2));
		btnngK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String sql="select * from admin where username=? and password=?";
					PreparedStatement pt =con.prepareStatement(sql);
					pt.setString(1, amdname.getText());
					pt.setString(2, amdpass.getText());
					ResultSet rs = pt.executeQuery();
					int count =0;
					while(rs.next()) {
						count=count+1;
						
					}
					if(count ==1) {
						JOptionPane.showMessageDialog(null, "đăng nhập thành công");
						dispose();
						LISTSV list = new LISTSV();
						list.setVisible(true);
						
						
					}
					else if(amdname.getText().equals("")||amdpass.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "vui lòng điền tên đăng nhập và mật khẩu");
					}
					else {
						JOptionPane.showMessageDialog(null, "tên đăng nhập hoặc mật khẩu không đúng,thử lại!");
						
					}
					rs.close();
					pt.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e);
				}
				
			}
		});
		btnngK.setBounds(218, 336, 173, 49);
		contentPane.add(btnngK);
		
		JLabel lblDnhChoQun = new JLabel("   DÀNH CHO QUẢN TRỊ VIÊN");
		lblDnhChoQun.setFont(new Font("Sitka Small", Font.BOLD, 15));
		lblDnhChoQun.setBounds(185, 185, 251, 32);
		contentPane.add(lblDnhChoQun);
		
		JLabel lbl = new JLabel("");
		Image img3 = new ImageIcon(this.getClass().getResource("/user-icon.png")).getImage();
		lbl.setIcon(new ImageIcon(img3));
		lbl.setBounds(240, 44, 141, 128);
		contentPane.add(lbl);
	}

}

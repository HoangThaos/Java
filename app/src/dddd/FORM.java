package dddd;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Label;
import java.awt.Color;

public class FORM extends JFrame {
	private JFrame frame;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FORM frame = new FORM();
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
	public FORM() {
		getContentPane().setBackground(new Color(245, 255, 250));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 629, 531);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("         PHẦN MỀM QUẢN LÍ SINH VIÊN");
		lblNewLabel.setFont(new Font("Sitka Small", Font.BOLD, 20));
		lblNewLabel.setBounds(69, 136, 441, 51);
		getContentPane().add(lblNewLabel);
		
		JLabel lblVuiLngChn = new JLabel("               VUI LÒNG CHỌN HÌNH THỨC ĐĂNG NHẬP    ");
		lblVuiLngChn.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		lblVuiLngChn.setBounds(51, 186, 446, 31);
		getContentPane().add(lblVuiLngChn);
		
		JButton btnQunL = new JButton("QUẢN LÍ");
		btnQunL.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnQunL.setBackground(new Color(153, 255, 153));
		Image img = new ImageIcon(this.getClass().getResource("/sign.png")).getImage();
		btnQunL.setIcon(new ImageIcon(img));
		btnQunL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				ADMIIN amd =new ADMIIN();
				amd.setVisible(true);
				
				
			}
		});
		btnQunL.setBounds(86, 277, 155, 51);
		getContentPane().add(btnQunL);
		
		JButton btnHcSinh = new JButton("HỌC SINH");
		btnHcSinh.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnHcSinh.setBackground(new Color(255, 255, 204));
		Image img2 = new ImageIcon(this.getClass().getResource("/user_group.png")).getImage();
		btnHcSinh.setIcon(new ImageIcon(img2));
		btnHcSinh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				STUDENT std = new STUDENT();
				std.setVisible(true);
			}
		
		});
		btnHcSinh.setBounds(341, 277, 169, 51);
		getContentPane().add(btnHcSinh);
		
		JLabel lable = new JLabel("");
		Image img1 = new ImageIcon(this.getClass().getResource("/logo.png")).getImage();
		lable.setIcon(new ImageIcon(img1));
		lable.setBounds(245, -11, 153, 209);
		getContentPane().add(lable);
	
	}
	}


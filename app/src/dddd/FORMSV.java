package dddd;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Image;

public class FORMSV extends JFrame {

	private JPanel contentPane;
	public  JLabel JTEN = new JLabel("");
	public  JLabel JLOP = new JLabel("");
	public  JLabel JDT = new JLabel("");
	public  JLabel JDLY = new JLabel("");
	public  JLabel JDHO = new JLabel("");
	connect cnn = new connect();
	Connection con = cnn.conect();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FORMSV frame = new FORMSV();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void source() {
		JTEN.setText("");
	}

	/**
	 * Create the frame.
	 */
	public FORMSV() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 539, 525);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 255, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("H\u1ECC V\u00C0 T\u00CAN");
		Image imvzz = new ImageIcon(this.getClass().getResource("/ll.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(imvzz));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(28, 13, 210, 30);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("L\u1EDAP");
		Image imvzzZ = new ImageIcon(this.getClass().getResource("/ll.png")).getImage();
		lblNewLabel_1.setIcon(new ImageIcon(imvzzZ));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(28, 92, 75, 30);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u0110I\u1EC2M TO\u00C1N");
		Image imvzzV = new ImageIcon(this.getClass().getResource("/ll.png")).getImage();
		lblNewLabel_2.setIcon(new ImageIcon(imvzzV));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(28, 168, 119, 30);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\u0110I\u1EC2M L\u00DD");
		Image imvzzQ = new ImageIcon(this.getClass().getResource("/ll.png")).getImage();
		lblNewLabel_3.setIcon(new ImageIcon(imvzzQ));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3.setBounds(28, 243, 119, 30);
		contentPane.add(lblNewLabel_3);
		JTEN.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		JTEN.setForeground(Color.RED);
		JTEN.setBackground(Color.BLACK);
		
	
		JTEN.setBounds(260, 13, 133, 30);
		contentPane.add(JTEN);
		JLOP.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		JLOP.setForeground(Color.RED);
		
	
		JLOP.setBounds(260, 77, 92, 30);
		contentPane.add(JLOP);
		JDT.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		JDT.setForeground(Color.RED);
		
		
		JDT.setBounds(260, 168, 92, 30);
		contentPane.add(JDT);
		JDLY.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		JDLY.setForeground(Color.RED);
		
		JDLY.setBounds(260, 243, 92, 30);
		contentPane.add(JDLY);
		
		JLabel lblNewLabel_4 = new JLabel("\u0110I\u1EC2M H\u00D3A");
		Image imvzXz = new ImageIcon(this.getClass().getResource("/ll.png")).getImage();
		lblNewLabel_4.setIcon(new ImageIcon(imvzXz));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_4.setBounds(28, 313, 119, 30);
		contentPane.add(lblNewLabel_4);
		JDHO.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		JDHO.setForeground(Color.RED);
		
		
		JDHO.setBounds(260, 313, 97, 30);
		contentPane.add(JDHO);
		
		JButton btnNewButton = new JButton("\u0110\u1ED4I M\u1EACT KH\u1EA8U");
		btnNewButton.setBackground(new Color(127, 255, 212));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		Image imvzzW = new ImageIcon(this.getClass().getResource("/s.png")).getImage();
		btnNewButton.setIcon(new ImageIcon(imvzzW));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			dispose();
			CHANGEPASS chga=new CHANGEPASS();
			
			chga.setVisible(true);
			}
		});
		btnNewButton.setBounds(12, 403, 205, 62);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("QUAY L\u1EA0I");
		btnNewButton_1.setBackground(new Color(255, 255, 224));
		Image imvzzr = new ImageIcon(this.getClass().getResource("/undo.png")).getImage();
		btnNewButton_1.setIcon(new ImageIcon(imvzzr));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				FORM fm =new FORM();
				fm.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(304, 403, 205, 62);
		contentPane.add(btnNewButton_1);
	}
}

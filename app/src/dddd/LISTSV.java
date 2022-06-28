package dddd;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.border.MatteBorder;
import javax.swing.ScrollPaneConstants;

public class LISTSV extends JFrame {
	connect cnn = new connect();
	Connection con = cnn.conect();
	private JTable table;
	private JTextField textField;
	private JComboBox comboBox;
	/**
	 * Launch the application.
	 */
	
	


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LISTSV frame = new LISTSV();
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
	public LISTSV() {
		getContentPane().setBackground(new Color(245, 255, 250));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 753, 614);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		scrollPane.setBackground(new Color(255, 255, 255));
		scrollPane.setBorder(new MatteBorder(2, 0, 2, 0, (Color) new Color(0, 0, 0)));
		scrollPane.setBounds(0, 178, 735, 234);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		
		scrollPane.setViewportView(table);
		
		JButton btnDanhSchSinh = new JButton("DANH SÁCH SINH VIÊN");
		btnDanhSchSinh.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btnDanhSchSinh.setBackground(new Color(255, 239, 213));
		Image imvzzt = new ImageIcon(this.getClass().getResource("/l.png")).getImage();
		btnDanhSchSinh.setIcon(new ImageIcon(imvzzt));
		btnDanhSchSinh.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnDanhSchSinh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String sql="select ID,[TÊN], [LỚP],'MẬT KHẨU'=PASS,'ĐIỂM TOÁN'=toan,'ĐIỂM LÝ'=ly,'ĐIỂM HÓA'=hoa from student";
					PreparedStatement pst = con.prepareStatement(sql);
					ResultSet rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		});
		btnDanhSchSinh.setBounds(12, 103, 268, 62);
		getContentPane().add(btnDanhSchSinh);
		
		JButton btnNewButton = new JButton("THÊM");
		btnNewButton.setBackground(new Color(144, 238, 144));
		Image imvzz = new ImageIcon(this.getClass().getResource("/ad.png")).getImage();
		btnNewButton.setIcon(new ImageIcon(imvzz));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				INPUTLISTSV lisst = new INPUTLISTSV();
				lisst.setVisible(true);
			}
		});
		btnNewButton.setBounds(12, 492, 148, 49);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("XÓA");
		btnNewButton_1.setBackground(new Color(240, 230, 140));
		Image imvzzz = new ImageIcon(this.getClass().getResource("/ia.png")).getImage();
		btnNewButton_1.setIcon(new ImageIcon(imvzzz));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DELETE dlt = new DELETE();
				dlt.setVisible(true);
				
			}
		});
		btnNewButton_1.setBounds(188, 492, 162, 49);
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("THAY ĐỔI");
		btnNewButton_2.setBackground(new Color(127, 255, 212));
		Image imvzzc = new ImageIcon(this.getClass().getResource("/sq.png")).getImage();
		btnNewButton_2.setIcon(new ImageIcon(imvzzc));
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				CHANGEINFORSV chg=new CHANGEINFORSV();
				chg.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(382, 492, 171, 49);
		getContentPane().add(btnNewButton_2);
		
		textField = new JTextField();
		textField.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(0, 0, 0)));
		textField.setForeground(Color.RED);
		textField.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
			try {
				String select = (String)comboBox.getSelectedItem();
				
				String quere="select ID,[TÊN],[LỚP],'MẬT KHẨU'=PASS,'ĐIỂM TOÁN'=toan,'ĐIỂM LÝ'=ly,'ĐIỂM HÓA'=hoa from student where "+select+"= ?";
				PreparedStatement pst = con.prepareStatement(quere);
				pst.setString(1, textField.getText());
				ResultSet rs = pst.executeQuery();
				table.setModel(DbUtils.resultSetToTableModel(rs));;
				pst.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
			}
		});
		
		
			
		textField.setBounds(218, 26, 255, 42);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		 comboBox = new JComboBox();
		 comboBox.setBackground(new Color(175, 238, 238));
		 comboBox.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(0, 0, 0)));
		 comboBox.setModel(new DefaultComboBoxModel(new String[] {"\t\t\t", "ID", "TÊN", "LỚP"}));
		
		
		comboBox.setBounds(501, 27, 207, 41);
		getContentPane().add(comboBox);
		
		JButton btnT = new JButton("THOÁT");
		btnT.setBackground(new Color(250, 128, 114));
		Image imvzzr = new ImageIcon(this.getClass().getResource("/e.png")).getImage();
		btnT.setIcon(new ImageIcon(imvzzr));
		btnT.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(EXIT_ON_CLOSE);
			}
		});
		btnT.setBounds(575, 492, 148, 49);
		getContentPane().add(btnT);
		
		JLabel lblSearch = new JLabel("TÌM KIẾM");
		Image imvzzr1 = new ImageIcon(this.getClass().getResource("/sea.png")).getImage();
		lblSearch.setIcon(new ImageIcon(imvzzr1));
		lblSearch.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSearch.setBounds(49, 26, 157, 49);
		getContentPane().add(lblSearch);
		
		JButton btnNewButton_3 = new JButton("QUAY LẠI");
		btnNewButton_3.setBackground(new Color(224, 255, 255));
		Image imvzz1 = new ImageIcon(this.getClass().getResource("/undo.png")).getImage();
		btnNewButton_3.setIcon(new ImageIcon(imvzz1));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FORM fm = new FORM();
				fm.setVisible(true);
				dispose();
				
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_3.setBounds(501, 103, 207, 62);
		getContentPane().add(btnNewButton_3);
		
			}
}


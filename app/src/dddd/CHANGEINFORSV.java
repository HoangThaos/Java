package dddd;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import sever.InterFace;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.rmi.Naming;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

public class CHANGEINFORSV extends JFrame {

	private JPanel contentPane;
	private JTextField ten;
	private JTextField lop;
	private JTextField dt;
	private JTextField dl;
	private JTextField dh;
	private JTextField id;
	connect cnn = new connect();
	Connection con = cnn.conect();
	private JPasswordField passwordField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CHANGEINFORSV frame = new CHANGEINFORSV();
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
	public CHANGEINFORSV() {
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 546, 544);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 255, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblThayiThng = new JLabel("                   THAY ĐỔI THÔNG TIN SINH VIÊN");
		lblThayiThng.setOpaque(true);
		lblThayiThng.setBackground(new Color(255, 250, 240));
		lblThayiThng.setFont(new Font("Sitka Small", Font.BOLD, 17));
		lblThayiThng.setBounds(0, 0, 528, 54);
		contentPane.add(lblThayiThng);
		
		JLabel lblId = new JLabel("ID");
		Image imt = new ImageIcon(this.getClass().getResource("/ll.png")).getImage();
		lblId.setIcon(new ImageIcon(imt));
		lblId.setFont(new Font("Sitka Small", Font.BOLD, 15));
		lblId.setBounds(12, 56, 56, 25);
		contentPane.add(lblId);
		
		JLabel lblTnSinhVin = new JLabel("T\u00CAN SINH VI\u00CAN");
		Image iwm = new ImageIcon(this.getClass().getResource("/ll.png")).getImage();
		lblTnSinhVin.setIcon(new ImageIcon(iwm));
		lblTnSinhVin.setFont(new Font("Sitka Small", Font.BOLD, 15));
		lblTnSinhVin.setBounds(12, 160, 159, 25);
		contentPane.add(lblTnSinhVin);
		
		ten = new JTextField();
		ten.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		ten.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		ten.setForeground(Color.RED);
		ten.setBounds(174, 156, 158, 30);
		contentPane.add(ten);
		ten.setColumns(10);
		
		JLabel lblLp = new JLabel("L\u1EDAP");
		Image imm = new ImageIcon(this.getClass().getResource("/ll.png")).getImage();
		lblLp.setIcon(new ImageIcon(imm));
		lblLp.setFont(new Font("Sitka Small", Font.BOLD, 15));
		lblLp.setBounds(12, 209, 105, 25);
		contentPane.add(lblLp);
		
		lop = new JTextField();
		lop.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		lop.setForeground(Color.RED);
		lop.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		lop.setBounds(174, 209, 158, 30);
		contentPane.add(lop);
		lop.setColumns(10);
		
		JLabel lblimTon = new JLabel("\u0110I\u1EC2M TO\u00C1N");
		Image imv = new ImageIcon(this.getClass().getResource("/ll.png")).getImage();
		lblimTon.setIcon(new ImageIcon(imv));
		lblimTon.setFont(new Font("Sitka Small", Font.BOLD, 15));
		lblimTon.setBounds(12, 264, 126, 25);
		contentPane.add(lblimTon);
		
		dt = new JTextField();
		dt.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		dt.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		dt.setForeground(Color.RED);
		dt.setBounds(174, 260, 158, 30);
		contentPane.add(dt);
		dt.setColumns(10);
		
		JLabel lblimL = new JLabel("\u0110I\u1EC2M L\u00DD");
		Image imvv = new ImageIcon(this.getClass().getResource("/ll.png")).getImage();
		lblimL.setIcon(new ImageIcon(imvv));
		lblimL.setFont(new Font("Sitka Small", Font.BOLD, 15));
		lblimL.setBounds(12, 317, 105, 25);
		contentPane.add(lblimL);
		
		dl = new JTextField();
		dl.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		dl.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		dl.setForeground(Color.RED);
		dl.setBounds(174, 313, 158, 30);
		contentPane.add(dl);
		dl.setColumns(10);
		
		JLabel lblimHa = new JLabel("\u0110I\u1EC2M H\u00D3A");
		Image imvvv = new ImageIcon(this.getClass().getResource("/ll.png")).getImage();
		lblimHa.setIcon(new ImageIcon(imvvv));
		lblimHa.setFont(new Font("Sitka Small", Font.BOLD, 15));
		lblimHa.setBounds(12, 371, 126, 25);
		contentPane.add(lblimHa);
		
		dh = new JTextField();
		dh.setForeground(Color.RED);
		dh.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		dh.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		dh.setBounds(174, 367, 156, 30);
		contentPane.add(dh);
		dh.setColumns(10);
		
		JButton btnLu = new JButton("L\u01AFU");
		btnLu.setBackground(new Color(144, 238, 144));
		Image im = new ImageIcon(this.getClass().getResource("/icon.png")).getImage();
		btnLu.setIcon(new ImageIcon(im));
		btnLu.setFont(new Font("Sitka Small", Font.BOLD, 17));
		btnLu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String sql = "update student set ID='"+id.getText()+"',[LỚP]='"+lop.getText()+"',PASS='"+passwordField.getText()+"',[TÊN]='"+ten.getText()+"',toan='"+dt.getText()+"',ly='"+dl.getText()+"',hoa='"+dh.getText()+"' where ID='"+id.getText()+"'";
					PreparedStatement pst = con.prepareStatement(sql);
					pst.execute();
					JOptionPane.showMessageDialog(null, "ĐÃ LƯU");
					dispose();
					
				} catch (Exception e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, "fail");
				}
			try {
				InterFace c = (InterFace)Naming.lookup("//localhost/Calci");
				int count = c.CHANGEINFORSV(id.getText(), lop.getText(), passwordField.getText(), ten.getText(), dt.getText(),dl.getText(),dh.getText());
				if(count==1)
				{
					JOptionPane.showMessageDialog(null, "ĐÃ LƯU");
				}
			} catch (Exception e2) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(null, "fail");
			}
			}
		});
		btnLu.setBounds(174, 424, 158, 60);
		contentPane.add(btnLu);
		
		id = new JTextField();
		id.setBackground(new Color(255, 255, 255));
		id.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		id.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		id.setForeground(Color.RED);
		id.setBounds(174, 56, 158, 30);
		contentPane.add(id);
		id.setColumns(10);
		
		JLabel PASS = new JLabel("MẬT KHẨU");
		Image i = new ImageIcon(this.getClass().getResource("/ll.png")).getImage();
		PASS.setIcon(new ImageIcon(i));
		PASS.setFont(new Font("Sitka Small", Font.BOLD, 15));
		PASS.setBounds(12, 101, 126, 28);
		contentPane.add(PASS);
		
		passwordField = new JPasswordField();
		passwordField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		passwordField.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		passwordField.setForeground(Color.RED);
		passwordField.setBounds(174, 104, 159, 30);
		contentPane.add(passwordField);
	}
}

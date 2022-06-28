package dddd;

import java.awt.BorderLayout;
import sever.InterFace;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.rmi.Naming;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.border.MatteBorder;
public class INPUTLISTSV extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JLabel lblNhpDanhSch;
	private JLabel lblStt;
	private JTextField ID;
	private JPasswordField MK;
	private JTextField TEN;
	private JTextField DT;
	private JTextField DY;
	private JTextField DH;
connect cnn = new connect();
Connection con = cnn.conect(); 
private JTextField CLA;

	/**
	 * Launch the application.
	 */

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					INPUTLISTSV frame = new INPUTLISTSV();
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
	public INPUTLISTSV() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 644, 529);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 255, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setBounds(136, 295, 479, -117);
		contentPane.add(table);
		
		lblNhpDanhSch = new JLabel("                              NHẬP THÔNG TIN  SINH VIÊN");
		lblNhpDanhSch.setBackground(new Color(255, 250, 205));
		lblNhpDanhSch.setOpaque(true);
		lblNhpDanhSch.setFont(new Font("Sitka Small", Font.BOLD, 17));
		lblNhpDanhSch.setBounds(0, 0, 626, 55);
		contentPane.add(lblNhpDanhSch);
		
		lblStt = new JLabel("ID");
		Image imv = new ImageIcon(this.getClass().getResource("/ll.png")).getImage();
		lblStt.setIcon(new ImageIcon(imv));
		lblStt.setFont(new Font("Sitka Small", Font.BOLD, 15));
		lblStt.setBounds(77, 75, 71, 26);
		contentPane.add(lblStt);
		
		ID = new JTextField();
		ID.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		ID.setForeground(Color.RED);
		ID.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		ID.setBounds(214, 68, 172, 33);
		contentPane.add(ID);
		ID.setColumns(10);
		
		JLabel lblTnLp = new JLabel("LỚP");
		Image imvv = new ImageIcon(this.getClass().getResource("/ll.png")).getImage();
		lblTnLp.setIcon(new ImageIcon(imvv));
		lblTnLp.setFont(new Font("Sitka Small", Font.BOLD, 15));
		lblTnLp.setBounds(77, 118, 89, 23);
		contentPane.add(lblTnLp);
		
		MK = new JPasswordField();
		MK.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		MK.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		MK.setForeground(Color.RED);
		MK.setBounds(214, 157, 172, 33);
		contentPane.add(MK);
		
		JLabel lblMtKhu = new JLabel("M\u1EACT KH\u1EA8U");
		Image imvc = new ImageIcon(this.getClass().getResource("/ll.png")).getImage();
		lblMtKhu.setIcon(new ImageIcon(imvc));
		lblMtKhu.setFont(new Font("Sitka Small", Font.BOLD, 15));
		lblMtKhu.setBounds(77, 162, 125, 28);
		contentPane.add(lblMtKhu);
		
		JLabel lblHVTn = new JLabel("H\u1ECC V\u00C0 T\u00CAN");
		Image imvx = new ImageIcon(this.getClass().getResource("/ll.png")).getImage();
		lblHVTn.setIcon(new ImageIcon(imvx));
		lblHVTn.setFont(new Font("Sitka Small", Font.BOLD, 15));
		lblHVTn.setBounds(77, 205, 125, 30);
		contentPane.add(lblHVTn);
		
		TEN = new JTextField();
		TEN.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		TEN.setForeground(Color.RED);
		TEN.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		TEN.setBounds(214, 203, 172, 33);
		contentPane.add(TEN);
		TEN.setColumns(10);
		
		JLabel lblimTon = new JLabel("\u0110I\u1EC2M TO\u00C1N");
		Image imvz = new ImageIcon(this.getClass().getResource("/ll.png")).getImage();
		lblimTon.setIcon(new ImageIcon(imvz));
		lblimTon.setFont(new Font("Sitka Small", Font.BOLD, 15));
		lblimTon.setBounds(77, 250, 125, 24);
		contentPane.add(lblimTon);
		
		DT = new JTextField();
		DT.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		DT.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		DT.setForeground(Color.RED);
		DT.setBounds(214, 250, 172, 32);
		contentPane.add(DT);
		DT.setColumns(10);
		
		JLabel lblimL = new JLabel("\u0110I\u1EC2M L\u00DD");
		Image imva = new ImageIcon(this.getClass().getResource("/ll.png")).getImage();
		lblimL.setIcon(new ImageIcon(imva));
		lblimL.setFont(new Font("Sitka Small", Font.BOLD, 15));
		lblimL.setBounds(77, 295, 112, 29);
		contentPane.add(lblimL);
		
		DY = new JTextField();
		DY.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		DY.setForeground(Color.RED);
		DY.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		DY.setBounds(214, 300, 172, 32);
		contentPane.add(DY);
		DY.setColumns(10);
		
		JLabel lblimHa = new JLabel("\u0110I\u1EC2M H\u00D3A");
		Image imvzz = new ImageIcon(this.getClass().getResource("/ll.png")).getImage();
		lblimHa.setIcon(new ImageIcon(imvzz));
		lblimHa.setFont(new Font("Sitka Small", Font.BOLD, 15));
		lblimHa.setBounds(77, 345, 125, 24);
		contentPane.add(lblimHa);
		
		DH = new JTextField();
		DH.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		DH.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		DH.setForeground(Color.RED);
		DH.setBounds(214, 345, 172, 32);
		contentPane.add(DH);
		DH.setColumns(10);
		
		JButton btnHonTt = new JButton("HO\u00C0N T\u1EA4T");
		btnHonTt.setBackground(new Color(144, 238, 144));
		Image imvq = new ImageIcon(this.getClass().getResource("/2.png")).getImage();
		btnHonTt.setIcon(new ImageIcon(imvq));
		btnHonTt.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnHonTt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
//				try {
//					
//					String sql ="insert into student  values('"+ID.getText()+"','"+CLA.getText()+"','"+MK.getText()+"',N'"+TEN.getText()+"','"+DT.getText()+"','"+DY.getText()+"','"+DH.getText()+"')";
//					PreparedStatement pst = con.prepareStatement(sql);
//					int n=pst.executeUpdate();
//					
//			JOptionPane.showMessageDialog(null, "HOÀN TẤT", "message",1);
//			
//			dispose();
//			pst.close();
//				} catch (Exception e2) {
//					JOptionPane.showMessageDialog(null, "fail");
//					// TODO: handle exception
//				}
				try {
					InterFace c = (InterFace)Naming.lookup("//localhost/Cal");
					int count = c.INPUTLISTSV(ID.getText(), CLA.getText(), MK.getText(), TEN.getText(), DT.getText(), DY.getText(), DH.getText());
					if(count==1)
					{
						JOptionPane.showMessageDialog(null, "HOÀN TẤT", "message",1);
						dispose();
					}
				} catch (Exception e) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, "fail");
				}
			}
		});
		btnHonTt.setBounds(191, 390, 212, 63);
		contentPane.add(btnHonTt);
		
		CLA = new JTextField();
		CLA.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		CLA.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		CLA.setForeground(Color.RED);
		CLA.setColumns(10);
		CLA.setBounds(214, 114, 172, 33);
		contentPane.add(CLA);
		
	}
}

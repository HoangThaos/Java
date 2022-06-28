package dddd;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import sever.InterFace;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.border.MatteBorder;

import sever.InterFace;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.rmi.Naming;

public class CHANGEPASS extends JFrame {

	private JPanel contentPane;
	private JPasswordField mkc;
	private JPasswordField mkm;
	connect cnn = new connect();
	Connection con = cnn.conect();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CHANGEPASS frame = new CHANGEPASS();
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
	public CHANGEPASS() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 255, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMtKhuC = new JLabel("M\u1EACT KH\u1EA8U C\u0168");
		Image imvzz = new ImageIcon(this.getClass().getResource("/ll.png")).getImage();
		lblMtKhuC.setIcon(new ImageIcon(imvzz));
		lblMtKhuC.setFont(new Font("Sitka Small", Font.BOLD, 15));
		lblMtKhuC.setBounds(12, 36, 174, 39);
		contentPane.add(lblMtKhuC);
		
		mkc = new JPasswordField();
		
		mkc.setForeground(new Color(255, 0, 0));
		mkc.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		mkc.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		mkc.setBounds(198, 33, 179, 38);
		contentPane.add(mkc);
		
		JLabel lblNewLabel = new JLabel("M\u1EACT KH\u1EA8U M\u1EDAI");
		Image imvzzq = new ImageIcon(this.getClass().getResource("/ll.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(imvzzq));
		lblNewLabel.setFont(new Font("Sitka Small", Font.BOLD, 15));
		lblNewLabel.setBounds(12, 88, 174, 38);
		contentPane.add(lblNewLabel);
		
		mkm = new JPasswordField();
		
		mkm.setForeground(new Color(255, 0, 0));
		mkm.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		mkm.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		mkm.setBounds(198, 88, 179, 38);
		contentPane.add(mkm);
		
		JButton btniMtKhu = new JButton("\u0110\u1ED4I M\u1EACT KH\u1EA8U");
		btniMtKhu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					String sql ="select *from student where PASS='"+mkc.getText()+"'";
					PreparedStatement pst = con.prepareStatement(sql);
					ResultSet rs = pst.executeQuery();
							int n =0;
				while(rs.next())
					n++;
				
					try {
                       if(n==1) {
						String sq="update student set PASS='"+mkm.getText()+"' where PASS='"+mkc.getText()+"'";
						PreparedStatement ps = con.prepareStatement(sq);
						n= ps.executeUpdate();
						JOptionPane.showMessageDialog(null, "đổi mật khẩu thành công");
						STUDENT std = new STUDENT();
						std.setVisible(true);
						dispose();}
                      else {
                    	   JOptionPane.showMessageDialog(null, "mật khẩu cũ không đúng");
                       }
					} catch (Exception e) {
						// TODO: handle exception
					
				}
				
				} catch (Exception e) {
					// TODO: handle exception
				}
					
			try {
				InterFace c = (InterFace)Naming.lookup("//localhost/Calci");
				int count = c.CHANGEPASS(mkc.getText(), mkm.getText());
				if(count ==1)
				{
					JOptionPane.showMessageDialog(null, "ok");
				}
			} catch (Exception e) {
				// TODO: handle exception
			}

			}
		});
		Image imvzzqq = new ImageIcon(this.getClass().getResource("/lo.png")).getImage();
		btniMtKhu.setIcon(new ImageIcon(imvzzqq));
		btniMtKhu.setBackground(new Color(250, 128, 114));
		btniMtKhu.setFont(new Font("Sitka Small", Font.BOLD, 16));
		btniMtKhu.setBounds(85, 169, 270, 71);
		contentPane.add(btniMtKhu);
	}
}

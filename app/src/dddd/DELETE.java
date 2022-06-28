package dddd;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import sever.InterFace;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.rmi.Naming;

public class DELETE extends JFrame {
private JTable table;
	private JPanel contentPane;
	connect cnn = new connect();
	Connection con = cnn.conect();
	private JTextField id1;
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DELETE frame = new DELETE();
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
	public DELETE() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 335);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 255, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		Image imvzz = new ImageIcon(this.getClass().getResource("/ll.png")).getImage();
		Image imvzxz = new ImageIcon(this.getClass().getResource("/ll.png")).getImage();
		
		JButton btnXa = new JButton("X\u00D3A");
		btnXa.setBackground(new Color(255, 240, 245));
		Image imvzqz = new ImageIcon(this.getClass().getResource("/d.png")).getImage();
		btnXa.setIcon(new ImageIcon(imvzqz));
		btnXa.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnXa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String sql="delete from student where ID='"+id1.getText()+"'" ;
					PreparedStatement pst = con.prepareStatement(sql);
					pst.execute();
					JOptionPane.showMessageDialog(null, "ĐÃ XÓA");
					dispose();
					pst.close();
				
					
				} catch (Exception e2) {
					// TODO: handle exception
				}
				
				
				
				
				
				
				
				
				
				
				
				
				try {
					InterFace c = (InterFace)Naming.lookup("//localhost/Cal");
					int count = c.DELETE(id1.getText());
					if(count==1)
					{
						JOptionPane.showMessageDialog(null, "ĐÃ XÓA");
					}
				} catch (Exception e2) {
					// TODO: handle exception
				}
				
			}
		});
		btnXa.setBounds(161, 224, 143, 51);
		contentPane.add(btnXa);
		
		JLabel id = new JLabel("id");
		id.setBounds(25, 185, 124, 37);
		contentPane.add(id);
		
		id1 = new JTextField();
		id1.setBounds(161, 189, 116, 22);
		contentPane.add(id1);
		id1.setColumns(10);
	}
}

package sever;
import java.awt.event.ActionEvent;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import dddd.LISTSV;
import dddd.STUDENT;
import dddd.connect;
public class Rmi extends UnicastRemoteObject implements InterFace{
	connect cnn = new connect();
	Connection con = cnn.conect();
	protected Rmi() throws RemoteException {
		int a,b;
		// TODO Auto-generated constructor stub
	}
	public int ADMIIN(String user, String password) {
		try {
			int count = 0;
			String sql="select * from admin where username=? and password=?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, user);
			pst.setString(2, password);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				count++;
			}
			if (count == 1) {
				return 1;
			}
			else {
				return 0;
			}
		} catch (Exception e2) {
			return 0;
		}
	}
	public int INPUTLISTSV(String id,String cla,String mk,String ten,String dt,String dl,String dh ) {
		try {
			
			String sql ="insert into student values ('"+id+"','"+cla+"','"+mk+"','"+ten+"','"+dt+"','"+dl+"','"+dh+"')";
			PreparedStatement pst = con.prepareStatement(sql);
			int n=pst.executeUpdate();
	        pst.close();
	        return 1;
		} catch (Exception e2) {
			// TODO: handle exception
		}return 0;
	}
	public int DELETE(String id) {
		try {
			String sql="delete from student where ID='"+id+"'" ;
			PreparedStatement pst = con.prepareStatement(sql);
			pst.execute();
			pst.close();
		} catch (Exception e2) {
			// TODO: handle exception
		}
		return 0;
	}
	public int STUDENT(String ten,String pass) {
		try {
			int count = 0;
			String sql="select * from student where [TÊN]=? and PASS=?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, ten);
			pst.setString(2, pass);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				count++;
			}
			if (count == 1) {
				return 1;
			}
			else {
				return 0;
			}
		} catch (Exception e2) {
			return 0;
		}
	}
	public int CHANGEPASS(String pass,String passold) {
		try {
			String sql ="select *from student where PASS=?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, pass);
			ResultSet rs = pst.executeQuery();
			int n =0;
		while(rs.next())
			n++;
			try {
               if(n==1) {
				String sq="update student set PASS='"+pass+"' where PASS='"+passold+"'";
				PreparedStatement ps = con.prepareStatement(sq);
				n= ps.executeUpdate();
				JOptionPane.showMessageDialog(null, "đổi mật khẩu thành công");
				STUDENT std = new STUDENT();
				std.setVisible(true);
				}
              else {
            	   JOptionPane.showMessageDialog(null, "mật khẩu cũ không đúng");
               }
			} catch (Exception e) {
				// TODO: handle exception
			
		}
		
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return 0;
			
	}
	public int CHANGEINFORSV(String id,String lop,String pass,String ten,String dt,String dl,String dh) {
			try {
				String sql = "update student set ID='"+id+"',[LỚP]='"+lop+"',PASS='"+pass+"',[TÊN]='"+ten+"',toan='"+dt+"',ly='"+dl+"',hoa='"+dh+"' where ID='"+id+"'";
				PreparedStatement pst = con.prepareStatement(sql);
				pst.execute();
				JOptionPane.showMessageDialog(null, "ĐÃ LƯU");
			} catch (Exception e2) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(null, "fail");
			}return 0;
	
}
	}
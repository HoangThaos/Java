package sever;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface InterFace extends Remote{
	public int ADMIIN(String a, String b) throws RemoteException;
	public int INPUTLISTSV(String a,String b,String c,String d,String e,String f,String g ) throws RemoteException;
	public int DELETE(String id) throws RemoteException;
	public int STUDENT(String ten,String pass) throws RemoteException;
	public int CHANGEPASS(String pass,String passold) throws RemoteException;
	public int CHANGEINFORSV(String id,String lop,String pass,String ten,String dt,String dl,String dh) throws RemoteException;
}
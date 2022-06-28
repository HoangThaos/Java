package sever;

import java.rmi.registry.Registry;

public class Server {
	public static void main(String args[]) {
		try {
			Registry r = java.rmi.registry.LocateRegistry.createRegistry(1099);
			r.bind("Cal", new Rmi());
			System.out.println("ok");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}

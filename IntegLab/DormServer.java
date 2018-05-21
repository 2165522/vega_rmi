import java.rmi.server.UnicastRemoteObject;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;

public class DormServer implements DormInterface {
	public String createDormName (String dormName) {
		return;
	}
	public int inputCapacity (String capacity) {
		return;
	}
	public String setNotif (String notif) {
		return;
	}
	public String register(String fname, String lname, String username, String password){
		return;
	}
	public String login (String username, String password) {
		return;
	}
	public String getNotif() {
		return;
	}
	public String getDormName() {
		return;
	}
	public int getCapacity() {
		return;
	}
	public String listOfTenants() {
		return;
	}
	public String getCurrentNumberOfTenants() {
		return;
	}
}
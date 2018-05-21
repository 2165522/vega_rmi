import java.rmi.Remote;
import java.rmi.RemoteException;

public interface DormInterface extends Remote {
	public String register(String fname, String lname, String username, String password) throws RemoteException;
	public String login (String username, String password) throws RemoteException;
	public String createDormName (String dormName) throws RemoteException;
	public int inputCapacity (String capacity) throws RemoteException;
	public String setNotif (String notif) throws RemoteException;
	public String getNotif() throws RemoteException;
	public String getDormName() throws RemoteException;
	public int getCapacity() throws RemoteException;
	public String listOfTenants() throws RemoteException;
	public String getCurrentNumberOfTenants() throws RemoteException();

}
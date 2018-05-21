import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.util.Scanner;

public class LandLord {
	public static void main (String[] args) {
		 try {
			Registry registry = LocateRegistry.getRegistry();
			DormInterface stub = (DormInterface)registry.lookup("dorminterface");
			Scanner kb = new Scanner(System.in);
	}
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

/**
 *
 * @author Earl
 */
public class Tenant {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        boolean repeat = false;
        try {
            Registry registry = LocateRegistry.getRegistry("127.0.0.1", 1050);
            DormInterface stub = (DormInterface) registry.lookup("dorm");

            do {
                System.out.println("\nBoarding House: "+stub.getDormName()+"\nCurrent Capacity: "+stub.getCurrentCapacity()+"\n\nAnnouncement!: "+stub.getNotif());
                System.out.println("=========================================");
                System.out.println("======== What do you want to do? ========");
                System.out.println("=========================================");
                System.out.println("1.\tCheck in.");
                System.out.println("2.\tCheck out.");
                System.out.println("3.\tReload console.");
                System.out.println("4.\tExit application.");

                System.out.print("\nEnter choice: ");
                byte choice = kb.nextByte();

                switch (choice) {
                    case 1:
                        stub.checkIn();
                        System.out.println("Checked in successfully");
                        repeat = true;
                        break;
                    case 2:
                        stub.checkOut();
                        System.out.println("Checked out successfully");
                        repeat = true;
                        break;
                    case 3:
                        repeat = true;
                        break;
                    case 4:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Choose a valid function.");
                        repeat = true;
                        break;
                }
            } while (repeat);

        } catch (Exception err) {
            System.out.println("Registry not found.");
        }
    }

}

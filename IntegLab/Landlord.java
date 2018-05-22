/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

/**
 *
 * @author Earl
 */
public class Landlord {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        boolean repeat = false;
        try {
            Registry registry = LocateRegistry.getRegistry("127.0.0.1", 1050);
            DormInterface stub = (DormInterface) registry.lookup("dorm");
            
            String dormName = "Vega Residences";
            stub.setDormName(dormName);
            
            int capacity = 0;
            stub.setCapacity(capacity);
            
            int maxCap = 0;
            stub.setMaxCap(maxCap);
            
            int numToAdd = 0;
            stub.setNumToAdd(numToAdd);
            
            stub.setCurrentCapacity(capacity, numToAdd);
            
            String announcement = "No Announcement!";
            stub.setNotif(announcement);

            do {
                System.out.println("\nBoarding House: "+stub.getDormName()+"\nCurrent Capacity: "+stub.getCurrentCapacity());
                System.out.println("\n=========================================");
                System.out.println("======== What do you want to do? ========");
                System.out.println("=========================================");
                System.out.println("1.\tChange the name of boarding house.");
                System.out.println("2.\tSet the maximum capacity of the house.");
                System.out.println("3.\tSet an announcement.");
                System.out.println("4.\tReload console.");
                System.out.println("5.\tExit application.");

                System.out.print("\nEnter choice: ");
                byte choice = Byte.parseByte(kb.nextLine());

                switch (choice) {
                    case 1:
                        System.out.print("Current name: "+stub.getDormName()+"\n");
                        System.out.print("Enter your desired boarding house name: ");
                        String dName = kb.next();
                        stub.setDormName(dName);
                        repeat = true;
                        break;
                    case 2:
                        System.out.println("Current maximum capacity: "+stub.getMaxCap());
                        System.out.print("Set new maximum capacity: ");
                        int max = Integer.parseInt(kb.nextLine());
                        stub.setMaxCap(max);
                        repeat = true;
                        break;
                    case 3:
                        System.out.print("Enter your announcement:");
                        String notif = kb.nextLine();
                        stub.setNotif(notif);
                        repeat = true;
                        break;
                    case 4:
                        repeat = true;
                        break;
                    case 5:
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

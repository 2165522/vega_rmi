/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vegadormsystem;

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
                System.out.println("=========================================");
                System.out.println("======== What do you want to do? ========");
                System.out.println("=========================================");
                System.out.println("1.\tChange the name of boarding house.");
                System.out.println("2.\tUpdate the current capacity of boarding house.");
                System.out.println("3.\tSet an announcement.");
                System.out.println("4.\tExit application.");

                System.out.print("\nEnter choice: ");
                byte choice = kb.nextByte();

                switch (choice) {
                    case 1:
                        System.out.print("Current name: " + stub.getDormName() + "\n");
                        System.out.print("Enter your desired boarding house name: ");
                        String dName = kb.next();
                        stub.setDormName(dName);
                        repeat = true;
                        break;
                    case 2:
                        System.out.print("Current capacity: " + stub.getCapacity() + "\n");
                        System.out.print("Enter capacity: ");
                        int cap = kb.nextInt();
                        stub.setCapacity(cap);
                        repeat = true;
                        break;
                    case 3:
                        System.out.print("Enter your announcement:");
                        String notif = kb.next();
                        stub.setNotif(notif);
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

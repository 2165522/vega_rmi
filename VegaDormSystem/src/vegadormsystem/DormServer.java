/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vegadormsystem;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


/**
 *
 * @author Earl
 */
public class DormServer {
    public static void main (String[]args) {
        try {
            Registry registry = LocateRegistry.createRegistry(1050);
            DormImplementation dorm = new DormImplementation();
            registry.rebind("dorm", dorm);
            System.out.println("Server is ready");
        } catch (RemoteException re) {
            System.out.println("Server is already Running");
        }
    }
    

//    public String register(String fname, String lname, String username, String password) {
//        return;
//    }
//
//    public String login(String username, String password) {
//        return;
//    }
//
//    public String getNotif() {
//        return notif;
//    }
//
//    public String getDormName() {
//        return dormName;
//    }
//
//    public int getCapacity() {
//        return capacity;
//    }
//
//    public String listOfTenants() {
//        return;
//    }
//
//    public String getCurrentNumberOfTenants() {
//        return;
//    }
}

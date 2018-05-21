/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vegadormsystem;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Earl
 */
public interface DormInterface extends Remote {

//    public String register(String fname, String lname, String username, String password) throws RemoteException;
//
//    public String login(String username, String password) throws RemoteException;
    public void setDormName(String dormName) throws RemoteException;

    public void setMaxCap(int maxCap) throws RemoteException;

    public void setNumToAdd(int numToAdd) throws RemoteException;

    public void setCapacity(int capacity) throws RemoteException;

    public void setCurrentCapacity(int capacity, int numToAdd) throws RemoteException;

    public void setNotif(String notif) throws RemoteException;

    public String getNotif() throws RemoteException;
//

    public String getDormName() throws RemoteException;
//

    public int getMaxCap() throws RemoteException;

    public int getNumToAdd() throws RemoteException;

    public int getCapacity() throws RemoteException;

    public String getCurrentCapacity() throws RemoteException;

    public void checkIn() throws RemoteException;

    public void checkOut() throws RemoteException;
//
//    public String listOfTenants() throws RemoteException;
//
//    public String getCurrentNumberOfTenants() throws RemoteException;
}

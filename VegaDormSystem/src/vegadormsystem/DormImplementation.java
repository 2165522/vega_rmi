/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vegadormsystem;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import vegadormsystem.DormInterface;

/**
 *
 * @author Earl
 */
public class DormImplementation extends UnicastRemoteObject implements DormInterface {

    public DormImplementation() throws RemoteException {

    }

    String dormName;
    int capacity;
    int numToAdd;
    int maxCap;
    String notif;

    public void setDormName(String dormName) throws RemoteException {
        this.dormName = dormName;
    }

    public void setMaxCap(int maxCap) throws RemoteException {
        this.maxCap = maxCap;
    }

    public void setNumToAdd(int numToAdd) throws RemoteException {
        this.numToAdd = numToAdd;
    }

    public void setCapacity(int capacity) throws RemoteException {
        this.capacity = capacity;
    }

    public void setCurrentCapacity(int capacity, int numToAdd) throws RemoteException {
        this.capacity = capacity + numToAdd;
    }

    public void setNotif(String notif) throws RemoteException {
        this.notif = notif;
    }

    public String getDormName() throws RemoteException {
        return dormName;
    }

    public int getMaxCap() throws RemoteException {
        return maxCap;
    }

    public int getNumToAdd() throws RemoteException {
        return numToAdd;
    }

    public int getCapacity() throws RemoteException {
        return capacity;
    }

    public String getCurrentCapacity() throws RemoteException {
        return capacity + "/" + maxCap;
    }

    public String getNotif() throws RemoteException {
        return notif;
    }
    
    public void checkIn() throws RemoteException {
        this.capacity++;
    }
    
    public void checkOut() throws RemoteException {
        this.capacity--;
    }
}

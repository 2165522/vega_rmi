/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login.Interface;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.Timestamp;

/**
 *
 * @author Earl
 */

public interface LoginInterface extends Remote {
    public boolean validateLogin(String user, String pass) throws RemoteException;
    
    public void timeIn (String user, Timestamp time_in) throws RemoteException;
    
    public void timeOut (String user, Timestamp time_out) throws RemoteException;
}

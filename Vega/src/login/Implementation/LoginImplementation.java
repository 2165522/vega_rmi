/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login.Implementation;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import login.Interface.LoginInterface;

/**
 *
 * @author Earl
 */
public class LoginImplementation extends UnicastRemoteObject implements LoginInterface {
    
    public LoginImplementation() throws RemoteException {
        
    }
    
    public boolean validateLogin(String user, String pass) throws RemoteException {
        Boolean res = false;
        
        try {
            res = user.equals("admin") && pass.equals("password");
        } catch (Exception err){
            err.printStackTrace();
        }
        return res;
    }
    
}

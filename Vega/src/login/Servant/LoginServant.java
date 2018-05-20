/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login.Servant;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import login.Implementation.LoginImplementation;

/**
 *
 * @author Earl
 */
public class LoginServant {

    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.createRegistry(1055);
            LoginImplementation login = new LoginImplementation();
            registry.rebind("login", login);
            System.out.println("Server is ready");
        } catch (RemoteException re) {
            System.out.println("Server not found.");
        }
    }
}

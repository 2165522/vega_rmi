/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login.Implementation;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
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
        Connection con;
        PreparedStatement ps;

        try {
            String conStr = "jdbc:mysql://localhost:3306/vegadb?user=root&password=";
            con = DriverManager.getConnection(conStr);
            String query = "SELECT userName, password FROM tenants where userName = ? AND password = ?";

            ps = con.prepareStatement(query);
            ps.setString(1, user);
            ps.setString(2, pass);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                res = true;
            }
        } catch (SQLException err) {
            err.printStackTrace();
            System.out.println("Database Connection Failed.");
        }
        return res;
    }

    public void timeIn(String user, Timestamp time_in) throws RemoteException {
        Connection con;
        PreparedStatement ps;

        try {
            String conStr = "jdbc:mysql://localhost:3306/vegadb?user=root&password=";
            con = DriverManager.getConnection(conStr);
            String query = "INSERT INTO tenants_log(tenant, time_in) VALUES (?,?)";

            ps = con.prepareStatement(query);
            
            ps.setString(1, user);
            ps.setTimestamp(2, time_in);
            ps.executeUpdate();

        } catch (SQLException err) {
            err.printStackTrace();
            System.out.println("Database Connection Failed.");
        }
    }

}

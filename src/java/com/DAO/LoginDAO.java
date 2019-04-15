/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DAO;

/**
 *
 * @author Rick
 */
import com.connection.ConnectionDB;
import com.model.LoginForm;
import com.controller.VerifierDonnee;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class LoginDAO {
    
       
public boolean verification(String nom, String pass) throws SQLException {
        boolean result = false;
        String MDP = null;
        PreparedStatement preparedStatement = null;
        Connection con = null;
        
//        if(nom == null || pass==null){
//            return false;
//        }
        try {
        con = ConnectionDB.createConnection();
        String query = "SELECT MDP from admins WHERE Login = '"+ nom +"'";
        preparedStatement = con.prepareStatement(query); 

        ResultSet rs = preparedStatement.executeQuery();
         
        while (rs.next()) {
                MDP = rs.getString("MDP");
        }
        
        //String MDP = rs.getString("MDP");
               
       
        if (MDP.equals(pass))
               result = true;     
        
        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }
            finally {

            if (preparedStatement != null) {
                preparedStatement.close();
            }

            if (con != null) {
                con.close();
            }

        }
        return result;
        }
        
}

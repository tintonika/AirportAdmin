/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DAO;

import com.connection.ConnectionDB;
import com.model.LoginForm;
import com.controller.VerifierDonnee;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Rick
 */
public class LoginFormDAO {
    PreparedStatement preparedStatement = null;
    Statement stmt = null;
    Connection con = null;
    //public static ArrayList<LoginForm> adminList;
    
    ResultSet rs = null;
    
    
     public boolean verification(String login, String password) throws SQLException{
        
        con = ConnectionDB.createConnection();   
        stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        
        stmt = con.createStatement();
        //adminList = new ArrayList<LoginForm>();    
        String querySelectID = "SELECT id,login, mdp from admins WHERE Login = '"+ login +"'";
        preparedStatement = con.prepareStatement(querySelectID);
        
        ResultSet rs = preparedStatement.executeQuery();
        //int ID=rs.getInt("ID");
        //String LOGIN=rs.getString("LOGIN");
        String MDP=rs.getString("MDP");
        if(rs!=null){
            if(MDP==password){
             return true; 
            } else{
            return false;
            } 
        }else{
             return false;
        
        } 
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DAO;

import com.connection.ConnectionDB;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author republic of gamers
 */
public class InsertVolDetailsDAO {

    PreparedStatement preparedStatement = null;
    Statement stmt = null;
    Connection con = null;

    public void deleteDetails() throws SQLException, IOException, ParseException {
        try {

            con = ConnectionDB.createConnection();

            preparedStatement = con.prepareStatement("DELETE FROM details");
            preparedStatement.executeUpdate();
            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }

    }
     public void deleteVols() throws SQLException, IOException, ParseException {
        try {

            con = ConnectionDB.createConnection();

            preparedStatement = con.prepareStatement("DELETE FROM vols");
            preparedStatement.executeUpdate();
            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void insertVol() throws SQLException, IOException, ParseException {

        JSONParser parser = new JSONParser();
        try {

            con = ConnectionDB.createConnection();

            JSONArray obj = (JSONArray) parser.parse(new FileReader("G:/Rosemont/4 Session/Projet/MasterBcup/Derniere version/AirportMTL/src/java/com/files/vols.json"));  // HERE PROBLEM

            for (Object o : obj) {

                JSONObject vols = (JSONObject) o;

                int ID = (int) (long) vols.get("ID");

                String NumeroVol = (String) vols.get("NumeroVol");
                String Heure_prevu = (String) vols.get("Heure_prevu");
                int ID_AEROPORT = (int) (long) vols.get("ID_AEROPORT");
                int ID_Compagnie = (int) (long) vols.get("ID_Compagnie");
                int TYPE = (int) (long) vols.get("TYPE");

                String query = "INSERT INTO vols "
                        + "(ID, NumeroVol, Heure_prevu, ID_AEROPORT, ID_Compagnie, TYPE)"
                        + "VALUES (?, ?, ?, ?, ?, ?)";

                preparedStatement = con.prepareStatement(query);

                preparedStatement.setInt(1, ID);
                preparedStatement.setString(2, NumeroVol);
                preparedStatement.setString(3, Heure_prevu);
                preparedStatement.setInt(4, ID_AEROPORT);
                preparedStatement.setInt(5, ID_Compagnie);
                preparedStatement.setInt(6, TYPE);

                preparedStatement.executeUpdate();
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());

        } finally {

            if (stmt != null) {
                stmt.close();
            }

            if (con != null) {
                con.close();
            }
        }

    }

    public void insertDetails() throws SQLException, IOException, ParseException {

        JSONParser parser = new JSONParser();
        try {

            con = ConnectionDB.createConnection();

            JSONArray obj = (JSONArray) parser.parse(new FileReader("G:/Rosemont/4 Session/Projet/MasterBcup/Derniere version/AirportMTL/src/java/com/files/details.json"));  // HERE PROBLEM

            for (Object o : obj) {

                JSONObject details = (JSONObject) o;

                int ID_VOL = (int) (long) details.get("ID_VOL");

                String DATE_PREVU = (String) details.get("DATE_PREVU");
                String DATE_REVISE = (String) details.get("DATE_REVISE");
                String HEURE_REVISE = (String) details.get("HEURE_REVISE");
                String PORTE = (String) details.get("PORTE");
                int STATUT = (int) (long) details.get("STATUT");

                String query = "INSERT INTO details "
                        + "(ID_VOL, DATE_PREVU, DATE_REVISE, HEURE_REVISE, PORTE, STATUT)"
                        + "VALUES (?, ?, ?, ?, ?, ?)";

                preparedStatement = con.prepareStatement(query);

                preparedStatement.setInt(1, ID_VOL);
                preparedStatement.setString(2, DATE_PREVU);
                preparedStatement.setString(3, DATE_REVISE);
                preparedStatement.setString(4, HEURE_REVISE);
                preparedStatement.setString(5, PORTE);
                preparedStatement.setInt(6, STATUT);

                preparedStatement.executeUpdate();
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());

        } finally {

            if (stmt != null) {
                stmt.close();
            }

            if (con != null) {
                con.close();
            }
        }

    }

}

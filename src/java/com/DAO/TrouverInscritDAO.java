package com.DAO;

import com.connection.ConnectionDB;
import java.io.FileNotFoundException;
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

public class TrouverInscritDAO {

    PreparedStatement preparedStatement = null;
    Statement stmt = null;
    Connection con = null;
    String telMatched;

    public String trouverNumTel() throws FileNotFoundException, IOException, ParseException, SQLException {

        try {
            con = ConnectionDB.createConnection();
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            stmt = con.createStatement();

            JSONParser parser = new JSONParser();
            JSONArray obj = (JSONArray) parser.parse(new FileReader("G:/AirportAdmin/src/java/com/files/updateDetails.json"));

            for (Object o : obj) {
                JSONObject details = (JSONObject) o;
                int ID_VOL = (int) (long) details.get("ID_VOL");
                int STATUT = (int) (long) details.get("STATUT");
                
                
                String querySelectIDInscrit = "SELECT Telephone from inscrits WHERE ID_VOL = '" + ID_VOL + "'";
                preparedStatement = con.prepareStatement(querySelectIDInscrit);
                ResultSet rs = preparedStatement.executeQuery();

                if (rs.next()) {
                    telMatched = rs.getString("Telephone");

                    //EnvoyerSMSDAO daoSMS = new EnvoyerSMSDAO();
                    // daoSMS.envoyerSMS(telMatched, STATUT);
                }
            }

                //stmt.executeUpdate(queryInsert);
            } catch (SQLException e) {
            System.out.println(e.getMessage());

        }finally {

            if (stmt != null) {
                stmt.close();
            }

            if (con != null) {
                con.close();
            }
        
           } 
                
        return telMatched;
    }
}

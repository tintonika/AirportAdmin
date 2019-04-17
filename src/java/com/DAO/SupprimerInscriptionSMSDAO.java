
package com.DAO;

import com.connection.ConnectionDB;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class SupprimerInscriptionSMSDAO {
    
    PreparedStatement preparedStatement = null;
    Statement stmt = null;
    Connection con = null;
    
    
    public void supprimerInscriptionSMS() throws SQLException, IOException, ParseException {
    JSONParser parser = new JSONParser();
        try {

            con = ConnectionDB.createConnection();

            JSONArray obj = (JSONArray) parser.parse(new FileReader("G:/AirportAdmin/src/java/com/files/listeTelephones.json")); 

            for (Object o : obj) {

                JSONObject telephones = (JSONObject) o;

               
                String TELEPHONE = (String) telephones.get("TELEPHONE");
                

                String query = "DELETE from inscrits WHERE Telephone =?";
                        
                preparedStatement = con.prepareStatement(query);
              
                preparedStatement.setString(1, TELEPHONE);

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

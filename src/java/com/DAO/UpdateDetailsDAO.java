
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

public class UpdateDetailsDAO {

    PreparedStatement preparedStatement = null;
    Statement stmt = null;
    Connection con = null;

   public void updateDetails() throws SQLException, IOException, ParseException {

        JSONParser parser = new JSONParser();
        try {

            con = ConnectionDB.createConnection();

            JSONArray obj = (JSONArray) parser.parse(new FileReader("G:/AirportAdmin/src/java/com/files/updateDetails.json"));  // HERE PROBLEM

            for (Object o : obj) {

                JSONObject details = (JSONObject) o;

                int ID_VOL = (int) (long) details.get("ID_VOL");

               
                String DATE_REVISE = (String) details.get("DATE_REVISE");
                String HEURE_REVISE = (String) details.get("HEURE_REVISE");
                String PORTE = (String) details.get("PORTE");
                int STATUT = (int) (long) details.get("STATUT");

                String query = "UPDATE details SET  DATE_REVISE =?, HEURE_REVISE =?, PORTE = ?, STATUT = ? WHERE ID_VOL = ?";
                        
                preparedStatement = con.prepareStatement(query);
              
                preparedStatement.setString(1, DATE_REVISE);
                preparedStatement.setString(2, HEURE_REVISE);
                preparedStatement.setString(3, PORTE);
                preparedStatement.setInt(4, STATUT);
                preparedStatement.setInt(5, ID_VOL);

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

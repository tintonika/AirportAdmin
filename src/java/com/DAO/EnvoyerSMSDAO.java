package com.DAO;

import com.connection.ConnectionDB;


import com.twilio.Twilio;

import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
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

public class EnvoyerSMSDAO {

    public static final String ACCOUNT_SID = "AC53db1ec9d30456dc0b5f6a7bcaba5979";
    public static final String AUTH_TOKEN = "7cc76a55106a6a7a4abce18293d25786";
    String message = "";

    public void trouverInscritEtEnvoyerSMS() throws FileNotFoundException, IOException, ParseException, SQLException {

        PreparedStatement preparedStatement = null;
        Statement stmt = null;
        Connection con = null;
        String telMatched;
        int statut_vol;

        try {
            con = ConnectionDB.createConnection();
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            stmt = con.createStatement();

            JSONParser parser = new JSONParser();
            JSONArray obj = (JSONArray) parser.parse(new FileReader("G:/AirportAdmin/src/java/com/files/updateDetails.json"));

            for (Object o : obj) {
                JSONObject details = (JSONObject) o;
                int ID_VOL = (int) (long) details.get("ID_VOL");
                int STATUT_VOL = (int) (long) details.get("STATUT");

                String querySelectIDInscrit = "SELECT Telephone from inscrits WHERE ID_VOL = '" + ID_VOL + "'";
//                String querySelectIDInscrit = "SELECT v.numeroVol, i.Telephone "
//                        + "FROM vols v,inscrits i"
//                        + "WHERE v.ID = i.ID_VOL";
                preparedStatement = con.prepareStatement(querySelectIDInscrit);
                ResultSet rs = preparedStatement.executeQuery();

             

                    
                    if (rs.next()) {
                    telMatched = rs.getString("Telephone");
                    //String numVol = rs.getString("NumeroVol");

                    
                    envoyerSMS(telMatched, STATUT_VOL);
                }
            }

            //stmt.executeUpdate(queryInsert);
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

    public void envoyerSMS(String telephone, int STATUT) {
        String numVol = " ";
        
        if (STATUT == 1) {
            message = "Le vol '" + numVol + "' est ARRIVÉ";
        } else if (STATUT == 2) {
            message = "Le vol '" + numVol + "' est PARTI";
        } else if (STATUT == 3) {
            message = "Le vol '" + numVol + "' est RETARDE";
        } else if (STATUT == 4) {
            message = "Le vol '" + numVol + "' est ANNULE";
        } else if (STATUT == 5) {
            message = "Le temps de vol '" + numVol + "' est REVISE";
        }

        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message msg = Message.creator(new PhoneNumber(telephone),
                new PhoneNumber("+14508001443"), message).create();

        System.out.println(msg.getSid());

    }
}


package com.controller;

import com.DAO.InsertVolDetailsDAO;
import com.DAO.SupprimerInscriptionSMSDAO;
import com.DAO.UpdateDetailsDAO;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.parser.ParseException;

public class Automat6mois extends TimerTask {

    public static void automatisation6mois() throws InterruptedException {
        Timer t2 = new Timer();
        
        // mis a jours chaque 10sec  pour le test
        //Thread.sleep(600000);
        t2.schedule(new Automat6mois(), 1000, 10000);

    }

    @Override
    public void run() {
        try {
   
            InsertVolDetailsDAO dao = new InsertVolDetailsDAO();
            dao.deleteDetails();
            dao.deleteVols();
            dao.insertVol();
            dao.insertDetails();

        } catch (SQLException | IOException | ParseException ex) {
            Logger.getLogger(Automat10min.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

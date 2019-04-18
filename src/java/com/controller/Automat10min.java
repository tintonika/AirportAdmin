
package com.controller;

import com.DAO.SupprimerInscriptionSMSDAO;
import com.DAO.UpdateDetailsDAO;
import com.DAO.EnvoyerSMSDAO;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Thierno
 */
public class Automat10min extends TimerTask {

    public static void automatiosation10min() throws InterruptedException {
        Timer t = new Timer();
        
        // mis a jours chaque 10sec  pour le test
       //(600000) 10min
        t.schedule(new Automat10min(), 1000, 10000);
    

    }

    @Override
    public void run() {
        try {
            
            
            
            UpdateDetailsDAO dao = new UpdateDetailsDAO();
            dao.updateDetails();

            EnvoyerSMSDAO daoSMS1 = new EnvoyerSMSDAO();
            daoSMS1.trouverInscritEtEnvoyerSMS();   
            
             SupprimerInscriptionSMSDAO daoSMS = new SupprimerInscriptionSMSDAO();
             daoSMS.supprimerInscriptionSMS();
            

        } catch (SQLException | IOException | ParseException ex) {
            Logger.getLogger(Automat10min.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

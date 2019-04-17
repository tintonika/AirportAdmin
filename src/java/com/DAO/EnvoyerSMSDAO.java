package com.DAO;

import java.net.URISyntaxException;
import java.net.URISyntaxException;

import com.twilio.Twilio;
import com.twilio.exception.ApiException;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

class EnvoyerSMSDAO {

    public static final String ACCOUNT_SID = "AC53db1ec9d30456dc0b5f6a7bcaba5979";
    public static final String AUTH_TOKEN = "7cc76a55106a6a7a4abce18293d25786";
    String message = "";

    public void envoyerSMS(String telephone, int STATUT) {

        if (STATUT == 1) {
            message = "Le vol est ARRIVÉ";
        } else if (STATUT == 2) {
            message = "Le vol est PARTI";
        } else if (STATUT == 3) {
            message = "Le vol est RETARDE";
        } else if (STATUT == 4) {
            message = "Le vol est ANNULE";
        } else if (STATUT == 5) {
            message = "Le temps de vol est REVISE";
        }
        
        
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message msg = Message.creator(new PhoneNumber(telephone),
                new PhoneNumber("+14508001443"), message).create();

        System.out.println(msg.getSid());

    }
}

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
    
    
    public void envoyerSMS(String telephone) {
     
    

    
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(new PhoneNumber("+15149653160"),
                new PhoneNumber("+14508001443"),
                "Bonsoir, votre vol est un peu en retard. ADMTL").create();

        System.out.println(message.getSid());

    
}}

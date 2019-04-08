/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

/**
 *
 * @author Rick
 */
public class LoginForm {
    private int ID;
    private String Login;
    private String MDP;

    public LoginForm(int ID, String NomUtilisateur, String Password) {
        this.ID = ID;
        this.Login = NomUtilisateur;
        this.MDP = Password;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getLogin() {
        return Login;
    }

    public void setLogin(String Login) {
        this.Login = Login;
    }

    public String getMDP() {
        return MDP;
    }

    public void setMDP(String MDP) {
        this.MDP = MDP;
    }
    
    
}

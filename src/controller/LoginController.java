/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.Login;

/**
 *
 * @author Firdaus
 */
public class LoginController implements ActionListener{
    private Login view_login;
    
    public LoginController(){
        view_login = new Login();
        view_login.setVisible(true);
        view_login.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object src = ae.getSource();
        if (src.equals(view_login.getLoginBtn())){
            loginBtnPerformed();
        }else if(src.equals(view_login.getDaftarBtn())){
            daftarBtnPerformed();
        }
    }
    
    public void loginBtnPerformed(){
        
    }
    
    public void daftarBtnPerformed(){
        new RegisController();
        view_login.dispose();
    }
    
    
    
    
}

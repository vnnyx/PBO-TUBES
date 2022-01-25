/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import database.Database;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.Admin;
import model.Penyewa;
import service.UserService;
import view.Login;

/**
 *
 * @author Firdaus
 */
public class LoginController extends Database implements ActionListener {

    private Login view_login;
    private UserService userService;

    public LoginController() {
        userService = new UserService();
        view_login = new Login();
        view_login.setVisible(true);
        view_login.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object src = ae.getSource();
        if (src.equals(view_login.getLoginBtn())) {
            loginBtnPerformed();
        } else if (src.equals(view_login.getDaftarBtn())) {
            daftarBtnPerformed();
        } else if (src.equals(view_login.getLihatPassword())) {
            lihatPswdPerformed();
        }
    }

    public void loginBtnPerformed() {
        String username = view_login.getUsername().getText();
        String password = String.valueOf(view_login.getPassword().getPassword());

        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Harap masukkan data");
        } else {
            Penyewa attPenyewa = new Penyewa(username, password);
            Admin attAdmin = new Admin(username, password);
            try {
                attPenyewa = userService.validatePenyewa(attPenyewa);
                attAdmin = userService.validateAdmin(attAdmin);
                if (attPenyewa.getUsername() != null) {
                    view_login.dispose();
                    new PenyewaPageController(attPenyewa.getUsername(), attPenyewa.getEmail(), attPenyewa.getFoto_diri());
                } else if (attAdmin.getUsername() != null) {
                    new AdminPageController();
                } else {
                    JOptionPane.showMessageDialog(null, "Data tidak ditemukan, silahkan daftar akun");
                }
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public void daftarBtnPerformed() {
        new RegisController();
        view_login.dispose();
    }

    public void lihatPswdPerformed() {
        if (view_login.getLihatPassword().isSelected()) {
            view_login.getPassword().setEchoChar((char) 0);
        } else {
            view_login.getPassword().setEchoChar('*');
        }
    }
    
}

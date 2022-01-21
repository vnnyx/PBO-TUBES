/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import database.Database;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Admin;
import model.Penyewa;
import service.UserService;
import view.KatalogKendaraan;
import view.Login;

/**
 *
 * @author Firdaus
 */
public class LoginController extends Database implements ActionListener {

    private Login view_login;
    private UserService userService;
    private KatalogKendaraan view_katalog;

    public LoginController() {
        view_katalog = new KatalogKendaraan();
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

    public Admin validateAdmin(Admin admin) throws SQLException {
        Admin user_admin = new Admin();
        ArrayList<Admin> selectUser = userService.getDataAdmin(admin, 1);
        if (selectUser.size() > 0) {
            user_admin = selectUser.get(0);
        }
        return user_admin;
    }

    public Penyewa validatePenyewa(Penyewa penyewa) throws SQLException {
        Penyewa user_Penyewa = new Penyewa();
        ArrayList<Penyewa> selectUser = userService.getDataPenyewa(penyewa, 1);
        if (selectUser.size() > 0) {
            user_Penyewa = selectUser.get(0);
        }
        return user_Penyewa;
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
                attPenyewa = validatePenyewa(attPenyewa);
                attAdmin = validateAdmin(attAdmin);
                if (attPenyewa.getUsername() != null) {
                    view_katalog.getUsername().setText(attPenyewa.getUsername());
                    new PenyewaPageController();
                } else if (attAdmin.getUsername() != null) {
                    JOptionPane.showMessageDialog(null, "Admin page");
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

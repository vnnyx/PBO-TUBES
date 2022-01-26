/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import database.Database;
import helper.Helper;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import model.Penyewa;
import repository.Repository;
import service.UserService;
import view.Registrasi1;
import view.Registrasi2;

/**
 *
 * @author Firdaus
 */
public class RegisController extends Database implements ActionListener {

    private Registrasi1 view_regis1;
    private Registrasi2 view_regis2;
    private Penyewa model_penyewa;
    private Helper helper;
    private Repository repo;
    private UserService userService;

    public RegisController() {
        userService = new UserService();
        repo = new Repository();
        helper = new Helper();
        view_regis1 = new Registrasi1();
        view_regis2 = new Registrasi2();
        view_regis1.setVisible(true);
        view_regis1.addActionListener(this);
        view_regis2.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object src = ae.getSource();
        if (src.equals(view_regis1.getNextBtn())) {
            nextBtnPerformed();
        } else if (src.equals(view_regis1.getBackBtn())) {
            backBtnPerformed();
        } else if (src.equals(view_regis2.getUnggahKTPBtn())) {
            unggahKTPBtnPerformed();
        } else if (src.equals(view_regis2.getUnggahFotoBtn())) {
            unggahFotoBtnPerformed();
        } else if (src.equals(view_regis2.getBackBtn())) {
            backBtn2Performed();
        } else if (src.equals(view_regis2.getDaftarBtn())) {
            daftarBtnPerformed();
        }
    }

    public void tempUser() {
        String username = view_regis1.getUsername().getText();
        String email = view_regis1.getEmail().getText();
        String password = String.valueOf(view_regis1.getConfirm_password().getPassword());
        model_penyewa = new Penyewa(username, password, email, "", "", "");
    }

    public void updateUser() {
        String alamat = view_regis2.getAlamat().getText();
        model_penyewa.setAlamat(alamat);
    }

    public void nextBtnPerformed() {
        String username = view_regis1.getUsername().getText();
        String password = String.valueOf(view_regis1.getPassword().getPassword());
        String confirm_password = String.valueOf(view_regis1.getConfirm_password().getPassword());
       
        if(username.equals("") || password.equals("") || view_regis1.getEmail().getText().isEmpty()){
              JOptionPane.showMessageDialog(null, "Data tidak boleh kosong");
        }else if (!password.equals(confirm_password)) {
            JOptionPane.showMessageDialog(null, "Password tidak sesuai");
        } else {
            Penyewa penyewa = new Penyewa(username, confirm_password);
            try {
                penyewa = userService.validatePenyewa(penyewa);
                if (penyewa.getUsername() != null) {
                    JOptionPane.showMessageDialog(null, "Username sudah digunakan");
                } else {
                    tempUser();
                    view_regis2.setVisible(true);
                    view_regis1.setVisible(false);
                }
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public void daftarBtnPerformed() {
        if (view_regis2.getAlamat().getText().isEmpty() || view_regis2.getPathFoto().getText().equals("Unggah foto diri")
                || view_regis2.getPathKTP().getText().equals("Unggah foto KTP")){
            JOptionPane.showMessageDialog(null, "Data tidak boleh kosong");
        }else{
            updateUser();
            try {
                repo.addUser(model_penyewa);
                JOptionPane.showMessageDialog(null, "Sukses daftar akun");
                view_regis2.dispose();
                new LoginController();

            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }

    }

    public void backBtnPerformed() {
        new LoginController();
        view_regis1.dispose();
    }

    public void unggahKTPBtnPerformed() {
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File file = chooser.getSelectedFile();
        String filename = file.getAbsolutePath();
        view_regis2.getPathKTP().setText(filename);
        try {
            String imageURL = helper.uploadImage(file);
            model_penyewa.setFoto_ktp(imageURL);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void unggahFotoBtnPerformed() {
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File file = chooser.getSelectedFile();
        String filename = file.getAbsolutePath();
        view_regis2.getPathFoto().setText(filename);
        try {
            String imageURL = helper.uploadImage(file);
            model_penyewa.setFoto_diri(imageURL);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void backBtn2Performed() {
        new RegisController();
        view_regis2.dispose();
    }
    
}

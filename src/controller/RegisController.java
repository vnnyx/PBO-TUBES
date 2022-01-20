/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import database.Database;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import model.Penyewa;
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

    public RegisController() {
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

    public void addUser() {
        String username = view_regis1.getUsername().getText();
        String email = view_regis1.getEmail().getText();
        String password = String.valueOf(view_regis1.getConfirm_password().getPassword());
        model_penyewa = new Penyewa(username, password, email, "", "", "");
    }

    public void updateUser() {
        String alamat = view_regis2.getAlamat().getText();
        String ktp = view_regis2.getPathKTP().getText();
        ktp = ktp.replace("\\", "\\\\");
        String foto = view_regis2.getPathFoto().getText();
        foto = foto.replace("\\", "\\\\");
        model_penyewa.setAlamat(alamat);
        model_penyewa.setFoto_ktp(ktp);
        model_penyewa.setFoto_diri(foto);
    }

    public void nextBtnPerformed() {
        connectDB();
        String username_db = "";
        String username = view_regis1.getUsername().getText();
        String email = view_regis1.getEmail().getText();
        String query = "SELECT username FROM user WHERE username='%s'";
        query = String.format(query, username);
        try {
            executeQuery(query);
            while (rs.next()) {
                username_db = rs.getString("username");
            }
            disconnectDB();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        String password = String.valueOf(view_regis1.getPassword().getPassword());
        String confirm_password = String.valueOf(view_regis1.getConfirm_password().getPassword());
        if (username.isEmpty() || email.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Data tidak boleh kosong");
        } else if (!confirm_password.equals(password)) {
            JOptionPane.showMessageDialog(null, "Password tidak sesuai");
        } else if (username.equals(username_db)) {
            JOptionPane.showMessageDialog(null, "Username sudah digunakan");
        } else {
            addUser();
            view_regis2.setVisible(true);
            view_regis1.dispose();
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
    }

    public void unggahFotoBtnPerformed() {
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File file = chooser.getSelectedFile();
        String filename = file.getAbsolutePath();
        view_regis2.getPathFoto().setText(filename);
    }

    public void backBtn2Performed() {
        new RegisController();
        view_regis2.dispose();
    }

    public void daftarBtnPerformed() {
        updateUser();
        connectDB();
        String sql = "INSERT INTO `user` (`role`, `username`, `email`, `password`, `alamat`, `foto_ktp`, `foto_diri`) VALUES ("
                + "'%s', '%s', '%s', '%s', '%s', '%s', '%s')";
        sql = String.format(sql, model_penyewa.getRole(), model_penyewa.getUsername(), model_penyewa.getEmail(), model_penyewa.getPassword(),
                model_penyewa.getAlamat(), model_penyewa.getFoto_ktp(), model_penyewa.getFoto_diri());
        try {
            execute(sql);
            disconnectDB();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        JOptionPane.showMessageDialog(null, "Sukses Daftar Akun");
        view_regis2.dispose();
        new LoginController();
    }
}

package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import database.Database;
import helper.Helper;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import model.Kendaraan;
import view.DaftarKendaraanSukses;
import view.MenuUtamaDaftarKendaraan;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author aryuska
 */
public class DaftarKendaraanController extends Database implements MouseListener, ActionListener {

    private final MenuUtamaDaftarKendaraan viewDaftar;
    private final Helper helper;

    public DaftarKendaraanController() {
        helper = new Helper();
        viewDaftar = new MenuUtamaDaftarKendaraan();
        viewDaftar.setVisible(true);
        viewDaftar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src.equals(viewDaftar.getSave())) {
            try {
                daftarKendaraanActionPerformed();
            } catch (IOException ex) {
                Logger.getLogger(DaftarKendaraanController.class.getName()).log(Level.SEVERE, null, ex);
            }
            viewDaftar.setVisible(false);
            new DaftarKendaraanSukses().setVisible(true);
        }
    }

    public void daftarKendaraanActionPerformed() throws IOException {
        String getNama = viewDaftar.getNamaKendaraan().getText();
        String getMerk = viewDaftar.getMerkKendaraan().getSelectedItem();
        String getWarna = viewDaftar.getWarnaKendaraan().getText();
        String getCC = viewDaftar.getCcKendaraan().getSelectedItem();
        String getHarga = viewDaftar.getHargaKendaraan().getText();
        String getKapasitas = viewDaftar.getKapasitas();
        File getImage1 = viewDaftar.getImage1();
        File getImage2 = viewDaftar.getImage2();
        File getImage3 = viewDaftar.getImage3();

        String image1URL = helper.uploadImage(getImage1);
        String image2URL = helper.uploadImage(getImage2);
        String image3URL = helper.uploadImage(getImage3);
        
        int cc = Integer.parseInt(getCC);
        int harga = Integer.parseInt(getHarga);
        int kapasitas = Integer.parseInt(getKapasitas);
        
        Kendaraan newData = new Kendaraan(0,getNama, getMerk,getWarna, cc, image1URL, image2URL, image3URL, harga, kapasitas,0);

        connectDB();
        String sql = "INSERT INTO `kendaraan` (`nama_kendaraan`, `merk_kendaraan`, `warna_kendaraan`, `cc_kendaraan`, `foto_1`, `foto_2`, `foto_3`, `harga_sewa`, `kapasitas`) VALUES\n"
                +
                "('%s', '%s', '%s', %d, '%s', '%s', '%s', %d, %d)";
        sql = String.format(sql, newData.getNama_kendaraan() ,newData.getMerk_kendaraan(), newData.getWarna_kendaraan(), newData.getCc_kendaraan(),
                newData.getFoto_1(), newData.getFoto_2(), newData.getFoto_3(), newData.getHarga_sewa(), newData.getKapasitas());
        try {
            execute(sql);
            disconnectDB();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent e) {
         Object src = e.getSource();
        if (src.equals(viewDaftar.getKapasitas2())) {
            System.out.println("pressed");
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

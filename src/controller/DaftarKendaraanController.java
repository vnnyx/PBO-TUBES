package controller;


import database.Database;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.swing.JOptionPane;
import model.Kendaraan;
import view.DaftarKendaraanSukses;
import view.MenuUtamaDaftarKendaraan;
import com.cloudinary.Cloudinary;
import helper.Helper;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author aryuska
 */
public class DaftarKendaraanController extends Database  implements ActionListener {
    
    private final MenuUtamaDaftarKendaraan viewDaftar;
    private final Helper helper;
    
    public DaftarKendaraanController(){
        helper = new Helper();
        viewDaftar = new MenuUtamaDaftarKendaraan();
        viewDaftar.setVisible(true);
        viewDaftar.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src.equals(viewDaftar.getSave())){
            try {
                daftarKendaraanActionPerformed();
            } catch (IOException ex) {
                Logger.getLogger(DaftarKendaraanController.class.getName()).log(Level.SEVERE, null, ex);
            }
           viewDaftar.setVisible(false);
           new DaftarKendaraanSukses().setVisible(true);
        }
    }
    
    public void daftarKendaraanActionPerformed() throws IOException{
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

        
        Kendaraan newData = new Kendaraan(getNama, getMerk, getWarna, getCC, image1URL, image2URL, image3URL, getHarga, getKapasitas);
        
        connectDB();
        String sql = "INSERT INTO `kendaraan` (`nama_kendaraan`, `merk_kendaraan`, `warna_kendaraan`, `cc_kendaraan`, `foto_1`, `foto_2`, `foto_3`, `harga_sewa`, `kapasitas`) VALUES\n" +
"('%s', '%s', '%s', %d, '%s', '%s', '%s', %d, %d)";
        sql = String.format(sql, newData.getNama(), newData.getMerk(), newData.getWarna(),newData.getCc(), newData.getFoto1(), newData.getFoto2(),newData.getFoto3(),newData.getHarga(), newData.getKapasitas());
        try {
            execute(sql);
            disconnectDB();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    
   
    
}

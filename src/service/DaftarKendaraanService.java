/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import helper.Helper;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import model.Kendaraan;
import repository.Repository;

/**
 *
 * @author aryuska
 */
public class DaftarKendaraanService {
    private Repository repo;
    private Helper helper;

    public DaftarKendaraanService() {
        repo = new Repository();
        helper = new Helper();
    }
    
    
    public void daftarKendaraan(String nama, String merk,String warna, String cc, String harga, String kapasitas, File img1, File img2,File img3) throws IOException, SQLException{
        String image1URL = helper.uploadImage(img1);
        String image2URL = helper.uploadImage(img2);
        String image3URL = helper.uploadImage(img3);
        
        int ccInt = Integer.parseInt(cc);
        int hargaInt = Integer.parseInt(harga);
        int kapasitasInt = Integer.parseInt(kapasitas);
        
        Kendaraan n = new Kendaraan(0,nama, merk,warna, ccInt, image1URL, image2URL, image3URL, hargaInt, kapasitasInt,0);
        
        
        repo.addKendaraan(n);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import helper.Helper;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Kendaraan;
import repository.Repository;
import view.PenyewaPageView;

/**
 *
 * @author Firdaus
 */
public class KendaraanService extends Repository {

    private Helper helper = new Helper();

    public void getDataKendaraan(PenyewaPageView view, String nama_kendaraan) {
        Kendaraan kendaraan = new Kendaraan();
        try {
            ArrayList<Kendaraan> detail_kendaraan = getDetail(nama_kendaraan);
            if (detail_kendaraan.size() > 0) {
                kendaraan = detail_kendaraan.get(0);
                helper.createAset(view, kendaraan);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public Kendaraan getDataKendaraan(String nama_kendaraan) {
        Kendaraan model_kendaraan = new Kendaraan();
        try {
            ArrayList<Kendaraan> data_kendaraan = getDetail(nama_kendaraan);
            if (data_kendaraan.size() > 0) {
                model_kendaraan = data_kendaraan.get(0);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return model_kendaraan;
    }
    
       public void daftarKendaraan(String nama, String merk,String warna, String cc, String harga, String kapasitas, File img1, File img2,File img3) throws IOException, SQLException{
        String image1URL = helper.uploadImage(img1);
        String image2URL = helper.uploadImage(img2);
        String image3URL = helper.uploadImage(img3);
        
        int ccInt = Integer.parseInt(cc);
        int hargaInt = Integer.parseInt(harga);
        int kapasitasInt = Integer.parseInt(kapasitas);
        
        Kendaraan n = new Kendaraan(0,nama, merk,warna, ccInt, image1URL, image2URL, image3URL, hargaInt, kapasitasInt,0);
        
        
        addKendaraan(n);
    }
       
       
    public void updateKendaraan(String nama, String merk,String warna, String cc, String harga, String kapasitas, File img1, File img2,File img3, String img1URL, String img2URL, String img3URL, int IDKendaraan) throws IOException, SQLException{
        Helper helper = new Helper();
        Repository repo = new Repository();
        String image1URL = img1URL;
        String image2URL = img2URL;
        String image3URL = img3URL;
        if(img1 != null){
             image1URL = helper.uploadImage(img1);
        }
        if (img2 != null){
            image2URL = helper.uploadImage(img2);
        }
        if (img3 != null){
            image3URL = helper.uploadImage(img3);
        }
        
        
        int ccInt = Integer.parseInt(cc);
        int hargaInt = Integer.parseInt(harga);
        int kapasitasInt = Integer.parseInt(kapasitas);
        
        Kendaraan n = new Kendaraan(IDKendaraan,nama, merk,warna, ccInt, image1URL, image2URL, image3URL, hargaInt, kapasitasInt,0);
        
        System.out.println(n);
        
        UpdateKendaraan(n);
    }
    
    
    public void updateStatus(int id, int status) throws SQLException{
         Repository repo = new Repository();
         
         repo.UpdateStatusKendaraan(id, status);
    }
    
    
    
    public Kendaraan getKendaraanByID(int id) throws SQLException{
         Kendaraan data = getKendaraanByIDRepo(id);
         return data;
    }
    
    public ArrayList<Kendaraan> getListKendaraan(String  q) throws SQLException{
         ArrayList<Kendaraan> data = getListKendaraanRepo(q);
         
         return data;
    }
    
    
    public void deleteKendaraan(int idKendaraan) throws SQLException{
        deleteKendaraanRepo(idKendaraan);
    }

}

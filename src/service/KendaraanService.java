/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import helper.Helper;
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

}

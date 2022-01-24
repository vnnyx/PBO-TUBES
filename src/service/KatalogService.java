/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import helper.Helper;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Kendaraan;
import view.KatalogKendaraan;

/**
 *
 * @author Firdaus
 */
public class KatalogService extends Helper{
    
//    private Helper helper = new Helper();

    public void katalogShow(KatalogKendaraan view, ArrayList<Kendaraan> kendaraan_data) throws SQLException, Exception {
        Kendaraan kendaraan1, kendaraan2, kendaraan3 = new Kendaraan();
        view.getPanelGambar1().setVisible(true);
        view.getPanelGambar2().setVisible(true);
        view.getPanelGambar3().setVisible(true);
        kendaraan1 = null;
        kendaraan2 = null;
        kendaraan3 = null;
        switch (kendaraan_data.size()) {
            case 0:
                if (kendaraan1 == null && kendaraan2 == null && kendaraan3 == null) {
                    view.getPanelGambar1().setVisible(false);
                    view.getPanelGambar2().setVisible(false);
                    view.getPanelGambar3().setVisible(false);
                }
                break;
            case 1:
                kendaraan1 = kendaraan_data.get(0);
                createAset(kendaraan1, view.getGambar1(), view.getHargaKendaraan1(),
                        view.getMerkKendaraan1(), view.getJmlPenumpang1());
                if (kendaraan2 == null && kendaraan3 == null) {
                    view.getPanelGambar2().setVisible(false);
                    view.getPanelGambar3().setVisible(false);
                }
                break;
            case 2:
                kendaraan1 = kendaraan_data.get(0);
                kendaraan2 = kendaraan_data.get(1);
                createAset(kendaraan1, view.getGambar1(), view.getHargaKendaraan1(),
                        view.getMerkKendaraan1(), view.getJmlPenumpang1());
                createAset(kendaraan2, view.getGambar2(), view.getHargaKendaraan2(),
                        view.getMerkKendaraan2(), view.getJmlPenumpang2());
                if (kendaraan3 == null) {
                    view.getPanelGambar3().setVisible(false);
                }
                break;
            default:
                kendaraan1 = kendaraan_data.get(0);
                kendaraan2 = kendaraan_data.get(1);
                kendaraan3 = kendaraan_data.get(2);
                createAset(kendaraan1, view.getGambar1(), view.getHargaKendaraan1(),
                        view.getMerkKendaraan1(), view.getJmlPenumpang1());
                createAset(kendaraan2, view.getGambar2(), view.getHargaKendaraan2(),
                        view.getMerkKendaraan2(), view.getJmlPenumpang2());
                createAset(kendaraan3, view.getGambar3(), view.getHargaKendaraan3(),
                        view.getMerkKendaraan3(), view.getJmlPenumpang3());
                break;
        }

    }
}

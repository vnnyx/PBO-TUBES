/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import helper.Helper;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JPanel;
import model.Kendaraan;
import model.Transaksi;
import repository.Repository;
import view.PenyewaPageView;

/**
 *
 * @author Firdaus
 */
public class PenyewaPageService extends Helper {

    private Repository repo = new Repository();

    public void katalogShow(PenyewaPageView view, ArrayList<Kendaraan> kendaraan_data) throws SQLException, Exception {
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

    public void swapPanel(PenyewaPageView view, JPanel panel) {
        JPanel main_panel = view.getMainPanel();
        main_panel.removeAll();
        main_panel.repaint();
        main_panel.revalidate();
        main_panel.add(panel);
        main_panel.repaint();
        main_panel.revalidate();
    }

    public void riwayatShow(PenyewaPageView view, ArrayList<Transaksi> transaksi_data) throws SQLException, Exception {
        Transaksi transaksi1, transaksi2 = new Transaksi();
        view.getCardPanel().setVisible(true);
        view.getCardPanel1().setVisible(true);
        transaksi1 = null;
        transaksi2 = null;
        switch (transaksi_data.size()) {
            case 0:
                if (transaksi1 == null && transaksi2 == null) {
                    view.getCardPanel().setVisible(false);
                    view.getCardPanel1().setVisible(false);
                }
                break;
            case 1:
                transaksi1 = transaksi_data.get(0);
                createAsetRiwayat(transaksi1, view.getImage(), view.getNamaKendaraan1(),
                        view.getTglMulai(), view.getTglSelesai(), view.getHargaSewa(), view.getStatus());
                if (transaksi2 == null) {
                    view.getCardPanel1().setVisible(false);
                }
                break;
            default:
                transaksi1 = transaksi_data.get(0);
                transaksi2 = transaksi_data.get(1);
                createAsetRiwayat(transaksi1, view.getImage(), view.getNamaKendaraan1(),
                        view.getTglMulai(), view.getTglSelesai(), view.getHargaSewa(), view.getStatus());
                createAsetRiwayat(transaksi2, view.getImage1(), view.getNamaKendaraan2(),
                        view.getTglMulai1(), view.getTglSelesai1(), view.getHargaSewa1(), view.getStatus1());
                break;
        }

    }

    public int getPageKatalog() {
        int page =0;
        try {
            int totalData = repo.getTotalDataKendaraan();
            page = (int) Math.ceil(totalData / 3);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return (int) page;
    }

    public int getPageTransaksi(String username) {
        int page =0;
        try {
            int totalData = repo.getTotalDataTransaksi(username);
            page = (int) Math.ceil(totalData / 2);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return (int) page;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import helper.Helper;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Kendaraan;
import model.Transaksi;
import repository.Repository;
import service.PenyewaPageService;
import service.KendaraanService;
import view.PenyewaPageView;

/**
 *
 * @author Firdaus
 */
public class PenyewaPageController implements MouseListener, ActionListener {

    private int total_page_katalog;
    private int total_page_riwayat;
    private int page_katalog = 1;
    private int page_riwayat = 1;
    private PenyewaPageView view_penyewa;
    private String username;
    private String email;
    private String url;
    private PenyewaPageService penyewaPageService;
    private KendaraanService kendaraanService;
    private Repository repo;
    private Helper helper;
    private Kendaraan model_kendaraan;
    private Transaksi model_transaksi;
    private String nama_kendaraan;

    public PenyewaPageController() {
    }

    public PenyewaPageController(String username, String email, String url) {
        view_penyewa = new PenyewaPageView();
        penyewaPageService = new PenyewaPageService();
        kendaraanService = new KendaraanService();
        repo = new Repository();
        helper = new Helper();
        view_penyewa.setVisible(true);
        this.username = username;
        this.email = email;
        this.url = url;
        total_page_riwayat = penyewaPageService.getPageTransaksi(this.username);
        total_page_katalog = penyewaPageService.getPageKatalog();
        int offset_katalog = (page_katalog - 1) * 3;
        penyewaPageService.swapPanel(view_penyewa, view_penyewa.getKatalogKendaraan());
        view_penyewa.addMouseListener(this);
        view_penyewa.addActionListener(this);
        try {
            penyewaPageService.katalogShow(view_penyewa, repo.getDataKendaraan(offset_katalog));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        showProfile();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Object src = e.getSource();
        if (src.equals(view_penyewa.getPanelGambar1())) {
            nama_kendaraan = view_penyewa.getMerkKendaraan1().getText();
            detailKendaraanClicked(nama_kendaraan);
        } else if (src.equals(view_penyewa.getPanelGambar2())) {
            nama_kendaraan = view_penyewa.getMerkKendaraan2().getText();
            detailKendaraanClicked(nama_kendaraan);
        } else if (src.equals(view_penyewa.getPanelGambar3())) {
            nama_kendaraan = view_penyewa.getMerkKendaraan3().getText();
            detailKendaraanClicked(nama_kendaraan);
        } else if (src.equals(view_penyewa.getPreviousPage())) {
            if (page_katalog > 1) {
                previousPageClicked();
            }
        } else if (src.equals(view_penyewa.getNextPage())) {
            if (page_katalog <= total_page_katalog && page_katalog >= 1) {
                nextPageClicked();
            }
        } else if (src.equals(view_penyewa.getCheckoutRental())) {
            checkoutRentalClicked();
        } else if (src.equals(view_penyewa.getRentalKendaraan())) {
            rentalKendaraanClicked();
        } else if (src.equals(view_penyewa.getExitBtn())) {
            exitBtnClicked();
        } else if (src.equals(view_penyewa.getBranchKatalog()) || src.equals(view_penyewa.getBranchKatalog1())) {
            branchKatalogClicked();
        } else if (src.equals(view_penyewa.getBranchDetailKendaraan())) {
            branchDetailClicked();
        } else if (src.equals(view_penyewa.getLihatRiwayatRental()) || src.equals(view_penyewa.getRiwayatRental())) {
            riwayatRentalClicked();
        } else if (src.equals(view_penyewa.getKatalog_Kendaraan())) {
            katalogKendaraanClicked();
        } else if (src.equals(view_penyewa.getNextPage1())) {
            if (page_riwayat <= total_page_riwayat && page_riwayat >= 1) {
                riwayatNextClicked();
            }
        } else if (src.equals(view_penyewa.getPreviousPage1())) {
            if (page_riwayat > 1) {
                riwayatPrevClicked();
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src.equals(view_penyewa.getSearchBtn())) {
            searchBtnPerformed();
        } else if (src.equals(view_penyewa.getListHari())) {
            listActionPerformed();
        }
    }

    public void showProfile() {
        view_penyewa.getUsername().setText(username);
        view_penyewa.getEmail().setText(email);
        try {
            view_penyewa.getPp().setIcon(helper.getImage(view_penyewa.getPp(), url));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void showList(String nama) throws SQLException, Exception {
        kendaraanService.getDataKendaraan(view_penyewa, nama);
    }

    public void detailKendaraanClicked(String merk) {
        view_penyewa.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        try {
            showList(merk);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        penyewaPageService.swapPanel(view_penyewa, view_penyewa.getDetailKendaraan());
        view_penyewa.setCursor(Cursor.getDefaultCursor());
    }

    public void searchBtnPerformed() {
        int offset_katalog = (page_katalog - 1) * 3;
        String search = view_penyewa.getSearchBar().getText();
        view_penyewa.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        if (search.isEmpty()) {
            try {
                penyewaPageService.katalogShow(view_penyewa, repo.getDataKendaraan(offset_katalog));
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        } else {
            try {
                ArrayList<Kendaraan> data_kendaraan = repo.getSearchDataKendaraan(offset_katalog, search);
                if (data_kendaraan.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Nama kendaraan tidak ditemukan");
                } else {
                    penyewaPageService.katalogShow(view_penyewa, data_kendaraan);
                }
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
        view_penyewa.setCursor(Cursor.getDefaultCursor());
    }

    public void previousPageClicked() {
        String search = view_penyewa.getSearchBar().getText();
        page_katalog -= 1;
        int offset_katalog = (page_katalog - 1) * 3;
        view_penyewa.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        try {
            if (search.isEmpty()) {
                penyewaPageService.katalogShow(view_penyewa, repo.getDataKendaraan(offset_katalog));
            } else {
                penyewaPageService.katalogShow(view_penyewa, repo.getSearchDataKendaraan(offset_katalog, search));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        view_penyewa.setCursor(Cursor.getDefaultCursor());
    }

    public void nextPageClicked() {
        String search = view_penyewa.getSearchBar().getText();
        page_katalog += 1;
        int offset_katalog = (page_katalog - 1) * 3;
        view_penyewa.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        try {
            if (search.isEmpty()) {
                penyewaPageService.katalogShow(view_penyewa, repo.getDataKendaraan(offset_katalog));
            } else {
                penyewaPageService.katalogShow(view_penyewa, repo.getSearchDataKendaraan(offset_katalog, search));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        view_penyewa.setCursor(Cursor.getDefaultCursor());
    }

    public void rentalKendaraanClicked() {
        view_penyewa.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        showDetailCheckout();
        penyewaPageService.swapPanel(view_penyewa, view_penyewa.getPagePembayaran());
        view_penyewa.setCursor(Cursor.getDefaultCursor());
    }

    public void showDetailCheckout() {
        this.model_kendaraan = kendaraanService.getDataKendaraan(nama_kendaraan);
        String harga = helper.priceFormat(model_kendaraan.getHarga_sewa());
        view_penyewa.getHargaHarian().setText(harga);
        view_penyewa.getHargaCheckout().setText(harga);
        view_penyewa.getHargaTotal().setText(harga);
        view_penyewa.getUsername().setText(username);
        view_penyewa.getEmail().setText(email);
        view_penyewa.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        try {
            view_penyewa.getPp().setIcon(helper.getImage(view_penyewa.getPp(), url));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        view_penyewa.setCursor(Cursor.getDefaultCursor());
    }

    public void listActionPerformed() {
        String selectedValue = view_penyewa.getListHari().getSelectedItem().toString();
        int hari = Integer.parseInt(selectedValue.substring(0, 1));
        System.out.println(hari);
        int total = hari * model_kendaraan.getHarga_sewa();
        view_penyewa.getHargaCheckout().setText(helper.priceFormat(total));
        view_penyewa.getHargaTotal().setText(helper.priceFormat(total));
    }

    public void checkoutRentalClicked() {
        String selectedValue = view_penyewa.getListHari().getSelectedItem().toString();
        int hari = Integer.parseInt(selectedValue.substring(0, 1));
        int total = hari * model_kendaraan.getHarga_sewa();
        LocalDate mulai = LocalDate.now();
        LocalDate akhir = mulai.plusDays(hari);
        model_transaksi = new Transaksi(username, model_kendaraan.getFoto_1(), mulai, akhir, nama_kendaraan, hari, total);
        view_penyewa.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        try {
            repo.addTransaksi(model_transaksi);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        penyewaPageService.swapPanel(view_penyewa, view_penyewa.getPopupSukses());
        view_penyewa.setCursor(Cursor.getDefaultCursor());
    }

    public void katalogKendaraanClicked() {
        view_penyewa.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        penyewaPageService.swapPanel(view_penyewa, view_penyewa.getKatalogKendaraan());
        view_penyewa.setCursor(Cursor.getDefaultCursor());
    }

    public void showRiwayatRental() {
        int offset_riwayat = (page_riwayat - 1) * 2;
        try {
            penyewaPageService.riwayatShow(view_penyewa, repo.getDataTransaksi(offset_riwayat, username));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        penyewaPageService.swapPanel(view_penyewa, view_penyewa.getRiwayat());
    }

    public void riwayatPrevClicked() {
        page_riwayat -= 1;
        int offset_riwayat = (page_riwayat - 1) * 2;
        view_penyewa.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        try {
            penyewaPageService.riwayatShow(view_penyewa, repo.getDataTransaksi(offset_riwayat, username));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        view_penyewa.setCursor(Cursor.getDefaultCursor());
    }

    public void riwayatNextClicked() {
        page_riwayat += 1;
        int offset_riwayat = (page_riwayat - 1) * 2;
        view_penyewa.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        try {
            penyewaPageService.riwayatShow(view_penyewa, repo.getDataTransaksi(offset_riwayat, username));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        view_penyewa.setCursor(Cursor.getDefaultCursor());
    }

    public void riwayatRentalClicked() {
        view_penyewa.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        showRiwayatRental();
        view_penyewa.setCursor(Cursor.getDefaultCursor());
    }

    public void branchKatalogClicked() {
        penyewaPageService.swapPanel(view_penyewa, view_penyewa.getRiwayat());
    }

    public void branchDetailClicked() {
        penyewaPageService.swapPanel(view_penyewa, view_penyewa.getRiwayat());
    }

    public void exitBtnClicked() {
        JOptionPane.showMessageDialog(null, "Berhasil keluar");
        view_penyewa.dispose();
        new LoginController();
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import helper.Helper;
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
    private int offset = 0;

    public PenyewaPageController(String username, String email, String url) {
        this.username = username;
        this.email = email;
        this.url = url;
        view_penyewa = new PenyewaPageView();
        penyewaPageService = new PenyewaPageService();
        kendaraanService = new KendaraanService();
        repo = new Repository();
        helper = new Helper();
        penyewaPageService.swapPanel(view_penyewa, view_penyewa.getKatalogKendaraan());
        view_penyewa.setVisible(true);
        view_penyewa.addMouseListener(this);
        view_penyewa.addActionListener(this);
        try {
            penyewaPageService.katalogShow(view_penyewa, repo.getDataKendaraan(offset));
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
            previousPageClicked();
        } else if (src.equals(view_penyewa.getNextPage())) {
            nextPageClicked();
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
        try {
            showList(merk);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        penyewaPageService.swapPanel(view_penyewa, view_penyewa.getDetailKendaraan());
    }

    public void searchBtnPerformed() {
        offset = 0;
        String search = view_penyewa.getSearchBar().getText();
        if (search.isEmpty()) {
            try {
                penyewaPageService.katalogShow(view_penyewa, repo.getDataKendaraan(offset));
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        } else {
            try {
                ArrayList<Kendaraan> data_kendaraan = repo.getSearchDataKendaraan(offset, search);
                if (data_kendaraan.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Nama kendaraan tidak ditemukan");
                } else {
                    penyewaPageService.katalogShow(view_penyewa, data_kendaraan);
                }
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public void previousPageClicked() {
        String search = view_penyewa.getSearchBar().getText();
        offset -= 3;
        try {
            if (search.isEmpty()) {
                penyewaPageService.katalogShow(view_penyewa, repo.getDataKendaraan(offset));
            } else {
                penyewaPageService.katalogShow(view_penyewa, repo.getSearchDataKendaraan(offset, search));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void nextPageClicked() {
        String search = view_penyewa.getSearchBar().getText();
        offset += 3;
        try {
            if (search.isEmpty()) {
                penyewaPageService.katalogShow(view_penyewa, repo.getDataKendaraan(offset));
            } else {
                penyewaPageService.katalogShow(view_penyewa, repo.getSearchDataKendaraan(offset, search));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void rentalKendaraanClicked() {
        showDetailCheckout();
        penyewaPageService.swapPanel(view_penyewa, view_penyewa.getPagePembayaran());
    }

    public void showDetailCheckout() {
        this.model_kendaraan = kendaraanService.getDataKendaraan(nama_kendaraan);
        String harga = helper.priceFormat(model_kendaraan.getHarga_sewa());
        view_penyewa.getHargaHarian().setText(harga);
        view_penyewa.getHargaCheckout().setText(harga);
        view_penyewa.getHargaTotal().setText(harga);
        view_penyewa.getUsername().setText(username);
        view_penyewa.getEmail().setText(email);
        try {
            view_penyewa.getPp().setIcon(helper.getImage(view_penyewa.getPp(), url));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
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
        LocalDate akhir = LocalDate.of(mulai.getYear(), mulai.getMonth(), mulai.getDayOfMonth() + hari);
        model_transaksi = new Transaksi(username, model_kendaraan.getFoto_1(), mulai, akhir, nama_kendaraan, hari, total);
        try {
            repo.addTransaksi(model_transaksi);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void branchKatalogClicked() {
        penyewaPageService.swapPanel(view_penyewa, view_penyewa.getKatalogKendaraan());
    }

    public void branchDetailClicked() {
        penyewaPageService.swapPanel(view_penyewa, view_penyewa.getDetailKendaraan());
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

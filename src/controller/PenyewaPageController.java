/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import helper.Helper;
import java.awt.Cursor;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import model.Kendaraan;
import model.Transaksi;
import repository.Repository;
import service.PenyewaPageService;
import service.KendaraanService;
import view.PenyewaPageView;
import view.Tes;

/**
 *
 * @author Firdaus
 */
public class PenyewaPageController implements MouseListener, ActionListener {

    protected PenyewaPageView view_penyewa;
    protected String username;
    private String email;
    private String url;
    private PenyewaPageService penyewaPageService;
    private KendaraanService kendaraanService;
    private Repository repo;
    private Helper helper;
    private Kendaraan model_kendaraan;
    private Transaksi model_transaksi;
    private String nama_kendaraan;
    private Tes[] tes;
    private int offset_katalog = 0;
    private int offset_riwayat = 0;

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
        } else if (src.equals(view_penyewa.getLihatRiwayatRental()) || src.equals(view_penyewa.getRiwayatRental())) {
            riwayatRentalClicked();
        } else if (src.equals(view_penyewa.getKatalog_Kendaraan())) {
            katalogKendaraanClicked();
        } else if (src.equals(view_penyewa.getNextPage1())) {
            riwayatNextClicked();
        } else if (src.equals(view_penyewa.getPreviousPage1())) {
            riwayatPrevClicked();
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
        offset_katalog = 0;
        String search = view_penyewa.getSearchBar().getText();
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
    }

    public void previousPageClicked() {
        String search = view_penyewa.getSearchBar().getText();
        offset_katalog -= 3;
        try {
            if (search.isEmpty()) {
                penyewaPageService.katalogShow(view_penyewa, repo.getDataKendaraan(offset_katalog));
            } else {
                penyewaPageService.katalogShow(view_penyewa, repo.getSearchDataKendaraan(offset_katalog, search));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void nextPageClicked() {
        String search = view_penyewa.getSearchBar().getText();
        offset_katalog += 3;
        try {
            if (search.isEmpty()) {
                penyewaPageService.katalogShow(view_penyewa, repo.getDataKendaraan(offset_katalog));
            } else {
                penyewaPageService.katalogShow(view_penyewa, repo.getSearchDataKendaraan(offset_katalog, search));
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
        LocalDate akhir = mulai.plusDays(hari);
        model_transaksi = new Transaksi(username, model_kendaraan.getFoto_1(), mulai, akhir, nama_kendaraan, hari, total);
        try {
            repo.addTransaksi(model_transaksi);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        penyewaPageService.swapPanel(view_penyewa, view_penyewa.getPopupSukses());
    }

    public void katalogKendaraanClicked() {
        penyewaPageService.swapPanel(view_penyewa, view_penyewa.getKatalogKendaraan());
    }

    public void showRiwayatRental() {
        try {
            penyewaPageService.riwayatShow(view_penyewa, repo.getDataTransaksi(offset_riwayat, username));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        penyewaPageService.swapPanel(view_penyewa, view_penyewa.getRiwayat());
    }

    public void riwayatPrevClicked() {
        offset_riwayat -= 2;
        try {
            penyewaPageService.riwayatShow(view_penyewa, repo.getDataTransaksi(offset_riwayat, username));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void riwayatNextClicked() {
        offset_riwayat += 2;
        try {
            penyewaPageService.riwayatShow(view_penyewa, repo.getDataTransaksi(offset_riwayat, username));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void riwayatRentalClicked() {
        view_penyewa.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        createList();
        view_penyewa.getKatalogKendaraan().setVisible(false);
        view_penyewa.getRiwayatv2().setVisible(true);
        view_penyewa.setCursor(Cursor.getDefaultCursor());
//        showRiwayatRental();
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

    public void createList() {
        try {
            ArrayList<Transaksi> transaksi = repo.getDataTransaksi(username);
            System.out.println(transaksi);
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridwidth = GridBagConstraints.REMAINDER;

            if (transaksi.isEmpty()) {
                JLabel label = new JLabel();
//                BufferedImage img = ImageIO.read(getClass().getResource("/icon/not-found.jpg"));
//                Image dimg = img.getScaledInstance(700, 500, Image.SCALE_SMOOTH);
//                ImageIcon icon = new ImageIcon(dimg);
//                label.setIcon(icon);
                view_penyewa.getScroll().setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
                view_penyewa.getScroll().setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
                view_penyewa.getPanelItem().add(label);
            } else {
                System.out.println("tes");
                view_penyewa.getScroll().setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                view_penyewa.getScroll().setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
                tes = new Tes[transaksi.size()];
                for (int i = 0; i < transaksi.size(); i++) {
                    Transaksi v = transaksi.get(i);
                    tes[i] = new Tes(v.getFoto_kendaraan(), v.getNama_kendaraan(), v.getMulai_sewa(), v.getSelesai_sewa(), v.getTotal());
                    tes[i].addMouseListener(this);
                    view_penyewa.getPanelItem().add(tes[i], gbc);
                }
            }

        } catch (Exception ex) {

        }
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

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
import java.time.LocalDate;
import java.util.ArrayList;
import model.Kendaraan;
import model.Transaksi;
import repository.Repository;
import view.PembayaranRental;

/**
 *
 * @author Firdaus
 */
public class CheckoutController implements MouseListener, ActionListener {

    private PembayaranRental view_pembarayan;
    private String username;
    private String email;
    private String url;
    private String nama_kendaraan;
    private Helper helper;
    private Repository repo;
    private Kendaraan model_kendaraan;
    private Transaksi model_transaksi;

    public CheckoutController(String username, String email, String url, String nama_kendaraan) {
        this.username = username;
        this.email = email;
        this.url = url;
        this.nama_kendaraan = nama_kendaraan;
        repo = new Repository();
        view_pembarayan = new PembayaranRental();
        view_pembarayan.setVisible(true);
        helper = new Helper();
        view_pembarayan.addMouseListener(this);
        view_pembarayan.addActionListener(this);
        showDetail();
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        Object src = me.getSource();
        if (src.equals(view_pembarayan.getCheckoutRental())) {
            checkoutRentalClicked();
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object src = ae.getSource();
        if (src.equals(view_pembarayan.getListHari())) {
            System.out.println("Test");
            listActionPerformed();
        }
    }

    public void getModelKendaraan() {
        try {
            ArrayList<Kendaraan> data_kendaraan = repo.getDetail(nama_kendaraan);
            if (data_kendaraan.size() > 0) {
                this.model_kendaraan = data_kendaraan.get(0);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void listActionPerformed() {
        String selectedValue = view_pembarayan.getListHari().getSelectedItem().toString();
        int hari = Integer.parseInt(selectedValue.substring(0,1));
        System.out.println(hari);
        int total = hari * model_kendaraan.getHarga_sewa();
        view_pembarayan.getHargaCheckout().setText(helper.priceFormat(total));
        view_pembarayan.getHargaTotal().setText(helper.priceFormat(total));
    }

    public void showDetail() {
        getModelKendaraan();
        String harga = helper.priceFormat(model_kendaraan.getHarga_sewa());
        view_pembarayan.getHargaHarian().setText(harga);
        view_pembarayan.getHargaCheckout().setText(harga);
        view_pembarayan.getHargaTotal().setText(harga);
        view_pembarayan.getUsername().setText(username);
        view_pembarayan.getEmail().setText(email);
        try {
            view_pembarayan.getPp().setIcon(helper.getImage(view_pembarayan.getPp(), url));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void checkoutRentalClicked() {
        String selectedValue = view_pembarayan.getListHari().getSelectedItem().toString();
        int hari = Integer.parseInt(selectedValue.substring(0,1));
        int total = hari * model_kendaraan.getHarga_sewa();
        LocalDate mulai = LocalDate.now();
        LocalDate akhir = LocalDate.of(mulai.getYear(), mulai.getMonth(), mulai.getDayOfMonth()+hari);
        model_transaksi = new Transaksi(username, model_kendaraan.getFoto_1(), mulai, akhir, nama_kendaraan, hari, total);
        try {
            repo.addTransaksi(model_transaksi); 
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
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

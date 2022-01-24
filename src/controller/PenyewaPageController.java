/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import database.Database;
import helper.Helper;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Kendaraan;
import repository.Repository;
import service.KatalogService;
import view.KatalogKendaraan;
import view.DetailKendaraan;

/**
 *
 * @author Firdaus
 */
public class PenyewaPageController extends Database implements MouseListener, ActionListener {

    private KatalogKendaraan view_catalog;
    private DetailKendaraan view_detail;
    private Helper helper;
    private Repository repo;
    private String username;
    private String email;
    private String url;
    private KatalogService katalogService;
    private int offset = 0;

    public PenyewaPageController(String username, String email, String url) {
        katalogService = new KatalogService();
        this.username = username;
        this.email = email;
        this.url = url;
        repo = new Repository();
        helper = new Helper();
        view_catalog = new KatalogKendaraan();
        view_detail = new DetailKendaraan();
        view_catalog.setVisible(true);
        view_catalog.addMouseListener(this);
        view_detail.addMouseListener(this);
        view_catalog.addActionListener(this);
        profile();
        try {
            katalogService.katalogShow(view_catalog, repo.getDataKendaraan(offset));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void profile() {
        view_catalog.getUsername().setText(username);
        view_catalog.getEmail().setText(email);
        try {
            view_catalog.getPp().setIcon(helper.getImage(view_catalog.getPp(), url));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src.equals(view_catalog.getSearchBtn())) {
            searchBtnPerformed();
        }
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        Object src = me.getSource();
        if (src.equals(view_catalog.getPanelGambar1())) {
            detailKendaraanClicked(view_catalog.getMerkKendaraan1().getText());
        } else if (src.equals(view_detail.getBranchKatalog())) {
            branchKatalogClicked();
        } else if (src.equals(view_catalog.getNextPage())) {
            nextPageClicked();
        } else if (src.equals(view_catalog.getPanelGambar2())) {
            detailKendaraanClicked(view_catalog.getMerkKendaraan2().getText());
        } else if (src.equals(view_catalog.getPanelGambar3())) {
            detailKendaraanClicked(view_catalog.getMerkKendaraan3().getText());
        } else if (src.equals(view_catalog.getPreviousPage())) {
            previousPageClicked();
        } else if (src.equals(view_catalog.getExitBtn()) || src.equals(view_detail.getExitBtn())) {
            exitBtnClicked();
        }
    }

    public void searchBtnPerformed() {
        offset = 0;
        String search = view_catalog.getSearchBar().getText();
        try {
            ArrayList<Kendaraan> data_kendaraan = repo.getSearchDataKendaraan(offset, search);
            if (data_kendaraan.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Nama kendaraan tidak ditemukan");
            } else if (search.isEmpty()) {
                katalogService.katalogShow(view_catalog, repo.getDataKendaraan(offset));
            } else {
                katalogService.katalogShow(view_catalog, data_kendaraan);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void showList(String nama) throws SQLException, Exception {
        Kendaraan kendaraan = new Kendaraan();
        ArrayList<Kendaraan> detail_kendaraan = repo.getDetail(nama);
        if (detail_kendaraan.size() > 0) {
            kendaraan = detail_kendaraan.get(0);
            helper.createAset(view_detail, kendaraan);
        }

    }

    public void previousPageClicked() {
        String search = view_catalog.getSearchBar().getText();
        offset -= 3;
        try {
            if (search.isEmpty()) {
                katalogService.katalogShow(view_catalog, repo.getDataKendaraan(offset));
            } else {
                katalogService.katalogShow(view_catalog, repo.getSearchDataKendaraan(offset, search));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void nextPageClicked() {
        String search = view_catalog.getSearchBar().getText();
        offset += 3;
        try {
            if (search.isEmpty()) {
                katalogService.katalogShow(view_catalog, repo.getDataKendaraan(offset));
            } else {
                katalogService.katalogShow(view_catalog, repo.getSearchDataKendaraan(offset, search));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void branchKatalogClicked() {
        view_detail.dispose();
    }

    public void detailKendaraanClicked(String merk) {
        try {
            showList(merk);
            view_detail.getUsername().setText(username);
            view_detail.getEmail().setText(email);
            view_detail.getPp().setIcon(helper.getImage(view_detail.getPp(), url));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        view_detail.setVisible(true);
    }

    public void exitBtnClicked() {
        JOptionPane.showMessageDialog(null, "Berhasil keluar");
        view_catalog.dispose();
        view_detail.dispose();
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

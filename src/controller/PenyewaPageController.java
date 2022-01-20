/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import database.Database;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import model.Kendaraan;
import view.KatalogKendaraan;
import view.DetailKendaraan;

/**
 *
 * @author Firdaus
 */
public class PenyewaPageController extends Database implements MouseListener {

    private KatalogKendaraan view_catalog;
    private DetailKendaraan view_detail;
    private int page = 1;

    public PenyewaPageController() {
        view_catalog = new KatalogKendaraan();
        view_detail = new DetailKendaraan();
        view_catalog.setVisible(true);
        view_catalog.addMouseListener(this);
        view_detail.addMouseListener(this);
        try {
            initData();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        Object src = me.getSource();
        if (src.equals(view_catalog.getPanelGambar1())) {
            detailKendaraanClicked();
        } else if (src.equals(view_detail.getBranchKatalog())) {
            branchKatalogClicked();
        } else if (src.equals(view_catalog.getNextPage())) {
            nextPageClicked();
        } else if (src.equals(view_catalog.getPanelGambar2())) {
            detailKendaraanClicked2();
        } else if (src.equals(view_catalog.getPanelGambar3())) {
            detailKendaraanClicked3();
        } else if (src.equals(view_catalog.getPreviousPage())) {
            previousPageClicked();
        }
    }

    public ArrayList<Kendaraan> getData(int limit, int offset) throws SQLException {
        ArrayList<Kendaraan> kendaraan = new ArrayList<>();
        connectDB();
        String sql = "SELECT * FROM kendaraan LIMIT %s OFFSET %s";
        sql = String.format(sql, limit, offset);
        executeQuery(sql);
        while (rs.next()) {
            String nama_kendaraan = rs.getString("nama_kendaraan");
            int harga_sewa = rs.getInt("harga_sewa");
            String foto_1 = rs.getString("foto_1");
            int kapasitas = rs.getInt("kapasitas");
            kendaraan.add(new Kendaraan(nama_kendaraan, foto_1, harga_sewa, kapasitas));
        }
        disconnectDB();
        return kendaraan;
    }

    public ArrayList<Kendaraan> getDetail(String namaKendaraan) throws SQLException {
        ArrayList<Kendaraan> kendaraan = new ArrayList<>();
        connectDB();
        String sql = "SELECT * FROM kendaraan WHERE nama_kendaraan='%s' LIMIT 1";
        sql = String.format(sql, namaKendaraan);
        executeQuery(sql);
        while (rs.next()) {
            String nama_kendaraan = rs.getString("nama_kendaraan");
            int harga_sewa = rs.getInt("harga_sewa");
            String foto_1 = rs.getString("foto_1");
            String foto_2 = rs.getString("foto_2");
            String foto_3 = rs.getString("foto_3");
            String warna = rs.getString("warna_kendaraan");
            String merk = rs.getString("merk_kendaraan");
            int cc = rs.getInt("cc_kendaraan");
            int kapasitas = rs.getInt("kapasitas");
            kendaraan.add(new Kendaraan(nama_kendaraan, merk, warna, cc, foto_1, foto_2, foto_3, harga_sewa, kapasitas));
        }
        disconnectDB();
        return kendaraan;
    }

    public ImageIcon getIcon(JLabel label, String path) {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(path));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        Image dimg = img.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon icon = new ImageIcon(dimg);
        return icon;
    }

    public void createAset(Kendaraan kendaraan, JLabel icon, JLabel harga, JLabel nama, JLabel kapasitas) {
        String path = "D:\\Gambar\\deye-eyed-patrick-prog4.jpg"; //Sementara
        icon.setIcon(getIcon(icon, path));
        harga.setText(priceFormat(kendaraan.getHarga_sewa()));
        nama.setText(kendaraan.getNama_kendaraan());
        kapasitas.setText(String.valueOf(kendaraan.getKapasitas()));
    }

    public String priceFormat(int price) {
        String harga = String.valueOf(price);
        return harga.substring(0, 3) + "." + harga.substring(3, 6) + ",00";
    }

    public void initData() throws SQLException {
        int limit = 3;
        int offset = (page - 1) * limit;
        Kendaraan kendaraan1, kendaraan2, kendaraan3 = new Kendaraan();
        view_catalog.getPanelGambar1().setVisible(true);
        view_catalog.getPanelGambar2().setVisible(true);
        view_catalog.getPanelGambar3().setVisible(true);
        kendaraan1 = null;
        kendaraan2 = null;
        kendaraan3 = null;
        ArrayList<Kendaraan> kendaraan_data = getData(limit, offset);
        switch (kendaraan_data.size()) {
            case 0:
                System.out.println("Masuk case 0");
                if (kendaraan1 == null && kendaraan2 == null && kendaraan3 == null) {
                    view_catalog.getPanelGambar1().setVisible(false);
                    view_catalog.getPanelGambar2().setVisible(false);
                    view_catalog.getPanelGambar3().setVisible(false);
                }
                break;
            case 1:
                System.out.println("Masuk case 1");
                kendaraan1 = kendaraan_data.get(0);
                createAset(kendaraan1, view_catalog.getGambar1(), view_catalog.getHargaKendaraan1(),
                        view_catalog.getMerkKendaraan1(), view_catalog.getJmlPenumpang1());
                if (kendaraan2 == null && kendaraan3 == null) {
                    view_catalog.getPanelGambar2().setVisible(false);
                    view_catalog.getPanelGambar3().setVisible(false);
                }
                break;
            case 2:
                System.out.println("Masuk case 2");
                kendaraan1 = kendaraan_data.get(0);
                kendaraan2 = kendaraan_data.get(1);
                createAset(kendaraan1, view_catalog.getGambar1(), view_catalog.getHargaKendaraan1(),
                        view_catalog.getMerkKendaraan1(), view_catalog.getJmlPenumpang1());
                createAset(kendaraan2, view_catalog.getGambar2(), view_catalog.getHargaKendaraan2(),
                        view_catalog.getMerkKendaraan2(), view_catalog.getJmlPenumpang2());
                if (kendaraan3 == null) {
                    view_catalog.getPanelGambar3().setVisible(false);
                }
                break;
            default:
                System.out.println("Masuk case default");
                kendaraan1 = kendaraan_data.get(0);
                kendaraan2 = kendaraan_data.get(1);
                kendaraan3 = kendaraan_data.get(2);
                createAset(kendaraan1, view_catalog.getGambar1(), view_catalog.getHargaKendaraan1(),
                        view_catalog.getMerkKendaraan1(), view_catalog.getJmlPenumpang1());
                createAset(kendaraan2, view_catalog.getGambar2(), view_catalog.getHargaKendaraan2(),
                        view_catalog.getMerkKendaraan2(), view_catalog.getJmlPenumpang2());
                createAset(kendaraan3, view_catalog.getGambar3(), view_catalog.getHargaKendaraan3(),
                        view_catalog.getMerkKendaraan3(), view_catalog.getJmlPenumpang3());
                break;
        }

    }

    public void createAset(DetailKendaraan view, Kendaraan kendaraan) {
        String path = "D:\\Gambar\\deye-eyed-patrick-prog4.jpg";
        view.getNamaKendaraan().setText(kendaraan.getNama_kendaraan());
        view.getMerkKendaraan().setText(kendaraan.getMerk_kendaraan());
        view.getWarnaKendaraan().setText(kendaraan.getWarna_kendaraan());
        view.getCcKendaraan().setText(String.valueOf(kendaraan.getCc_kendaraan()));
        view.getGambar1().setIcon(getIcon(view.getGambar1(), path));
        view.getGambar2().setIcon(getIcon(view.getGambar2(), path));
        view.getGambar3().setIcon(getIcon(view.getGambar3(), path));
        view.getHarga().setText(priceFormat(kendaraan.getHarga_sewa()));
        view.getKapasitasKendaraan().setText(String.valueOf(kendaraan.getKapasitas()));
    }

    public void showList(String nama) throws SQLException {
        Kendaraan kendaraan = new Kendaraan();
        ArrayList<Kendaraan> detail_kendaraan = getDetail(nama);
        if (detail_kendaraan.size() > 0) {
            kendaraan = detail_kendaraan.get(0);
            createAset(view_detail, kendaraan);
        }

    }

    public void previousPageClicked() {
        page--;
        try {
            initData();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void nextPageClicked() {
        page++;
        try {
            initData();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void branchKatalogClicked() {
        new PenyewaPageController();
        view_detail.dispose();
    }

    public void detailKendaraanClicked() {
        String merk = view_catalog.getMerkKendaraan1().getText();
        try {
            showList(merk);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        view_detail.setVisible(true);
        view_catalog.dispose();
    }

    public void detailKendaraanClicked2() {
        String merk = view_catalog.getMerkKendaraan2().getText();
        try {
            showList(merk);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        view_detail.setVisible(true);
        view_catalog.dispose();
    }

    public void detailKendaraanClicked3() {
        String merk = view_catalog.getMerkKendaraan3().getText();
        try {
            showList(merk);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        view_detail.setVisible(true);
        view_catalog.dispose();
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

package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import database.Database;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author aryuska
 */
public class DaftarKendaraanController extends Database implements MouseListener, ActionListener {

    @Override
    public void mouseClicked(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

//    private final MenuUtamaDaftarKendaraan viewDaftar;
//    private final Helper helper;
//    private final DaftarKendaraanService daftarKendaraanService;
//
//    public DaftarKendaraanController() {
//        helper = new Helper();
//        viewDaftar = new MenuUtamaDaftarKendaraan();
//        viewDaftar.setVisible(true);
//        viewDaftar.addActionListener(this);
//        daftarKendaraanService = new DaftarKendaraanService();
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        Object src = e.getSource();
//        if (src.equals(viewDaftar.getSave())) {
//            try {
//                daftarKendaraanActionPerformed();
//            } catch (IOException ex) {
//                Logger.getLogger(DaftarKendaraanController.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            viewDaftar.setVisible(false);
//            new DaftarKendaraanSukses().setVisible(true);
//        }
//    }
//
//    public void daftarKendaraanActionPerformed() throws IOException, SQLException {
//        String getNama = viewDaftar.getNamaKendaraan().getText();
//        String getMerk = viewDaftar.getMerkKendaraan().getSelectedItem();
//        String getWarna = viewDaftar.getWarnaKendaraan().getText();
//        String getCC = viewDaftar.getCcKendaraan().getSelectedItem();
//        String getHarga = viewDaftar.getHargaKendaraan().getText();
//        String getKapasitas = viewDaftar.getKapasitas();
//        File getImage1 = viewDaftar.getImage1();
//        File getImage2 = viewDaftar.getImage2();
//        File getImage3 = viewDaftar.getImage3();
//
//        daftarKendaraanService.daftarKendaraan(getNama, getMerk, getWarna, getCC, getHarga, getKapasitas, getImage1, getImage2, getImage3);
//        
//        
//    }
//
//    @Override
//    public void mouseClicked(MouseEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public void mousePressed(MouseEvent e) {
//         Object src = e.getSource();
//        if (src.equals(viewDaftar.getKapasitas2())) {
//            System.out.println("pressed");
//        }
//    }
//
//    @Override
//    public void mouseReleased(MouseEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public void mouseEntered(MouseEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public void mouseExited(MouseEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

}

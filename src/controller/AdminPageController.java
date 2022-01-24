package controller;

import database.Database;
import java.awt.GridBagConstraints;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import model.Kendaraan;
import repository.Repository;
import service.InformasiKendaraanService;
import view.DaftarKendaraanSukses;
import view.InfoCard;
import view.InformasiKendaraan;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author aryuska
 */
public final class AdminPageController extends Database implements MouseListener {
    private InformasiKendaraanService infoKendaraanService;
    private InformasiKendaraan viewInfoKendaraan;
    private InfoCard[] infoCard;
    
    public AdminPageController() throws Exception {
        infoKendaraanService = new InformasiKendaraanService();
        viewInfoKendaraan = new InformasiKendaraan();
        viewInfoKendaraan.addMouseListener(this);
        createList(viewInfoKendaraan,"");
    }
    
    


    @Override
    public void mousePressed(MouseEvent e) {
       Object src = e.getSource();
       if (src.equals(viewInfoKendaraan.getSearch())) {
           String search = viewInfoKendaraan.getSearchField().getText();
           System.out.println(viewInfoKendaraan.getSearchField().getText());
           viewInfoKendaraan.getjPanelItem().removeAll();
           try {   
              createList(viewInfoKendaraan, search);

           } catch (Exception ex) {
               Logger.getLogger(AdminPageController.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        JPanel src = (JPanel)e.getSource();
        InfoCard pressedCard = (InfoCard)src.getParent();
        if (src.equals(pressedCard.getHapus())){
           System.out.println("pressed");
           int opsi = JOptionPane.showConfirmDialog(src, "Benarkah anda ingin menghapus data ini ?", 
                        "Hapus Data", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        
             if (opsi == JOptionPane.YES_OPTION){
                int idKendaraan = Integer.parseInt(pressedCard.getId().getText());
                deleteKendaraan(idKendaraan);
             }
       }
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
    
    public void deleteKendaraan(int idKendaraan){
        try {
            infoKendaraanService.deleteKendaraan(idKendaraan);
            viewInfoKendaraan.getjPanelItem().removeAll();
            createList(viewInfoKendaraan, "");     
        } catch (SQLException ex) {
            Logger.getLogger(InformasiKendaraanService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(AdminPageController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void createList(InformasiKendaraan view, String q) throws SQLException, Exception {  
        Repository repo = new Repository();
        ArrayList<Kendaraan> kendaraan = repo.getListKendaraan(q);
        System.out.println(kendaraan);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        
        if(kendaraan.size() == 0){
           JLabel label = new JLabel();
           BufferedImage img = ImageIO.read(getClass().getResource("/icon/not-found.jpg"));
           Image dimg = img.getScaledInstance(700, 500, Image.SCALE_SMOOTH);
           ImageIcon icon = new ImageIcon(dimg);
           label.setIcon(icon);
           view.getScroll().setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
           view.getScroll().setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
           view.getjPanelItem().add(label);
        }else{
           view.getScroll().setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
           view.getScroll().setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
           infoCard = new InfoCard[kendaraan.size()];
            for (int i=0;i<kendaraan.size();i++) {
                Kendaraan v = kendaraan.get(i);
                infoCard[i] = new InfoCard(v.getId_kendaraan(),v.getNama_kendaraan(), v.getWarna_kendaraan(), v.getMerk_kendaraan(), v.getKapasitas(), v.getHarga_sewa(), v.getStatus(), v.getFoto_1()); 
                infoCard[i].addMouseListener(this);
                view.getjPanelItem().add(infoCard[i],gbc);
            } 
        }
       
        view.setVisible(true);
    }
    
}

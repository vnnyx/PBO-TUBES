/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import helper.Helper;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
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
import javax.swing.border.Border;
import model.Kendaraan;
import repository.Repository;
import view.InfoCard;
import view.InformasiKendaraan;

/**
 *
 * @author aryuska
 */
public class InformasiKendaraanService implements MouseListener {
    private InfoCard[] infoCard;
    private InformasiKendaraan view;
    
    @Override
    public void mouseClicked(MouseEvent e) {
         JPanel src = (JPanel)e.getSource();
         InfoCard pressedCard = (InfoCard)src.getParent();
 
  
         if (src.toString().equals(pressedCard.getHapus().toString())){
             int opsi = JOptionPane.showConfirmDialog(src, "Benarkah anda ingin menghapus data ini ?", 
                        "Hapus Data", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        
             if (opsi == JOptionPane.YES_OPTION){
                 int idKendaraan = Integer.parseInt(pressedCard.getId().getText());
                 try {
                     deleteKendaraan(idKendaraan);
                 
                     
                 } catch (SQLException ex) {
                     Logger.getLogger(InformasiKendaraanService.class.getName()).log(Level.SEVERE, null, ex);
                 }
             }
               
                       
         }else{
             System.out.println("SUNTING PRESSED");
         }
    }
    
        
    public void updateKendaraan(String nama, String merk,String warna, String cc, String harga, String kapasitas, File img1, File img2,File img3, String img1URL, String img2URL, String img3URL, int IDKendaraan) throws IOException, SQLException{
        Helper helper = new Helper();
        Repository repo = new Repository();
        String image1URL = img1URL;
        String image2URL = img2URL;
        String image3URL = img3URL;
        if(img1 != null){
             image1URL = helper.uploadImage(img1);
        }
        if (img2 != null){
            image2URL = helper.uploadImage(img2);
        }
        if (img3 != null){
            image3URL = helper.uploadImage(img3);
        }
        
        
        int ccInt = Integer.parseInt(cc);
        int hargaInt = Integer.parseInt(harga);
        int kapasitasInt = Integer.parseInt(kapasitas);
        
        Kendaraan n = new Kendaraan(IDKendaraan,nama, merk,warna, ccInt, image1URL, image2URL, image3URL, hargaInt, kapasitasInt,0);
        
        System.out.println(n);
        
        repo.UpdateKendaraan(n);
    }
    
    public void updateStatus(int id, int status) throws SQLException{
         Repository repo = new Repository();
         
         repo.UpdateStatusKendaraan(id, status);
    }
    
    public Kendaraan getKendaraanByID(int id) throws SQLException{
         Repository repo = new Repository();
         Kendaraan data = repo.getKendaraanByID(id);
         
         return data;
    }
    
    public ArrayList<Kendaraan> getListKendaraan(String  q) throws SQLException{
         Repository repo = new Repository();
         
         ArrayList<Kendaraan> data = repo.getListKendaraan(q);
         
         return data;
    }
    
    
    public void deleteKendaraan(int idKendaraan) throws SQLException{
        Repository repo = new Repository();
        repo.deleteKendaraan(idKendaraan);
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

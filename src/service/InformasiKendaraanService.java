/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
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

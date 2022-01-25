package controller;

import database.Database;
import helper.Helper;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.GridBagConstraints;
import java.awt.Image;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
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
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import model.Kendaraan;
import repository.Repository;
import service.DaftarKendaraanService;
import service.InformasiKendaraanService;
import view.AdminView;
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
public final class AdminPageController extends Database implements MouseListener, ItemListener {
    private InformasiKendaraanService infoKendaraanService;
    private InformasiKendaraan viewInfoKendaraan;
    private InfoCard[] infoCard;
//    private final MenuUtamaDaftarKendaraan viewDaftar;
    private final Helper helper;
    private final DaftarKendaraanService daftarKendaraanService;
    private AdminView adminView;
    private String imageURL1;
    private String imageURL2;
    private String imageURL3;

    public String getImageURL1() {
        return imageURL1;
    }

    public void setImageURL1(String imageURL1) {
        this.imageURL1 = imageURL1;
    }

    public String getImageURL2() {
        return imageURL2;
    }

    public void setImageURL2(String imageURL2) {
        this.imageURL2 = imageURL2;
    }

    public String getImageURL3() {
        return imageURL3;
    }

    public void setImageURL3(String imageURL3) {
        this.imageURL3 = imageURL3;
    }
    
    public AdminPageController() throws Exception {
        infoKendaraanService = new InformasiKendaraanService();
        helper = new Helper();
        daftarKendaraanService = new DaftarKendaraanService();
        adminView = new AdminView();
        adminView.setVisible(true);
        adminView.addMouseListener(this);
        createList("");
    }
   

    public void daftarKendaraanActionPerformed() throws IOException, SQLException {
        String getNama = adminView.getNamaKendaraan().getText();
        String getMerk = adminView.getMerkKendaraan().getSelectedItem();
        String getWarna = adminView.getWarnaKendaraan().getText();
        String getCC = adminView.getCcKendaraan().getSelectedItem();
        String getHarga = adminView.getHargaKendaraan().getText();
        String getKapasitas = adminView.getKapasitas();
        File getImage1 = adminView.getImage1();
        File getImage2 = adminView.getImage2();
        File getImage3 = adminView.getImage3();
                
        daftarKendaraanService.daftarKendaraan(getNama, getMerk, getWarna, getCC, getHarga, getKapasitas, getImage1, getImage2, getImage3);
    }


    @Override
    public void mousePressed(MouseEvent e) {
       JPanel src = (JPanel)e.getSource();
       String btnName = src.getName();
       System.out.println(btnName);
       if (btnName.equals("searchBtn")) {
           String search = adminView.getSearchField().getText();
           adminView.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
           adminView.getjPanelItem().removeAll();
           try {  
              
              createList(search);
             

           } catch (Exception ex) {
               Logger.getLogger(AdminPageController.class.getName()).log(Level.SEVERE, null, ex);
           }
           adminView.setCursor(Cursor.getDefaultCursor());
       }else if (btnName.equals("saveBtn")){
           if(adminView.getTextBtnFormKendaraan().getText().equals("Selanjutnya")){
                try {
                    adminView.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
                    daftarKendaraanActionPerformed();
                    adminView.getjPanelItem().removeAll();
                    createList("");
                    adminView.setCursor(Cursor.getDefaultCursor());
               } catch (IOException ex) {
                   Logger.getLogger(AdminPageController.class.getName()).log(Level.SEVERE, null, ex);
               } catch (SQLException ex) {
                   Logger.getLogger(AdminPageController.class.getName()).log(Level.SEVERE, null, ex);
               } catch (Exception ex) {
                   Logger.getLogger(AdminPageController.class.getName()).log(Level.SEVERE, null, ex);
               }
               adminView.getDaftarKendaraan().setVisible(false);
               adminView.getDaftarKendaraanSukses().setVisible(true);
           }else if (adminView.getTextBtnFormKendaraan().getText().equals("Simpan Perubahan")){
               System.out.println("BUTTON UPDATE");
               adminView.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
               try {
                   updateKendaraan(Integer.parseInt(adminView.getIdKendaraan().getText()));
               } catch (IOException ex) {
                   Logger.getLogger(AdminPageController.class.getName()).log(Level.SEVERE, null, ex);
               } catch (SQLException ex) {
                   Logger.getLogger(AdminPageController.class.getName()).log(Level.SEVERE, null, ex);
               }
               adminView.setCursor(Cursor.getDefaultCursor());
               adminView.getDaftarKendaraan().setVisible(false);
               adminView.getjPanelItem().removeAll();
               adminView.getListKendaraan().setVisible(true);
               try {
                   createList("");
               } catch (Exception ex) {
                   Logger.getLogger(AdminPageController.class.getName()).log(Level.SEVERE, null, ex);
               }
                adminView.setCursor(Cursor.getDefaultCursor());
//               
           }
        
       }else if (btnName.equals("nextDaftarBtn")){
           adminView.getDaftarKendaraanSukses().setVisible(false);
           adminView.getListKendaraan().setVisible(true);
           adminView.getjPanelItem().removeAll();
           adminView.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
           try {
               createList("");
           } catch (Exception ex) {
               Logger.getLogger(AdminPageController.class.getName()).log(Level.SEVERE, null, ex);
           }
           adminView.setCursor(Cursor.getDefaultCursor());
       }else if(btnName.equals("hapusBtn")){
            InfoCard pressedCard = (InfoCard)src.getParent();
            int idKendaraan = Integer.parseInt(pressedCard.getId().getText());
            int opsi = JOptionPane.showConfirmDialog(src, "Benarkah anda ingin menghapus data ini ?", 
                        "Hapus Data", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        
            if (opsi == JOptionPane.YES_OPTION){
                adminView.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
                deleteKendaraan(idKendaraan);
                try {
                       adminView.getjPanelItem().removeAll();
                       createList("");
                } catch (Exception ex) {
                       Logger.getLogger(AdminPageController.class.getName()).log(Level.SEVERE, null, ex);
                }
                   adminView.setCursor(Cursor.getDefaultCursor());
            }
       }else if (btnName.equals("suntingBtn")){
            InfoCard pressedCard = (InfoCard)src.getParent();
            int idKendaraan = Integer.parseInt(pressedCard.getId().getText());
            adminView.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
            try {
                showDataKendaraan(idKendaraan);
                adminView.getListKendaraan().setVisible(false);
                adminView.getDaftarKendaraan().setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(AdminPageController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(AdminPageController.class.getName()).log(Level.SEVERE, null, ex);
            }
            adminView.setCursor(Cursor.getDefaultCursor());
       }
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
//        JPanel src = (JPanel)e.getSource();
//        
//        InfoCard pressedCard = (InfoCard)src.getParent();
//        int idKendaraan = Integer.parseInt(pressedCard.getId().getText());
//        if (src.equals(pressedCard.getHapus())){
//           int opsi = JOptionPane.showConfirmDialog(src, "Benarkah anda ingin menghapus data ini ?", 
//                        "Hapus Data", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
//        
//             if (opsi == JOptionPane.YES_OPTION){
//                adminView.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
//                deleteKendaraan(idKendaraan);
//               try {
//                   adminView.getjPanelItem().removeAll();
//                   createList("");
//               } catch (Exception ex) {
//                   Logger.getLogger(AdminPageController.class.getName()).log(Level.SEVERE, null, ex);
//               }
//               adminView.setCursor(Cursor.getDefaultCursor());
//             }
//       }else if (src.equals(pressedCard.getSunting())){
//            adminView.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
//            try {
//                showDataKendaraan(idKendaraan);
//                adminView.getListKendaraan().setVisible(false);
//                adminView.getDaftarKendaraan().setVisible(true);
//            } catch (SQLException ex) {
//                Logger.getLogger(AdminPageController.class.getName()).log(Level.SEVERE, null, ex);
//            } catch (Exception ex) {
//                Logger.getLogger(AdminPageController.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            adminView.setCursor(Cursor.getDefaultCursor());
//       }
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
            createList("");     
        } catch (SQLException ex) {
            Logger.getLogger(InformasiKendaraanService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(AdminPageController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void showDataKendaraan(int id) throws SQLException, Exception{
        Kendaraan data = infoKendaraanService.getKendaraanByID(id);
 
        adminView.getTitleFormKendaraan().setText("Update Kendaraan");
        adminView.getSubTitleFormKendaraan().setText("Sunting dan edit item kendaraan yang telah didaftarkan");
        adminView.getIconArrowFormKendaraan().setIcon(null);
        adminView.getTextBtnFormKendaraan().setText("Simpan Perubahan");
        adminView.getNamaKendaraan().setText(data.getNama_kendaraan());
        adminView.getMerkKendaraan().select(data.getMerk_kendaraan());
        adminView.getWarnaKendaraan().setText(data.getWarna_kendaraan());
        adminView.getCcKendaraan().select(String.valueOf(data.getCc_kendaraan()));
        adminView.getImg1().setText(null);
        adminView.getImg2().setText(null);
        adminView.getImg3().setText(null);
        adminView.getImg1().setIcon(helper.getImage(adminView.getImg1(), data.getFoto_1()));
        adminView.getImg2().setIcon(helper.getImage(adminView.getImg2(), data.getFoto_2()));
        adminView.getImg3().setIcon(helper.getImage(adminView.getImg3(), data.getFoto_3()));
        adminView.getHargaKendaraan().setText(String.valueOf(data.getHarga_sewa()));
        adminView.getIdKendaraan().setText(String.valueOf(id));
        adminView.getIdKendaraan().setVisible(false);
        setKapasitas(String.valueOf(data.getKapasitas()));
        
        setImageURL1(data.getFoto_1());
        setImageURL2(data.getFoto_2());
        setImageURL3(data.getFoto_3());
        
    }   
    
    
    public void updateKendaraan(int id) throws IOException, SQLException{
        infoKendaraanService.updateKendaraan(adminView.getNamaKendaraan().getText(), adminView.getMerkKendaraan().getSelectedItem(), 
                adminView.getWarnaKendaraan().getText(), adminView.getCcKendaraan().getSelectedItem(), adminView.getHargaKendaraan().getText(), 
                adminView.getKapasitas(), adminView.getImage1(), adminView.getImage2(), adminView.getImage2(), 
                getImageURL1(), getImageURL2(), getImageURL3(),id);
        
        adminView.getTitleFormKendaraan().setText("Update Kendaraan");
        adminView.getSubTitleFormKendaraan().setText("Sunting dan edit item kendaraan yang telah didaftarkan");
        adminView.getIconArrowFormKendaraan().setIcon(null);
        adminView.getTextBtnFormKendaraan().setText("Simpan Perubahan");
        adminView.getNamaKendaraan().setText("");
        adminView.getMerkKendaraan().select("");
        adminView.getWarnaKendaraan().setText("");
        adminView.getCcKendaraan().select("BMW");
        adminView.getImg1().setText(null);
        adminView.getImg2().setText(null);
        adminView.getImg3().setText(null);
        adminView.getImg1().setIcon(null);
        adminView.getImg2().setIcon(null);
        adminView.getImg3().setIcon(null);
        adminView.getHargaKendaraan().setText("");
        adminView.getIdKendaraan().setText("");
        adminView.getIdKendaraan().setVisible(false);
        resetKapasitas();
    }
    
    public void resetKapasitas(){
        adminView.getKapasitas4().setBackground(Color.white);
        adminView.getKapasitas6().setBackground(Color.white);
        adminView.getKapasitas2().setBackground(Color.white);
        adminView.getLabel2org().setForeground(Color.black);
        adminView.getLabel4org().setForeground(Color.black);
        adminView.getLabel6org().setForeground(Color.black);
    }
    
    public void setKapasitas(String kapasitas){
        if(kapasitas.equals("2")){
            adminView.getKapasitas4().setBackground(Color.white);
            adminView.getKapasitas6().setBackground(Color.white);
            adminView.getKapasitas2().setBackground(Color.decode("#003F82"));
            adminView.getLabel2org().setForeground(Color.white);
            adminView.getLabel4org().setForeground(Color.black);
            adminView.getLabel6org().setForeground(Color.black);
        }else if(kapasitas.equals("4")){
            adminView.getKapasitas4().setBackground(Color.decode("#003F82"));
            adminView.getKapasitas6().setBackground(Color.white);
            adminView.getKapasitas2().setBackground(Color.white);
            adminView.getLabel4org().setForeground(Color.white);
            adminView.getLabel2org().setForeground(Color.black);
            adminView.getLabel6org().setForeground(Color.black);
        }else{
            adminView.getKapasitas4().setBackground(Color.white);
            adminView.getKapasitas6().setBackground(Color.decode("#003F82"));
            adminView.getKapasitas2().setBackground(Color.white);
            adminView.getLabel6org().setForeground(Color.white);
            adminView.getLabel4org().setForeground(Color.black);
            adminView.getLabel2org().setForeground(Color.black);
        }
    }
    
    public void createList(String q) throws SQLException, Exception {
        
        ArrayList<Kendaraan> kendaraan = infoKendaraanService.getListKendaraan(q);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        
        if(kendaraan.isEmpty()){
           JLabel label = new JLabel();
           BufferedImage img = ImageIO.read(getClass().getResource("/icon/not-found.jpg"));
           Image dimg = img.getScaledInstance(700, 500, Image.SCALE_SMOOTH);
           ImageIcon icon = new ImageIcon(dimg);
           label.setIcon(icon);
           adminView.getScroll().setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
           adminView.getScroll().setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
           adminView.getjPanelItem().add(label);
        }else{
           adminView.getScroll().setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
           adminView.getScroll().setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
           infoCard = new InfoCard[kendaraan.size()];
            for (int i=0;i<kendaraan.size();i++) {
                Kendaraan v = kendaraan.get(i);
                infoCard[i] = new InfoCard(v.getId_kendaraan(),v.getNama_kendaraan(), v.getWarna_kendaraan(), v.getMerk_kendaraan(), v.getKapasitas(), v.getHarga_sewa(), v.getStatus(), v.getFoto_1()); 
                    infoCard[i].addMouseListener(this);
                    infoCard[i].addItemListener(this);
                adminView.getjPanelItem().add(infoCard[i],gbc);
            } 
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
      JComboBox src = (JComboBox)e.getSource();
      InfoCard pressedCard = (InfoCard)src.getParent();
      int idKendaraan = Integer.parseInt(pressedCard.getId().getText());
      
      
      if(src.getName().equals("statusCB") && e.getStateChange() == ItemEvent.SELECTED){
          adminView.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
          try {
              infoKendaraanService.updateStatus(idKendaraan, src.getSelectedIndex());
          } catch (SQLException ex) {
              Logger.getLogger(AdminPageController.class.getName()).log(Level.SEVERE, null, ex);
          }
          
          adminView.getjPanelItem().removeAll();
          try {
              createList("");
          } catch (Exception ex) {
              Logger.getLogger(AdminPageController.class.getName()).log(Level.SEVERE, null, ex);
          }
          adminView.setCursor(Cursor.getDefaultCursor());
      }
    }
    
}

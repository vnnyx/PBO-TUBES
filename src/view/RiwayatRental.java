/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Firdaus
 */
public class RiwayatRental extends javax.swing.JPanel {

    /**
     * Creates new form RiwayatRental
     */
    public RiwayatRental() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        previousPage = new javax.swing.JPanel();
        prev = new javax.swing.JLabel();
        nextPage = new javax.swing.JPanel();
        next = new javax.swing.JLabel();
        cardPanel = new javax.swing.JPanel();
        image = new javax.swing.JLabel();
        namaKendaraan = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tglMulai = new javax.swing.JLabel();
        tglSelesai = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        hargaSewa = new javax.swing.JLabel();
        status = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        cardPanel1 = new javax.swing.JPanel();
        image1 = new javax.swing.JLabel();
        namaKendaraan1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        tglMulai1 = new javax.swing.JLabel();
        tglSelesai1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        hargaSewa1 = new javax.swing.JLabel();
        status1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Riwayatrental (2).png"))); // NOI18N

        previousPage.setBackground(new java.awt.Color(255, 255, 255));
        previousPage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(139, 139, 139)));
        previousPage.setForeground(new java.awt.Color(255, 255, 255));
        previousPage.setPreferredSize(new java.awt.Dimension(74, 50));

        prev.setFont(new java.awt.Font("Nanum Pen", 1, 22)); // NOI18N
        prev.setText("<");

        javax.swing.GroupLayout previousPageLayout = new javax.swing.GroupLayout(previousPage);
        previousPage.setLayout(previousPageLayout);
        previousPageLayout.setHorizontalGroup(
            previousPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(previousPageLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(prev)
                .addContainerGap(31, Short.MAX_VALUE))
        );
        previousPageLayout.setVerticalGroup(
            previousPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, previousPageLayout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addComponent(prev)
                .addGap(11, 11, 11))
        );

        nextPage.setBackground(new java.awt.Color(255, 255, 255));
        nextPage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 63, 130)));
        nextPage.setPreferredSize(new java.awt.Dimension(74, 50));

        next.setFont(new java.awt.Font("Nanum Pen", 1, 22)); // NOI18N
        next.setText(">");

        javax.swing.GroupLayout nextPageLayout = new javax.swing.GroupLayout(nextPage);
        nextPage.setLayout(nextPageLayout);
        nextPageLayout.setHorizontalGroup(
            nextPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, nextPageLayout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addComponent(next)
                .addGap(29, 29, 29))
        );
        nextPageLayout.setVerticalGroup(
            nextPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, nextPageLayout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addComponent(next)
                .addGap(11, 11, 11))
        );

        cardPanel.setBackground(new java.awt.Color(255, 255, 255));
        cardPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(49, 49, 49)));
        cardPanel.setPreferredSize(new java.awt.Dimension(805, 160));

        image.setPreferredSize(new java.awt.Dimension(135, 136));

        namaKendaraan.setFont(new java.awt.Font("Mulish", 1, 20)); // NOI18N
        namaKendaraan.setForeground(new java.awt.Color(49, 49, 49));
        namaKendaraan.setText("Alphard Tipe X");

        jLabel3.setBackground(new java.awt.Color(79, 79, 79));
        jLabel3.setFont(new java.awt.Font("Mulish Medium", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(79, 79, 79));
        jLabel3.setText("Tanggal Rental      :");

        jLabel4.setFont(new java.awt.Font("Mulish Medium", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(79, 79, 79));
        jLabel4.setText("Tanggal Kembali   :");

        tglMulai.setFont(new java.awt.Font("Mulish", 1, 12)); // NOI18N
        tglMulai.setForeground(new java.awt.Color(49, 49, 49));
        tglMulai.setText("12 Januari 2021");

        tglSelesai.setFont(new java.awt.Font("Mulish", 1, 12)); // NOI18N
        tglSelesai.setForeground(new java.awt.Color(49, 49, 49));
        tglSelesai.setText("12 Januari 2021");

        jLabel8.setBackground(new java.awt.Color(79, 79, 79));
        jLabel8.setFont(new java.awt.Font("Mulish Medium", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(79, 79, 79));
        jLabel8.setText("Harga Sewa :");

        jLabel9.setBackground(new java.awt.Color(79, 79, 79));
        jLabel9.setFont(new java.awt.Font("Mulish Medium", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(79, 79, 79));
        jLabel9.setText("Status :");

        hargaSewa.setFont(new java.awt.Font("Mulish", 1, 14)); // NOI18N
        hargaSewa.setForeground(new java.awt.Color(249, 166, 32));
        hargaSewa.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        hargaSewa.setText("800.000,00");

        status.setFont(new java.awt.Font("Mulish", 1, 12)); // NOI18N
        status.setForeground(new java.awt.Color(47, 225, 75));
        status.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        status.setText("Sedang dirental");

        jPanel3.setBackground(new java.awt.Color(0, 63, 130));
        jPanel3.setPreferredSize(new java.awt.Dimension(125, 39));

        jLabel12.setFont(new java.awt.Font("Mulish", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Lihat Detail");

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/print.png"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel13)
                .addGap(18, 18, 18))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13))
                .addGap(12, 12, 12))
        );

        javax.swing.GroupLayout cardPanelLayout = new javax.swing.GroupLayout(cardPanel);
        cardPanel.setLayout(cardPanelLayout);
        cardPanelLayout.setHorizontalGroup(
            cardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardPanelLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(image, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(cardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cardPanelLayout.createSequentialGroup()
                        .addComponent(namaKendaraan)
                        .addGap(245, 245, 245)
                        .addGroup(cardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel8))
                        .addGap(79, 79, 79)
                        .addGroup(cardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(hargaSewa, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(status, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(cardPanelLayout.createSequentialGroup()
                        .addGroup(cardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(cardPanelLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(12, 12, 12)
                                .addComponent(tglMulai))
                            .addGroup(cardPanelLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tglSelesai)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 302, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12))
        );
        cardPanelLayout.setVerticalGroup(
            cardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(cardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(cardPanelLayout.createSequentialGroup()
                        .addGroup(cardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(hargaSewa))
                        .addGap(12, 12, 12)
                        .addGroup(cardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(status))
                        .addGap(57, 57, 57)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(cardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(cardPanelLayout.createSequentialGroup()
                            .addComponent(namaKendaraan)
                            .addGap(73, 73, 73)
                            .addGroup(cardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3)
                                .addComponent(tglMulai))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(cardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4)
                                .addComponent(tglSelesai)))
                        .addComponent(image, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12))
        );

        cardPanel1.setBackground(new java.awt.Color(255, 255, 255));
        cardPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(49, 49, 49)));
        cardPanel1.setPreferredSize(new java.awt.Dimension(805, 160));

        image1.setPreferredSize(new java.awt.Dimension(135, 136));

        namaKendaraan1.setFont(new java.awt.Font("Mulish", 1, 20)); // NOI18N
        namaKendaraan1.setForeground(new java.awt.Color(49, 49, 49));
        namaKendaraan1.setText("Alphard Tipe X");

        jLabel6.setBackground(new java.awt.Color(79, 79, 79));
        jLabel6.setFont(new java.awt.Font("Mulish Medium", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(79, 79, 79));
        jLabel6.setText("Tanggal Rental      :");

        jLabel7.setFont(new java.awt.Font("Mulish Medium", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(79, 79, 79));
        jLabel7.setText("Tanggal Kembali   :");

        tglMulai1.setFont(new java.awt.Font("Mulish", 1, 12)); // NOI18N
        tglMulai1.setForeground(new java.awt.Color(49, 49, 49));
        tglMulai1.setText("12 Januari 2021");

        tglSelesai1.setFont(new java.awt.Font("Mulish", 1, 12)); // NOI18N
        tglSelesai1.setForeground(new java.awt.Color(49, 49, 49));
        tglSelesai1.setText("12 Januari 2021");

        jLabel10.setBackground(new java.awt.Color(79, 79, 79));
        jLabel10.setFont(new java.awt.Font("Mulish Medium", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(79, 79, 79));
        jLabel10.setText("Harga Sewa :");

        jLabel11.setBackground(new java.awt.Color(79, 79, 79));
        jLabel11.setFont(new java.awt.Font("Mulish Medium", 0, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(79, 79, 79));
        jLabel11.setText("Status :");

        hargaSewa1.setFont(new java.awt.Font("Mulish", 1, 14)); // NOI18N
        hargaSewa1.setForeground(new java.awt.Color(249, 166, 32));
        hargaSewa1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        hargaSewa1.setText("800.000,00");

        status1.setFont(new java.awt.Font("Mulish", 1, 12)); // NOI18N
        status1.setForeground(new java.awt.Color(47, 225, 75));
        status1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        status1.setText("Sedang dirental");

        jPanel4.setBackground(new java.awt.Color(0, 63, 130));
        jPanel4.setPreferredSize(new java.awt.Dimension(125, 39));

        jLabel14.setFont(new java.awt.Font("Mulish", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Lihat Detail");

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/print.png"))); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel15)
                .addGap(18, 18, 18))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15))
                .addGap(12, 12, 12))
        );

        javax.swing.GroupLayout cardPanel1Layout = new javax.swing.GroupLayout(cardPanel1);
        cardPanel1.setLayout(cardPanel1Layout);
        cardPanel1Layout.setHorizontalGroup(
            cardPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(image1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(cardPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cardPanel1Layout.createSequentialGroup()
                        .addComponent(namaKendaraan1)
                        .addGap(245, 245, 245)
                        .addGroup(cardPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel10))
                        .addGap(79, 79, 79)
                        .addGroup(cardPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(hargaSewa1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(status1, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(cardPanel1Layout.createSequentialGroup()
                        .addGroup(cardPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(cardPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(12, 12, 12)
                                .addComponent(tglMulai1))
                            .addGroup(cardPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tglSelesai1)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12))
        );
        cardPanel1Layout.setVerticalGroup(
            cardPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(cardPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(cardPanel1Layout.createSequentialGroup()
                        .addGroup(cardPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(hargaSewa1))
                        .addGap(12, 12, 12)
                        .addGroup(cardPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(status1))
                        .addGap(57, 57, 57)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(cardPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(cardPanel1Layout.createSequentialGroup()
                            .addComponent(namaKendaraan1)
                            .addGap(73, 73, 73)
                            .addGroup(cardPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel6)
                                .addComponent(tglMulai1))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(cardPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel7)
                                .addComponent(tglSelesai1)))
                        .addComponent(image1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(previousPage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(nextPage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cardPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(cardPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel5)
                .addGap(36, 36, 36)
                .addComponent(cardPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(cardPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(previousPage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nextPage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel cardPanel;
    private javax.swing.JPanel cardPanel1;
    private javax.swing.JLabel hargaSewa;
    private javax.swing.JLabel hargaSewa1;
    private javax.swing.JLabel image;
    private javax.swing.JLabel image1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel namaKendaraan;
    private javax.swing.JLabel namaKendaraan1;
    private javax.swing.JLabel next;
    private javax.swing.JPanel nextPage;
    private javax.swing.JLabel prev;
    private javax.swing.JPanel previousPage;
    private javax.swing.JLabel status;
    private javax.swing.JLabel status1;
    private javax.swing.JLabel tglMulai;
    private javax.swing.JLabel tglMulai1;
    private javax.swing.JLabel tglSelesai;
    private javax.swing.JLabel tglSelesai1;
    // End of variables declaration//GEN-END:variables

    public JPanel getCardPanel() {
        return cardPanel;
    }

    public JPanel getCardPanel1() {
        return cardPanel1;
    }

    public JLabel getHargaSewa() {
        return hargaSewa;
    }

    public JLabel getHargaSewa1() {
        return hargaSewa1;
    }

    public JLabel getImage() {
        return image;
    }

    public JLabel getImage1() {
        return image1;
    }

    public JLabel getNamaKendaraan() {
        return namaKendaraan;
    }

    public JLabel getNamaKendaraan1() {
        return namaKendaraan1;
    }

    public JLabel getNext() {
        return next;
    }

    public JPanel getNextPage() {
        return nextPage;
    }

    public JLabel getPrev() {
        return prev;
    }

    public JPanel getPreviousPage() {
        return previousPage;
    }

    public JLabel getStatus() {
        return status;
    }

    public JLabel getStatus1() {
        return status1;
    }

    public JLabel getTglMulai() {
        return tglMulai;
    }

    public JLabel getTglMulai1() {
        return tglMulai1;
    }

    public JLabel getTglSelesai() {
        return tglSelesai;
    }

    public JLabel getTglSelesai1() {
        return tglSelesai1;
    }

    

}

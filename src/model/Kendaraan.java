/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author aryuska
 */
public class Kendaraan {
    private String nama;
    private String merk;
    private String warna;
    private int cc;
    private String foto1;
    private String foto2;
    private String foto3;
    private int harga;
    private int kapasitas;

    public Kendaraan(String nama, String merk, String warna, String cc, String foto1, String foto2, String foto3, String harga, String kapasitas) {
        this.nama = nama;
        this.merk = merk;
        this.warna = warna;
        this.cc = Integer.parseInt(cc);
        this.foto1 = foto1;
        this.foto2 = foto2;
        this.foto3 = foto3;
        this.harga = Integer.parseInt(harga);
        this.kapasitas = Integer.parseInt(kapasitas);
    }


    public void setHarga(int harga) {
        this.harga = harga;
    }

    public void setKapasitas(String kapasitas) {
        this.kapasitas = Integer.parseInt(kapasitas);
    }

    public int getHarga() {
        return harga;
    }

    public int getKapasitas() {
        return kapasitas;
    }

    public String getNama() {
        return nama;
    }

    public String getMerk() {
        return merk;
    }

    public String getWarna() {
        return warna;
    }

    public int getCc() {
        return cc;
    }

    public String getFoto1() {
        return foto1;
    }

    public String getFoto2() {
        return foto2;
    }

    public String getFoto3() {
        return foto3;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public void setWarna(String warna) {
        this.warna = warna;
    }

    public void setCc(String cc) {
        this.cc = Integer.parseInt(cc);
    }

    public void setFoto1(String foto1) {
        this.foto1 = foto1;
    }

    public void setFoto2(String foto2) {
        this.foto2 = foto2;
    }

    public void setFoto3(String foto3) {
        this.foto3 = foto3;
    }
    
    
    
}

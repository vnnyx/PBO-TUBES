/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Firdaus
 */
public class Kendaraan {
    private int id_kendaraan;
    private String nama_kendaraan;
    private String merk_kendaraan;
    private String warna_kendaraan;
    private int cc_kendaraan;
    private String foto_1;
    private String foto_2;
    private String foto_3;
    private int harga_sewa;
    private int kapasitas;
    private int status;

    public Kendaraan(int id_kendaraan, String nama_kendaraan, String merk_kendaraan, String warna_kendaraan,
            int cc_kendaraan, String foto_1, String foto_2, String foto_3, int harga_sewa, int kapasitas, int status) {
        this.nama_kendaraan = nama_kendaraan;
        this.merk_kendaraan = merk_kendaraan;
        this.warna_kendaraan = warna_kendaraan;
        this.cc_kendaraan = cc_kendaraan;
        this.foto_1 = foto_1;
        this.foto_2 = foto_2;
        this.foto_3 = foto_3;
        this.harga_sewa = harga_sewa;
        this.kapasitas = kapasitas;
        this.status = status;
        this.id_kendaraan=id_kendaraan;
    }

    public Kendaraan(String nama_kendaraan, String foto_1, int harga_sewa, int kapasitas) {
        this.nama_kendaraan = nama_kendaraan;
        this.foto_1 = foto_1;
        this.harga_sewa = harga_sewa;
        this.kapasitas = kapasitas;
    }

    public Kendaraan() {
    }

    public String getNama_kendaraan() {
        return nama_kendaraan;
    }

    public void setNama_kendaraan(String nama_kendaraan) {
        this.nama_kendaraan = nama_kendaraan;
    }

    public String getMerk_kendaraan() {
        return merk_kendaraan;
    }

    public void setMerk_kendaraan(String merk_kendaraan) {
        this.merk_kendaraan = merk_kendaraan;
    }

    public String getWarna_kendaraan() {
        return warna_kendaraan;
    }

    public void setWarna_kendaraan(String warna_kendaraan) {
        this.warna_kendaraan = warna_kendaraan;
    }

    public int getCc_kendaraan() {
        return cc_kendaraan;
    }

    public void setCc_kendaraan(int cc_kendaraan) {
        this.cc_kendaraan = cc_kendaraan;
    }

    public String getFoto_1() {
        return foto_1;
    }

    public void setFoto_1(String foto_1) {
        this.foto_1 = foto_1;
    }

    public String getFoto_2() {
        return foto_2;
    }

    public void setFoto_2(String foto_2) {
        this.foto_2 = foto_2;
    }

    public String getFoto_3() {
        return foto_3;
    }

    public void setFoto_3(String foto_3) {
        this.foto_3 = foto_3;
    }

    public int getId_kendaraan() {
        return id_kendaraan;
    }

    public void setId_kendaraan(int id_kendaraan) {
        this.id_kendaraan = id_kendaraan;
    }

    public int getHarga_sewa() {
        return harga_sewa;
    }

    public void setHarga_sewa(int harga_sewa) {
        this.harga_sewa = harga_sewa;
    }

    public int getKapasitas() {
        return kapasitas;
    }

    public void setKapasitas(int kapasitas) {
        this.kapasitas = kapasitas;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    

}
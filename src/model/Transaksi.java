/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.LocalDate;

/**
 *
 * @author Firdaus
 */
public class Transaksi {

    private String username;
    private String foto_kendaraan;
    private LocalDate mulai_sewa;
    private LocalDate selesai_sewa;
    private String nama_kendaraan;
    private int lama_sewa;
    private int total;

    public Transaksi(String username, String foto_kendaraan, LocalDate mulai_sewa,
            LocalDate selesai_sewa, String nama_kendaraan, int lama_sewa, int total) {
        this.username = username;
        this.foto_kendaraan = foto_kendaraan;
        this.mulai_sewa = mulai_sewa;
        this.selesai_sewa = selesai_sewa;
        this.nama_kendaraan = nama_kendaraan;
        this.lama_sewa = lama_sewa;
        this.total = total;
    }

    public Transaksi() {

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFoto_kendaraan() {
        return foto_kendaraan;
    }

    public void setFoto_kendaraan(String foto_kendaraan) {
        this.foto_kendaraan = foto_kendaraan;
    }

    public LocalDate getMulai_sewa() {
        return mulai_sewa;
    }

    public void setMulai_sewa(LocalDate mulai_sewa) {
        this.mulai_sewa = mulai_sewa;
    }

    public LocalDate getSelesai_sewa() {
        return selesai_sewa;
    }

    public void setSelesai_sewa(LocalDate selesai_sewa) {
        this.selesai_sewa = selesai_sewa;
    }

    public String getNama_kendaraan() {
        return nama_kendaraan;
    }

    public void setNama_kendaraan(String nama_kendaraan) {
        this.nama_kendaraan = nama_kendaraan;
    }

    public int getLama_sewa() {
        return lama_sewa;
    }

    public void setLama_sewa(int lama_sewa) {
        this.lama_sewa = lama_sewa;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

}

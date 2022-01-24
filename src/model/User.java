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
public class User {

    private String username;
    private String password;
    private String email;
    private String alamat;
    private String foto_ktp;
    private String foto_diri;

    public User(String username, String password, String email, String alamat, String foto_ktp, String foto_diri) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.alamat = alamat;
        this.foto_ktp = foto_ktp;
        this.foto_diri = foto_diri;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getFoto_ktp() {
        return foto_ktp;
    }

    public void setFoto_ktp(String foto_ktp) {
        this.foto_ktp = foto_ktp;
    }

    public String getFoto_diri() {
        return foto_diri;
    }

    public void setFoto_diri(String foto_diri) {
        this.foto_diri = foto_diri;
    }
}

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
public class Admin extends User {

    private final String role = "Admin";

    public String getRole() {
        return role;
    }

    public Admin(String username, String password, String email, String alamat, String foto_ktp, String foto_diri) {
        super(username, password, email, alamat, foto_ktp, foto_diri);
    }

    public Admin(String username, String password) {
        super(username, password);
    }

    public Admin() {
    }

}

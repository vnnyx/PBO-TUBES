/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import database.Database;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Admin;
import model.Kendaraan;
import model.Penyewa;

/**
 *
 * @author Firdaus
 */
public class Repository extends Database {

    public ArrayList<Admin> getDataAdmin(Admin admin, int limit) throws SQLException {
        ArrayList<Admin> user_admin = new ArrayList<>();
        connectDB();
        String sql = "SELECT * FROM user WHERE username = '%s' AND password = '%s' AND role = '%s' LIMIT %s;";
        sql = String.format(sql, admin.getUsername(), admin.getPassword(), admin.getRole(), limit);
        executeQuery(sql);
        while (rs.next()) {
            String username = rs.getString("username");
            String email = rs.getString("email");
            String password = rs.getString("password");
            String alamat = rs.getString("alamat");
            String foto_ktp = rs.getString("foto_ktp");
            String foto_diri = rs.getString("foto_diri");
            user_admin.add(new Admin(username, password, email, alamat, foto_ktp, foto_diri));
        }
        disconnectDB();
        return user_admin;
    }

    public ArrayList<Penyewa> getDataPenyewa(Penyewa penyewa, int limit) throws SQLException {
        ArrayList<Penyewa> user_penyewa = new ArrayList<>();
        connectDB();
        String sql = "SELECT * FROM user WHERE username = '%s' AND password = '%s' AND role = '%s' LIMIT %s;";
        sql = String.format(sql, penyewa.getUsername(), penyewa.getPassword(), penyewa.getRole(), limit);
        executeQuery(sql);
        while (rs.next()) {
            String username = rs.getString("username");
            String email = rs.getString("email");
            String password = rs.getString("password");
            String alamat = rs.getString("alamat");
            String foto_ktp = rs.getString("foto_ktp");
            String foto_diri = rs.getString("foto_diri");
            user_penyewa.add(new Penyewa(username, password, email, alamat, foto_ktp, foto_diri));
        }
        disconnectDB();
        return user_penyewa;
    }

    public void addUser(Penyewa penyewa) throws SQLException {
        String role = penyewa.getRole();
        String username = penyewa.getUsername();
        String email = penyewa.getEmail();
        String password = penyewa.getPassword();
        String alamat = penyewa.getAlamat();
        String foto_ktp = penyewa.getFoto_ktp();
        String foto_diri = penyewa.getFoto_diri();
        connectDB();
        String query = "INSERT INTO `user` (`role`, `username`, `email`, `password`, `alamat`, `foto_ktp`, `foto_diri`) "
                + "VALUES ('%s', '%s', '%s', '%s', '%s', '%s', '%s')";
        query = String.format(query, role, username, email, password, alamat, foto_ktp, foto_diri);
        execute(query);
        disconnectDB();
    }

    public ArrayList<Kendaraan> getData(int offset) throws SQLException {
        ArrayList<Kendaraan> kendaraan = new ArrayList<>();
        connectDB();
        String sql = "SELECT * FROM kendaraan LIMIT 3 OFFSET %s";
        sql = String.format(sql, offset);
        executeQuery(sql);
        while (rs.next()) {
            String nama_kendaraan = rs.getString("nama_kendaraan");
            int harga_sewa = rs.getInt("harga_sewa");
            String foto_1 = rs.getString("foto_1");
            int kapasitas = rs.getInt("kapasitas");
            kendaraan.add(new Kendaraan(nama_kendaraan, foto_1, harga_sewa, kapasitas));
        }
        disconnectDB();
        return kendaraan;
    }

    public ArrayList<Kendaraan> getData(int offset, String nama) throws SQLException {
        ArrayList<Kendaraan> kendaraan = new ArrayList<>();
        connectDB();
        String sql = "SELECT * FROM kendaraan WHERE nama_kendaraan = '%s' LIMIT 3 OFFSET %s";
        sql = String.format(sql, nama, offset);
        executeQuery(sql);
        while (rs.next()) {
            String nama_kendaraan = rs.getString("nama_kendaraan");
            int harga_sewa = rs.getInt("harga_sewa");
            String foto_1 = rs.getString("foto_1");
            int kapasitas = rs.getInt("kapasitas");
            kendaraan.add(new Kendaraan(nama_kendaraan, foto_1, harga_sewa, kapasitas));
        }
        disconnectDB();
        return kendaraan;
    }

    public ArrayList<Kendaraan> getDetail(String namaKendaraan) throws SQLException {
        ArrayList<Kendaraan> kendaraan = new ArrayList<>();
        connectDB();
        String sql = "SELECT * FROM kendaraan WHERE nama_kendaraan='%s' LIMIT 1";
        sql = String.format(sql, namaKendaraan);
        executeQuery(sql);
        while (rs.next()) {
            String nama_kendaraan = rs.getString("nama_kendaraan");
            int harga_sewa = rs.getInt("harga_sewa");
            String foto_1 = rs.getString("foto_1");
            String foto_2 = rs.getString("foto_2");
            String foto_3 = rs.getString("foto_3");
            String warna = rs.getString("warna_kendaraan");
            String merk = rs.getString("merk_kendaraan");
            int cc = rs.getInt("cc_kendaraan");
            int kapasitas = rs.getInt("kapasitas");
            kendaraan.add(new Kendaraan(nama_kendaraan, merk, warna, cc, foto_1, foto_2, foto_3, harga_sewa, kapasitas));
        }
        disconnectDB();
        return kendaraan;
    }

}

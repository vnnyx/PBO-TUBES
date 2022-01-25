/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import database.Database;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import model.Admin;
import model.Kendaraan;
import model.Penyewa;
import model.Transaksi;

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

    public ArrayList<Kendaraan> getDataKendaraan(int offset) throws SQLException {
        ArrayList<Kendaraan> kendaraan = new ArrayList<>();
        connectDB();
        String sql = "SELECT * FROM kendaraan WHERE status=1 LIMIT 3 OFFSET %s";
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

    public ArrayList<Kendaraan> getSearchDataKendaraan(int offset, String nama) throws SQLException {
        ArrayList<Kendaraan> kendaraan = new ArrayList<>();
        connectDB();
        String sql = "SELECT * FROM kendaraan WHERE nama_kendaraan LIKE '%s' AND status=1 LIMIT 3 OFFSET %s";
        sql = String.format(sql, "%" + nama + "%", offset);
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

    public void addTransaksi(Transaksi transaksi) throws SQLException {
        String username = transaksi.getUsername();
        String foto_kendaraan = transaksi.getFoto_kendaraan();
        String nama_kendaraan = transaksi.getNama_kendaraan();
        int lama_sewa = transaksi.getLama_sewa();
        LocalDate mulai_sewa = transaksi.getMulai_sewa();
        LocalDate selesai_sewa = transaksi.getSelesai_sewa();
        int total = transaksi.getTotal();
        connectDB();
        String query = "INSERT INTO transaksi (`nama_kendaraan`, `foto_kendaraan`, "
                + "`username`, `lama_sewa(hari)`, `mulai_sewa`, `selesai_sewa`, `total_harga`) "
                + "VALUES('%s', '%s', '%s', '%s', '%s', '%s', '%s')";
        query = String.format(query, nama_kendaraan, foto_kendaraan, username, lama_sewa, mulai_sewa, selesai_sewa, total);
        execute(query);
        disconnectDB();
    }

    public ArrayList<Transaksi> getDataTransaksi(int offset, String username) throws SQLException {
        ArrayList<Transaksi> transaksi = new ArrayList<>();
        connectDB();
        String sql = "SELECT * FROM transaksi WHERE username = '%s' ORDER BY id DESC LIMIT 3 OFFSET %s";
        sql = String.format(sql, username, offset);
        executeQuery(sql);
        while (rs.next()) {
            String nama_kendaraan = rs.getString("nama_kendaraan");
            String image = rs.getString("foto_kendaraan");
            String user = rs.getString("username");
            int lama_sewa = rs.getInt("lama_sewa(hari)");
            LocalDate mulai_sewa = rs.getDate("mulai_sewa").toLocalDate();
            LocalDate selesai_sewa = rs.getDate("selesai_sewa").toLocalDate();
            int harga_total = rs.getInt("total_harga");
            transaksi.add(new Transaksi(user, image, mulai_sewa, selesai_sewa, nama_kendaraan, lama_sewa, harga_total));
        }
        disconnectDB();
        return transaksi;
    }

    public ArrayList<Transaksi> getDataTransaksi(String username) throws SQLException {
        ArrayList<Transaksi> transaksi = new ArrayList<>();
        connectDB();
        String sql = "SELECT * FROM transaksi WHERE username = '%s' ORDER BY id DESC";
        sql = String.format(sql, username);
        executeQuery(sql);
        while (rs.next()) {
            String nama_kendaraan = rs.getString("nama_kendaraan");
            String image = rs.getString("foto_kendaraan");
            String user = rs.getString("username");
            int lama_sewa = rs.getInt("lama_sewa(hari)");
            LocalDate mulai_sewa = rs.getDate("mulai_sewa").toLocalDate();
            LocalDate selesai_sewa = rs.getDate("selesai_sewa").toLocalDate();
            int harga_total = rs.getInt("total_harga");
            transaksi.add(new Transaksi(user, image, mulai_sewa, selesai_sewa, nama_kendaraan, lama_sewa, harga_total));
        }
        disconnectDB();
        return transaksi;
    }

    public int getTotalDataTransaksi(String username) throws SQLException {
        connectDB();
        int total = 0;
        String sql = "SELECT COUNT (*) FROM transaksi WHERE username='%s'";
        sql = String.format(sql, username);
        executeQuery(sql);
        rs.next();
        total = rs.getInt(1);
        disconnectDB();
        return total;
    }
    
    public int getTotalDataKendaraan() throws SQLException {
        connectDB();
        int total = 0;
        String sql = "SELECT COUNT (*) FROM kendaraan WHERE status=1";
        executeQuery(sql);
        rs.next();
        total = rs.getInt(1);
        disconnectDB();
        return total;
    }

}

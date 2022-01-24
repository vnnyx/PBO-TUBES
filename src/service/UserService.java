/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.sql.SQLException;
import java.util.ArrayList;
import model.Admin;
import model.Penyewa;
import repository.Repository;

/**
 *
 * @author Firdaus
 */
public class UserService extends Repository {

    public Admin validateAdmin(Admin admin) throws SQLException {
        Admin user_admin = new Admin();
        ArrayList<Admin> selectUser = getDataAdmin(admin, 1);
        if (selectUser.size() > 0) {
            user_admin = selectUser.get(0);
        }
        return user_admin;
    }

    public Penyewa validatePenyewa(Penyewa penyewa) throws SQLException {
        Penyewa user_Penyewa = new Penyewa();
        ArrayList<Penyewa> selectUser = getDataPenyewa(penyewa, 1);
        if (selectUser.size() > 0) {
            user_Penyewa = selectUser.get(0);
        }
        return user_Penyewa;
    }
}

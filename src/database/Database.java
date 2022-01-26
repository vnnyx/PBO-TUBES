/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Firdaus
 */
public class Database {

    static final String DB_URL = "jdbc:mysql://db-mysql-do-do-user-7851304-0.b.db.ondigitalocean.com:25060/sewakendaraan";
    static final String DB_USER = "doadmin";
    static final String DB_PASS = "Gy0kEuurt5HuDGqw";
    protected Connection conn = null;
    protected Statement stmt = null;
    protected ResultSet rs = null;

    public void connectDB() {
        try {
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            stmt = conn.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void executeQuery(String query) throws SQLException {
        this.rs = stmt.executeQuery(query);
    }

    public void execute(String query) throws SQLException {
        stmt.execute(query);
    }

    public ResultSet getRs() {
        return this.rs;
    }

    public void disconnectDB() throws SQLException {
        this.conn.close();
    }

}

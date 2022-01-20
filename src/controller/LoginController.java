/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import database.Database;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import model.User;
import view.Login;

/**
 *
 * @author Firdaus
 */
public class LoginController extends Database implements ActionListener {

    private Login view_login;

    public LoginController() {
        view_login = new Login();
        view_login.setVisible(true);
        view_login.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object src = ae.getSource();
        if (src.equals(view_login.getLoginBtn())) {
            loginBtnPerformed();
        } else if (src.equals(view_login.getDaftarBtn())) {
            daftarBtnPerformed();
        } else if (src.equals(view_login.getLihatPassword())) {
            lihatPswdPerformed();
        }
    }

    public ArrayList<User> getDataUser(User user, int limit) throws SQLException {
        ArrayList<User> users = new ArrayList<>();
        connectDB();
        String sql = "SELECT * FROM user WHERE username = '%s' AND password = '%s' LIMIT %s;";
        sql = String.format(sql, user.getUsername(), user.getPassword(), limit);
        executeQuery(sql);
        while (rs.next()) {
            String username = rs.getString("username");
            String email = rs.getString("email");
            String password = rs.getString("password");
            String alamat = rs.getString("alamat");
            String foto_ktp = rs.getString("foto_ktp");
            String foto_diri = rs.getString("foto_diri");
            users.add(new User(username, password, email, alamat, foto_ktp, foto_diri));
        }
        disconnectDB();
        return users;
    }

    public ImageIcon getIcon(JLabel label, String path) {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(path));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        Image dimg = img.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon icon = new ImageIcon(dimg);
        return icon;
    }

    public User Login(User user) throws SQLException {
        User selectedUser = new User();
        ArrayList<User> selectUsers = getDataUser(user, 1);
        if (selectUsers.size() > 0) {
            selectedUser = selectUsers.get(0);
        }
        return selectedUser;
    }

    public void loginBtnPerformed() {
        String username = view_login.getUsername().getText();
        String password = String.valueOf(view_login.getPassword().getPassword());
        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Harap masukkan data");
        } else {
            User attemptUser = new User(username, password);
            User currentUser = new User();
            try {
                attemptUser = Login(attemptUser);
                currentUser.setUsername(attemptUser.getUsername());
                currentUser.setPassword(attemptUser.getPassword());
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }

            if (currentUser.getUsername() == null) {
                JOptionPane.showMessageDialog(null, "Username / password salah");
            } else {
                new PenyewaPageController();
                view_login.dispose();
            }
        }
    }

    public void daftarBtnPerformed() {
        new RegisController();
        view_login.dispose();
    }

    public void lihatPswdPerformed() {
        if (view_login.getLihatPassword().isSelected()) {
            view_login.getPassword().setEchoChar((char) 0);
        } else {
            view_login.getPassword().setEchoChar('*');
        }
    }
}

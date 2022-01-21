/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import com.cloudinary.Cloudinary;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import model.Kendaraan;
import view.DetailKendaraan;

/**
 *
 * @author Firdaus
 */
public class Helper {

    public String uploadImage(File image) throws IOException {
        Map config = new HashMap();
        config.put("cloud_name", "dlz36gxog");
        config.put("api_key", "413437548493451");
        config.put("api_secret", "7_0ScXRwIMgts4ouARqiHfUU5W4");
        Cloudinary cloudinary = new Cloudinary(config);

        Map result = cloudinary.uploader().upload(image, config);

        return (String) result.get("url");
    }

    public String priceFormat(int price) {
        String harga = String.valueOf(price);
        if (harga.length() == 6) {
            return harga.substring(0, 3) + "." + harga.substring(3, 6) + ",00";
        } else if (harga.length() == 5) {
            return harga.substring(0, 2) + "." + harga.substring(2, 5) + ",00";
        } else {
            return harga.substring(0, 1) + "." + harga.substring(1, 4) + ",00";
        }

    }

    public ImageIcon getImage(JLabel label, String path) throws Exception {
        URL url = new URL(path);
        Image img = ImageIO.read(url);
        Image dimg = img.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon icon = new ImageIcon(dimg);
        return icon;
    }

    public void createAset(Kendaraan kendaraan, JLabel icon, JLabel harga, JLabel nama, JLabel kapasitas) throws Exception {
        icon.setIcon(getImage(icon, kendaraan.getFoto_1()));
        harga.setText(priceFormat(kendaraan.getHarga_sewa()));
        nama.setText(kendaraan.getNama_kendaraan());
        kapasitas.setText(String.valueOf(kendaraan.getKapasitas()));
    }

    public void createAset(DetailKendaraan view, Kendaraan kendaraan) throws Exception {
        view.getNamaKendaraan().setText(kendaraan.getNama_kendaraan());
        view.getMerkKendaraan().setText(kendaraan.getMerk_kendaraan());
        view.getWarnaKendaraan().setText(kendaraan.getWarna_kendaraan());
        view.getCcKendaraan().setText(String.valueOf(kendaraan.getCc_kendaraan()));
        view.getGambar1().setIcon(getImage(view.getGambar1(), kendaraan.getFoto_1()));
        view.getGambar2().setIcon(getImage(view.getGambar2(), kendaraan.getFoto_2()));
        view.getGambar3().setIcon(getImage(view.getGambar3(), kendaraan.getFoto_3()));
        view.getHarga().setText(priceFormat(kendaraan.getHarga_sewa()));
        view.getKapasitasKendaraan().setText(String.valueOf(kendaraan.getKapasitas()));
    }
}

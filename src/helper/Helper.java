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
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import model.Kendaraan;
import view.PenyewaPageView;

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
        DecimalFormat kursIDN = (DecimalFormat) DecimalFormat.getCurrencyInstance();
        DecimalFormatSymbols formatRp = new DecimalFormatSymbols();
        formatRp.setCurrencySymbol("");
        formatRp.setMonetaryDecimalSeparator(',');
        formatRp.setGroupingSeparator('.');
        kursIDN.setDecimalFormatSymbols(formatRp);
        return kursIDN.format(price);
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

    public void createAset(PenyewaPageView view, Kendaraan kendaraan) throws Exception {
        view.getNamaKendaraan().setText(kendaraan.getNama_kendaraan());
        view.getMerkKendaraan().setText(kendaraan.getMerk_kendaraan());
        view.getWarnaKendaraan().setText(kendaraan.getWarna_kendaraan());
        view.getCcKendaraan().setText(String.valueOf(kendaraan.getCc_kendaraan()));
        view.getGambar4().setIcon(getImage(view.getGambar4(), kendaraan.getFoto_1()));
        view.getGambar5().setIcon(getImage(view.getGambar5(), kendaraan.getFoto_2()));
        view.getGambar6().setIcon(getImage(view.getGambar6(), kendaraan.getFoto_3()));
        view.getHarga().setText(priceFormat(kendaraan.getHarga_sewa()));
        view.getKapasitasKendaraan().setText(String.valueOf(kendaraan.getKapasitas()));
    }
}

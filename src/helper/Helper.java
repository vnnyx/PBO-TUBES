/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package helper;

import java.util.HashMap;
import com.cloudinary.Cloudinary;
import java.io.File;
import java.io.IOException;
import java.util.Map;

/**
 *
 * @author aryuska
 */
public class Helper {
    public Helper(){
        
    }
    
    public String uploadImage(File image) throws IOException{
        Map config = new HashMap();
        config.put("cloud_name", "dlz36gxog");
        config.put("api_key", "413437548493451");
        config.put("api_secret", "7_0ScXRwIMgts4ouARqiHfUU5W4");
        Cloudinary cloudinary = new Cloudinary(config);
        
        Map result = cloudinary.uploader().upload(image, config);
        
        return (String) result.get("url");
    }
}

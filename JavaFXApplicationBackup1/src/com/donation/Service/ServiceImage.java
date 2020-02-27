/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.donation.Service;

import com.donation.Entite.Image;
import com.donation.IService.IService;
import com.donation.Utils.DataBase;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.embed.swing.SwingFXUtils;
import javax.imageio.ImageIO;

/**
 *
 * @author Hatem
 */
public class ServiceImage implements IService<Image>{
     private Connection con;
    private Statement ste;

    public ServiceImage() {
        con = DataBase.getInstance().getConnection();
    }
    
    @Override
    public void add(Image t) throws SQLException {
        ste = con.createStatement();
        String addImage = "INSERT INTO `donation`.`image` (`Id_image`, `Id_view`, `Name`) "
                + "VALUES (NULL, '" + t.getId_view() + "', '" + t.getName() + "');";
        ste.executeUpdate(addImage);
    }

    @Override
    public boolean delete(Image t) throws SQLException {
        ste = con.createStatement();
        String deleteImage = "DELETE FROM `donation`.`image` WHERE `Id_image` = " + t.getId_image();
        ste.executeUpdate(deleteImage);
        return ste.execute(deleteImage); //check*************************************** 
    }

    @Override
    public boolean update(Image t) throws SQLException {
        ste = con.createStatement();
        String updateImage = "UPDATE `donation`.`image` SET `Name` = '" + t.getName() + "' " 
                + "WHERE `Id_image` = " + t.getId_image();
        ste.executeUpdate(updateImage);
        return ste.execute(updateImage); //check*************************************** 
    }

    @Override
    public List<Image> readAll() throws SQLException {
        List<Image> arr = new ArrayList<>();
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery("select * from image");
        while (rs.next()) {
            int Id_image = rs.getInt("Id_image");
            int Id_view = rs.getInt("Id_view");
            String Name = rs.getString("Name");
            Image a = new Image(Id_image, Id_view, Name);
            arr.add(a);
        }
        return arr;
    }
    
    public javafx.scene.image.Image BTM(Blob b) throws SQLException,IOException {
        InputStream is = null;
        //OutputStream os = null;
            //ste = con.createStatement();
            //ResultSet rs = ste.executeQuery("select * from image");
            is = b.getBinaryStream();  
            BufferedImage imagen = ImageIO.read(is);
            javafx.scene.image.Image imagef = SwingFXUtils.toFXImage(imagen, null);
            //is.close();
            return imagef;
            //os = new FileOutputStream(dest);

            // buffer size 1K
            //byte[] buf = new byte[1024];

            //int bytesRead;
            //while ((bytesRead = is.read(buf)) > 0) {
                //os.write(buf, 0, bytesRead);
                //os.close();
            }     
    public byte[] ITB(javafx.scene.image.Image imagen) {
    BufferedImage bufferimage = SwingFXUtils.fromFXImage(imagen, null);
      ByteArrayOutputStream output = new ByteArrayOutputStream();
      try {
        ImageIO.write(bufferimage, "jpg", output );
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
      byte [] data = output.toByteArray();
      return data;
}
}

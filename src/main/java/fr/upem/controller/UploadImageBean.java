/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.upem.controller;

import fr.upem.entity.Image;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.servlet.http.Part;

/**
 *
 * @author Denis
 */
@Named("uploadImageBean")
@RequestScoped
public class UploadImageBean {
    
    private Part part;
    private Image image;

    public UploadImageBean() {
        image = new Image();
    }
    
    public String uploadFile(){
        //Metadata
        image.setDimX(0);
        image.setDimY(0);
        
        image.setNbView(0);
        
        Calendar calendar = Calendar.getInstance();
        Date now = calendar.getTime();
        image.setTime(new Timestamp(now.getTime()));

        
        image.setUsers(null);
        
        image.setPath(null);
        
        /*try {
            BufferedImage bf = ImageIO.read(part.getInputStream());
        } catch (IOException ex) {
            
        }*/
        System.out.println(part.getContentType());
        
        //Upload the file
        Path basePath = Paths.get("C:/Users/Denis/Desktop/TW/");
        File file = basePath.resolve(part.getSubmittedFileName()).toFile();
        try(InputStream is = part.getInputStream(); OutputStream os = new FileOutputStream(file)) {
            int read = 0;
            final byte[] bytes = new byte[1024];
            while ((read = is.read(bytes)) != -1) {
                os.write(bytes, 0, read);
            }
        } catch (IOException ex) {
            
        }
        
        return null;
    }

    public Part getPart() {
        return part;
    }

    public void setPart(Part part) {
        this.part = part;
    }
    
    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
    
}

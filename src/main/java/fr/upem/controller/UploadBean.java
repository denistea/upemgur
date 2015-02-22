/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.upem.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.servlet.http.Part;

/**
 *
 * @author Denis
 */
@Named("uploadBean")
@RequestScoped
public class UploadBean {
    
    private Part part;
    
    public String uploadFile(){
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
    
    
}

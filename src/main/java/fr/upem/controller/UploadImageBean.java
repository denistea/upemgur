/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.upem.controller;

import fr.upem.dao.ImageDAO;
import fr.upem.entity.Image;
import fr.upem.entity.Users;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.validator.ValidatorException;
import javax.imageio.ImageIO;
import javax.inject.Named;
import javax.servlet.http.Part;

/**
 *
 * @author Denis
 */
@Named("uploadImageBean")
@RequestScoped
public class UploadImageBean {
    
    private final static String PATH = "C:/var/webapp/images";
    
    @EJB
    private ImageDAO imageDAO;
    
    private Part part;
    private Image image;

    public UploadImageBean() {
        image = new Image();
    }
    
    public String uploadFile(Users users){
        System.out.println(part.getContentType());
        if(!"image/jpeg".equals(part.getContentType())) {
            return null;
        }
        
        BufferedImage bf;
        try {
            bf = ImageIO.read(part.getInputStream());
            
            if(bf == null) {
                return null;
            }
        } catch (IOException ex) {
            return null;
        }
        
        //Metadata
        image.setDimX(bf.getWidth());
        image.setDimY(bf.getHeight());
        
        image.setNbView(0);
        image.setUsers(users);
        
        Calendar calendar = Calendar.getInstance();
        Date now = calendar.getTime();
        image.setTime(new Timestamp(now.getTime()));

        /*try {
            BufferedImage bf = ImageIO.read(part.getInputStream());
        } catch (IOException ex) {
            
        }*/
        System.out.println(part.getContentType());
        
        //Upload the file
        Path basePath = Paths.get(PATH);
        image.setFilename(part.getSubmittedFileName());
        File file = basePath.resolve(part.getSubmittedFileName()).toFile();
        
        try (InputStream is = part.getInputStream()){
            Path filepath = Files.createTempFile(basePath,"",".jpg");
            image.setFilename(filepath.getFileName().toString());
            image.setPath(filepath.toString());
            Files.copy(is, filepath,REPLACE_EXISTING);
        } catch (IOException ex) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, ex.toString(), null));
        }
        imageDAO.create(image);
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

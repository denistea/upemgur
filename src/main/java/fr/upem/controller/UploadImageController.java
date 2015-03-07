/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.upem.controller;

import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;
import fr.upem.dao.ImageDAO;
import fr.upem.entity.Image;
import fr.upem.entity.User;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.imageio.ImageIO;
import javax.inject.Named;
import javax.servlet.http.Part;

/**
 *
 * @author Denis
 */
@Named("uploadImageController")
@RequestScoped
public class UploadImageController {
    @EJB
    private ImageDAO imageDAO;
    
    private Part part;
    private Image image;

    public UploadImageController() {
        image = new Image();
    }
    
    public String uploadFile(User user){
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
        
        image.setNbView(0L);
        image.setUser(user);
        
        Calendar calendar = Calendar.getInstance();
        Date now = calendar.getTime();
        image.setTime(new Timestamp(now.getTime()));

        //Upload the file
        Path basePath = Paths.get(FacesContext.getCurrentInstance().getExternalContext().getInitParameter("IMAGE_DIR"));
        image.setFilename(part.getSubmittedFileName());
        
        try (InputStream is = part.getInputStream()){
            Path filepath = Files.createTempFile(basePath,"",".jpg");
            image.setFilename(filepath.getFileName().toString());
            image.setPath(filepath.toString());
            Files.copy(is, filepath,REPLACE_EXISTING);
            
            Metadata metadata = ImageMetadataReader.readMetadata(filepath.toFile());
          
            StringBuilder out = new StringBuilder();
            for(Directory dir : metadata.getDirectories()) {
                if(dir.getName().equals("Exif IFD0") || dir.getName().equals("Exif SubIFD")) {
                    for (Tag tag : dir.getTags()) {
                        out.append(tag.getTagName()).append(" ").append(tag.getDescription()).append("\n");
                    }
                }
            }
            
            image.setMetadata(out.toString());
            
        } catch (IOException ex) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, ex.toString(), null));
        } catch (ImageProcessingException ex) {
            Logger.getLogger(UploadImageController.class.getName()).log(Level.SEVERE, null, ex);
        }
        

        imageDAO.create(image);
        return "user.xhtml?faces-redirect=true&includeViewParams=true&userName="+user.getUserName();
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

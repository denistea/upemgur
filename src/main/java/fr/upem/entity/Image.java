/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.upem.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;
import static javax.persistence.CascadeType.MERGE;
import static javax.persistence.CascadeType.REMOVE;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import org.eclipse.persistence.annotations.CascadeOnDelete;

/**
 *
 * @author Denis
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Image.findAll", query = "SELECT i FROM Image i ORDER BY i.time DESC"),
    @NamedQuery(name = "Image.findByUsers", query = "SELECT i FROM Image i WHERE i.user = :user ORDER BY i.time DESC"),
    @NamedQuery(name = "Image.findLikeTitle", query = "SELECT i FROM Image i WHERE i.title LIKE :title ORDER BY i.time DESC"),
    @NamedQuery(name = "Image.findByTimeRange", query = "SELECT i FROM Image i WHERE i.time < :time ORDER BY i.time DESC"),
})
public class Image implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @NotNull
    @Column(unique=true, nullable = false)
    private String filename;
    
    @Column(name = "FILE_PATH")
    private String path;
    private String title;
    private String description;
    
    @Column(name = "POSTED_TIME")
    private Timestamp time;
    
    @Column(length = 3024)   
    private String metadata;
    
    @Column(name = "NB_VIEW")
    private Long nbView;
    
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name="USERS_ID", nullable = false)
    private User user;
    
    @CascadeOnDelete
    @OneToMany(mappedBy="image", fetch = FetchType.LAZY, orphanRemoval = true, cascade = {REMOVE,MERGE})
    private List<Comment> comments;
    
    public Image() {
    }

    public Image(String filename, String path, String title, String description, Timestamp time, String metadata, Long nbView, User user) {
        this.filename = filename;
        this.path = path;
        this.title = title;
        this.description = description;
        this.time = time;
        this.metadata = metadata;
        this.nbView = nbView;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public String getMetadata() {
        return metadata;
    }

    public void setMetadata(String metadata) {
        this.metadata = metadata;
    }

    public Long getNbView() {
        return nbView;
    }

    public void setNbView(Long nbView) {
        this.nbView = nbView;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Image other = (Image) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}

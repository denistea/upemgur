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

/**
 *
 * @author Denis
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Image.findAll", query = "SELECT i FROM Image i ORDER BY i.time DESC"),
    @NamedQuery(name = "Image.findByUsers", query = "SELECT i FROM Image i WHERE i.users = :users ORDER BY i.time DESC"),
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
    private String path;
    private String title;
    private String descriptioin;
    private Timestamp time;
    private Long dimX;
    private Long dimY;
    @Column(name = "nb_view")
    private Long nbView;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="users_id", nullable = false)
    private Users users;
    
    @OneToMany(mappedBy="image", fetch = FetchType.LAZY)
    private List<Comment> comments;
    
    public Image() {
    }

    public Image(Long id, String filename, String path, String title, String descriptioin, Timestamp time, Long dimX, Long dimY, Long nbView) {
        this.id = id;
        this.filename = filename;
        this.title = title;
        this.descriptioin = descriptioin;
        this.time = time;
        this.dimX = dimX;
        this.dimY = dimY;
        this.nbView = nbView;
        this.path = path;
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

    public String getDescriptioin() {
        return descriptioin;
    }

    public void setDescriptioin(String descriptioin) {
        this.descriptioin = descriptioin;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public Long getDimX() {
        return dimX;
    }

    public void setDimX(Long dimX) {
        this.dimX = dimX;
    }

    public Long getDimY() {
        return dimY;
    }

    public void setDimY(Long dimY) {
        this.dimY = dimY;
    }

    public Long getNbView() {
        return nbView;
    }

    public void setNbView(Long nbView) {
        this.nbView = nbView;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
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

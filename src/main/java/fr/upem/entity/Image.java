/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.upem.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Denis
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Image.findAll", query = "SELECT i FROM Image i"),
    @NamedQuery(name = "Image.findByUsers", query = "SELECT i FROM Image i WHERE i.users = :users")
})
public class Image implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    @Column(unique=true, nullable = false)
    private String path;
    private String title;
    private String descriptioin;
    private Timestamp time;
    private Long dimX;
    private Long dimY;
    @Column(name = "nb_view")
    private Long nbView;
    
    @ManyToOne
    @JoinColumn(name="users_id")
    private Users users;
    
    public Image() {
    }

    public Image(Long id, String path, String title, String descriptioin, Timestamp time, Long dimX, Long dimY, Long nbView) {
        this.id = id;
        this.path = path;
        this.title = title;
        this.descriptioin = descriptioin;
        this.time = time;
        this.dimX = dimX;
        this.dimY = dimY;
        this.nbView = nbView;
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

    public void setDimX(long dimX) {
        this.dimX = dimX;
    }

    public long getDimY() {
        return dimY;
    }

    public void setDimY(long dimY) {
        this.dimY = dimY;
    }

    public Long getNbView() {
        return nbView;
    }

    public void setNbView(long nbView) {
        this.nbView = nbView;
    }

    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
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

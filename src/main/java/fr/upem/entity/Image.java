/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.upem.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Denis
 */
@Entity
public class Image implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
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

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }
 
}

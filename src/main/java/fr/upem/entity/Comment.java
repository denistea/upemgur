/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.upem.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author Denis
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Comment.findAll", query = "SELECT c FROM Comment c"),
    @NamedQuery(name = "Comment.findByUsers", query = "SELECT c FROM Comment c WHERE c.users = :users ORDER BY c.time DESC"),
    @NamedQuery(name = "Comment.findByImage", query = "SELECT c FROM Comment c WHERE c.image = :image ORDER BY c.time DESC"),
    @NamedQuery(name = "Comment.findByImageUsers", query = "SELECT c FROM Comment c WHERE c.users = :users AND c.image = :image ORDER BY c.time DESC"),
    @NamedQuery(name = "Comment.findByTimeRange", query = "SELECT c FROM Comment c WHERE c.time < :time ORDER BY c.time DESC")
})
public class Comment implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String content;

    private Timestamp time;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="users_id", nullable = false)
    private Users users;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="image_id", nullable = false)
    private Image image;
    
    public Comment() {
    }

    public Comment(Long id, String content, Timestamp time) {
        this.id = id;
        this.content = content;
        this.time = time;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.id);
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
        final Comment other = (Comment) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}

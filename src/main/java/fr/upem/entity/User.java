/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.upem.entity;

import static java.awt.Event.DELETE;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import static javax.persistence.CascadeType.MERGE;
import static javax.persistence.CascadeType.REFRESH;
import static javax.persistence.CascadeType.REMOVE;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.eclipse.persistence.annotations.CascadeOnDelete;

/**
 *
 * @author Denis
 */
@Entity
@Table(name="USERS")
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
    @NamedQuery(name = "User.findByUserName", query = "SELECT u FROM User u WHERE u.userName = :userName"),
    @NamedQuery(name = "User.findBeginUserName", query = "SELECT u FROM User u WHERE UPPER(u.userName) LIKE UPPER(:userName)"),
    @NamedQuery(name = "User.findBeginEmail", query = "SELECT u FROM User u WHERE UPPER(u.email) LIKE UPPER(:email)"),
    @NamedQuery(name = "User.findByEmail", query = "SELECT u FROM User u WHERE u.email = :email")
})
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @NotNull(message = "Email is required" )
    @Pattern(regexp="[\\w\\.-]*[a-zA-Z0-9_]@[\\w\\.-]*[a-zA-Z0-9]\\.[a-zA-Z][a-zA-Z\\.]*[a-zA-Z]")
    @Column(unique=true, nullable = false)
    private String email;
    
    @NotNull ( message = "UserName is required" )
    @Size(min = 3)
    @Pattern(regexp="[^\\W\\d_]\\w*")
    @Column(unique=true, nullable = false)
    private String userName;
    
    @NotNull ( message = "Password is required" )
    @Size(min = 4)
    @Column(nullable = false)
    private String password;
    
    @Column(name = "JOINED_TIME")
    private Timestamp time;
    
    @CascadeOnDelete
    @OneToMany(mappedBy="user", fetch = FetchType.LAZY, orphanRemoval = true, cascade = {REMOVE,MERGE})
    private List<Comment> comments;
    
    @CascadeOnDelete
    @OneToMany(mappedBy="user", fetch = FetchType.LAZY, orphanRemoval = true, cascade = {REMOVE,MERGE})
    private List<Image> images;
    
    public User() {
    }

    public User(String userName, String password, String email) {
        this.userName = userName;
        this.password = password;
        this.email = email;
    }    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + Objects.hashCode(this.id);
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
        final User other = (User) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}

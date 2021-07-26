package com.rental.advertisements;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ra_user")
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long user_id;

    private String fullname;
    private String email;
    private String upassword;

    protected User() {}

    public User(String fullname, String email, String upassword) {
        this.fullname = fullname;
        this.email = email;
        this.upassword = upassword;
    }

    public Long getUser_id() {
        return this.user_id;
    }

    public String getFullname() {
        return this.fullname;
    }

    public String getEmail() {
        return this.email;
    }

    public String getUpassword() {
        return this.upassword;
    }
}

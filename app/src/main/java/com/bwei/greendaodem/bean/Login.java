package com.bwei.greendaodem.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Index;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Transient;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by muhanxi on 17/6/11.
 */

@Entity( nameInDb = "logins" )
public class Login {

    @Id(autoincrement = true)
    public Long id;

    @Property
    public String username;

    @Property
    public String password;

    @Transient
    public Long timer;

    @Generated(hash = 145544175)
    public Login(Long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    @Generated(hash = 1827378950)
    public Login() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}

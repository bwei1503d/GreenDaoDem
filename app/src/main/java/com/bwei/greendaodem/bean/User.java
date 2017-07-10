package com.bwei.greendaodem.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Index;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Transient;
import org.greenrobot.greendao.DaoException;
import com.bwei.dao.DaoSession;
import com.bwei.dao.UserDao;

import static android.R.attr.value;

/**
 * Created by muhanxi on 17/6/11.
 */

//indexes = {@Index(value = "name , cid " , unique = true)}
@Entity( nameInDb = "tab1"  )
public class User {

    @Id(autoincrement = true)
    public Long id;

    @Property(nameInDb = "name1")
    @NotNull
    public String name;
    @Property
    @NotNull
    public int cid ;

    @Property
//    @Index(name = "age1" , unique = true)
    public int age;


    @Transient
    public int max;
    @Generated(hash = 1497397517)
    public User(Long id, @NotNull String name, int cid, int age) {
        this.id = id;
        this.name = name;
        this.cid = cid;
        this.age = age;
    }


    @Generated(hash = 586692638)
    public User() {
    }


    public Long getId() {
        return this.id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getName() {
        return this.name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public int getAge() {
        return this.age;
    }


    public void setAge(int age) {
        this.age = age;
    }


    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }


    public int getCid() {
        return this.cid;
    }


    public void setCid(int cid) {
        this.cid = cid;
    }


   
}

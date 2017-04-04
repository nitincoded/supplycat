package com.enterprisecat.entity;

import javax.persistence.*;

/**
 * Created by Nitin Reddy on 4/3/2017.
 */
@Entity
public class Organization {
    @Column(unique = true)
    private String code;

    private String description;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

package com.enterprisecat.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Developer on 4/5/17.
 */
@Entity
public class Lot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    public int getId() { return id; }
    public void setId(int a) { id=a; }

    @Column(nullable = false)
    private String description;
    public String getDescription() { return description; }
    public void setDescription(String a) { description=a; }

    private Date expiry;
    public Date getExpiry() {
        return expiry;
    }
    public void setExpiry(Date expiry) {
        this.expiry = expiry;
    }
}

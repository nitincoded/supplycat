package com.enterprisecat.entity;

import javax.persistence.*;

/**
 * Created by Developer on 4/5/17.
 */
@Entity
public class Bin {
    @Column(unique = true)
    private String code;
    public String getCode() { return code; }
    public void setCode(String a) { code=a; }

    private String description;
    public String getDescription() { return description; }
    public void setDescription(String a) { description=a; }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    public int getId() { return id; }
    public void setId(int a) { id=a; }

    @ManyToOne
    @JoinColumn(name = "store", nullable = false)
    private Store store;
    public Store getStore() {
        return store;
    }
    public void setStore(Store store) {
        this.store = store;
    }
}

package com.enterprisecat.entity;

import javax.persistence.*;

/**
 * Created by Nitin Reddy on 4/3/2017.
 */
@Entity
public class PartCommodity {
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
}

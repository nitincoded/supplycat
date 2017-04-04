package com.enterprisecat.entity;

import javax.persistence.*;

/**
 * Created by Nitin Reddy on 4/4/2017.
 */
@Entity
public class Store {
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
    @JoinColumn(name = "organization")
    private Organization organization;

    public Organization getOrganization() { return organization; }
    public void setOrganization(Organization a) { organization = a; }
}

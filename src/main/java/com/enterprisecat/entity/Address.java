package com.enterprisecat.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Developer on 4/7/17.
 */
@Entity
public class Address {
    private String description;
    public String getDescription() { return description; }
    public void setDescription(String a) { description=a; }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    public int getId() { return id; }
    public void setId(int a) { id=a; }

    private String firstName;
    private String lastName;
    private String displayName;
    private String company;
    private String jobTitle;
    private String salutation;
    private Date dob;
    private String primaryFax;
    private String primaryWorkPhone;
    private String primaryHomePhone;
    private String primaryMobilePhone;
    private String primaryEmail;
    private String secondaryFax;
    private String secondaryWorkPhone;
    private String secondaryHomePhone;
    private String secondaryMobilePhone;
    private String secondaryEmail;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getSalutation() {
        return salutation;
    }

    public void setSalutation(String salutation) {
        this.salutation = salutation;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getPrimaryFax() {
        return primaryFax;
    }

    public void setPrimaryFax(String primaryFax) {
        this.primaryFax = primaryFax;
    }

    public String getPrimaryWorkPhone() {
        return primaryWorkPhone;
    }

    public void setPrimaryWorkPhone(String primaryWorkPhone) {
        this.primaryWorkPhone = primaryWorkPhone;
    }

    public String getPrimaryHomePhone() {
        return primaryHomePhone;
    }

    public void setPrimaryHomePhone(String primaryHomePhone) {
        this.primaryHomePhone = primaryHomePhone;
    }

    public String getPrimaryMobilePhone() {
        return primaryMobilePhone;
    }

    public void setPrimaryMobilePhone(String primaryMobilePhone) {
        this.primaryMobilePhone = primaryMobilePhone;
    }

    public String getPrimaryEmail() {
        return primaryEmail;
    }

    public void setPrimaryEmail(String primaryEmail) {
        this.primaryEmail = primaryEmail;
    }

    public String getSecondaryFax() {
        return secondaryFax;
    }

    public void setSecondaryFax(String secondaryFax) {
        this.secondaryFax = secondaryFax;
    }

    public String getSecondaryWorkPhone() {
        return secondaryWorkPhone;
    }

    public void setSecondaryWorkPhone(String secondaryWorkPhone) {
        this.secondaryWorkPhone = secondaryWorkPhone;
    }

    public String getSecondaryHomePhone() {
        return secondaryHomePhone;
    }

    public void setSecondaryHomePhone(String secondaryHomePhone) {
        this.secondaryHomePhone = secondaryHomePhone;
    }

    public String getSecondaryMobilePhone() {
        return secondaryMobilePhone;
    }

    public void setSecondaryMobilePhone(String secondaryMobilePhone) {
        this.secondaryMobilePhone = secondaryMobilePhone;
    }

    public String getSecondaryEmail() {
        return secondaryEmail;
    }

    public void setSecondaryEmail(String secondaryEmail) {
        this.secondaryEmail = secondaryEmail;
    }
}

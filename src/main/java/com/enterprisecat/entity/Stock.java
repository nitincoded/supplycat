package com.enterprisecat.entity;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by Developer on 4/5/17.
 */
@Entity
public class Stock {
    @Column(nullable = false)
    private BigDecimal quantity;
    @Column(nullable = false)
    private Part part;
    private Lot lot;

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public Part getPart() {
        return part;
    }

    public void setPart(Part part) {
        this.part = part;
    }

    public Lot getLot() {
        return lot;
    }

    public void setLot(Lot lot) {
        this.lot = lot;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    public int getId() { return id; }
    public void setId(int a) { id=a; }
}

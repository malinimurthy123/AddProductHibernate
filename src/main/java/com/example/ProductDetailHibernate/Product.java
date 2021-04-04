package com.example.ProductDetailHibernate;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Embeddable;

@Embeddable
@Entity
@Table(name= "product")

public class Product {

    public Product() {

    }

    @Column(name = "ProductID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    int ProductID;

    @Column(name = "ProductName")
    String ProductName;

    @Column(name = "price")
    BigDecimal price;

    @Column(name = "Colour")
    String Colour;

    public Product(String ProductName, BigDecimal price, String color) {
        //this.ProductID = ProductID;
        this.ProductName = ProductName;
        this.price = price;
        this.Colour = color;
    }

    public int getID() {return this.ProductID; }
    public String getName() { return this.ProductName;}
    public BigDecimal getPrice() { return this.price;}
    public String getColor() { return this.Colour;}

    public void setID(int id) { this.ProductID = id;}
    public void setName(String name) { this.ProductName = name;}
    public void setPrice(BigDecimal price) { this.price = price;}
    public void setColor(String color) { this.Colour = color;}
}


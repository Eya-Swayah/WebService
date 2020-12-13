/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.Serializable;

/**
 *
 * @author eya
 */
public class Produit implements Serializable{
   private int id;
   private String productName;
   private double price;
   private String photo;
   
   
   public Produit(int id,String productName, double price, String photo) {
    this.id=id;
    this.productName = productName;
    this.price = price;
    this.photo = photo;
}

    Produit() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   public int getProductId() {
          return id;
}
public String getProductName() {
return productName;
}

public double getPrice() {
return price;
}
    public String getPhoto() {
        return photo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
   
 
}

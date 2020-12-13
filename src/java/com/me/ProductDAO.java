/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author eya
 */
public class ProductDAO {

    private Connection con;

    public ProductDAO() {
        databaseConnect();
    }

    public void databaseConnect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/product";
            String user = "root";
            String pass = "password";
            con = DriverManager.getConnection(url, user, pass);
            // System.out.println("bien");
        } catch (Exception e) {
            System.out.println("No database connection estableshed");
            e.printStackTrace();
        }
    }

    public List<String> findAllProducts() {
        try {
            ResultSet rs = con.createStatement().executeQuery("SELECT p.productName FROM Produit p ");
            List<String> l = new ArrayList<>();
            while (rs.next()) {
                l.add(rs.getString("productName"));
            }
            return l;
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    public String getProductById(int id) {
        String ch=null;
        try {
            ResultSet rs = con.createStatement().executeQuery("SELECT p.productName FROM Produit p where p.id = " + id);
            while (rs.next()) {
                ch= rs.getString("productName");
            }
            return ch;
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
            return ch;
        }

    }
    public List<String> getProductByKeyWord(String keyWord) {
        try {
            ResultSet rs = con.createStatement().executeQuery("SELECT p.productName FROM Produit p where p.productName LIKE '%" + keyWord+"%'");
            List<String> l = new ArrayList<>();
            while (rs.next()) {
                l.add(rs.getString("productName"));
            }
            return l;
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }
    public List<String> getProductByPriceInf(float price) {
        try {
            ResultSet rs = con.createStatement().executeQuery("SELECT p.productName FROM Produit p where p.price < " + price);
            List<String> l = new ArrayList<>();
            while (rs.next()) {
                l.add(rs.getString("productName"));
            }
            return l;
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }
    
    
      public List<String> getClientsProduct(int id) {
        try {
            ResultSet rs = con.createStatement().executeQuery("SELECT DISTINCT Client.firstName, Client.lastName, Produit.id FROM product.Achat JOIN product.Client ON Achat.`ClientId`=Client.clientId JOIN product.Produit ON Achat.`ProduitId` = Produit.id where ProduitId="+id);
            List<String> l = new ArrayList<>();
            while (rs.next()) {
                l.add(rs.getString("firstName"));
            }
            return l;
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
      }
        
    /**
     *
     * @param d
     * @return
     */
    public List<Integer> getAchatParDate (Date d) {
        try {
            ResultSet rs = con.createStatement().executeQuery("SELECT a.AchatId FROM Achat a where a.DATE <= '"+d.toString()+"'"); 
            List<Integer> l = new ArrayList<>();
            while (rs.next()) {
                l.add(rs.getInt("AchatId"));
            }
            return l;
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }
       public List<Integer> getAchatParDatePost (Date d) {
        try {
            ResultSet rs = con.createStatement().executeQuery("SELECT a.AchatId FROM Achat a where a.DATE >= '"+d.toString()+"'"); 
            List<Integer> l = new ArrayList<>();
            while (rs.next()) {
                l.add(rs.getInt("AchatId"));
            }
            return l;
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }
      public List<Integer> BetweenDate (Date d1 , Date d2) {
        try {
            ResultSet rs = con.createStatement().executeQuery("Select a.AchatId from Achat a where a.DATE BETWEEN '"+d1.toString()+"' AND '"+d2.toString()+"'");
            List<Integer> l = new ArrayList<>();
            while (rs.next()) {
                l.add(rs.getInt("AchatId"));
            }
            return l;
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
        

    }
           public List<String> BestSellers () {
        try {
//            ResultSet rs = con.createStatement().executeQuery("Select Produit.id, Produit.productName from product.Achat JOIN product.Client ON Achat.`clientId`=Client.clientid  JOIN product.Produit on Achat.`produitId` = Produit.id GROUP BY Produit.id ORDER BY(count(Achat.`produitId`)) desc LIMIT 3 ");
            ResultSet rs = con.createStatement().executeQuery("Select p.productName from Achat a JOIN Produit p on a.produitId = p.id GROUP BY p.id ORDER BY(count(a.produitId)) desc LIMIT 3");
            List<String> l = new ArrayList<>();
            while (rs.next()) {
                l.add(rs.getString("productName"));
            }
            return l;
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
        

    }

 
    
    

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me;

import java.sql.Date;
import java.text.DateFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author eya
 */
public class TestMetier {

    public static void main(String[] args) throws Exception {
        MetierCatalogueImpl m = new MetierCatalogueImpl();
        System.out.println("All Products:");
        for (String ch : m.AllProducts()) {
            System.out.println(ch);
        }
        System.out.println("clients by product id");
        for (String ch : m.ProduitClient(2)) {
            System.out.println(ch);
        }
        System.out.println("Achat anterieur a une date");
        Date date = Date.valueOf("2020-02-03");

        for (Integer ch : m.AchatParDateAnt(date)) {
            System.out.println(ch);
        }
        System.out.println("Best seller");
        for (String ch : m.BestSellers()) {
            System.out.println(ch);
        }
        System.out.println("Achat posterieur a une date");
        for (Integer ch : m.AchatParDatePost(date)) {
            System.out.println(ch);
        }

//       List<Produit> produits = new ArrayList<>();
//      Produit produit ;
//      MetierCatalogueImpl metier = new MetierCatalogueImpl();
//      System.out.println("donner le produit dont l'id est 1");
//      produit = metier.getProduit(1);
//        produit = metier.getProduit(2);
//          produit = metier.getProduit(3);
//        System.out.println();
//        metier.AllProducts() ;
//
//       produits = metier.AllProducts();
//        System.out.println("donner tous les prods");
//
//      for (Produit p : produits) {
//           System.out.print(p);
//      }
//
//       List<Produit> prods = metier.KeyWord("HP");
//       System.out.println("donner les produits qui contient HP");
//
//      for (Produit p : prods) {
//           System.out.print(p);
//       }
    }

}

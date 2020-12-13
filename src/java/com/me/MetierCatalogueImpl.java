/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me;



import java.sql.Date;
import java.util.List;

/**
 *
 * @author eya
 */
public class MetierCatalogueImpl {

    private ProductDAO pdao;

    public MetierCatalogueImpl() {
        pdao = new ProductDAO();
    }


    public List<String> AllProducts() {
        return pdao.findAllProducts();
    }

    public List<String> KeyWord(String motCle) {
        return pdao.getProductByKeyWord(motCle);
    }

    public String getProduit(int id) {
        return pdao.getProductById(id);
    }

    public List<String> ProduitX(float price) {
        return pdao.getProductByPriceInf(price);
    }
      public List<String> ProduitClient(int id) {
        return pdao.getClientsProduct(id);
    }
        public List<Integer> AchatParDateAnt(Date d ) {
        return pdao.getAchatParDate( d);
    }
           public List<Integer> AchatParDatePost(Date d ) {
        return pdao.getAchatParDatePost(d);
    }
        public List<Integer> AchatBtweenDate(Date d1 , Date d2 ) {
        return pdao.BetweenDate( d1,  d2);
    }  
           public List<String> BestSellers() {
        return pdao.BestSellers();
    } 

    
}

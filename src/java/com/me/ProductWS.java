/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me;

import java.sql.Date;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author eya
 */
@WebService(serviceName = "ProductWS")
public class ProductWS {

//
    //@EJB
    private MetierCatalogueImpl metier;
//

    public ProductWS() {
        metier = new MetierCatalogueImpl();
    }

    /**
     * This is a sample web service operation
     *
     * @param txt
     * @return
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }
//    /**
//    * Web service operation
//     *
//     * @param id
//     * @return
//     */

    @WebMethod(operationName = "GetAllProducts")
    public List<String> GetAllProducts() {
//
//        return metier.getProduit(id);
        return metier.AllProducts();
//
    }
    @WebMethod(operationName = "GetProductById")
    public String GetProductById(@WebParam(name = "id") int id) {
        return metier.getProduit(id);
    }

//    /**
//     * Web service operation
//     *
//     * @param motCle
//     * @return
//     */   
    @WebMethod(operationName = "GetProductByWord")
    public List<String> GetProductByWorld(@WebParam(name = "motCle") String motCle) {
        return metier.KeyWord(motCle);
    }

    /**
     * Web service operation
     *
     *
     * @param prix
     * @return
     */
    @WebMethod(operationName = "GetProductByPrice")
    public List<String> GetProductByPrice(@WebParam(name = "prix") float prix) {
        return metier.ProduitX(prix);
    }
       @WebMethod(operationName = "GetProductByClient")
    public List<String> GetProductByClient(@WebParam(name = "id") int id) {
        return metier.ProduitClient(id);
    }
         @WebMethod(operationName = "GetAchatParDateAnt")
    public List<Integer> GetAchatParDateAnt(@WebParam(name = "d") String date) {
        
        return metier.AchatParDateAnt(Date.valueOf(date)) ;
    }
        @WebMethod(operationName = "GetAchatParDatePost")
    public List<Integer> GetAchatParDatePost(@WebParam(name = "d") String date) {
        
        return metier.AchatParDatePost(Date.valueOf(date)) ;
    }
         @WebMethod(operationName = "GetAchatBetweenDate")
    public List<Integer> GetAchatBetweenDate(@WebParam(name = "d1") String d1 ,@WebParam(name = "d2") String d2) {
        return metier.AchatBtweenDate(Date.valueOf(d1), Date.valueOf(d2));
    }
           @WebMethod(operationName = "BestSeller")
    public List<String> BestSeller() {
        return metier.BestSellers() ;
    }
}

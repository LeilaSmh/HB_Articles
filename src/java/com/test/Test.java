/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.test;

import com.dao.daoArticle;
import com.entity.Article;
import java.util.List;

/**
 *
 * @author Dell
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {// TODO code application logic here
        daoArticle dao = new daoArticle();
          dao.addArticle(new Article(999, "Tele", 120F));
//       List<Article> L= dao.findAll();
       List<Article> L= dao.All();
       for (Article art : L)
            System.out.println(art.getCode()+"   " + art.getDesignation()+ " ====> "+art.getPrix());

    }
    
}

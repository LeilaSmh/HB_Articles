/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dao;

import com.entity.Article;
import com.hibernate.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Dell
 */
public class daoArticle {
    
    Session S ;
    Transaction Tx ;

    public daoArticle()
    {
        S = HibernateUtil.getSessionFactory().openSession();
    }
    
    public void addArticle(Article art) 
    {
        try {
            Tx= S.beginTransaction();
            S.save(art);
            Tx.commit();

        } catch (Exception e){
            Tx.rollback();
            e.printStackTrace();
        }
    }
    public void updateArticle(Article art) 
    {
        try {
            Tx= S.beginTransaction();
            S.update(art);
            Tx.commit();

        } catch (Exception e){
            Tx.rollback();
            e.printStackTrace();
        }
    }
    
    
    public void deleteArticle(int code)
    {
        Article art = null;
        try {
            Tx= S.beginTransaction();
            art = (Article) S.get(Article.class, code);
            if (art != null){
                S.delete(art);
                if (!Tx.wasCommitted())
                    Tx.commit();
            }
            
        } catch (Exception e) {
            Tx.rollback();
            e.printStackTrace();
        }
    }
    
    public Article getArticle(int code)
    {
        Article art = null;
        
        try {
            Tx= S.beginTransaction();
            art = (Article) S.get(Article.class, code);
            if (!Tx.wasCommitted())
                    Tx.commit();
        } catch (Exception e) {
            Tx.rollback();
            e.printStackTrace();
        }
        
        return art;
    }
    
    public List<Article> All() {
        List<Article> articles = null;
        try {
                articles = S.createQuery("from Article").list();
        } catch (Exception e) {
                e.printStackTrace();
        }
        return articles;
    }

}

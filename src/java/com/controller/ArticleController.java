/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.controller;

import com.dao.daoArticle;
import com.entity.Article;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Dell
 */
@WebServlet(name = "ArticleController", urlPatterns = {"/article"})
public class ArticleController extends HttpServlet {

    private daoArticle articleDAO = new daoArticle();
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String action = request.getParameter("action");
        if(action.equalsIgnoreCase("form")){
            this.ArticleForm(request, response);
        }else if(action.equalsIgnoreCase("list")){
            this.AllArticles(request, response);
        }else{
            request.getRequestDispatcher("articles_list.jsp").forward(request, response);
        }
        
       
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

    protected void AllArticles (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Article> list = articleDAO.All();
        request.setAttribute("list", list);
        request.getRequestDispatcher("articles_list.jsp").forward(request, response);
    }
    
    protected void ArticleForm (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String codeStr = request.getParameter("code");
        int code = codeStr.equals("") ? 0 : Integer.parseInt(codeStr);
        String designation = request.getParameter("designation");
        String prixStr = request.getParameter("prix");
        double prix = prixStr.equals("") ? 0 : Double.parseDouble(prixStr);
        String operation = request.getParameter("operation");
        
        Article article = new Article(code,designation,prix);
       
        if (operation.equalsIgnoreCase("Add")) {
            articleDAO.addArticle(article);
        } else if (operation.equalsIgnoreCase("Delete")) {
            articleDAO.deleteArticle(code);
        } else if (operation.equalsIgnoreCase("Search")) {
            article = articleDAO.getArticle(code);
        }else if (operation.equalsIgnoreCase("Edit")) {
            articleDAO.updateArticle(article);
        }
        
        request.setAttribute("article", article);
        request.getRequestDispatcher("articles_form.jsp").forward(request, response);
    }
}
<%-- 
    Document   : articles_list
    Created on : 14-Jan-2021, 21:40:22
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
        <link rel="stylesheet" href="style.css">
        <title>Articles</title>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav">
                    <li class="nav-item active">
                        <a class="nav-link" href="articles_form.jsp">Article Info</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="./article?action=list">Articles List</a>
                    </li>
                </ul>
            </div>
        </nav>
        <h1 class="test">Articles List</h1>

        <table>
            <tr>
                <th scope="col">Code</th>
                <th scope="col">Designation</th>
                <th scope="col">Prix</th>
            </tr>
            <c:forEach items="${list}" var="article">
                <tr>
                    <td>${article.code}</td>
                    <td>${article.designation}</td>
                    <td>${article.prix}</td>
                </tr>
            </c:forEach>              
        </table>     
    </body>
</html>

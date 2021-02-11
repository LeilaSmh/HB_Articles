<%-- 
    Document   : articles_form
    Created on : 14-Jan-2021, 21:39:35
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

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
        <h1 class="test">Articles Information</h1>
        <form action="./article?action=form" method="POST">
            <table>
                <tr>
                    <th>Code:</th>
                    <td><input type="text" name="code" value="${article.code}"/></td>
                </tr>
                <tr>
                    <th>Designation:</th>
                    <td><input type="text" name="designation" value="${article.designation}"/></td>
                </tr>
                <tr>
                    <th>Prix:</th>
                    <td><input type="text" name="prix" value="${article.prix}"/></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" name="operation" value="Add"/>
                        <input type="submit" name="operation" value="Edit"/>
                        <input type="submit" name="operation" value="Delete"/>
                        <input type="submit" name="operation" value="Search"/>
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>

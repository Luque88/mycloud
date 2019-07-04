<%-- 
    Document   : index
    Created on : 4-lug-2019, 11.39.39
    Author     : tss
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/app.css" rel="stylesheet" type="text/css"/>
        <link href="css/pure.css" rel="stylesheet" type="text/css"/>
        <script src="js/../" type="text/javascript"></script>
        <title>mycloud</title>
     
    </head>
    <body>
        <input type="button" id="callDB" value="Documenti"/>
        <input id="in_findId" type="text" placeholder="id del documento da cercare">
        <input type="button" id="findId" value="cerca ID">
        <input type="button" id="b_post" value="inserisci DOCUMENTO">
        
        <div id="risultato"></div>
        
        <script src="js/" type="text/javascript"></script>
               
        
    </body>
</html>

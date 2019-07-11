<%-- 
    Document   : User
    Created on : 5-lug-2019, 11.28.49
    Author     : tss
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <c:import url="./includes/imports.jsp"/>
      
    <title>Autenticazione</title>
    </head>
    <body>
        <main> 
            <header>
                <nav>
                    <c:import url="./includes/menu.jsp"/>
                </nav>
                
            </header>
        <form class="pure-form">
            <div class="campo">
                <label for="cognome"> Cognome: </label>
                <input type="text" id="cognome" value="" placeholder="inserisci il cognome"/>
            </div> 
            <br>
            <div class="campo">
                <label for="nome"> Nome: </label>
                <input type="text" id="nome" value="" placeholder="inserisci il nome"/>
            </div>
            <br>
            <div class="username">
                <label for="username"> Username: </label>
                <input type="text" id="username" value="" placeholder="inserisci username"/>
            </div>  
            <br>
              <div class="password">
                <label for="password"> Password: </label>
                <input type="text" id="password" value="" placeholder="inserisci password"/>
            </div>  
            <br>
             <div class="email">
                <label for="email"> Email: </label>
                <input type="text" id="email" value="" placeholder="inserisci email"/>
            </div>    
            
            </div>
            <br>
            <div class="campo">
                <label for="pButton"></label>
                <input type="button" class="pure-button pure-button-primary" value="Inserisci i dati" id="pButton"/>
            </div>
            
        </form>
                <footer> 
                    <c:import url="./includes/footer.jsp"/>
                </footer>
        <script src="js/user.js" type="module"></script>
    </body>
    </html>
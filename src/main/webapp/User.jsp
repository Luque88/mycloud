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
                <article>
                    <div id="contenitore"></div>
                    <br><br>
                    <form class="pure-form">
                        <fieldset>
                            <legend>Inserisci User</legend>
                            <label for="cognome">Cognome:  </label>
                            <input type="text" id="cognome">
                        </fieldset> 
                      
                        <fieldset>
                            <label for="nome">Nome:  </label>
                            <input type="text" id="nome">
                        </fieldset>
                        
                        <fieldset>
                            <label for="username">Username:  </label>
                            <input type="text" id="username">
                        </fieldset>
                        
                        <fieldset>
                            <label for="password">Password: </label>
                            <input type="text" id="password">
                        </fieldset>
                        
                        <fieldset>
                            <label for="email">Email: </label>
                            <input type="text" id="email">
                        </fieldset>
                        
                        <input type="button" class="pure-button pure-button-primary" id="b_inserisci" value="Inserisci">
                    </form>
                    
                </article>
        </main>
                <script src="js/user.js" type="text/javascript"></script>
    </body>
</html>

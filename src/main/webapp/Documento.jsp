<%-- 
    Document   : Documento
    Created on : 4-lug-2019, 14.00.10
    Author     : tss
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <c:import url="./includes/imports.jsp"/>
        <title>Documento</title>
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
                    //da mettere nel css
                    <br><br>
                    <form class="pure-form">
                        //da mettere nel css
                        <fieldset>
                            <legend>Inserisci/Modifica DOCUMENTI</legend>
                            <label for="titolo">Titolo: </label>
                            <input type="text" id="titolo">
                            //css pure qua?
                            <label for="file">File: </label>
                            <input type="text" id="file">
                            //css pure qua?
                            <label for="user_id">User: </label>
                            <input type="text" id="user_id">
                            <input type="button" class="pure-button pure-button-primary" id="b_modDoc" value="Conferma modifica">
                            <br>
                        </fieldset>  
                        
                    </form>
                </article>
                <footer>
                    <c:import url="./includes/footer.jsp"/>
                </footer>
        </main>
                <script src="./indexDocumento.js" type="module"></script>
                // fare javascript di Documento
    </body>
</html>

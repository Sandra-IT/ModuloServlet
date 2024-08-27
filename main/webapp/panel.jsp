<%-- 
    Document   : panel
    Created on : Aug 23, 2024, 9:26:47 PM
    Author     : Luka927
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

        <link
            rel="stylesheet"
            href="https://cdn.jsdelivr.net/npm/@picocss/pico@2/css/pico.min.css"
            >
    </head>
    <body>
        <%
            if (session.getAttribute("user") == null) {
                response.sendRedirect("index.html");
                return;

            }
        %>
        <main class="container">
        <h1>Hello World!</h1>
        </main>
    </body>
</html>

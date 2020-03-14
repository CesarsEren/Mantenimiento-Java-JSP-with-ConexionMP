<%-- 
    Document   : index
    Created on : 13/03/2020, 04:41:12 PM
    Author     : Cesar´s
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mantenimento</title>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <header>
            <div id="bg-img1" class="shadow container ">
                <ul id="navbar">
                    <li class="menu-item-img  " id="logo-2"> <img src="img/logo2.png" alt=""></li>
                    <li class="menu-item-active"><a href="SvlCargarDatos">Inicio</a></li>
                    <ul class="float-end">
                        <li class="menu-item"><a href="SvlCargarDatos?cargar=index">Productos</a></li>
                        <li class="menu-item">
                            <a href="SvlCargarDatos?cargar=categorias">Categorias</a></li> 
                    </ul>
                </ul> 
            </div>
        </header>
        <main>
            <%
                String pagina = request.getParameter("pagina");
                if (pagina.equals("productos")) {
            %>
            <jsp:include page="WEB-INF/productos.jsp"></jsp:include>
            <%} else {%>
            <jsp:include page="WEB-INF/categorias.jsp"></jsp:include> 
            <%}%>
        </main>
    </body>
</html>

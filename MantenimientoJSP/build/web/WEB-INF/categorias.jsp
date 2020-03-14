<%@ page pageEncoding="UTF-8" %>
<jsp:useBean id="categorias" class="java.lang.Object" scope="request"/>
<%Object[][] listcate = (Object[][]) categorias;%>

<form method="post" action="SvlCategoria?action=Add">
    <label for="nombre">Nombre</label>
    <input type="text" name="nombre" /> 
    <input type="submit" value="Registrar"/>
</form>
<h1>Categorias</h1>
<table>   
    
    <thead>
        <tr>
            <th>Codigo Único</th>
            <th>Nombre</th> 
        </tr>
    </thead>
    <tbody>
        <%for (Object[] prod : listcate) {
                out.print("<tr>");
                out.print("<td>");
                out.print(prod[0]);
                out.print("<td>");
                out.print("<td>");
                out.print(prod[1]);
                out.print("<td>");
                out.print("</tr>");
            }%> 
    </tbody>

</table>
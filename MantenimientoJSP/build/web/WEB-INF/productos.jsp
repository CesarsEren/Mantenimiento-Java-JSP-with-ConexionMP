<%@ page pageEncoding="UTF-8" %>
<jsp:useBean id="categorias" class="java.lang.Object" scope="request"/>
<jsp:useBean id="productos" class="java.lang.Object" scope="request"/>
<%Object[][] listcate = (Object[][]) categorias;%>
<%Object[][] listprod = (Object[][]) productos;%>

<form method="post" action="SvlProducto?action=Add">
    <label for="nombre">Nombre</label>
    <input type="text" name="nombre" />
    <label for="precio">Precio</label>
    <input type="text" name="precio" id="precio" />
    <label for="categoria">Categoria</label>
    <select name="categoria"  id="categoria">
        <%for (Object[] cate : listcate) {%>
        <option value="<%=cate[0]%>"><%=cate[1]%></option>
        <%}%>
    </select>
    <input type="submit" value="Registrar"/>
</form>
<h1>Productos</h1>
<table>
    <thead>
        <tr>
            <th>Codigo Único</th>
            <th>Nombre</th>
            <th>Precio</th>
            <th>Categoria</th> 
            <th>Acción</th> 
        </tr>
    </thead>
    <tbody>
        <%for (Object[] prod : listprod) {
                out.print("<tr>");
                out.print("<td>");
                out.print(prod[0]);
                out.print("<td>");
                out.print("<td>");
                out.print(prod[1]);
                out.print("<td>");
                out.print("<td>");
                out.print(prod[2]);
                out.print("<td>");
                out.print("<td>");
                out.print(prod[3]);
                out.print("<td>");
                out.print("<td>");
                out.print("<a href='SvlCargarDatos'>Editar</a>");
                out.print("<a href='SvlCargarDatos'>Eliminar</a>");
                out.print("<td>");
                out.print("</tr>");
            }%> 
    </tbody>

</table>
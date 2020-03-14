 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mantenimiento Jquery</title>  
        <link href="css/style.css" rel="stylesheet" type="text/css"/> 
    </head> 
    <body>  
        <form method="post" action="SvlCategoria?action=Add">
            <label for="nombre">Nombre</label>
            <input type="text" name="nombre" /> 
            <input type="submit" value="Registrar"/>
        </form>
        <h1>Categorias</h1>
        <table 
            id="tablaproductos"
            data-toggle="table" 
            data-locale="es-ES" 
            data-side-pagination="server"
            data-pagination="true"
            data-url="SvlCategoria"
            data-response-handler="responseHandler">
            <thead>
                <tr>
                    <!--<th data-field="id" data-visible="false"></th>-->
                    <th data-field="idproducto">Codigo único</th>
                    <th data-field="nombre">Nombre</th>
                    <th data-field="precio">Precio</th> 
                    <th data-field="nombrecategoria">Categoria</th>
                </tr>
            </thead>
        </table>  
        <script src="https://code.jquery.com/jquery-3.4.1.js" integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU=" crossorigin="anonymous"></script>
        <script src="jsp/index.js" type="text/javascript"></script> 
        <script src="https://unpkg.com/tableexport.jquery.plugin/tableExport.min.js"></script>
        <script src="https://unpkg.com/bootstrap-table@1.16.0/dist/bootstrap-table-locale-all.min.js"></script>
    </body>
</html>

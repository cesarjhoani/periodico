<%-- 
    Document   : ListarPorCategorias
    Created on : 22/09/2023, 6:53:38 p. m.
    Author     : cesar
--%>

<%@page import="dao.CategoriaDao"%>
<%@page import="modelo.Categoria"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>listar por categoria</h1>

        <table border="1">

            <thead>
                <tr>
                    <th>id</th>
                    <th>nombre categoria</th>
                    <th>obtener libros</th>
                </tr>
            </thead>
            <tbody>
                <%
                    for (Categoria categoria : CategoriaDao.listar()) {
                %>
                <tr>
                    <td><%=categoria.getId_categoria()%></td>
                    <td><%=categoria.getNombre_categoria()%></td>
                    <td>
                        <a href="ControlerLibro?accion=obtCategoria&id=<%=categoria.getId_categoria()%>">obtener por categoria</a>
                    </td>

                </tr>
                <%}%>
            </tbody>
        </table>
        <h1>
            ${idCategoria}
        </h1>


    </body>
</html>

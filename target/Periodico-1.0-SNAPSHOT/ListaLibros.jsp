<%-- 
    Document   : ListaLibros
    Created on : 22/09/2023, 7:52:03 p. m.
    Author     : cesar
--%>

<%@page import="java.util.List"%>
<%@page import="dao.LibroDao"%>
<%@page import="modelo.Libro"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>libros segun su categoria</title>
    </head>
    <body>
        <table border="1">
            <thead>
                <tr>

                    <th>id</th>
                    <th>nombre:</th>
                    <th>autor</th>
                    <th>fecha registro</th>

                </tr>
            </thead>
            <tbody>
                <%
                    //Integer id = (Integer) request.getAttribute("idCategoria"); si en el controlador el atribute fueara un int
                    int id = Integer.parseInt((String) request.getAttribute("idCategoria"));

                    for (Libro libro : LibroDao.listarPorCategoria(id)) {

                %>
                <tr>
                    <td><%=libro.getId_libro()%></td>
                    <td><%=libro.getNombre()%></td>
                    <td><%=libro.getFecha_registro()%></td>
                    <td><%=libro.getAutor()%></td>
                    <%}%>
                </tr>
            </tbody>
        </table>

    </body>
</html>

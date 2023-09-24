<%-- 
    Document   : listar
    Created on : 21/08/2023, 12:36:23 p. m.
    Author     : cesar
--%>

<%@page import="dao.CategoriaDao"%>
<%@page import="dao.LibroDao"%>
<%@page import="modelo.Libro"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>listar libros</h1>
        <a href="registrarLibro.jsp">registrar nuevo libro</a>
        <br>
        <a href="registrarCategoria.jsp">registrar una nueva categoria</a>
        <table border="1">
            <thead>
                
                <tr>
                    <th>id:</th>
                    <th>nombre:</th>
                    <th>autor</th>
                    <th>fecha registro</th>
                    <th>categoria</th>
                    <th>acciones </th>
                </tr>
            </thead>
            <tbody>
                <%for(Libro libro:LibroDao.listar()){%>
                <tr>
                    <td><%= libro.getId_libro() %></td>
                    <td><%= libro.getNombre() %></td>
                    <td><%= libro.getAutor() %></td>
                    <td><%= libro.getFecha_registro() %></td>
                    <td><%= CategoriaDao.obtenerCategoria(libro.getCategoria_id()) %></td>
                    <td>
                        <a href="ControlerLibro?accion=eliminar&id=<%=libro.getId_libro()%>">eliminar</a>
                        <a href="ControlerLibro?accion=editar&id=<%=libro.getId_libro()%>">editar</a>
                    </td>
                    <%}%>
                </tr>
            </tbody>
        </table>
                    <h2>
                        <%if(request.getAttribute("mensaje")!=null)
                        out.print(request.getAttribute("mensaje"));
                        
                        %>
                    
                </h2>

    </body>
</html>

<%-- 
    Document   : editar
    Created on : 22/08/2023, 9:39:48 a. m.
    Author     : cesar
--%>

<%@page import="dao.LibroDao"%>
<%@page import="modelo.Libro"%>
<%@page import="modelo.Categoria"%>
<%@page import="dao.CategoriaDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <h1>editar libro</h1>
        <%
            int id = Integer.parseInt((String)request.getAttribute("idLibro"));
            Libro libro = LibroDao.list(id);
        
        %>
        <form action="ControlerLibro" method="get">
            <p><label>nombre</label><input type="text" name="txtnombre" value="<%= libro.getNombre()%>"></p>
            <p><label>autor</label><input type="text" name="txtautor" value="<%= libro.getAutor()%>"></p>
            <p><label>categoria</label>
                <select name="txtcategoria" value="<%=libro.getCategoria_id() %>">
                    <option value="0">selecione una categoria</option>
                    <%for(Categoria categoria:CategoriaDao.listar()){%>
                    <option value="<%= categoria.getId_categoria()%>"><%= categoria.getNombre_categoria() %></option>
                    <%}%>
                </select>
            </p>
            <h3>
                <%if(request.getAttribute("mensaje")!=null)
                out.print(request.getAttribute("mensaje"));
                %>
            </h3>
            <input type="hidden" name="txtid" value="<%=libro.getId_libro()%>">
            <button type="submit" name="accion" value="actualizar">registrar libro</button>
            
        </form>
            
    </body>
</html>

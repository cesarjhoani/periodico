<%-- 
    Document   : registrarLibro
    Created on : 21/08/2023, 12:36:13 p. m.
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
        <h1>registrar libro</h1>
        
        <form action="ControlerLibro" method="post">
            <p><label>nombre</label><input type="text" name="nombre" placeholder="nombre"></p>
            <p><label>autor</label><input type="text" name="autor" placeholder="autor"></p>
            <p><label>categoria</label>
                <select name="categoria">
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
            <button type="submit">registrar libro</button>
        </form>
    </body>
</html>

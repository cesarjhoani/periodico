<%-- 
    Document   : registrarCategoria
    Created on : 21/08/2023, 12:35:56 p. m.
    Author     : cesar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>ingresar categoria</h1>
        
        <form action="ControlerCategoria" method="post">
            <p><label>nombre</label><input type="text" name="nombre" placeholder="nombre"></p>
            <button type="submit">agregar categoria</button>
        </form>
        
        <h1>
            <%if(request.getAttribute("mensaje")!=null)
            out.print(request.getAttribute("mensaje"));
            %>
            
        </h1>
    </body>
</html>

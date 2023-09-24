/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import dao.LibroDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Libro;

/**
 *
 * @author cesar
 */
public class ControlerLibro extends HttpServlet {

    String listar = "listar.jsp";
    String editar = "editar.jsp";
   
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("accion");
        String acceso = "";
        if(action.equalsIgnoreCase("eliminar")){
            int id = Integer.parseInt(request.getParameter("id"));
            Libro libro = new Libro();
            libro.setId_libro(id);
            boolean eliminado = LibroDao.eliminar(libro);
            if(eliminado){
                request.setAttribute("mensaje", "el libro fue eliminado");
                request.getRequestDispatcher("listar.jsp").forward(request, response);
            }else{
                request.setAttribute("mensaje", "el libro no fue eliminado");
                request.getRequestDispatcher("listar.jsp").forward(request, response);
            }
        }else if(action.equalsIgnoreCase("editar")){
            request.setAttribute("idLibro", request.getParameter("id"));
           request.getRequestDispatcher("editar.jsp").forward(request, response);
        }else if(action.equalsIgnoreCase("actualizar")){
            int id = Integer.parseInt(request.getParameter("txtid"));
            String nombre  = request.getParameter("txtnombre");
            String autor = request.getParameter("txtautor");
            int idforaneo = Integer.parseInt(request.getParameter("txtcategoria"));
            Libro libro = new Libro();
            libro.setNombre(nombre);
            libro.setAutor(autor);
            libro.setCategoria_id(idforaneo);
            libro.setId_libro(id);
            LibroDao.editar(libro);
            request.getRequestDispatcher("listar.jsp").forward(request, response);
        }else if(action.equalsIgnoreCase("obtener")){
            request.getRequestDispatcher("ListarPorCategorias.jsp").forward(request, response);
        }else if(action.equalsIgnoreCase("obtCategoria")){
            
            //int idCategoria = Integer.parseInt(request.getParameter("id"));
            String idCategoria = request.getParameter("id");
            //List<Libro> lista = LibroDao.listarPorCategoria(idCategoria);
            
            request.setAttribute("idCategoria", idCategoria);
            
          request.getRequestDispatcher("ListaLibros.jsp").forward(request, response);
        }
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        String autor = request.getParameter("autor");
        int categoria = Integer.parseInt(request.getParameter("categoria"));
        Libro libro = new Libro();
        libro.setNombre(nombre);
        libro.setAutor(autor);
        libro.setCategoria_id(categoria);
        if(LibroDao.registrar(libro)){
            request.setAttribute("mensaje", "el libro fue registrado");
        }else{
            request.setAttribute("mensaje", "el libro no fue registrado");
        }
        request.getRequestDispatcher("registrarLibro.jsp").forward(request, response);
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

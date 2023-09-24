/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Libro;


/**
 *
 * @author cesar
 */
public class LibroDao {
    public static Libro libro = new Libro();
    public static boolean registrar(Libro libro){
        try {
            Conexion conexion = new Conexion();
            Connection cx = conexion.conectar();
            String sql = "INSERT INTO libro(nombre,autor,fecha_registro,categoria_id) values (?,?,NOW(),?);";
            PreparedStatement st = cx.prepareStatement(sql);
            st.setString(1, libro.getNombre());
            st.setString(2, libro.getAutor());
            st.setInt(3, libro.getCategoria_id());
            if(st.executeUpdate()>0){
                return true;
            }else{
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(LibroDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
       
    }
    public static List<Libro> listar(){
        List<Libro> lista = new ArrayList<>();
        try {
            Conexion dao = new Conexion();
            Connection cx = dao.conectar();
            String sql = "SELECT * FROM libro";
            PreparedStatement st = cx.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                Libro libro = new Libro();
                libro.setId_libro(rs.getInt("id_libro"));
                libro.setNombre(rs.getString("nombre"));
                libro.setAutor(rs.getString("autor"));
                libro.setFecha_registro(rs.getString("fecha_registro"));
                libro.setCategoria_id(rs.getInt("categoria_id"));
                lista.add(libro);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(CategoriaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
       }
    public static boolean eliminar(Libro libro){
        try {
            Conexion dao = new Conexion();
            Connection cx = dao.conectar();
            String sql = "delete from libro where id_libro = ?";
            PreparedStatement st = cx.prepareStatement(sql);
            st.setInt(1, libro.getId_libro());
            if(st.executeUpdate()>0){
                return true;
            }else{
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(LibroDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public static boolean editar(Libro libro){
        try {
            Conexion dao = new Conexion();
            Connection cx = dao.conectar();
            String sql = "UPDATE libro SET nombre = '"+libro.getNombre()+"',autor = '"+libro.getAutor()+"',categoria_id = '"+libro.getCategoria_id()+"'WHERE id_libro ="+libro.getId_libro();
            PreparedStatement st = cx.prepareStatement(sql);
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(LibroDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public static Libro list(int id){
        try {
            Conexion dao = new Conexion();
            Connection cx = dao.conectar();
            String sql = "SELECT * FROM libro WHERE id_libro="+id;
            PreparedStatement st = cx.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                
                libro.setId_libro(rs.getInt("id_libro"));
                libro.setNombre(rs.getString("nombre"));
                libro.setAutor(rs.getString("autor"));
                libro.setFecha_registro(rs.getString("fecha_registro"));
                libro.setCategoria_id(rs.getInt("categoria_id"));
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(CategoriaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return libro;
    }
    public static List<Libro> listarPorCategoria(int categoriaId) {
    List<Libro> lista = new ArrayList<>();
    try {
        Conexion dao = new Conexion();
        Connection cx = dao.conectar();
        String sql = "SELECT * FROM libro WHERE categoria_id = ?";
        PreparedStatement st = cx.prepareStatement(sql);
        st.setInt(1, categoriaId);
        ResultSet rs = st.executeQuery();
        while (rs.next()) {
            Libro libro = new Libro();
            libro.setId_libro(rs.getInt("id_libro"));
            libro.setNombre(rs.getString("nombre"));
            libro.setAutor(rs.getString("autor"));
            libro.setFecha_registro(rs.getString("fecha_registro"));
            libro.setCategoria_id(rs.getInt("categoria_id"));
            lista.add(libro);
        }
    } catch (SQLException ex) {
        Logger.getLogger(CategoriaDao.class.getName()).log(Level.SEVERE, null, ex);
    }
    return lista;
}

}

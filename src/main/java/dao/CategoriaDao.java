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
import modelo.Categoria;

/**
 *
 * @author cesar
 */
public class CategoriaDao {
    public static boolean registrar(Categoria categoria){
        try {
            Conexion dao = new Conexion();
            Connection cx = dao.conectar();
            String sql = "INSERT INTO categoria(nombre_categoria) VALUES (?);";
            PreparedStatement st = cx.prepareStatement(sql);
            st.setString(1, categoria.getNombre_categoria());
            if(st.executeUpdate()>0){
                return true;
            }else{
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoriaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public static List<Categoria> listar(){
        List<Categoria> lista = new ArrayList<>();
        try {
            Conexion dao = new Conexion();
            Connection cx = dao.conectar();
            String sql = "SELECT * FROM categoria";
            PreparedStatement st = cx.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                Categoria categoria = new Categoria();{
                categoria.setId_categoria(rs.getInt("id_categoria"));
                categoria.setNombre_categoria(rs.getString("nombre_categoria"));
                lista.add(categoria);
            }
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoriaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
       }
    public static String obtenerCategoria(int id){
        
        try {
            Conexion dao = new Conexion();
            Connection cx = dao.conectar();
            String sql = "SELECT nombre_categoria FROM categoria where id_categoria=?";
            PreparedStatement st = cx.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                
                return rs.getString("nombre_categoria");
                
            }
            return "--";
        } catch (SQLException ex) {
            Logger.getLogger(CategoriaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "--";
       }
}

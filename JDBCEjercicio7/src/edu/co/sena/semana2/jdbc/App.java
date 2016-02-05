/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.semana2.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

/**
 *
 * @author Fores
 */
public class App {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException {
        Connection conexion = null;
        Properties propiedades = new Properties();
        propiedades.setProperty("user", "usuario");
        propiedades.setProperty("password", "12345");
        Statement sentencia = null;
        ResultSet rs = null;

        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese el id del producto");
        int i = teclado.nextInt();
        String sql = "select * from tienda_online2.producto p where p.ID_Producto = " + i + ";";
        System.out.println(sql);

        try {
            conexion = DriverManager.getConnection("jdbc:mysql://172.16.2.142:3306/tienda_online2", propiedades);
            System.out.println("Se conecto");
            sentencia = conexion.createStatement();
            rs = sentencia.executeQuery(sql);
            Producto producto = new Producto();
            if (!rs.wasNull()) {
                while (rs.next()) {

                    producto.setIdProducto(rs.getString(1));
                    producto.setNombreProducto(rs.getString(2));
                    producto.setPrecioDetal(rs.getDouble(3));
                    producto.setImagen(rs.getBlob(4));
                    producto.setCantidad(rs.getFloat(5));
                    producto.setActivo(rs.getByte(6));
                    producto.setCategoriaIdCategoria(rs.getInt(7));
                    producto.setCatalogoIdCatalogo(rs.getInt(8));
                }

            } else {
                System.out.println("No hay datos");
            }

            System.out.println("Producto: " + "\n"
                    + "Id Producto: " + producto.getIdProducto() + "\n"
                    + "Nombre Producto: " + producto.getNombreProducto() + "\n"
                    + "Precio Detal: " + producto.getPrecioDetal() + "\n"
                    + "Imagen: " + producto.getImagen().length() + "\n"
                    + "Cantidad: " + producto.getCantidad() + "\n"
                    + "Activo: " + producto.getActivo() + "\n"
                    + "Categoria Id Categoria: " + producto.getCategoriaIdCategoria() + "\n"
                    + "Catalogo Id Catalogo: " + producto.getCatalogoIdCatalogo());
            conexion.close();

        } catch (SQLException e) {
            System.err.println(e.toString());

        } finally {
            if (conexion != null) {
                conexion.close();
                System.out.println("Se cerro la conexion correctamente");
            }
        }
    }

}

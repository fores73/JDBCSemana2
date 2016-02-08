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
import javax.swing.JOptionPane;

/**
 *
 * @author Fores
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        Connection conexion = null;
        Properties propiedades = new Properties();
        propiedades.setProperty("user", "usuario");
        propiedades.setProperty("password", "12345");
        Statement sentencia = null;
        ResultSet rs = null;

        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese el id de la factura");
       
        int i = teclado.nextInt();
        String sql = "SELECT \n"
                + "    p.ID_PRODUCTO, p.NOMBRE_PRODUCTO, i.CANTIDAD, i.COSTO_TOTAL\n"
                + "FROM\n"
                + "    tienda_online2.factura f,\n"
                + "    tienda_online2.producto p,\n"
                + "    tienda_online2.item i,\n"
                + "    tienda_online2.pedido d\n"
                + "WHERE\n"
                + "    f.id_factura = "+i+"\n"
                + "        AND f.id_factura = d.factura_id_factura\n"
                + "        AND d.factura_id_factura = i.pedido_factura_id_factura\n"
                + "        AND i.pedido_factura_id_factura = p.id_producto;";
        System.out.println(sql);

        try {
            conexion = DriverManager.getConnection("jdbc:mysql://172.16.2.142:3306/tienda_online2", propiedades);
            System.out.println("Se conecto");
            sentencia = conexion.createStatement();
            rs = sentencia.executeQuery(sql);

            if (!rs.wasNull()) {
                while (rs.next()) {
                    

                }

            } else {
                System.out.println("No hay datos");
            }

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

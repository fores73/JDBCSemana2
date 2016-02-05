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
public class Ejercicio {

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
        System.out.println("Ingrese el id del catalogo");
        int i = teclado.nextInt();
        String sql = "Select * from tienda_online2.Catalogo p where p.ID_CATALOGO = " + i + ";";
        System.out.println(sql);
        try {

            conexion = DriverManager.getConnection("jdbc:mysql://172.16.2.142:3306/tienda_online2", propiedades);
            System.out.println("Se conecto");
            sentencia = conexion.createStatement();
            rs = sentencia.executeQuery(sql);

            if (!rs.wasNull()) {
                while (rs.next()) {
                    System.out.println("id catalogo: " + rs.getInt(1));
                    System.out.println("nombre catalogo: " + rs.getString(2));
                    System.out.println("Descripcion: " + rs.getString(3));
                    System.out.println("----------------------");

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

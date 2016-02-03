/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.semana2.jdbc;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.util.Properties;

/**
 *
 * @author Fores
 */
public class Ejercicio4 {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException {

        java.sql.Connection conexion = null;
        Properties propiedades = new Properties();
        propiedades.setProperty("user", "aprendiz");
        propiedades.setProperty("password", "12345");

        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/prueba1", propiedades);

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

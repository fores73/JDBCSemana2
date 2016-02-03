/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.semana1.jdbc;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Fores
 */
public class Ejercicio3 {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException {
        java.sql.Connection conexion = null;
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/prueba1?"
                    + "user=aprendiz&password=12345");
            System.out.println("se conecto");

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

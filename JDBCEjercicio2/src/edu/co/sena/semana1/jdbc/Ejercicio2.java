/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.semana1.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Fores
 */
public class Ejercicio2 {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException {
        Connection conexion = null;

        try {
            String urlServidor = "jdbc:mysql://172.16.0.96:3306/prueba1";
            String usuarioDB = "aprendiz";
            String passwordDB = "12345";
            conexion = DriverManager.getConnection(urlServidor, usuarioDB, passwordDB);
            System.out.println("Se conecto");

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

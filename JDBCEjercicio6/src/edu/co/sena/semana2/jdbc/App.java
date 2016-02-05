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
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

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

        List<Factura> listaFactura = new ArrayList<>();

        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese la id de la factura");
        int i = teclado.nextInt();
        String sql = "select * from tienda_online2.factura p where p.ID_FACTURA = " + i + ";";
        System.out.println(sql);

        try {
            conexion = DriverManager.getConnection("jdbc:mysql://172.16.2.142:3306/tienda_online2", propiedades);
            System.out.println("Se conecto");
            sentencia = conexion.createStatement();
            rs = sentencia.executeQuery(sql);

            if (!rs.wasNull()) {
                while (rs.next()) {
                    Factura factura = new Factura();
                    factura.setIdFactura(rs.getInt(1));
                    factura.setCuentaTipoDocumento(rs.getString(2));
                    factura.setCuentaNumeroDocumento(rs.getString(3));
                    factura.setFechaFactura(rs.getDate(4));
                    factura.setFormaPago(rs.getString(5));
                    factura.setEstado(rs.getString(6));

                    listaFactura.add(factura);
                }

            } else {
                System.out.println("No hay datos");
            }

            for (Factura factura1 : listaFactura) {
                System.out.println(factura1.toString());
                System.out.println("------------------");
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

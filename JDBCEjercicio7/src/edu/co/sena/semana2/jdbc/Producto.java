/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.semana2.jdbc;

import java.sql.Blob;

/**
 *
 * @author Fores
 */
public class Producto {

    private String idProducto;
    private String nombreProducto;
    private double precioDetal;
    private Blob imagen;
    private float cantidad;
    private Byte activo;
    private int categoriaIdCategoria;
    private int catalogoIdCatalogo;

    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public double getPrecioDetal() {
        return precioDetal;
    }

    public void setPrecioDetal(double precioDetal) {
        this.precioDetal = precioDetal;
    }

    public Blob getImagen() {
        return imagen;
    }

    public void setImagen(Blob imagen) {
        this.imagen = imagen;
    }

    public float getCantidad() {
        return cantidad;
    }

    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }

    public Byte getActivo() {
        return activo;
    }

    public void setActivo(Byte activo) {
        this.activo = activo;
    }

    public int getCategoriaIdCategoria() {
        return categoriaIdCategoria;
    }

    public void setCategoriaIdCategoria(int categoriaIdCategoria) {
        this.categoriaIdCategoria = categoriaIdCategoria;
    }

    public int getCatalogoIdCatalogo() {
        return catalogoIdCatalogo;
    }

    public void setCatalogoIdCatalogo(int catalogoIdCatalogo) {
        this.catalogoIdCatalogo = catalogoIdCatalogo;
    }

    @Override
    public String toString() {
        return "Producto: " + "\n"
                + "Id Producto: " + idProducto + "\n"
                + "Nombre Producto: " + nombreProducto + "\n"
                + "Precio Detal: " + precioDetal + "\n"
                + "Imagen: " + imagen + "\n"
                + "Cantidad: " + cantidad + "\n"
                + "Activo: " + activo + "\n"
                + "Categoria Id Categoria: " + categoriaIdCategoria + "\n"
                + "Catalogo Id Catalogo: " + catalogoIdCatalogo + "\n";
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.semana2.jdbc;

import java.sql.Date;

/**
 *
 * @author Fores
 */
public class Factura {

    private int idFactura;
    private String cuentaTipoDocumento;
    private String cuentaNumeroDocumento;
    private Date fechaFactura;
    private String formaPago;
    private String estado;

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public String getCuentaTipoDocumento() {
        return cuentaTipoDocumento;
    }

    public void setCuentaTipoDocumento(String cuentaTipoDocumento) {
        this.cuentaTipoDocumento = cuentaTipoDocumento;
    }

    public String getCuentaNumeroDocumento() {
        return cuentaNumeroDocumento;
    }

    public void setCuentaNumeroDocumento(String cuentaNumeroDocumento) {
        this.cuentaNumeroDocumento = cuentaNumeroDocumento;
    }

    public Date getFechaFactura() {
        return fechaFactura;
    }

    public void setFechaFactura(Date fechaFactura) {
        this.fechaFactura = fechaFactura;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Factura: " + "\n"
                + "ID factura: " + idFactura + "\n"
                + "Cuenta Tipo Documento: " + cuentaTipoDocumento + "\n"
                + "Cuenta Numero Documento: " + cuentaNumeroDocumento + "\n"
                + "Fecha Factura: " + fechaFactura + "\n"
                + "Forma Pago: " + formaPago + "\n"
                + "Estado: " + estado + "\n";
    }

}

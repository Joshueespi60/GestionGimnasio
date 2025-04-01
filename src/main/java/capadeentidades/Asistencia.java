/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package capadeentidades;

import java.sql.Date;
import java.sql.Time;

public class Asistencia {
    private int idCliente;
    private Date fechaAsistencia;
    private Time horaEntrada;
    private Time horaSalida;
    private String observaciones;
    private double pagoDiario;  // El valor que se paga por la asistencia diaria

    // Constructor
    public Asistencia(int idCliente, Date fechaAsistencia, Time horaEntrada, Time horaSalida, String observaciones, double pagoDiario) {
        this.idCliente = idCliente;
        this.fechaAsistencia = fechaAsistencia;
        this.horaEntrada = horaEntrada;
        this.horaSalida = horaSalida;
        this.observaciones = observaciones;
        this.pagoDiario = pagoDiario;
    }

    // Getters y Setters
    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public Date getFechaAsistencia() {
        return fechaAsistencia;
    }

    public void setFechaAsistencia(Date fechaAsistencia) {
        this.fechaAsistencia = fechaAsistencia;
    }

    public Time getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(Time horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public Time getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(Time horaSalida) {
        this.horaSalida = horaSalida;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public double getPagoDiario() {
        return pagoDiario;
    }

    public void setPagoDiario(double pagoDiario) {
        this.pagoDiario = pagoDiario;
    }
}


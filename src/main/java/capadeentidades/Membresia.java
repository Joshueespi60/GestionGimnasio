/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package capadeentidades;

/**
 *
 * @author Joshue
 */
import java.util.Date;

public class Membresia {
    private int idCliente;
    private String nombre;
    private String apellido;
    private String telefono;
    private String tipoMembresia;
    private Date fechaInicio;
    private Date fechaVencimiento;

    public Membresia(int idCliente, String nombre, String apellido, String telefono, String tipoMembresia, Date fechaInicio, Date fechaVencimiento) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.tipoMembresia = tipoMembresia;
        this.fechaInicio = fechaInicio;
        this.fechaVencimiento = fechaVencimiento;
    }

    public Membresia(int idCliente, String tipoMembresia, Date fechaInicio, Date fechaVencimiento) {
        this.idCliente = idCliente;
        this.tipoMembresia = tipoMembresia;
        this.fechaInicio = fechaInicio;
        this.fechaVencimiento = fechaVencimiento;
    }

    public int getIdCliente() { return idCliente; }
    public String getNombre() { return nombre; }
    public String getApellido() { return apellido; }
    public String getTelefono() { return telefono; }
    public String getTipoMembresia() { return tipoMembresia; }
    public Date getFechaInicio() { return fechaInicio; }
    public Date getFechaVencimiento() { return fechaVencimiento; }
}

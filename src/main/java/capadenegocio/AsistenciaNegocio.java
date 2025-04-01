/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package capadenegocio;

import capadedatos.AsistenciaDAO;
import capadeentidades.Asistencia;
import capadeentidades.Membresia;
import java.util.List;

public class AsistenciaNegocio {
    private AsistenciaDAO asistenciaDAO = new AsistenciaDAO();
    private MembresiaNegocio membresiaNegocio = new MembresiaNegocio();  // Se crea solo una vez

    // Registrar una nueva asistencia
    public boolean registrarAsistencia(Asistencia asistencia) {
        // Aquí puedes agregar alguna validación de reglas de negocio
        // Ejemplo: Verificar si el cliente tiene membresía activa o si es un pago diario
        return asistenciaDAO.registrarAsistencia(asistencia);
    }

    // Obtener las asistencias por cliente
    public List<Asistencia> obtenerAsistenciasPorCliente(int idCliente) {
        return asistenciaDAO.obtenerAsistenciasPorCliente(idCliente);
    }

    // Obtener todas las asistencias registradas
    public List<Asistencia> obtenerTodasLasAsistencias() {
        return asistenciaDAO.obtenerAsistencias();
    }



    // Registrar pago diario si el cliente no tiene membresía activa
    public boolean registrarPagoDiario(int idCliente, double monto) {
        Asistencia asistencia = new Asistencia(idCliente, new java.sql.Date(System.currentTimeMillis()), null, null, null, monto);
        return registrarAsistencia(asistencia);
    }
}



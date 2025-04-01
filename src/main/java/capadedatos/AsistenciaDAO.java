/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package capadedatos;

import capadeentidades.Asistencia;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AsistenciaDAO {
    // Método para registrar asistencia
    public boolean registrarAsistencia(Asistencia asistencia) {
        String sql = "INSERT INTO asistencia (id_cliente, fecha_asistencia, hora_entrada, hora_salida, observaciones, pago_diario) "
                   + "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = Conexion.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, asistencia.getIdCliente());
            stmt.setDate(2, asistencia.getFechaAsistencia());
            stmt.setTime(3, asistencia.getHoraEntrada());
            stmt.setTime(4, asistencia.getHoraSalida());
            stmt.setString(5, asistencia.getObservaciones());
            stmt.setDouble(6, asistencia.getPagoDiario());

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al registrar asistencia: " + e.getMessage());
            return false;
        }
    }

    // Obtener todas las asistencias registradas
    public List<Asistencia> obtenerAsistencias() {
        List<Asistencia> asistencias = new ArrayList<>();
        String sql = "SELECT * FROM asistencia";

        try (Connection conn = Conexion.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Asistencia asistencia = new Asistencia(
                        rs.getInt("id_cliente"),
                        rs.getDate("fecha_asistencia"),
                        rs.getTime("hora_entrada"),
                        rs.getTime("hora_salida"),
                        rs.getString("observaciones"),
                        rs.getDouble("pago_diario")
                );
                asistencias.add(asistencia);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener asistencias: " + e.getMessage());
        }
        return asistencias;
    }

    // Obtener asistencias por cliente (por ID de cliente)
    public List<Asistencia> obtenerAsistenciasPorCliente(int idCliente) {
        List<Asistencia> asistencias = new ArrayList<>();
        String sql = "SELECT * FROM asistencia WHERE id_cliente = ?";

        try (Connection conn = Conexion.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idCliente);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Asistencia asistencia = new Asistencia(
                        rs.getInt("id_cliente"),
                        rs.getDate("fecha_asistencia"),
                        rs.getTime("hora_entrada"),
                        rs.getTime("hora_salida"),
                        rs.getString("observaciones"),
                        rs.getDouble("pago_diario")
                );
                asistencias.add(asistencia);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener asistencias por cliente: " + e.getMessage());
        }
        return asistencias;
    }
}


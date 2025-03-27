/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package capadedatos;

/**
 *
 * @author Joshue
 */
import capadeentidades.Membresia;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MembresiaDAO {
    public List<Membresia> obtenerClientesConMembresia() {
        List<Membresia> lista = new ArrayList<>();
        String sql = "SELECT c.id, c.nombre, c.apellido, c.telefono, m.tipo, m.fecha_inicio, m.fecha_fin " +
                     "FROM clientes c " +
                     "LEFT JOIN membresias m ON c.id = m.id_cliente";

        try (Connection conn = Conexion.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Membresia m = new Membresia(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("apellido"),
                    rs.getString("telefono"),
                    rs.getString("tipo"),
                    rs.getDate("fecha_inicio"),
                    rs.getDate("fecha_fin")
                );
                lista.add(m);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener clientes con membresía: " + e.getMessage());
        }
        return lista;
    }

    public boolean registrarMembresia(Membresia membresia) {
        String sql = "INSERT INTO membresias (id_cliente, tipo, fecha_inicio, fecha_fin) VALUES (?, ?, ?, ?)";

        try (Connection conn = Conexion.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, membresia.getIdCliente());
            stmt.setString(2, membresia.getTipoMembresia());
            stmt.setDate(3, new java.sql.Date(membresia.getFechaInicio().getTime()));
            stmt.setDate(4, new java.sql.Date(membresia.getFechaVencimiento().getTime()));

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al registrar membresía: " + e.getMessage());
            return false;
        }
    }

    public boolean cancelarMembresia(int idCliente) {
        String sql = "DELETE FROM membresias WHERE id_cliente = ?";

        try (Connection conn = Conexion.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idCliente);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al cancelar membresía: " + e.getMessage());
            return false;
        }
    }
}

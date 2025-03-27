/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package capadenegocio;

/**
 *
 * @author Joshue
 */
import capadedatos.MembresiaDAO;
import capadeentidades.Membresia;
import java.util.List;

public class MembresiaNegocio {
    private MembresiaDAO membresiaDAO = new MembresiaDAO();

    public List<Membresia> obtenerClientesConMembresia() {
        return membresiaDAO.obtenerClientesConMembresia();
    }

    public boolean registrarMembresia(Membresia membresia) {
        return membresiaDAO.registrarMembresia(membresia);
    }

    public boolean cancelarMembresia(int idCliente) {
        return membresiaDAO.cancelarMembresia(idCliente);
    }
}

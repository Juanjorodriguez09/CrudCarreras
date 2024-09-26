import entidades.Carrera;
import jakarta.persistence.EntityManager;
import utilidades.JpaUtil;

import javax.swing.*;

public class HibernateCrear {
    public static void main(String[] args) {

        // Creamos una nueva instancia de Carrera
        Carrera ca = new Carrera();

        // Solicitamos los datos de la nueva carrera al usuario
        String nombre = JOptionPane.showInputDialog("Ingrese nombre de Carrera");
        String tipo = JOptionPane.showInputDialog("Digite el tipo de la Carrera (número entero):");
        String idFacultad = JOptionPane.showInputDialog("Digite el id de la facultad:");

        // Establecemos los valores de la instancia Carrera
        ca.setNombre(nombre);
        ca.setTipo(Integer.parseInt(tipo));
        ca.setIdFacultad(Integer.parseInt(idFacultad));

        // Obtenemos el EntityManager
        EntityManager em = JpaUtil.getEntityManager();
        try {
            // Iniciamos una transacción
            em.getTransaction().begin();
            // Persistimos la entidad Carrera
            em.persist(ca);
            // Confirmamos la transacción
            em.getTransaction().commit();
            System.out.println("Carrera creada exitosamente!");
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println("Error al crear la carrera: " + e.getMessage());
        } finally {
            em.close();
        }
    }
}

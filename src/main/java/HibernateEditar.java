import entidades.Carrera;
import jakarta.persistence.EntityManager;
import utilidades.JpaUtil;

import javax.swing.*;

public class HibernateEditar {
    public static void main(String[] args) {

        EntityManager em = JpaUtil.getEntityManager();

        try {
            // Solicitar un Id
            Long id = Long.valueOf((JOptionPane.showInputDialog("Ingrese un código de carrera a modificar: ")));
            // Se busca en la base de datos
            Carrera ca = em.find(Carrera.class, id);

            // Se solicitan los nuevos datos
            String nombre = JOptionPane.showInputDialog("Ingrese nuevo nombre de Carrera : ", ca.getNombre());
            String tipo=JOptionPane.showInputDialog("Ingrese tipo de carrera: ",ca.getTipo());
            String Facultad = JOptionPane.showInputDialog("Ingrese abreviatura de Carrera: ", ca.getIdFacultad());

            // Se inicia transacción
            em.getTransaction().begin();
            //Pasamos los nuevos valores
            ca.setNombre(nombre);
            ca.setTipo(Integer.parseInt(tipo));
            ca.getIdFacultad();
            // TODO
            em.merge(ca);


            em.getTransaction().commit(); //Se sincronizan los datos a la BD
            // Se publica el registro modificado
            System.out.println(ca);

        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println("Se ha generado el error: " + e.getMessage());

        } finally {
            em.close();
        }
    }
}
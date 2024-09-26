import entidades.Carrera;

import jakarta.persistence.EntityManager;
import utilidades.JpaUtil;

import java.util.List;

public class HibernateListar {
    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEntityManager();
        List<Carrera> Carreras = em.createQuery("from Carrera ", Carrera.class).getResultList();
        Carreras.forEach(System.out::println);

    }
}

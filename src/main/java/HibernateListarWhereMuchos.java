import entidades.Carrera;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import utilidades.JpaUtil;
import java.util.List;
import java.util.Scanner;

public class HibernateListarWhereMuchos {
    public static void main(String[] args) {
        Scanner s =new Scanner(System.in);

        EntityManager em= JpaUtil.getEntityManager();

        Query consulta =em.createQuery("SELECT f from Carrera f where f.id>?1", Carrera.class);

        System.out.print("Ingrese un código de carrera: ");
        String id = s.next();

        consulta.setParameter(1,id);
        //TODO
        List<Carrera> ca = consulta.getResultList();
        System.out.println(ca);


        em.close();

    }
}
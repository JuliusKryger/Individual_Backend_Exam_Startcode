package facades;

import dtos.ZooDTO;
import entities.Zoo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class ZooFacade {

    private static EntityManagerFactory emf;
    private static ZooFacade instance;

    public ZooFacade() {
    }


    /**
     * Full CRUD checklist ...
     * Create Animal
     * Get Animal By ID
     * Get all animals
     * Update Animal
     * Delete Animal
     **/

    public static ZooFacade getZooFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new ZooFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public ZooDTO getZooById(Integer id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Zoo zoo = em.find(Zoo.class, id);
        em.getTransaction().commit();
        em.close();
        if (zoo != null) {
            zoo.setId(id);
            return new ZooDTO(zoo);
        } else {
            return null;
        }

    }










}

package facades;

import dtos.ZooDTO;
import dtos.ZoosDTO;
import entities.Zoo;
import utils.Utility;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

public class ZooFacade {

    private static EntityManagerFactory emf;
    private static ZooFacade instance;

    public ZooFacade() {
    }


    /**
     * Full CRUD checklist ...
     * Create Zoo
     * Get Zoo By ID done
     * Get all Zoo's
     * Update Zoo
     * Delete Zoo
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

    /**                                                     !! Will remove later !!
    public List<ZooDTO> getAllZoosREMOVE() {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Zoo> query = em.createQuery("SELECT z FROM Zoo z JOIN z.animals", Zoo.class);
        return Utility.convertList(ZooDTO.class, query.getResultList());
    }
    **/

    public ZoosDTO getAllZoos(){
        EntityManager em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
            TypedQuery <Zoo> typedQuery = em.createNamedQuery("Zoo.getAllRows", Zoo.class);
            List<Zoo> zooList = typedQuery.getResultList();
            ZoosDTO zoosDTO = new ZoosDTO(zooList);
            em.getTransaction().commit();
            return zoosDTO;
        }
        finally {
            em.close();
        }
    }

    public boolean deleteZooById(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.createQuery("DELETE FROM Zoo z WHERE z.id = :id").setParameter("id", id).executeUpdate();
            em.createNamedQuery("Zoo.deleteZooById").setParameter("id", id).executeUpdate();
            em.getTransaction().commit();
            return true;
        } finally {
            em.close();
        }
    }








}

package facades;

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









}

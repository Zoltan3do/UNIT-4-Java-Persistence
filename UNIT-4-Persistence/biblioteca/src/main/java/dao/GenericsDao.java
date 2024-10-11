package dao;

import java.util.UUID;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class GenericsDao {
	
	// Dagli studi del Sig. Pellizzari

    private final EntityManager entityManager;

    public GenericsDao(EntityManager em){
        this.entityManager = em;
    }

    public <T> void save(T obj){
        EntityTransaction t = entityManager.getTransaction();

        t.begin();

        entityManager.persist(obj);

        t.commit();

        System.out.println(obj + " Saved!");
    }


    
    public <T> T getEventById (Class<T> entityClass, String id) throws Exception {

        T found = entityManager.find(entityClass, UUID.fromString(id));
        
        if (found == null) throw new Exception("Evento non trovato");
        
        return found;
    }

    
    
    public <T> void delete (Class<T> entityClass, String  id) throws Exception {
    	
        T obj = this.getEventById(entityClass, id);

        EntityTransaction t = entityManager.getTransaction();

        t.begin();

        entityManager.remove(obj);

        t.commit();

        System.out.println(obj + " Deleted!");

    }

}

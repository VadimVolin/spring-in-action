package spitter.data.jpa;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;
import spitter.data.Spitter;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Random;

@Repository("spitter")
public class JpaSpitterDao implements SpitterDAO {

    private Random random = new Random();
    private static final int RANGE = 999_999_999;

    private static final String SQL_ALL_SPITTER = "SELECT s FROM spitter s";

    @PersistenceContext
    private EntityManager entityManager;

    //    @Transactional
    @Override
    public void addSpitter(Spitter spitter) {
        Session session = entityManager.unwrap(Session.class);
        entityManager.persist(spitter);
    }

    //    @Transactional
    @CachePut("updateSpitter")
    @Override
    public void updateSpitter(Spitter spitter) {
        Session session = entityManager.unwrap(Session.class);
        entityManager.merge(spitter);
    }

    //    @Transactional
    @CachePut("spitterObject")
    @Override
    public Spitter findById(int id) {
        Session session = entityManager.unwrap(Session.class);
        Spitter spitter = entityManager.find(Spitter.class, id);
        return spitter;
    }

    //    @Transactional
    @CachePut("spitters")
    @Override
    public List<Spitter> list() {
        Session session = entityManager.unwrap(Session.class);
        List<Spitter> objectList = entityManager.createQuery(SQL_ALL_SPITTER).getResultList();
        return objectList;
    }


    //    @Transactional
    @CacheEvict("deleteSpitter")
    @Override
    public void delete(Spitter spitter) {
        Session session = entityManager.unwrap(Session.class);
        Spitter deleteSpitter = entityManager.find(Spitter.class, spitter.getId());
        entityManager.remove(deleteSpitter);
    }

    public int queryForIdentity() {
        return Math.abs(random.nextInt(RANGE) << 16);
    }

}

package com.cgi.dentistapp.dal;

import com.cgi.dentistapp.entity.PersonEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class PersonRepository {
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public PersonEntity add(PersonEntity entity) {
        if (entity.getId() == null) {
            em.persist(entity);
        } else {
            em.merge(entity);
        }
        return entity;
    }

    @Transactional
    public List<PersonEntity> getAll() {
        return em.createQuery(
                "SELECT d FROM PersonEntity d",
                PersonEntity.class).getResultList();
    }

    @Transactional
    public PersonEntity findById(Long id) {
        return em.find(PersonEntity.class, id);
    }

    @Transactional
    public void delete(Long id) {
        PersonEntity e = findById(id);
        if (e != null) {
            em.remove(e);
        }
    }
}

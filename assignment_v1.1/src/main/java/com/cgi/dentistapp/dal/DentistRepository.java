package com.cgi.dentistapp.dal;

import com.cgi.dentistapp.entity.DentistEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class DentistRepository {
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public DentistEntity add(DentistEntity entity) {
        if (entity.getId() == null) {
            em.persist(entity);
        } else {
            em.merge(entity);
        }
        return entity;
    }

    @Transactional
    public List<DentistEntity> getAll() {
        return em.createQuery(
                "SELECT d FROM DentistEntity d",
                DentistEntity.class).getResultList();
    }

    @Transactional
    public DentistEntity findById(Long id) {
        return em.find(DentistEntity.class, id);
    }

    @Transactional
    public void delete(Long id) {
        DentistEntity e = findById(id);
        if (e != null) {
            em.remove(e);
        }
    }
}

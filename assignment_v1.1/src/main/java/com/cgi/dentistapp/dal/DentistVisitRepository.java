package com.cgi.dentistapp.dal;

import com.cgi.dentistapp.entity.DentistVisitEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class DentistVisitRepository {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public DentistVisitEntity addVisit(DentistVisitEntity entity) {
        if (entity.getId() == null) {
            em.persist(entity.getDentist());
            em.flush();
            em.persist(entity.getPerson());
            em.flush();
            em.persist(entity);
        } else {
            em.merge(entity);
        }
        return entity;
    }
    @Transactional
    public List<DentistVisitEntity> getAll() {
        return em.createQuery(
                "SELECT dv FROM DentistVisitEntity dv",
                DentistVisitEntity.class).getResultList();
    }


    @Transactional
    public DentistVisitEntity findById(Long id) {
        return em.find(DentistVisitEntity.class, id);
    }

    @Transactional
    public void delete(Long id) {
        DentistVisitEntity e = findById(id);
        if (e != null) {
            em.remove(e);
        }
    }
}

package com.cgi.dentistapp.dal;

import com.cgi.dentistapp.entity.DentistVisitEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@SuppressWarnings("JpaQlInspection")
@Repository
public class DentistVisitRepository {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public DentistVisitEntity addVisit(DentistVisitEntity entity) {
        if (entity.getId() == null) {
            em.persist(entity.getPerson());
            em.flush();
            em.persist(entity);
        } else {
            em.merge(entity.getPerson());
            em.flush();
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
            Query q = em.createQuery("delete from DentistVisitEntity dve where dve.id = :id");
            q.setParameter("id", id);
            q.executeUpdate();
        }
    }

    public List<DentistVisitEntity> search(String search) {
        TypedQuery<DentistVisitEntity> query = em.createQuery(
                "SELECT dve from DentistVisitEntity dve " +
                        "where" +
                        " LOWER( dve.dentist.firstName ) like :search or lower( dve.dentist.lastName ) like :search or" +
                        " LOWER( dve.person.firstName ) like :search or LOWER( dve.person.lastName ) like :search or" +
                        " LOWER( dve.person.personalCode ) like :search",
                DentistVisitEntity.class
        );
        query.setParameter("search", "%" + search.toLowerCase() + "%");
        return query.getResultList();
    }
}

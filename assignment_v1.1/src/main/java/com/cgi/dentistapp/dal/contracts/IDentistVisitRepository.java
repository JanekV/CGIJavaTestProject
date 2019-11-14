package com.cgi.dentistapp.dal.contracts;

import com.cgi.dentistapp.entity.DentistVisitEntity;
import org.springframework.data.repository.CrudRepository;

// Discovered this way of doing CRUD, but ended up not using it because I need custom functionality,
// mainly in delete.
public interface IDentistVisitRepository  extends CrudRepository<DentistVisitEntity, Long> {
}

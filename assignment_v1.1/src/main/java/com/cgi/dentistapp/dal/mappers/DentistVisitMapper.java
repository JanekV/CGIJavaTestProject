package com.cgi.dentistapp.dal.mappers;

import com.cgi.dentistapp.dto.DentistVisitDTO;
import com.cgi.dentistapp.entity.DentistEntity;
import com.cgi.dentistapp.entity.DentistVisitEntity;
import com.cgi.dentistapp.entity.PersonEntity;


public class DentistVisitMapper {

    public static DentistVisitDTO mapToDTO(DentistVisitEntity entity) {
        PersonEntity p = entity.getPerson();
        return new DentistVisitDTO(
                entity.getId(), // Important to preserve Ids in order to later see whether to update or add entity in the db.
                entity.getDentist().getId(),
                entity.getPerson().getId(),
                entity.getDentist().getFirstName() + " " + entity.getDentist().getLastName(),
                entity.getPerson().getFirstName() + " " + entity.getPerson().getLastName(),
                p.getFirstName(), p.getLastName(), p.getPersonalCode(),
                entity.getVisitDate(), entity.getVisitTime());
    }

    public static DentistVisitEntity mapToEntity(DentistVisitDTO dto, DentistEntity dentist, PersonEntity personEntity) {
        return new DentistVisitEntity(dto.getId(), dentist, personEntity, dto.getVisitDate(), dto.getVisitTime());
    } // Important to preserve Ids in order to later see whether to update or add entity in the db.


}

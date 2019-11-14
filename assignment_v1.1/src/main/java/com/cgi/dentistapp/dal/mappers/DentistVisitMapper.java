package com.cgi.dentistapp.dal.mappers;

import com.cgi.dentistapp.dto.DentistVisitDTO;
import com.cgi.dentistapp.entity.DentistEntity;
import com.cgi.dentistapp.entity.DentistVisitEntity;
import com.cgi.dentistapp.entity.PersonEntity;


public class DentistVisitMapper {

    public static DentistVisitDTO MapToDTO(DentistVisitEntity entity) {
        PersonEntity p = entity.getPerson();
        return new DentistVisitDTO(
                entity.getId(),
                entity.getDentist().getId(),
                entity.getPerson().getId(),
                entity.getDentist().getFirstName() + " " + entity.getDentist().getLastName(),
                entity.getPerson().getFirstName() + " " + entity.getPerson().getLastName(),
                p.getFirstName(), p.getLastName(), p.getPersonalCode(),
                entity.getVisitDate(), entity.getVisitTime());
    }

    public static DentistVisitEntity MapToEntity(DentistVisitDTO dto, DentistEntity dentist, PersonEntity personEntity) {
        return new DentistVisitEntity(dto.getId(), dentist, personEntity, dto.getVisitDate(), dto.getVisitTime());
    }


}
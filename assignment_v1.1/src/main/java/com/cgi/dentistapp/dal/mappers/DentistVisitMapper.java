package com.cgi.dentistapp.dal.mappers;

import com.cgi.dentistapp.dto.DentistVisitDTO;
import com.cgi.dentistapp.entity.DentistEntity;
import com.cgi.dentistapp.entity.DentistVisitEntity;
import com.cgi.dentistapp.entity.PersonEntity;


public class DentistVisitMapper {

    public static DentistVisitDTO MapToDTO(DentistVisitEntity entity) {
        PersonEntity p = entity.getPerson();
        return new DentistVisitDTO(
                entity.getDentist().getId(),
                entity.getDentist().getFirstName() + " " + entity.getDentist().getLastName(),
                entity.getPerson().getFirstName() + " " + entity.getPerson().getLastName(),
                p.getFirstName(), p.getLastName(), p.getPersonalCode(),
                entity.getVisitDate(), entity.getVisitTime());
    }

    public static DentistVisitEntity MapToEntity(DentistVisitDTO dto, DentistEntity dentist) {
        PersonEntity p = new PersonEntity(dto.getPersonFirstName(), dto.getPersonLastName(), dto.getPersonPersonalCode());
        return new DentistVisitEntity(dentist, p, dto.getVisitDate(), dto.getVisitTime());
    }


}

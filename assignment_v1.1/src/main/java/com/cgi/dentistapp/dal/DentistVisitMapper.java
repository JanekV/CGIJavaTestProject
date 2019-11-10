package com.cgi.dentistapp.dal;

import com.cgi.dentistapp.dto.DentistVisitDTO;
import com.cgi.dentistapp.entity.DentistVisitEntity;
import com.cgi.dentistapp.entity.PersonEntity;

public class DentistVisitMapper {

    public static DentistVisitDTO MapToDTO(DentistVisitEntity entity) {
        PersonEntity p = entity.getPerson();
        return new DentistVisitDTO(entity.getDentist(),
                p.getFirstName(), p.getLastName(), p.getPersonalCode(),
                entity.getVisitTime());
    }

    public static DentistVisitEntity MapToEntity(DentistVisitDTO dto) {
        PersonEntity p = new PersonEntity(dto.getPersonFirstName(), dto.getPersonLastName(), dto.getPersonPersonalCode());
        return new DentistVisitEntity(dto.getDentist(), p, dto.getVisitTime());
    }
}

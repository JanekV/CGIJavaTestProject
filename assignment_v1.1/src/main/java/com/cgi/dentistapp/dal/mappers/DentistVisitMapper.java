package com.cgi.dentistapp.dal.mappers;

import com.cgi.dentistapp.dto.DentistVisitDTO;
import com.cgi.dentistapp.entity.DentistEntity;
import com.cgi.dentistapp.entity.DentistVisitEntity;
import com.cgi.dentistapp.entity.PersonEntity;
import org.codehaus.groovy.transform.SourceURIASTTransformation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;


public class DentistVisitMapper {

    public static DentistVisitDTO MapToDTO(DentistVisitEntity entity) {
        PersonEntity p = entity.getPerson();
        return new DentistVisitDTO(
                entity.getDentist().getId(),
                entity.getDentist().getFirstName() + " " + entity.getDentist().getLastName(),
                p.getFirstName(), p.getLastName(), p.getPersonalCode(),
                entity.getVisitDate(), entity.getVisitTime());
    }

    public static DentistVisitEntity MapToEntity(DentistVisitDTO dto, DentistEntity dentist) {
        PersonEntity p = new PersonEntity(dto.getPersonFirstName(), dto.getPersonLastName(), dto.getPersonPersonalCode());
        return new DentistVisitEntity(dentist, p, dto.getVisitDate(), dto.getVisitTime());
    }


}

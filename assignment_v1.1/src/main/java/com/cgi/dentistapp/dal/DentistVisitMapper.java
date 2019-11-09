package com.cgi.dentistapp.dal;

import com.cgi.dentistapp.dto.DentistVisitDTO;
import com.cgi.dentistapp.entity.DentistVisitEntity;

public class DentistVisitMapper {

    public static DentistVisitDTO MapToDTO(DentistVisitEntity entity) {
        return new DentistVisitDTO(entity.getDentistName(), entity.getVisitTime());
    }

    public static DentistVisitEntity MapToEntity(DentistVisitDTO dto) {
        return new DentistVisitEntity(dto.getDentistName(), dto.getVisitTime());
    }
}

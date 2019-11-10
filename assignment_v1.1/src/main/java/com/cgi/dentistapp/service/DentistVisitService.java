package com.cgi.dentistapp.service;

import com.cgi.dentistapp.dal.DentistRepository;
import com.cgi.dentistapp.dal.DentistVisitMapper;
import com.cgi.dentistapp.dal.DentistVisitRepository;
import com.cgi.dentistapp.dto.DentistVisitDTO;
import com.cgi.dentistapp.entity.DentistEntity;
import com.cgi.dentistapp.entity.DentistVisitEntity;
import com.cgi.dentistapp.entity.PersonEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class DentistVisitService {

    @Autowired
    private DentistVisitRepository dentistVisitRepository;

    @Autowired
    private DentistRepository dentistRepository;

    public DentistVisitDTO addVisit(DentistVisitDTO dto) {
        PersonEntity p = new PersonEntity(dto.getPersonFirstName(), dto.getPersonLastName(),
                dto.getPersonPersonalCode());
        return DentistVisitMapper.MapToDTO(dentistVisitRepository.addVisit(
                new DentistVisitEntity(dto.getDentist(), p, dto.getVisitTime())));
    }

    public List<DentistVisitDTO> getAll() {
        return dentistVisitRepository.getAll()
                .stream().map(DentistVisitMapper::MapToDTO)
                .collect(Collectors.toList());
    }

    public List<DentistEntity> getAllDentists() {
        return dentistRepository.getAll();
    }
}

package com.cgi.dentistapp.service;

import com.cgi.dentistapp.dal.DentistVisitMapper;
import com.cgi.dentistapp.dal.DentistVisitRepository;
import com.cgi.dentistapp.dto.DentistVisitDTO;
import com.cgi.dentistapp.entity.DentistVisitEntity;
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

    public DentistVisitDTO addVisit(DentistVisitDTO dto) {

        return DentistVisitMapper.MapToDTO(dentistVisitRepository.addVisit(
                new DentistVisitEntity(dto.getDentistName(), dto.getVisitTime())));
    }

    public List<DentistVisitDTO> getAll() {
        return dentistVisitRepository.getAll()
                .stream().map(DentistVisitMapper::MapToDTO)
                .collect(Collectors.toList());
    }
}

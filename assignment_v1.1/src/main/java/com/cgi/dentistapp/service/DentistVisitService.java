package com.cgi.dentistapp.service;

import com.cgi.dentistapp.dal.DentistRepository;
import com.cgi.dentistapp.dal.PersonRepository;
import com.cgi.dentistapp.dal.mappers.DentistVisitMapper;
import com.cgi.dentistapp.dal.DentistVisitRepository;
import com.cgi.dentistapp.dto.DentistVisitDTO;
import com.cgi.dentistapp.entity.DentistEntity;
import com.cgi.dentistapp.entity.PersonEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class DentistVisitService {

    private final DentistVisitRepository dentistVisitRepository;

    private final DentistRepository dentistRepository;

    public DentistVisitService(DentistVisitRepository dentistVisitRepository, DentistRepository dentistRepository) {
        this.dentistVisitRepository = dentistVisitRepository;
        this.dentistRepository = dentistRepository;
    }
    // Returning added value, may be needed to know it's generated id later.
    public DentistVisitDTO addVisit(DentistVisitDTO dto) {
        PersonEntity personEntity = new PersonEntity(dto.getPersonId(),
                dto.getPersonFirstName(), dto.getPersonLastName(),
                dto.getPersonPersonalCode());
        return DentistVisitMapper.mapToDTO(
                dentistVisitRepository.addVisit(
                        DentistVisitMapper.mapToEntity(dto, dentistRepository.findById(dto.getDentistId()), personEntity)));
    }

    public List<DentistVisitDTO> getAll() {
        return dentistVisitRepository.getAll()
                .stream().map(DentistVisitMapper::mapToDTO)
                .collect(Collectors.toList());
    }

    public List<DentistEntity> getAllDentists() {
        return dentistRepository.getAll();
    }

    public DentistVisitDTO findById(Long id) {
        return DentistVisitMapper.mapToDTO(
                dentistVisitRepository.findById(id));
    }

    public void delete(Long id) {
        dentistVisitRepository.delete(id);
    }

    public List<DentistVisitDTO> search(String key) {
        return dentistVisitRepository.search(key)
                .stream().map(DentistVisitMapper::mapToDTO)
                .collect(Collectors.toList());
    }
}

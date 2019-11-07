package com.cgi.dentistapp.service;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;

@Service
@Transactional
public class DentistVisitService {

    public void addVisit(String dentistName, Date visitTime) {
        //TODO implementation
    }
}

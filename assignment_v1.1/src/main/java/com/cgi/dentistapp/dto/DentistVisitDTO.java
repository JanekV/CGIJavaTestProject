package com.cgi.dentistapp.dto;

import com.cgi.dentistapp.entity.DentistEntity;
import com.cgi.dentistapp.entity.PersonEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DentistVisitDTO {

    @Valid
    private DentistEntity dentist;

    @NotNull
    @Size(min = 1, max = 50)
    private String personFirstName;

    @NotNull
    @Size(min = 1, max = 50)
    private String personLastName;

    @NotNull
    @Size(min = 1, max = 50)
    private String personPersonalCode;

    @NotNull
    @DateTimeFormat(pattern = "dd.MM.yyyy HH:mm:ss")
    private Date visitTime;
}

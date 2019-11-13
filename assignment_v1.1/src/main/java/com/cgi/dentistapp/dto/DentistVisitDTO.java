package com.cgi.dentistapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DentistVisitDTO {

    @NotNull
    private Long dentistId;

    private String dentistName;
    private String personFullName;

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
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date visitDate;

    @NotNull
    @DateTimeFormat(pattern = "HH:mm")
    @Temporal(TemporalType.TIME)
    private Date visitTime;
}

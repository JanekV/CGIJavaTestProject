package com.cgi.dentistapp.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "dentist_visit")
@Data
@NoArgsConstructor
public class DentistVisitEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "dentist_visit_id")
    private Long id;

    @Valid
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "dentist_id", nullable = false)
    private DentistEntity dentist;

    @Valid
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id", nullable = false)
    private PersonEntity person;

    @NotNull
    @Column(name = "visit_date")
    private Date visitDate;
    
    @NotNull
    @Column(name = "visit_time")
    private Date visitTime;

    public DentistVisitEntity(Long id, DentistEntity dentist, PersonEntity person, Date visitDate, Date visitTime) {
        this.id = id;
        this.dentist = dentist;
        this.person = person;
        this.visitTime = visitTime;
        this.visitDate = visitDate;
    }

}

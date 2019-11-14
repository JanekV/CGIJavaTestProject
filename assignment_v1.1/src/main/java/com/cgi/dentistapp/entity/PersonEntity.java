package com.cgi.dentistapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "person")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "person_id")
    private Long id;

    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "first_name")
    private String firstName;

    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "last_name")
    private String lastName;

    @NotNull
    @Size(min = 1, max = 23)
    @Column(name = "personal_code")
    private String personalCode; //Isikukood

    @OneToMany(mappedBy = "person")
    private List<DentistVisitEntity> visits;

    public PersonEntity(Long id, String personFirstName, String personLastName, String personPersonalCode) {
        this.id = id;
        this.firstName = personFirstName;
        this.lastName = personLastName;
        this.personalCode = personPersonalCode;
    }

    public String getName() {
        return firstName + " " + lastName;
    }
}

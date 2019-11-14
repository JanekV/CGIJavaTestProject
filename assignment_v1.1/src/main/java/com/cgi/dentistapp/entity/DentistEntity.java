package com.cgi.dentistapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "dentist")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DentistEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "dentist_id")
    private Long id;

    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "first_name")
    private String firstName;

    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "last_name")
    private String lastName;

    @OneToMany(mappedBy = "dentist")
    private List<DentistVisitEntity> visits;

    public String getName() {
        return firstName + " " + lastName;
    }
}

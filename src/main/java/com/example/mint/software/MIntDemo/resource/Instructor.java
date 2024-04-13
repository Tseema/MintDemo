package com.example.mint.software.MIntDemo.resource;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "instructor")
public class Instructor {

    @Id
    @GeneratedValue
    Long instructorId;

    String firstName;
    String lastName;
    Date birthdate;


    //one to many
    @OneToMany(mappedBy = "instructor",cascade = {CascadeType.PERSIST})
    List<Event> events = new ArrayList<>();


}

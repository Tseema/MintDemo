package com.example.mint.software.MIntDemo.resource;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
@Table(name = "event")
public class Event {

    @Id
    @GeneratedValue
    Long eventId;

    @ManyToOne
    //@JoinColumn(name="instructorId")
    private Instructor instructor;

    String eventType;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    Date startDate;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    Date endDate;


    long duration;



}

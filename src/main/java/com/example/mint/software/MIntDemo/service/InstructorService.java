package com.example.mint.software.MIntDemo.service;

import com.example.mint.software.MIntDemo.InstructorRepository.EventRepository;
import com.example.mint.software.MIntDemo.InstructorRepository.InstructorRepository;
import com.example.mint.software.MIntDemo.resource.Event;
import com.example.mint.software.MIntDemo.resource.Instructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InstructorService {

    @Autowired
    InstructorRepository repository ;

    @Autowired
    EventRepository eventRepository;

    public void getallInstructorDetails() {
        repository.findAll();
    }

    public void add(Instructor instructor) {
        repository.save(instructor);

    public long getduration(Long instructor) {
        Optional<Instructor> byId = repository.findById(instructor);

        List<Event> events = byId.stream().map(instructor1 -> instructor1.getEvents()).findFirst().get();
        long entireDurationsOfCourses = events.stream().map(event -> event.getDuration()).mapToLong(e -> e).sum();

        return entireDurationsOfCourses;
    }

    public List<Event> geteventsforinstructorBYid(Long instructor) {
        Optional<Instructor> byId = repository.findById(instructor);
        List<Event> events = byId.stream().map(instructor1 -> instructor1.getEvents()).findFirst().get();
        return events;
    }
}

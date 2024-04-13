package com.example.mint.software.MIntDemo.service;


import com.example.mint.software.MIntDemo.InstructorRepository.EventRepository;
import com.example.mint.software.MIntDemo.InstructorRepository.InstructorRepository;
import com.example.mint.software.MIntDemo.resource.Event;
import com.example.mint.software.MIntDemo.resource.Instructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Service
public class EventService {

    @Autowired
    public  EventRepository repository;

    @Autowired
    public InstructorRepository instructorRepository;


    public void add(Event event ) {
        long diffInMillies = Math.abs(event.getEndDate().getTime() - event.getStartDate().getTime());
        long duration = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
        event.setDuration(duration);
        repository.save(event);
    }

    public void edit(Event event, Long id) {
        Optional<Event> byId = repository.findById(id);
        if(byId.isPresent()){
            Event newevent = byId.get();
            newevent.setStartDate(event.getStartDate());
            newevent.setEndDate(event.getEndDate());
            newevent.setDuration(event.getDuration());
            newevent.setEventType(event.getEventType());
            newevent.setInstructor(event.getInstructor());
            repository.save(newevent);
        }

    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public void addEventToInstructor(String name, Long eventID) {
        Instructor byFirstName = instructorRepository.findByFirstName(name);
        Optional<Event> byId = repository.findById(eventID);
        byId.stream().findFirst().get().setInstructor(byFirstName);
        repository.save(byId.get());

    }
}

package com.example.mint.software.MIntDemo.controller;


import com.example.mint.software.MIntDemo.resource.Event;
import com.example.mint.software.MIntDemo.resource.Instructor;
import com.example.mint.software.MIntDemo.service.EventService;
import com.example.mint.software.MIntDemo.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/instructor")
public class InstructorController {

    @Autowired
    InstructorService service;

    @Autowired
    EventService eventService;

    @GetMapping("/all")
    public void getAllInstructorDetails(){
        service.getallInstructorDetails();
    }


    @PostMapping("/add")
    public void addInstructors(@RequestBody Instructor instructor){
        service.add(instructor);
    }

    @PostMapping("/addEvent")
    public void addEvents(@RequestBody Event event){
        eventService.add(event);
    }

    @PostMapping("/update/{id}")
    public void editEvents(@RequestBody Event event,@PathVariable Long id){

        eventService.edit(event,id);
    }

    @PostMapping("/delete/{id}")
    public void deleteEvents(@PathVariable Long id){
        eventService.delete(id);
    }

    @GetMapping("/duration/{instructor}")
    public String getDuration(@PathVariable Long instructor){
        long entireDurationOfCourses = service.getduration(instructor);
        return ("The duration of all courses for the instructor " + entireDurationOfCourses);
    }

    @GetMapping("/events/{instructor}")
    public ResponseEntity<List<Event>> geteventsforinstructor(@PathVariable Long instructor){
        List<Event> events = service.geteventsforinstructorBYid(instructor);

        /*URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(events)
                .toUri();*/
      /*  JSONArray jsonArray = new JSONArray();
        JSONObject jsonObject = new JSONObject();
        jsonArray.put(jsonObject);
        return new ResponseEntity( jsonArray.toString(), HttpStatus.OK);*/
        return  ResponseEntity.ok(events);
    }

    @PostMapping("/addEventToInstructor/{name}/{eventID}")
    public void addEventToInstructor(@PathVariable String name,@PathVariable Long eventID){
        eventService.addEventToInstructor(name,eventID);
    }
}

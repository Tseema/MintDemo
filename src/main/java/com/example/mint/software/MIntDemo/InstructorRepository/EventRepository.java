package com.example.mint.software.MIntDemo.InstructorRepository;

import com.example.mint.software.MIntDemo.resource.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface EventRepository extends JpaRepository<Event,Long> {
}

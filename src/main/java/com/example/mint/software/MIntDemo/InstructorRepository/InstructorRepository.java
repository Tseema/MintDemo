package com.example.mint.software.MIntDemo.InstructorRepository;

import com.example.mint.software.MIntDemo.resource.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;



public interface InstructorRepository extends JpaRepository<Instructor,Long> {

    Instructor findByFirstName(String name);
}

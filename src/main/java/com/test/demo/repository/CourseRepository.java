package com.test.demo.repository;
 

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.test.demo.entity.Course;  
 
@Repository
public interface CourseRepository extends CrudRepository<Course, Integer> {
   Course findById(Long id);
    
}

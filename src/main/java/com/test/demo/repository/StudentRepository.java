package com.test.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.test.demo.entity.Student; 
 

@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {
    Student findById(Long id);
    
}

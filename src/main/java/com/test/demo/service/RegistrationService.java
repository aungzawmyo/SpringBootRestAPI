package com.test.demo.service;
 
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.demo.dto.StudentDto;
import com.test.demo.dto.UpdateStudentDto;
import com.test.demo.entity.Student; 
import com.test.demo.entity.Course;
import com.test.demo.repository.StudentRepository;
import com.test.demo.exception.ResourceNotFoundException; 
import com.test.demo.repository.CourseRepository;
 

@Service
public class RegistrationService {

    @Autowired
	private StudentRepository studentRepository;

    @Autowired
	private CourseRepository courseRepository;
 
	public Student registerStudent(StudentDto input) {
		var student = new Student();
		Course course = courseRepository.findById(Long.parseLong(input.getCourseId()));
	    student.setFirstName(input.getFirstName());
	    student.setLastName(input.getLastName());
	    student.setEmail(input.getEmail());
	    student.setPhoneNumber(input.getPhoneNumber());
	    student.setCourse(course);
	    return studentRepository.save(student); 
	}
	
	public Student updateStudent(Long studentId,UpdateStudentDto studentDetail) {
		Student student = studentRepository.findById(studentId);
		student.setFirstName(studentDetail.getFirstName());
		student.setLastName(studentDetail.getLastName());
		student.setPhoneNumber(studentDetail.getPhoneNumber());
		Student updatedStudent = studentRepository.save(student);
		return updatedStudent;
	}
	
	public Map<String,Boolean> deleteStudent(Long studentId)
			throws ResourceNotFoundException{
		Student student = studentRepository.findById(studentId);
		
		studentRepository.delete(student);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	} 
	
	public Student getStudent(Long studentId) 
			throws ResourceNotFoundException{
		return studentRepository.findById(studentId);	 
	}
	
	public List<Student> getStudentList(){
		List<Student> students= new ArrayList<>();
		studentRepository.findAll().forEach(students::add);
		return students;
	} 
	
	public List<Course> getCourseList(){
		List<Course> courses= new ArrayList<>();
		courseRepository.findAll().forEach(courses::add);
		return courses;
	} 
	
	public Course getCourseById(String id) { 
		return courseRepository.findById(Long.parseLong(id));
	}
}

package com.test.demo.controller;

import java.util.List;
import java.util.Map;
 
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.test.demo.dto.StudentDto;
import com.test.demo.dto.UpdateStudentDto;
import com.test.demo.entity.Student; 
import com.test.demo.entity.Course;
import com.test.demo.service.RegistrationService;

import com.test.demo.exception.ResourceNotFoundException;

@RestController
@RequestMapping("/registration")
public class StudentController {

	 	private final RegistrationService registrationService; 

	    public StudentController(RegistrationService registrationService) {
	        this.registrationService = registrationService;
	    }
	    
		@PostMapping("/student")
		public ResponseEntity<Student> registerStudent(@RequestBody StudentDto registerStudentDto)throws ResourceNotFoundException  { 
			Student  registerStudent= registrationService.registerStudent(registerStudentDto);
		 	return ResponseEntity.ok(registerStudent);
		}
		
		@PutMapping("/student/{id}")
		public ResponseEntity<Student> updateStudent(@PathVariable(value = "id") Long studentId,@RequestBody UpdateStudentDto updateStudentDto) 
				throws ResourceNotFoundException { 
			System.out.println("update");
			Student  updateStudent= registrationService.updateStudent(studentId,updateStudentDto);
		 	return ResponseEntity.ok(updateStudent);
		}

		@DeleteMapping("/student/{id}")
		public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long studentId)
				throws ResourceNotFoundException {
			return registrationService.deleteStudent(studentId);
		}

		@GetMapping("/student/{id}")
	  	public ResponseEntity<Student> getStudent(@PathVariable(value = "id") Long studentId)
	  			throws ResourceNotFoundException { 

			System.out.println("test");
		  	Student  student= registrationService.getStudent(studentId);
	        return ResponseEntity.ok(student);
	    }

		@GetMapping("/studentList")
	  	public ResponseEntity<List<Student>> getStudentList() 
	  			throws ResourceNotFoundException { 
		  	List<Student>  studentList= registrationService.getStudentList();
	        return ResponseEntity.ok(studentList);
	    }
		@GetMapping("/courseList")
	  	public ResponseEntity<List<Course>> getCourse() 
	  			throws ResourceNotFoundException { 
		  	List<Course>  courseList= registrationService.getCourseList();
	        return ResponseEntity.ok(courseList);
	    }
 
}

package com.test.demo.dto;
 
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class StudentDto {
 
	private String firstName;
   	private String lastName;
   	private String email;
   	private String phoneNumber;
   	private String courseId;
	
   	@Override
	public String toString() {
		return "StudentDto [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", phoneNumber="
				+ phoneNumber + ", courseId=" + courseId + "]";
	}
    
}

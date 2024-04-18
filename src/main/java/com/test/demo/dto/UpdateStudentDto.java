package com.test.demo.dto;


import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UpdateStudentDto {
	
	private String firstName;
   	private String lastName; 
   	private String phoneNumber;
   	
	@Override
	public String toString() {
		return "UpdateStudentDto [firstName=" + firstName + ", lastName=" + lastName + ", phoneNumber=" + phoneNumber
				+ "]";
	} 
	
}

package com.example.demo.form;


import javax.validation.constraints.NotEmpty;


import com.example.demo.dto.StudentDTO;

public class StudentForm {
	
	private long id;
	
	@NotEmpty(message= "Please enter firstname")
	private String firstName;
	
	
	private String lastName;
	
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public StudentDTO getdto() {
		StudentDTO dto=new StudentDTO();
		dto.setId(id);
		dto.setFirstName(firstName);
		dto.setLastName(lastName);
		
		
		System.out.println(dto.getFirstName()+"First name");
		System.out.println(dto.getLastName()+"last name");
		
		return dto;
	}

}

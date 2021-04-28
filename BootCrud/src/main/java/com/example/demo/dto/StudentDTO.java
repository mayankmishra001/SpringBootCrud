package com.example.demo.dto;

	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
//	import javax.validation.constraints.Max;

	import org.hibernate.annotations.GenericGenerator;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.web.multipart.MultipartFile;

	@Entity
	@Table(name="st_student")
	public class StudentDTO {
		@Id
		@Column(name="ID")
		@GeneratedValue(generator = "NCSPK")
		@GenericGenerator(name="NCSPK",strategy = "native")
		private long id;

		@Column(name= "first_name")
		private String firstName = null;

		@Column(name="last_name")
		private String lastName = null;
		
		
		public StudentDTO() {
		System.out.println("Student DTO constructor ");
		}

		public StudentDTO(long id,String firstName,String lastName ) {
			this.id=id;
			this.firstName=firstName;
			this.lastName=lastName;
			}

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
		
	
	
}

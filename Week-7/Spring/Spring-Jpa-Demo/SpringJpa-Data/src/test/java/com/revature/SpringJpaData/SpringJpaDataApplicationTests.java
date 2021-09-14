package com.revature.SpringJpaData;

import com.revature.SpringJpaData.entity.Guardian;
import com.revature.SpringJpaData.entity.Student;
import com.revature.SpringJpaData.repo.StudentRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
class SpringJpaDataApplicationTests {

	@Autowired
	private StudentRepo studentRepo;

	@Test
	public void saveStudent(){
		Student student = Student.builder()
				.firstName("Mark")
				.lastName("Smail")
				.emailId("m@mail.com")
//				.guardianName("Paul Smail")
//				.guardianEmail("p@gmail.com")
//				.guardianMobile("3244234")
				.build();

		studentRepo.save(student);
	}

	@Test
	public void saveStudentWithGuardian(){
		Guardian guardian = Guardian.builder()
				.name("Some Name")
				.email("S@Name.com")
				.mobile("789234234")
				.build();

		Student student = Student.builder()
				.firstName("Stacy")
				.lastName("Smail")
				.emailId("s@mail.com")
				.guardian(guardian)
				.build();
		studentRepo.save(student);
	}

	@Test
	public void displayAllStudents(){
		List<Student> studentList = studentRepo.findAll();
		System.out.println(studentList);
	}

	@Test
	public void displayStudentByFirstName(){
		List<Student> studentList = studentRepo.findByFirstName("Mark");
		System.out.println(studentList);
	}
	@Test
	public void displayStudentByFirstNameContaining(){
		List<Student> studentList = studentRepo.findByFirstNameContaining("Mark");
		System.out.println(studentList);
	}

	@Test
	public void displayStudentNameBasedOnGuardianName(){
		List<Student> studentList = studentRepo.findByGuardianName("Paul");
		System.out.println(studentList);
	}

	@Test
	public void displayStudentByEmailAddress(){
		Student student = studentRepo.getStudentByEmailAddress("s@mail.com");
		System.out.println(student);
	}

	@Test
	public void displayGetStudentNameByEmailAddress(){
		String name = studentRepo.getStudentFirstNameByEmailAddress("s@mail.com");
		System.out.println(name);
	}

	@Test
	public void displayGetStudentByEmailAddressNative(){
		Student student = studentRepo.getStudentByEmailAddressNative("s@mail.com");
		System.out.println(student);
	}

	@Test
	public void displayGetStudentByEmailAddressNativeParams(){
		Student student = studentRepo.getStudentByEmailAddressNativeNamedParams("s@mail.com");
		System.out.println(student);
	}



}

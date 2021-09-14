package com.revature.SpringJpaData.repo;

import com.revature.SpringJpaData.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<Student,Long> {

    List<Student> findByFirstName(String firstName);

    List<Student> findByGuardianName(String name);

    List<Student> findByFirstNameContaining(String containing);

    List<Student> findByLastNameNotNull();

    Student findByFirstNameAndLastName(String firstName,String lastName);

    //JPQL
    @Query("select s from Student s where s.emailId= ?1")
    Student getStudentByEmailAddress (String email);

    @Query("select s.firstName from Student s where s.emailId = ?1")
    String getStudentFirstNameByEmailAddress(String emailId);


    //native query
    @Query(
            value = "select * from tbl_student s where s.email_address = ?1",
            nativeQuery = true
    )
    Student getStudentByEmailAddressNative(String emailId);

    //native names parameters
    @Query(
            value = "select * from tbl_student s where s.email_address = :emailId",
            nativeQuery = true
    )
    Student getStudentByEmailAddressNativeNamedParams(
            @Param("emailId")String emailId
    );

    @Modifying
    @Transactional
    @Query(
            value = "update tbl_student set first_name = ?1 where email_address = ?2",
            nativeQuery = true
    )
    int updateStudentNameByEmailId(String firstName, String emailId);

}

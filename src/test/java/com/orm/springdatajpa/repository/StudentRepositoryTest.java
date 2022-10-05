package com.orm.springdatajpa.repository;

import com.orm.springdatajpa.entity.Guardian;
import com.orm.springdatajpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
//@DataJpaTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent() {
        Student student = Student.builder()
                .email("ahmet@gmail.com")
                .firstName("ahmet")
                .lastName("simsek")
                //.guardianName("veli2")
                //.guardianEmail("veli2@gmail.com")
                //.guardianMobile("2222222")
                .build();
        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian() {
        Guardian guardian = Guardian.builder()
                .email("h3@gmail.com")
                .name("h3")
                .mobile("33333")
                .build();

            Student student = Student.builder()
                    .email("h1@gmail.com")
                    .firstName("h1")
                    .lastName("h2")
                    .guardian(guardian)
                    .build();

            studentRepository.save(student);
    }

    @Test
    public void printAllStudents() {
        List<Student> studentList = studentRepository.findAll();

        System.out.println("studentList = " + studentList);
    }

    @Test
    public void printStudentByFirstName() {
        List<Student> students = studentRepository.findByFirstName("ahmet");
        System.out.println("students = " + students);
    }

    @Test
    public void printStudentByFirstNameContaining() {
        List<Student> students = studentRepository.findByFirstNameContaining("ahm");
        System.out.println("students = " + students);
    }

    @Test
    public void printStudentBasedOnGuardianName(){
        List<Student> students =
                studentRepository.findByGuardianName("h3");
        System.out.println("students = " + students);
    }

    @Test
    public void printGetStudentByEmailAddress() {
        Student student = 
                studentRepository.getStudentByEmailAddress("ahmet@gmail.com");
        System.out.println("student = " + student);
    }

}
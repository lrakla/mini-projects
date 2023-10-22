package com.example.crud.student;

import java.util.List;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentService {
    /*
     Interface for accessing and modifying student data in the database.
     */
    private final StudentRepository studentRepository;
    
    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
    return studentRepository.findAll(); // returns list of all students
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentOptional  = studentRepository.findStudentByEmail(student.getEmail());
        if (studentOptional.isPresent()) {
            throw new IllegalStateException("Oops, email taken!");
        }
        studentRepository.save(student);
        System.out.println(student);
    }

	public void deleteStudent(Long studentId) {
        boolean exists = studentRepository.existsById(studentId);
        if (!exists) {
            throw new IllegalStateException("Student with id " + studentId + " does not exist!");
        }   
        studentRepository.deleteById(studentId);
	}

  
    @Transactional
    public void updateStudent(Long studentId, String name, String email) {
        Student student = studentRepository.findById(studentId).orElseThrow(() 
        -> new IllegalStateException("Student with id " + studentId + " does not exist!"));
        if (name != null && name.length() > 0 && !name.equals(student.getName())) {
            student.setName(name);
        }
        if (email != null && email.length() > 0 && !email.equals(student.getEmail())) {
            Optional<Student> studentOptional = studentRepository.findStudentByEmail(email);
            if (studentOptional.isPresent()) {
                throw new IllegalStateException("Oops, email taken!");
            }
            student.setEmail(email);
        }
    }

	}

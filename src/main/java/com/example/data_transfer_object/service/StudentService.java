package com.example.data_transfer_object.service;

import com.example.data_transfer_object.DTO.StudentRequestDTO;
import com.example.data_transfer_object.DTO.StudentResponseDTO;
import com.example.data_transfer_object.Entity.Student;
import com.example.data_transfer_object.ExceptionHandling.DeletedResourceException;
import com.example.data_transfer_object.ExceptionHandling.DuplicateResourceException;
import com.example.data_transfer_object.ExceptionHandling.ResourceNotFoundException;
import com.example.data_transfer_object.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    private StudentResponseDTO toResponseDTO(Student student){
        return new StudentResponseDTO(student.getId(),student.getName(),student.getAge(),student.getCourse());
    }

    public StudentResponseDTO createStudent(StudentRequestDTO request){
        Student s = new Student(
                request.getName(),
                request.getAge(),
                request.getCourse()
        );

        if(studentRepository.existsByName(s.getName())){
            throw new DuplicateResourceException("Student already Exists by Name: " + s.getName());
        }

        Student savedStudent = studentRepository.save(s);
        return toResponseDTO(savedStudent);
    }

    public List<StudentResponseDTO> getAllStudent(){
        return studentRepository.findAll()
                .stream()
                .map(this::toResponseDTO)
                .toList();
    }

    public StudentResponseDTO getStudentById(Long id){
        Student student = studentRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Student not found with id: " + id
                        ));

        return toResponseDTO(student);
    }


    @Transactional
    public StudentResponseDTO updateStudent(Long id,StudentRequestDTO request){
        Student student = studentRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Student not found with id: " + id
                        ));


        student.setName(request.getName());
        student.setAge(request.getAge());
        student.setCourse(request.getCourse());

        Student updatedStudent = studentRepository.save(student);

        return toResponseDTO(updatedStudent);
    }

    public void deleteStudent(Long id) {

        if (!studentRepository.existsById(id)) {
            throw new ResourceNotFoundException(
                    "Student not found with id: " + id + "Plz Enter the correct id"
            );
        }

        studentRepository.deleteById(id);
    }

}

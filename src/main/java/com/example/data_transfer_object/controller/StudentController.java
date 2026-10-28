package com.example.data_transfer_object.controller;

import com.example.data_transfer_object.DTO.StudentRequestDTO;
import com.example.data_transfer_object.DTO.StudentResponseDTO;
import com.example.data_transfer_object.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<StudentResponseDTO> create(@RequestBody StudentRequestDTO student){
        StudentResponseDTO response = studentService.createStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentResponseDTO>getStudent(@PathVariable Long id){
        return ResponseEntity.ok(
                studentService.getStudentById(id));
    }

    @GetMapping
    public ResponseEntity<List<StudentResponseDTO>> getAllStudents(){
        return ResponseEntity.ok(studentService.getAllStudent());
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentResponseDTO>update(@PathVariable Long id,@RequestBody StudentRequestDTO request){
        return ResponseEntity.ok(studentService.updateStudent(id,request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        studentService.deleteStudent(id);
        return ResponseEntity.ok("Student deleted....");
    }

}

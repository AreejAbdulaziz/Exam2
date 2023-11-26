package com.example.exam.Controller;

import com.example.exam.Model.Student;
import com.example.exam.Service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/student")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;
    @GetMapping("/get")
    public ResponseEntity getStudents(){
        ArrayList<Student>students=studentService.getStudents();
        return ResponseEntity.status(HttpStatus.OK).body(students);
    }
    @PostMapping("/add")
    public ResponseEntity addStudent(@RequestBody@Valid Student student, Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }
        studentService.addStudent(student);
        return ResponseEntity.status(HttpStatus.OK).body("student added");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateStudent(@PathVariable String id,@RequestBody@Valid Student student,Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }
        boolean isUpdated=studentService.updateStudent(id,student);
        if(isUpdated){
            return ResponseEntity.status(HttpStatus.OK).body("student updated");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("wrong id");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteStudent(@PathVariable String id){
        boolean isDeleted=studentService.deleteStudent(id);
        if(isDeleted){
            return ResponseEntity.status(HttpStatus.OK).body("student deleted");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("wrong id");
    }
    @GetMapping("/search/{name}")
    public ResponseEntity searchStudent(@PathVariable String name){
        Student student=studentService.searchStudent(name);
        if(student==null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("wrong name");
        }
        return ResponseEntity.status(HttpStatus.OK).body(student);
    }
}

package com.example.exam.Controller;

import com.example.exam.Model.Teacher;
import com.example.exam.Service.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/teacher")
@RequiredArgsConstructor
public class TeacherController {
    private final TeacherService teacherService;
    @GetMapping("/get")
    public ResponseEntity getTeacher(){
        ArrayList<Teacher>teachers=teacherService.getTeachers();
        return ResponseEntity.status(HttpStatus.OK).body(teachers);
    }
    @PostMapping("/add")
    public ResponseEntity addTeacher(@RequestBody@Valid Teacher teacher, Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }
        teacherService.addTeacher(teacher);
        return ResponseEntity.status(HttpStatus.OK).body("teacher added");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateTeacher(@PathVariable String id,@RequestBody@Valid Teacher teacher,Errors errors){
      if(errors.hasErrors()){
          String message=errors.getFieldError().getDefaultMessage();
          return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
      }
      boolean isUpdated=teacherService.updateTeacher(id,teacher);
      if(isUpdated){
          return ResponseEntity.status(HttpStatus.OK).body("teacher updated");
      }
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("wrong id");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteTeacher(@PathVariable String id){
        boolean isDeleted=teacherService.deleteTeacher(id);
        if(isDeleted){
            return ResponseEntity.status(HttpStatus.OK).body("teacher deleted");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("wrong id");
    }
    @GetMapping("/search/{id}")
    public ResponseEntity searchTeacher(@PathVariable String id){
        Teacher teacher=teacherService.searchTeacher(id);
        if(teacher==null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("teacher not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(teacher);
    }
}

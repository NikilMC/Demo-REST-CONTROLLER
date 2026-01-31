package com.demo4.demo4;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class DemoRestController {
    private List<Student> students;
    @PostConstruct
    public void loaddata(){
        students=new ArrayList<>();
        students.add(new Student("Poornima","Patel"));
        students.add(new Student("Mario","Rossi"));
        students.add(new Student("Mary","Smith"));
    }
    @GetMapping("/students")
    public List<Student> Helloworld(){
        return students;
    }
    @GetMapping("/students/{studentid}")
    public Student getStudent(@PathVariable int studentid){
        if(studentid>=students.size() || studentid<0){
            throw new StudentNotFoundException("Student id not found - "+studentid);
        }
        return students.get(studentid);
    }
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleexception(StudentNotFoundException exc){
        StudentErrorResponse error = new StudentErrorResponse();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimestamp(System.currentTimeMillis());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleexception(Exception exc){
        StudentErrorResponse error = new StudentErrorResponse();
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exc.getMessage());
        error.setTimestamp(System.currentTimeMillis());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}


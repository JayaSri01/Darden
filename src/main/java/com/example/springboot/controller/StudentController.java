package com.example.springboot.controller;

import com.example.springboot.entity.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("students")
public class StudentController {

    @GetMapping("student")
    public ResponseEntity<Student> getStudent() {
        Student student = new Student(
                1,
                "Jaya",
                "Sri"
        );
        return ResponseEntity.ok()
                .header("custom-header", "Jaya")
                .body(student);
    }

    @GetMapping()
    public ResponseEntity<List<Student>> getStudents() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Jaya", "Sri"));
        students.add(new Student(2, "Sri", "Latha"));
        students.add(new Student(3, "Latha", "Sri"));
        students.add(new Student(4, "Jasu", "Tej"));
        return ResponseEntity.ok(students);
    }

    @GetMapping("students/{id}/{first-name}/{last-name}")
    public ResponseEntity<Student> studentPathVariable(@PathVariable("id") int studentId,
                                                       @PathVariable("first-name") String firstName,
                                                       @PathVariable("last-name") String lastName) {
        Student student = new Student(studentId, firstName, lastName);
        return ResponseEntity.ok(student);
    }

    @GetMapping("students/query")
    public ResponseEntity<Student> studentRequestVariable(@RequestParam int id,
                                                          @RequestParam String firstName,
                                                          @RequestParam String lastName) {
        Student student = new Student(id, firstName, lastName);
        return ResponseEntity.ok(student);
    }

    @PostMapping("create")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        System.out.println(student.getId());
        System.out.println((student.getFirstName()));
        System.out.println((student.getLastName()));
        return new ResponseEntity<>(student, HttpStatus.CREATED);

    }

    @PutMapping("{id}/update")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student, @PathVariable("id") int studentId){
    System.out.println((student.getFirstName()));
    System.out.println((student.getLastName()));
    return ResponseEntity.ok(student);
}

    @DeleteMapping("{id}/delete")
    public ResponseEntity<String> deleteStudent(@PathVariable int id){
        System.out.println(id);
        return ResponseEntity.ok("Student Deleted Successfully");
    }


}

package org.src.Controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.src.Service.StudentService;
import org.src.entity.Student;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @GetMapping("/students/{studentId}")
    public Student getStudentByStudentId(@PathVariable Long studentId) {
        return studentService.getStudentsByStudentId(studentId);
    }

    //only students name, from CS dept

    @GetMapping("/students/{deptName}")
    public List<String> getStudentsByDepartName(@PathVariable String deptName) {
        return studentService.getStudentsByDepartmentName(deptName);
    }
}

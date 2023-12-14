package org.src.Service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.src.Repository.StudentRepository;
import org.src.entity.Student;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student getStudentsByStudentId(Long studentId) {
        return studentRepository.findById(studentId).orElse(null);
    }

    public List<String> getStudentsByDepartmentName(String deptName) {
        List<Student> students = studentRepository.findAll();
        return students.stream().filter(s -> s.getDepartment().getName().equals(deptName)).map(Student::getName).collect(Collectors.toList());
    }
}

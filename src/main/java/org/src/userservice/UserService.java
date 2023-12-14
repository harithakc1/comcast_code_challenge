package org.src.userservice;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.src.repository.UserRepository;


@AllArgsConstructor
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

//    public Student getStudentsByStudentId(Long studentId) {
//        return userRepository.findById(studentId).orElse(null);
//    }

   /* public List<String> getStudentsByDepartmentName(String deptName) {
        List<User> users = userRepository.findAll();
        return users.stream().filter(s -> s.getDepartment().getName().equals(deptName)).map(Student::getName).collect(Collectors.toList());
    }*/
}

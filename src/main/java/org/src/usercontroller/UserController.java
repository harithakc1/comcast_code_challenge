package org.src.usercontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.src.userservice.UserService;

@RestController
public class UserController {
    @Autowired
    public UserService userService;

    /*@GetMapping("/students/{studentId}")
    public User getStudentByStudentId(@PathVariable Long studentId) {
        return userService.getStudentsByStudentId(studentId);
    }*/

    //only students name, from CS dept

   /* @GetMapping("/students/{deptName}")
    public List<String> getStudentsByDepartName(@PathVariable String deptName) {
        return userService.getStudentsByDepartmentName(deptName);
    }*/
}

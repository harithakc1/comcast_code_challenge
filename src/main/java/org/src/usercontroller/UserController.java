package org.src.usercontroller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.src.UserInputDTO;
import org.src.entity.User;
import org.src.userservice.UserService;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    public UserService userService;

    @Operation(summary = "Get the list of users")
    @GetMapping("/users")
    public List<User> findAllUsers() {
        return userService.findAllUsers();
    }

    @Operation(summary = "Create a new user")
    @PostMapping(value = "/user/create", headers = "Content-Type=application/json")
    public ResponseEntity<UserInputDTO> createUser(@RequestBody UserInputDTO userInputDTO) {
        userService.createUser(userInputDTO);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Edit the created user")
    @PatchMapping(value = "user/update/{id}")
    public ResponseEntity<UserInputDTO> updateUser(@PathVariable(value = "id") Long id) {
        userService.updateUser(id);
        return ResponseEntity.accepted().build();
    }

    @Operation(summary = "To delete existing user")
    @DeleteMapping(value = "user/delete/{id}")
    public ResponseEntity deleteUser(@PathVariable(value = "id") Long id){
        userService.deleteUser(id);
        return ResponseEntity.ok().build();
    }
}

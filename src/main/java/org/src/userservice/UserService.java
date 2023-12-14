package org.src.userservice;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.src.UserInputDTO;
import org.src.entity.User;
import org.src.repository.UserRepository;

import java.util.List;
import java.util.Objects;


@AllArgsConstructor
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public UserInputDTO createUser(UserInputDTO userInputDTO){
        User newUser = userInputDTO.toConvertUserEntity();
        return userRepository.save(newUser).toConvertUserDTO();
    }

    public UserInputDTO updateUser(Long id){
        User existingUser = userRepository.findById(id).orElse(null);
        assert existingUser != null;
        return userRepository.save(existingUser).toConvertUserDTO();
    }

    public void deleteUser(Long id){
        User existingUser = userRepository.findById(id).orElse(null);
        assert existingUser != null;
        userRepository.delete(existingUser);
    }
}

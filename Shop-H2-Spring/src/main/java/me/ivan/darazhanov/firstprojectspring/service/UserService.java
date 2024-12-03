package me.ivan.darazhanov.firstprojectspring.service;

import me.ivan.darazhanov.firstprojectspring.model.User;
import me.ivan.darazhanov.firstprojectspring.model.dto.UserDTO;
import me.ivan.darazhanov.firstprojectspring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {

        return userRepository.findAll();
    }

//    public User newUser(User user) {
//        return userRepository.save(user);
//    }


    public boolean save (UserDTO userDTO) {
        if (userDTO==null)
            return false;
        User user = new User();
        user.setFname(userDTO.getFname());
        user.setLname(userDTO.getLname());
        user.setEmail(userDTO.getEmail());

        userRepository.save(user);
        return true;
    }

    public UserDTO findUserById(int id) {
        Optional<User> optional = userRepository.findById(id);
        if (optional.isEmpty()) {
            return null;
        }
        UserDTO userDTO = new UserDTO();
        userDTO.setFname(optional.get().getFname());
        userDTO.setLname(optional.get().getLname());
        userDTO.setEmail(optional.get().getEmail());
        return userDTO;
    }
    public User findEUserById(int id) {
        Optional<User> optional = userRepository.findById(id);
        if (optional.isEmpty()) {
            return null;
        }
        User user = new User();
        user.setFname(optional.get().getFname());
        user.setLname(optional.get().getLname());
        user.setEmail(optional.get().getEmail());
        return user;
    }

    public boolean updateUser(UserDTO userDTO, int id) {
        Optional<User> optional = userRepository.findById(id);
        if (optional.isEmpty()) {
            return false;
        }
        User user = optional.get();
        user.setFname(userDTO.getFname());
        user.setLname(userDTO.getLname());
        user.setEmail(userDTO.getEmail());
        userRepository.save(user);
        return true;
    }

    public boolean deleteUser(int id) {
        Optional<User> optional = userRepository.findById(id);
        if (optional.isEmpty()) {
            return false;
        }
        userRepository.deleteById(id);
        return true;
    }
}

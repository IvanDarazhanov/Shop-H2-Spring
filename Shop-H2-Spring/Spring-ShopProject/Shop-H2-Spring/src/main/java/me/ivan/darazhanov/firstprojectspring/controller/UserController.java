package me.ivan.darazhanov.firstprojectspring.controller;

import me.ivan.darazhanov.firstprojectspring.model.User;
import me.ivan.darazhanov.firstprojectspring.model.dto.UserDTO;
import me.ivan.darazhanov.firstprojectspring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;


    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    //List all users

    @GetMapping("/list")
    public ResponseEntity<List<User>> getUsers() {
        List<User> userlist = new ArrayList<User>();
        userService.findAll().forEach(userlist::add);

        return new ResponseEntity<>(userlist, HttpStatus.OK);
    }

//    @GetMapping("/test")
//    public ResponseEntity<User> getUser() {
//        User user = new User();
//        user.setFname("Pesho");
//        user.setLname("Peshov");
//        user.setEmail("peshov@gmail.com");
//        return ResponseEntity.ok(user);
//    }

    //Post query for adding user

    @PostMapping("/add")
    public ResponseEntity<Object> createUser(@RequestBody UserDTO user) {

        if (userService.save(user)) {
            return ResponseEntity.status(HttpStatus.CREATED).body(user);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("error", "invalid data"));

    }

    //get query user by id

    @GetMapping("/get-user/{id}")
    public ResponseEntity<?> getUserById(@PathVariable int id) {
        UserDTO userdata = userService.findUserById(id);
        if (userdata == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error", "Invalid id: " + id));
        }
        return ResponseEntity.ok(userdata);
    }

//update user by id

    @PutMapping("/update-user/{id}")
    public ResponseEntity<?> updateUser(@RequestBody UserDTO userDTO, @PathVariable int id) {
        if (userService.updateUser(userDTO, id)) {
            return ResponseEntity.status(HttpStatus.OK).body(userDTO);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("error", "Invalid id: " + id));
    }

    //delete user by id

    @DeleteMapping("/delete-user/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable int id) {
        if (userService.deleteUser(id)) {
            return ResponseEntity.status(HttpStatus.OK).body(Map.of("Successfully deleted user on", " id: " + id));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("error", "Invalid id: " + id));
    }
}

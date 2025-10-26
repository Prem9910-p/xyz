package com.example.xyz.Controller;

import com.example.xyz.Entity.User;
import com.example.xyz.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/add")
    public User addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @GetMapping("/all")
    public List<User> findAllUser(){
        List<User> userList=userService.findAllUser();
        return userList;
    }

    @GetMapping("/{id}")
    public User findUserById(@RequestParam int id){
        return userService.findUserById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteUserById(@RequestParam int id){
        return userService.deleteUserById(id);
    }
    @PutMapping("/{id}")
    public ResponseEntity updateUser(@RequestBody User user,  @RequestParam int id){
      try {
          User user1= userService.updateUser(user,id);
          return new ResponseEntity<>(user1, HttpStatus.CREATED);

      } catch (RuntimeException e) {
          return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
      }
    }

}

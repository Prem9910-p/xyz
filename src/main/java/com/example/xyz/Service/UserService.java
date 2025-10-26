package com.example.xyz.Service;

import com.example.xyz.Entity.User;
import com.example.xyz.Repository.UserReository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserReository userReository;

    public User addUser(User user) {
        User user1=userReository.save(user);
        return user1;    }

    public List<User> findAllUser() {
        List<User> userList=userReository.findAll();
        return userList;
    }

    public User findUserById(int id) {
        Optional<User> user=userReository.findById(id);
        if(user.isPresent()){
            return user.orElse(null);
        }
        return null;
    }

    public String deleteUserById(int id) {
        userReository.deleteById(id);
        return "user deleted successfully";

    }


    public User updateUser(User user, int id) {
        User user1=userReository.findById(id)
                .orElseThrow(()->new RuntimeException("user not found for id ="+id));
        user1.setEmail(user.getEmail());
        user1.setAge(user.getAge());
        user1.setName(user.getName());
        return userReository.save(user1);
    }
}

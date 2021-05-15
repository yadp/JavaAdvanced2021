package com.example.lecture24;

import com.example.lecture24.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDetailService {

    @Autowired
    private UserRepository userRepository;



    public User showUsers(long id){
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        return user;
    }

    public User findUser(String name){
        List<User> users =  userRepository.findByName(name);
        //for
        return users.get(0);
    }

}

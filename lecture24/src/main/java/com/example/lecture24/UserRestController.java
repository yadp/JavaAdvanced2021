package com.example.lecture24;

import com.example.lecture24.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/user")
public class UserRestController {


    private final UserRepository userRepository;

    @Autowired
    private UserDetailService userDetailService;

    @Autowired
    public UserRestController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/")
    public Iterable<User> showUserList() {
       return  userRepository.findAll();

    }

    @GetMapping("/{id}")
    public User showUser(@PathVariable Long id) {
        return  userRepository.findById(id).get();

    }

    @PostMapping("/")
    public User addUser(User user) {
        return userRepository.save(user);
    }


    @PutMapping("/{id}")
    public User updateUser(@PathVariable("id") long id, User user) {
        User userToChange = userRepository.findById(id).get();
        userToChange.setName(user.getName());
        userToChange.setEmail(user.getEmail());
        return userRepository.save(userToChange);
    }

    @DeleteMapping("/{id}")
    public User deleteUser(@PathVariable("id") long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        userRepository.delete(user);

        return user;
    }
}

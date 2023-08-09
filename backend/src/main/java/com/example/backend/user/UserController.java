package com.example.backend.user;

import com.example.backend.EmailValidator;
import com.example.backend.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @CrossOrigin("http://82.76.142.241:3000")
    @PostMapping("/api/v1/user")
    public Response addUser(@RequestBody User user) {
        if(user.getUsername().equals("") || user.getEmail().equals("") || user.getPassword().equals("")) {
            return new Response(3, "All fields must be filled!");
        }

        if(!EmailValidator.isEmailValid(user.getEmail())) {
            return new Response(2, "Invalid email format!");
        }

        if(!isEmailAvailable(user)) {
            return  new Response(7, "An account with this username already exists!");
        }

        userService.addUser(user);
        return new Response(1, "Account created successfully!");
    }

    @CrossOrigin("http://82.76.142.241:3000")
    @PostMapping("/api/v1/user/login")
    public Response searchUser(@RequestParam(value="email") String email, @RequestParam(value="password") String password) {
        List<User> users = userService.getUsers();
        boolean isEmailInDatabase = false;

        for(User it:users) {
            if(it.getEmail().equals(email) && it.getPassword().equals(password)) {
                return new Response(4, "Login successful!");
            } else if (it.getEmail().equals(email)) {
                isEmailInDatabase = true;
            }
        }

        if(isEmailInDatabase) {
            return new Response(6, "Incorrect password!");
        }

        return new Response(5, "The email isn't registered!");
    }

    @CrossOrigin("http://82.76.142.241:3000")
    @GetMapping("/api/v1/user/data")
    public User getUser(@RequestParam(value="email") String email) {
        List<User> users = userService.getUsers();
        User requestedUser = null;

        for(User it:users) {
            if(it.getEmail().equals(email)) {
                requestedUser = it;
                break;
            }
        }

        return requestedUser;
    }

    private boolean isEmailAvailable(User user) {
        List<User> users = userService.getUsers();

        for(User it:users) {
            if(it.getUsername().equals(user.getUsername())) {
                return false;
            }
        }

        return true;
    }
}

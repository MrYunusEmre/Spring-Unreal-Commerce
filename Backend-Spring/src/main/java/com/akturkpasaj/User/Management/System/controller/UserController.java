package com.akturkpasaj.User.Management.System.controller;

import com.akturkpasaj.User.Management.System.model.User;
import com.akturkpasaj.User.Management.System.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@PreAuthorize("hasAuthority('ROLE_ADMIN')")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/save")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveNewUser(@RequestBody User user){
        userService.saveNewUser(user);
    }

    @RequestMapping(value = "/allUsers")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public User getUser(@RequestParam("id") int id){
        return userService.getUser(id);
    }

    @RequestMapping("/deleteUser")
    @PostMapping
    @ResponseStatus(HttpStatus.GONE)
    public void deleteUser(@RequestParam("id") int id){
        userService.deleteUser(id);
    }



}

package com.my.atark.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.my.atark.domain.User;
import com.my.atark.exceptions.UnknownUserException;
import com.my.atark.service.IUserServ;
import com.my.atark.service.ServiceFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/administration/users")
@CrossOrigin("*")
public class UserController {

    @GetMapping(path = "allUsers")
    public String allUsers() {
        List<User> result = null;
        try {
            IUserServ userServ = ServiceFactory.getUserService();
            result = userServ.findAllUsers();
        } catch (UnknownUserException e) {
            e.printStackTrace();
        }
        ObjectMapper mapper = new ObjectMapper();
        String json = null;
        try {
            json = mapper.writeValueAsString(result);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return json;
    }

    @GetMapping(path = "allUsers/from={from}&offset={offset}")
    public  List<User> usersOffset(@PathVariable("from") String from, @PathVariable("offset") String offset) {
        List<User> result = null;
        try {
            IUserServ productServ = ServiceFactory.getUserService();
            result = productServ.findUsers(Integer.parseInt(from),Integer.parseInt(offset));
        } catch (UnknownUserException e) {
            e.printStackTrace();
        }
        return result;
    }

    @GetMapping(path = "{id}")
    public String findUserById(@PathVariable("id") String id) {
        User result = null;
        try {
            IUserServ productServ = ServiceFactory.getUserService();
            result = productServ.findUserById(Integer.parseInt(id));
        } catch (UnknownUserException e) {
            e.printStackTrace();
        }
        ObjectMapper mapper = new ObjectMapper();
        String json = null;
        try {
            json = mapper.writeValueAsString(result);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return json;
    }
    /*@GetMapping(path = "login={login}&password={password}")
    public User findUserByName(@PathVariable("login") String login) {
        User result = null;
        try {
            IUserServ productServ = ServiceFactory.getUserService();
            result = productServ.findUserById(Integer.parseInt(id));
        } catch (UnknownUserException e) {
            e.printStackTrace();
        }
        return result;
    }*/


    @PostMapping
    public void addUser(@RequestBody User user) {
        IUserServ serv = ServiceFactory.getUserService();
        serv.addUser(user);
    }

    @PutMapping
    public void updateUser(@RequestBody User user) {
        IUserServ serv = ServiceFactory.getUserService();
        serv.updateUser(user);
    }

    @DeleteMapping(path = "{id}")
    public void deleteUser(@PathVariable("id") String id) {
        IUserServ serv = ServiceFactory.getUserService();
        serv.deleteUserById(Integer.parseInt(id));
    }

    @DeleteMapping
    public void deleteUser(@RequestBody User user) {
        IUserServ serv = ServiceFactory.getUserService();
        serv.deleteUser(user);
    }
}

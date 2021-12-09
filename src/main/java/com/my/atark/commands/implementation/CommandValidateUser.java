/*
package com.my.atark.commands.implementation;

import com.my.atark.domain.Product;
import com.my.atark.domain.User;
import com.my.atark.exceptions.UnknownUserException;
import com.my.atark.service.ServiceFactory;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/auth")
public class CommandValidateUser{

    @GetMapping(path = "login={login}&password={password}")
    public User productByCode(@PathVariable("login") String login, @PathVariable("password") String password) {
        User user = null;
        try {
            user = ServiceFactory.getUserService().findUser(login, password);
        } catch (UnknownUserException e) {
            e.printStackTrace();
        }
        return user;
    }
}
*/

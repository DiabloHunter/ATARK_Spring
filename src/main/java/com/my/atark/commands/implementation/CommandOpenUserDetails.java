/*
package com.my.atark.commands.implementation;

import com.my.atark.domain.Product;
import com.my.atark.domain.User;
import com.my.atark.exceptions.UnknownUserException;
import com.my.atark.service.IUserServ;
import com.my.atark.service.ServiceFactory;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/user")
public class CommandOpenUserDetails {

    @GetMapping(path = "{id}")
    public User execute(@PathVariable("id") String id) {
        IUserServ serv = ServiceFactory.getUserService();
        User user = null;
        try {
            user = serv.findUserById(Integer.parseInt(id));
        } catch (UnknownUserException e) {
            e.printStackTrace();
        }
        return user;
    }
}
*/

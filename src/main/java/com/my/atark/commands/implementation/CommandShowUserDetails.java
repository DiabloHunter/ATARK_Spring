/*
package com.my.atark.commands.implementation;

import com.my.atark.domain.User;
import com.my.atark.exceptions.UnknownUserException;
import com.my.atark.service.IUserServ;
import com.my.atark.service.ServiceFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/administration/user")
public class CommandShowUserDetails{


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

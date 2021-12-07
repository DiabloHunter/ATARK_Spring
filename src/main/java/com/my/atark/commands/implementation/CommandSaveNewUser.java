package com.my.atark.commands.implementation;

import com.my.atark.domain.User;
import com.my.atark.service.IUserServ;
import com.my.atark.service.ServiceFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/administration/userNew")
public class CommandSaveNewUser  {

    @PostMapping
    public void execute(@RequestBody User user) {
        IUserServ userServ = ServiceFactory.getUserService();
        userServ.addUser(user);
    }
}

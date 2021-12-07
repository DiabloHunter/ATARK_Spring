package com.my.atark.commands.implementation;

import com.my.atark.domain.Product;
import com.my.atark.domain.User;
import com.my.atark.service.IUserServ;
import com.my.atark.service.ServiceFactory;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/administration/user")
public class CommandSaveUserProfileAsAdmin{

    @PutMapping
    public void execute(@RequestBody User user) {
            IUserServ userServ = ServiceFactory.getUserService();
            userServ.updateUser(user);
    }
}

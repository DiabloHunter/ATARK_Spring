/*
package com.my.atark.commands.implementation;

import com.my.atark.domain.User;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "api/user")
public class CommandSaveUserProfile{

    @PostMapping
    public void execute(@RequestBody User user) {
        try {
            String userId = content.getRequestParameter("userId")[0];
            UserRole userRole = UserRole.valueOf(content.getRequestParameter("userRole")[0]);
            String login = content.getRequestParameter("name")[0];
            String password = content.getRequestParameter("password")[0];
            String phone = content.getRequestParameter("phone")[0];
            String email = content.getRequestParameter("email")[0];
            String address = content.getRequestParameter("address")[0];
            String notes = content.getRequestParameter("notes")[0];
            User user = new User(login, password);
            user.setId(Integer.parseInt(userId));
            user.setUserRole(userRole);
            user.setPhoneNumber(phone);
            user.setEmail(email);
            user.setAddress(address);
            user.setNotes(notes);
            IUserServ userServ = ServiceFactory.getUserService();
            if (userServ.updateUser(user)) {
                result.setPage(conf.getPage("redirect_home"));
                result.addSessionAttribute("user", user);
            }
            else {
                result.addRequestAttribute("errorMessage", conf.getErrorMessage("saveUserProfileErr"));
                result.setPage(Configuration.getInstance().getPage("error"));
            }
        }
        catch (Exception uue) {
            log.error(uue);
            result.addRequestAttribute("errorMessage", conf.getErrorMessage("saveUserProfileErr"));
            result.setPage(Configuration.getInstance().getPage("error"));
        }
        return result;
    }
}
*/

package org.iskycode.jeesky.adm.web;

import org.iskycode.jeesky.adm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/a/user")
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/index")
    public String index() {
        userService.findAllUser();
        return "index";
    }
}

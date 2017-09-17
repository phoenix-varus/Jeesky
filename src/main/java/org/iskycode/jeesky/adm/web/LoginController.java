package org.iskycode.jeesky.adm.web;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.iskycode.jeesky.adm.entity.User;
import org.iskycode.jeesky.adm.service.UserService;
import org.iskycode.jeesky.sys.util.Const;
import org.iskycode.jeesky.sys.util.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.apache.shiro.mgt.SecurityManager;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RequestMapping(value = "/l")
@Controller
public class LoginController {

    @Autowired
    private SecurityManager securityManager;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/tologin")
    public String toLogin() {
        return Const.COMMON_JSP + "login";
    }

    @ResponseBody
    @RequestMapping(value = "/login")
    public String login(String username, String password) {
        Map map = new HashMap<String, String>();

        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        SecurityUtils.setSecurityManager(securityManager);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
        } catch (IncorrectCredentialsException ice) {
            // 捕获密码错误异常
            map.put("status", "failed");
            map.put("msg", "密码错误");
            return JsonUtils.toJson(map);
        } catch (UnknownAccountException uae) {
            // 捕获未知用户名异常
            map.put("status", "failed");
            map.put("msg", "用户不存在");
            return JsonUtils.toJson(map);
        } catch (ExcessiveAttemptsException eae) {
            // 捕获错误登录过多的异常
            map.put("status", "failed");
            map.put("msg", "请稍后再试");
            return JsonUtils.toJson(map);
        }
        map.put("status", "success");
        map.put("msg", "登录成功");
        return JsonUtils.toJson(map);
    }

    @RequestMapping(value = "toregister")
    public String toRegister() {
        return Const.COMMON_JSP + "register";
    }

    @RequestMapping(value = "register")
    public String register(String username, String password) {
        User user = new User();
        user.setName(username);
        user.setPassword(password);
        userService.saveOrUpdate(user);
        return "redirect:/l/tologin";
    }


    @RequestMapping(value = "/logout")
    public String logout() {
        SecurityUtils.setSecurityManager(securityManager);
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "redirect:/l/tologin";
    }
}

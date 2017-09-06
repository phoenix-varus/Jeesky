package org.iskycode.jeesky.adm.web;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.iskycode.jeesky.sys.util.Const;
import org.iskycode.jeesky.sys.util.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.apache.shiro.mgt.SecurityManager;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@RequestMapping(value = "/l")
@Controller
public class LoginController {

    @Autowired
    private SecurityManager securityManager;

    @RequestMapping(value = "/index")
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


    public String toRegister() {
        return "";
    }

    @RequestMapping(value = "/logout")
    public String logout() {
        SecurityUtils.setSecurityManager(securityManager);
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "redirect:/l/index";
    }
}

package kang.controller;

import kang.model.User;
import kang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 登录逻辑处理
     * 这里采用简单的用户名密码校验，只看用户名或密码是否为null并是够正确，
     * 校验通过则跳转到首页，失败则返回登录页面
     * 校验通过后需将登录信息设置到 session 中
     * @return
     */
    @RequestMapping("/login")
    public String login(String username, String password, HttpServletRequest request) {
        //用户名密码任一个为 null，校验失败
        if (username == null || password == null) {
            return "login";
        }
        //接下来从数据库中查找用户，根据传入的 username、password 看是否能找到对应的用户
        //传入参数时，要在对应的 Mapper 文件的方法参数前加入注解 @Para("name")
        User user = userService.login(username, password);
        //根据传入的用户名、密码没有找到用户，校验失败
        if (user == null) {
            return "login";
        }
        //校验成功，设置 session 信息，跳转到首页
        HttpSession session = request.getSession();
        session.setAttribute("user", user);
        return "/";
    }
}

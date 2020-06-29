package kang.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//实现登录拦截器，没有登录时，访问任何页面都将跳转到登录页面
//HandlerInterceptor 是一个拦截器
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    /**
     * preHandle：在业务处理器处理请求之前被调用。预处理，可以进行编码、安全控制、权限校验等处理；
     * Controller类方法调用前，如果匹配到拦截器的url，就会调用preHandle进行处理
     * @return true能够继续访问（可以调用Controller中的方法，或是访问某个页面）
     */
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //参数填false，获取session，如果没有则返回null
        HttpSession session = request.getSession(false);
        //判断 session 是否为 null
        if (session != null) {
            Object user = session.getAttribute("user");
            if (user != null) {
                return true;
            }
        }
        //没有获取到登录信息，重定向到登录页面，返回 false
        response.sendRedirect("/login");
        return false;
    }
}

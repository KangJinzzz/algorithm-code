package kang.config;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import java.io.PrintWriter;
import java.io.StringWriter;

//统一异常拦截器
@ControllerAdvice
public class ControllerInterception {

    @ExceptionHandler(Exception.class)
    public ModelAndView handle(Exception e) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        e.printStackTrace(pw);
        ModelAndView mv = new ModelAndView();
        mv.addObject("message", e.getMessage());
        mv.addObject("stackTrace", sw.toString());
        mv.setViewName("error");
        return mv;
    }
}

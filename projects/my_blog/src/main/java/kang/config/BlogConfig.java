package kang.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//配置程序执行前后的一些统一逻辑处理比如登录拦截器等
@Configuration
public class BlogConfig implements WebMvcConfigurer {

    //重写添加拦截器方法
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //添加拦截器，排除拦截一些资源，如首页,登录页面和一些静态资源不需要拦截
        registry.addInterceptor(new LoginInterceptor())
                .excludePathPatterns("/css/**")
                .excludePathPatterns("/fronts/**")
                .excludePathPatterns("/images/**")
                .excludePathPatterns("/js/**")
                .excludePathPatterns("/")
                .excludePathPatterns("/login")
                .excludePathPatterns("/a/*");
    }
}

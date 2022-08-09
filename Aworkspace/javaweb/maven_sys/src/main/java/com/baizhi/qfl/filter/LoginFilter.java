package com.baizhi.qfl.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }
    //ServletRequest:和http协议无关的请求 HttpServletRequest是ServletRequest的子类
    //ServletResponse：和http协议无关的响应 HttpServletResponse是ServletResponse的子类
    //FilterChain：根据过滤器的业务判断是否放行，doFilter(request,response);
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("Loginfilter----start----1");
        // 获取 session中登陆标记
        HttpServletRequest request1 = (HttpServletRequest) request;
        HttpServletResponse response1= (HttpServletResponse) response;
        HttpSession session = request1.getSession(true);
        Object obj=session.getAttribute("user");
        if(obj == null){
            // 跳转到 登陆界面
            response1.sendRedirect("/maven_sys/login.jsp");
            return;
        }
        //放行
        chain.doFilter(request, response);//有1没1 没有区别
        System.out.println("Loginfilter----end----1");
    }

    @Override
    public void destroy() {
    }
}

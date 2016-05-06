package org.bookpub.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by MaMingJiang on 2016/2/17.
 */
public class TestFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("初始化 TestFilter method");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
          System.out.println("doFilter method");
          chain.doFilter(request,response);
    }

    @Override
    public void destroy() {
        System.out.println("銷毀 TestFilter method");
    }
}

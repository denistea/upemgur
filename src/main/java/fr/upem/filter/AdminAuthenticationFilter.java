/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.upem.filter;

import fr.upem.entity.User;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Denis
 */
public class AdminAuthenticationFilter implements Filter{
    private FilterConfig filterConfig = null;
    
    public AdminAuthenticationFilter() {
    }    

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        String path = httpRequest.getRequestURI().substring(httpRequest.getContextPath().length());
        User user = (User) httpRequest.getSession().getAttribute("userSession");
        if(!path.equals("/admin/index.xhtml") && (user == null || !user.isIsAdmin())) {
            httpResponse.sendRedirect("/upemgur/admin/index.xhtml");
        }
        else if(path.equals("/admin/index.xhtml") && (user != null && user.isIsAdmin())) {
            httpResponse.sendRedirect("/upemgur/admin/user.xhtml");
        }
        else {
            chain.doFilter(request, response);
        }
    
    }

    @Override
    public void destroy() {
        this.filterConfig = null;
    }
}

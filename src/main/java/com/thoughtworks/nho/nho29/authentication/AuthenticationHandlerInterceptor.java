package com.thoughtworks.nho.nho29.authentication;

import com.thoughtworks.nho.nho29.authentication.util.SecurityUtils;
import com.thoughtworks.nho.nho29.domain.User;
import org.springframework.stereotype.Component;
import org.springframework.util.ClassUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.Objects;

@Component
public class AuthenticationHandlerInterceptor extends HandlerInterceptorAdapter{

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (ClassUtils.isAssignableValue(HandlerMethod.class, handler)) {
            this.authenticate(request);
        }
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        SecurityUtils.removePrincipal();

    }


    private boolean authenticate(HttpServletRequest request) {

        HttpSession session = request.getSession();

        Principal principal = Principal.class.cast(session.getAttribute(SecurityUtils.SECURITY_KEY));

        if (Objects.isNull(principal)) {
            principal = new User("admin", "admin");
            session.setAttribute(SecurityUtils.SECURITY_KEY, principal);
        }
        SecurityUtils.setPrincipal(principal);
        return true;
    }
}

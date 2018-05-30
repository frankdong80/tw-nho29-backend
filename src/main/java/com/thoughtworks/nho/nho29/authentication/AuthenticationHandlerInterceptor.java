package com.thoughtworks.nho.nho29.authentication;

import com.thoughtworks.nho.nho29.authentication.util.SecurityUtils;
import com.thoughtworks.nho.nho29.domain.TrainingClubUser;
import com.thoughtworks.nho.nho29.domain.User;
import com.thoughtworks.nho.nho29.service.TrainingClubUserService;
import lombok.AllArgsConstructor;
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
@AllArgsConstructor
public class AuthenticationHandlerInterceptor extends HandlerInterceptorAdapter{

    private TrainingClubUserService trainingClubUserService;

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
            principal = this.trainingClubUserService.findByUsername("admin");
            session.setAttribute(SecurityUtils.SECURITY_KEY, principal);
        }
        SecurityUtils.setPrincipal(principal);
        return true;
    }
}

package com.thoughtworks.nho.nho29.authentication.util;

import java.security.Principal;

public abstract class SecurityUtils {

    public static final String SECURITY_KEY = SecurityUtils.class.getName() + ".SECURITY_KEY";

    private static final ThreadLocal<Principal> contexts = new ThreadLocal<>();

    public static Principal getPrincipal() {
        return contexts.get();
    }

    public static void setPrincipal(Principal principal) {
        contexts.set(principal);
    }

    public static void removePrincipal() {
        contexts.remove();
    }
}

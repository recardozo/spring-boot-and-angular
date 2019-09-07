package com.payhere.services;

import com.payhere.security.UserDetailsImpl;
import org.springframework.security.core.context.SecurityContextHolder;

public class UserService {
    
    public static UserDetailsImpl authenticated() {
        try {
            return (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        } catch (Exception e) {
            return null;
        }
    }
}

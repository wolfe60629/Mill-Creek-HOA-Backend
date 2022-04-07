package com.example.millcreekhoa.repo;

import com.example.millcreekhoa.data.CurrentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;

@Component
public class UserInMemoryRepo {
    private static final HashMap<String, CurrentUser> REGISTERED_USERS = new HashMap<>();

    @PostConstruct
    public void setupUsers() {
        REGISTERED_USERS.put("admin", new CurrentUser("admin", "$2a$10$.buIMxgnjFYW1e4k6JAr4uFvscjBQ0JL6bPzL5QuHAog3RSSopHGG"));
    }

    public CurrentUser findUserByUsername (final String username) {
        return REGISTERED_USERS.get(username);
    }


}

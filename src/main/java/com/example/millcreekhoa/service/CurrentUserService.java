package com.example.millcreekhoa.service;

import com.example.millcreekhoa.data.CurrentUser;
import com.example.millcreekhoa.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CurrentUserService implements UserDetailsService {

    @Autowired
    private final UserRepository userRepository;

    public CurrentUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public CurrentUser loadUserByUsername(String username) throws UsernameNotFoundException {
        final CurrentUser currentUser = new CurrentUser(userRepository.getUserEntityByUsername(username));
        if (currentUser == null) {
            throw new UsernameNotFoundException("No user found with username: " + username);
        }

        return currentUser;
    }
}

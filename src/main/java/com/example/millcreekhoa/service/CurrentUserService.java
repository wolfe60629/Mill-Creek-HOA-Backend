package com.example.millcreekhoa.service;

import com.example.millcreekhoa.data.CurrentUser;
import com.example.millcreekhoa.repo.UserInMemoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CurrentUserService implements UserDetailsService {

    @Autowired
    private final UserInMemoryRepo userInMemoryRepo;

    public CurrentUserService(UserInMemoryRepo userInMemoryRepo) {
        this.userInMemoryRepo = userInMemoryRepo;
    }


    @Override
    public CurrentUser loadUserByUsername(String username) throws UsernameNotFoundException {
        final CurrentUser currentUser = userInMemoryRepo.findUserByUsername(username);
        if (currentUser == null) {
            throw new UsernameNotFoundException("No user found with username: " + username);
        }

        return currentUser;
    }
}

package com.millcreek.backend.controller;

import com.millcreek.backend.repo.InMemorySessionRegistry;
import com.millcreek.backend.data.ResponseDto;
import com.millcreek.backend.data.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class AuthenticationController {

    @Autowired
    public AuthenticationManager manager;

    @Autowired
    public InMemorySessionRegistry inMemorySessionRegistry;

    @PostMapping()
    public ResponseEntity<ResponseDto> login(@RequestBody UserDto user) {
        manager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));

       final String sessionId =  inMemorySessionRegistry.registerSession(user.getUsername());
       ResponseDto responseDto = new ResponseDto(sessionId);

       return ResponseEntity.ok(responseDto);
    };

    @PostMapping(value = "checkSessionId/{sessionID}")
    public boolean checkSessionId(@PathVariable String sessionID) throws Exception {
        if (sessionID == null) {
            throw new Exception("The sessionID was not provided");
        }

        return inMemorySessionRegistry.getUsernameForSession(sessionID) != null;
    }
}

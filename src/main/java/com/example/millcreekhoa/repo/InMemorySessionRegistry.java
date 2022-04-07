package com.example.millcreekhoa.repo;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.*;

class SessionToken{
    String username;
    Date expireTime;

    SessionToken(String username, Date expireTime) {
        this.username = username;
        this.expireTime = expireTime;
    }
}

@Component
public class InMemorySessionRegistry {
    private static final HashMap<String, SessionToken> SESSIONS = new HashMap<>();

    public String registerSession(String username) {
        if (username == null || username.isEmpty()) {
            throw new RuntimeException("Username needs to be provided");
        }

        final String sessionId = generateSessionId();

        // Create expiration time
        Calendar date = Calendar.getInstance();
        long timeInSecs = date.getTimeInMillis();
        int expireTimeInMin = 45;
        Date expireDate =  new Date(timeInSecs + (expireTimeInMin * 10 * 60 * 1000));

        SESSIONS.put(sessionId, new SessionToken(username, expireDate));

        return sessionId;
    }

    public String getUsernameForSession (String sessionID) {
        SessionToken session = SESSIONS.get(sessionID);

        // Check if session exists
        if (session == null) {
            return  null;
        }

        // Check if the time has expired
        if (session.expireTime.before(new Date())) {
            SESSIONS.remove(sessionID);
            return null;
        }

        return session.username;
    }

    private String generateSessionId() {
        return new String(
                Base64.getEncoder().encode(
                        UUID.randomUUID().toString().getBytes(StandardCharsets.UTF_8)
        ));
    }
}

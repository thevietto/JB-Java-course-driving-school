package ru.kpfu.driving_school.service.impl;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.driving_school.model.Credentials;
import ru.kpfu.driving_school.repository.CredentialsRepository;
import ru.kpfu.driving_school.service.TokenService;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class TokenServiceImpl implements TokenService {

    @Autowired
    private CredentialsRepository credentialsRepository;

    @Override
    public String getToken(String username, String password) throws Exception {
        if (username == null || password == null)
            return null;
        Credentials user = credentialsRepository.findOneByLogin(username);
        Map<String, Object> tokenData = new HashMap<>();
        if (password.equals(user.getPassword())) {
            tokenData.put("clientType", "user");
            tokenData.put("userID", user.getId());
            tokenData.put("token_create_date", new Date().getTime());
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.YEAR, 100);
            tokenData.put("token_expiration_date", calendar.getTime());
            JwtBuilder jwtBuilder = Jwts.builder();
            jwtBuilder.setExpiration(calendar.getTime());
            jwtBuilder.setClaims(tokenData);
            String key = "Driver";
            String token = jwtBuilder.signWith(SignatureAlgorithm.HS512, key).compact();
            return token;
        } else {
            throw new Exception("Authentication error");
        }
    }

}

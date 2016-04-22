package ru.kpfu.driving_school.service;

/**
 * Created by mikl on 15.04.2016.
 */
public interface TokenService {
    public String getToken(String username, String password) throws Exception ;
}

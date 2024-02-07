package com.lcwd.gateway.models;

import java.util.Collection;

public class AuthResponse {
    private String userId;
    private String acessToken;
    private String refreshToken;
    private Long expireAt;

    private Collection<String>authories;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAcessToken() {
        return acessToken;
    }

    public void setAcessToken(String acessToken) {
        this.acessToken = acessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public Long getExpireAt() {
        return expireAt;
    }

    public void setExpireAt(Long expireAt) {
        this.expireAt = expireAt;
    }

    public Collection<String> getAuthories() {
        return authories;
    }

    public void setAuthories(Collection<String> authories) {
        this.authories = authories;
    }

    @Override
    public String toString() {
        return "AuthResponse{" +
                "userId='" + userId + '\'' +
                ", acessToken='" + acessToken + '\'' +
                ", refreshToken='" + refreshToken + '\'' +
                ", expireAt=" + expireAt +
                ", authories=" + authories +
                '}';
    }

    public AuthResponse() {
    }

    public AuthResponse(String userId, String acessToken, String refreshToken, Long expireAt, Collection<String> authories) {
        this.userId = userId;
        this.acessToken = acessToken;
        this.refreshToken = refreshToken;
        this.expireAt = expireAt;
        this.authories = authories;
    }
}

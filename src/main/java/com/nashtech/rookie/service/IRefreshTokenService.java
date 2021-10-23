package com.nashtech.rookie.service;

import com.nashtech.rookie.model.RefreshToken;

import java.util.Optional;

public interface IRefreshTokenService {
    Optional<RefreshToken> findByToken(String token);
    RefreshToken createRefreshToken(Long userId);
    RefreshToken verifyExpiration(RefreshToken token);
    int deleteByUserId(Long userId);
}

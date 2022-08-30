package com.wwg.gabozzago.domain.auth.utils;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.wwg.gabozzago.domain.auth.dto.response.TokenResponseDto;

import java.io.IOException;
import java.security.GeneralSecurityException;

public interface AuthUtils {
    TokenResponseDto generateTokenResponse(String email);
    GoogleIdToken generateIdToken(String idToken) throws GeneralSecurityException, IOException;
}

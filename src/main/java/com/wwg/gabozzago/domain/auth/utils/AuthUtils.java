package com.wwg.gabozzago.domain.auth.utils;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.wwg.gabozzago.domain.auth.data.dto.TokenDto;

import java.io.IOException;
import java.security.GeneralSecurityException;

public interface AuthUtils {
    TokenDto generateTokenResponse(String email);
    GoogleIdToken generateIdToken(String idToken) throws GeneralSecurityException, IOException;
}

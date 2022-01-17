package com.alfimenkov.finalproject.service.api;

import com.alfimenkov.finalproject.dto.AuthenticationRequestDto;
import com.alfimenkov.finalproject.dto.AuthenticationResponceDto;

public interface IAuthenticationService {

    AuthenticationResponceDto login(AuthenticationRequestDto requestDto);
}

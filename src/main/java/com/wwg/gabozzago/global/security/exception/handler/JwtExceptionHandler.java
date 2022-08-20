package com.wwg.gabozzago.global.security.exception.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wwg.gabozzago.global.error.ErrorResponse;
import com.wwg.gabozzago.global.error.exception.ErrorCode;
import com.wwg.gabozzago.global.error.exception.GlobalException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtExceptionHandler extends OncePerRequestFilter {
    private final ObjectMapper objectMapper;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain)
                                    throws ServletException, IOException {
        try{
            filterChain.doFilter(request,response);
        }catch(GlobalException e){
            e.printStackTrace();

        }
    }
    private void responseError(HttpServletResponse response, ErrorCode errorCode) throws IOException {
        response.setStatus(401);
        response.setContentType("application/json");
        ErrorResponse errorResponse = new ErrorResponse(errorCode.getStatus(),errorCode.getMessage());
        String valueAsString = objectMapper.writeValueAsString(errorResponse);
        response.getWriter().write(valueAsString);
    }
}

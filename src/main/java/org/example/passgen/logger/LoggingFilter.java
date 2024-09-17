package org.example.passgen.logger;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class LoggingFilter implements Filter {
    public static final Logger logger = LoggerFactory.getLogger(LoggingFilter.class);

    public LoggingFilter() {
    }

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
        logger.info("Incoming Request: {} {}", httpRequest.getMethod(), httpRequest.getRequestURI());
        filterChain.doFilter(servletRequest, servletResponse);
        logger.info("Outgoing Response: {}", httpResponse.getStatus());
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("LoggingFilter initialized");
    }
}

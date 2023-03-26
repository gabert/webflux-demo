package com.github.gabert.async.demo.logic;

import jakarta.servlet.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

import static com.github.gabert.async.demo.logic.ThreadUtil.sleep;

@Component
public class AsyncFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain)
            throws IOException, ServletException {

        sleep(200);

        filterChain.doFilter(servletRequest, servletResponse);
    }
}
package woowacourse.auth.support;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;
import woowacourse.auth.exception.InvalidTokenException;

public class LoginInterceptor implements HandlerInterceptor {

    private final JwtTokenProvider jwtTokenProvider;

    public LoginInterceptor(JwtTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        if (isPreflight(request)) {
            return true;
        }

        if (request.getMethod().equals("POST") && request.getRequestURI().equals("/api/customers")) {
            return true;
        }

        String token = AuthorizationExtractor.extract(request);
        if (jwtTokenProvider.validateToken(token)) {
            return true;
        }

        throw new InvalidTokenException();
    }

    private boolean isPreflight(HttpServletRequest request) {
        return request.getMethod().equals("OPTIONS");
    }
}

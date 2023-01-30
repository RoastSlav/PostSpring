package rostislav.postspring.interceptors;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import rostislav.postspring.mappers.UserMapper;

@Component
public class AuthInterceptor implements HandlerInterceptor {
    @Autowired
    UserMapper mapper;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();

        if(session == null)
            return false;

        String user = (String) session.getAttribute("user");
        if (user == null)
            return false;

        return true;
    }
}

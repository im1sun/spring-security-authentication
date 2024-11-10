package nextstep.security.context;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class HttpSessionSecurityContextRepository {

    public static final String SPRING_SECURITY_CONTEXT_KEY = "SPRING_SECURITY_CONTEXT";

    public SecurityContext loadContext(HttpServletRequest request) {
        System.out.println("HttpSessionSecurityContextRepository.loadContext");
        HttpSession session = request.getSession(false);
        if(session == null) {
            System.out.println("session null");

            return null;
        }
        System.out.println("session.getAttribute(SPRING_SECURITY_CONTEXT_KEY) not null");
        return (SecurityContext) session.getAttribute(SPRING_SECURITY_CONTEXT_KEY);
    }

    public void saveContext(SecurityContext context, HttpServletRequest request, HttpServletResponse response) {
        System.out.println("HttpSessionSecurityContextRepository.saveContext");
        HttpSession session = request.getSession();
        session.setAttribute(SPRING_SECURITY_CONTEXT_KEY, context);
    }

}
package session;

import model.UserData;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.UUID;


public class SessionClass {
    public static HttpSession createSession(ServletRequest request, ServletResponse response) {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        UserData userData = new UserData();
        HttpSession session = httpServletRequest.getSession();
        session.setAttribute("userdata", userData);
        return session;
    }
}

package Servlet;

import model.UserData;
import session.SessionClass;
import utils.UserObjectMapper;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

@WebServlet(urlPatterns = "/loginpage")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserData data = null;
        UserData userData = UserObjectMapper.getObjectFromJson(req.getReader(), UserData.class);
       // String userName = userData.getUserName();
        String email = userData.getEmail();
        String password = userData.getPassword();

        //session.getAttribute("userdata");
//        String name = data.getUserName();
//        String mail = data.getEmail();
//        String psw = data.getPassword();
        Map<String,UserData> users = RegisterUser.userDataMap();
        data = users.get(email);
        String mail = data.getEmail();
        String psw = data.getPassword();
        String userName=data.getUserName();
        HttpSession session = req.getSession();
        session.setAttribute("userdata",userName+ UUID.randomUUID().toString());
        if (email.equals(mail) && password.equals(psw)) {
            RequestDispatcher dispatcher = req.getRequestDispatcher("userinfo");
            dispatcher.forward(req, resp);
        } else if (session.getAttribute("userdata") != null) {
            RequestDispatcher dispatcher = req.getRequestDispatcher("userinfo");
            dispatcher.forward(req, resp);
        } else {
            RequestDispatcher dispatcher = req.getRequestDispatcher("registeruser");
            dispatcher.forward(req, resp);
        }

    }
}

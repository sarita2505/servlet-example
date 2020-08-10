package Servlet;

import model.UserData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/userinfo")
public class UserInformation extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // UserData userData=new UserData();
        HttpSession session=req.getSession();
        String userdata=(String) session.getAttribute("userdata");

        resp.getWriter().write("hello "+userdata);


    }
}

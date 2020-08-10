package Servlet;

import model.UserData;
import session.SessionClass;
import utils.UserObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@WebServlet(urlPatterns = "/registeruser")
public class RegisterUser extends HttpServlet {
    static Map<String, UserData> map = new HashMap<>();

    public static Map<String, UserData> userDataMap() {
        return map;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    UserData userData = null;
        try {
            userData = UserObjectMapper.getObjectFromJson(req.getReader(), UserData.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        map.put(userData.getEmail(), userData);
        System.out.println(map);
        for (Map.Entry<String, UserData> entry : map.entrySet()) {
            resp.getWriter().write(entry.getKey() + "</br>");
            userData = entry.getValue();

        }

//        HttpSession session=req.getSession();
//        session.setAttribute("userdata",userData);
    }
}

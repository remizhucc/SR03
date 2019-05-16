package Controller;

import Model.DAOFactory;
import Model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

public class DisplayEditUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String url = req.getRequestURI();
//        int lastIndex = url.lastIndexOf("/");
//        String userId = url.substring(lastIndex + 1);
        String userId = req.getParameter("userId");

        User user = DAOFactory.getDAOUser().selectByID(Integer.parseInt(userId));

        req.setAttribute("user", user);
        req.getRequestDispatcher("/WEB-INF/pages/editUser.jsp").forward(req, resp);
    }
}
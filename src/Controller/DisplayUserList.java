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

public class DisplayUserList extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        ArrayList<User> userList;
        userList = DAOFactory.getDAOUser().selectAll();
        req.setAttribute("userList", userList);
        req.getRequestDispatcher("/WEB-INF/pages/userList.jsp").forward(req, resp);
    }
}
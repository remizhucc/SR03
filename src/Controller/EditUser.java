package Controller;

import Helper.AccountHelper;
import Model.DAOUser;
import Model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EditUser extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("User email") != null) {
            User user = new User(
                    req.getParameter("User id"),
                    req.getParameter("User email"),
                    req.getParameter("User password"),
                    req.getParameter("User first name"),
                    req.getParameter("User last name"),
                    req.getParameter("User company"),
                    req.getParameter("User telephone"),
                    req.getParameter("User type"),
                    req.getParameter("User status")
            );
            DAOUser daoUser = new DAOUser();
            daoUser.update(user);

//            //return previous page
//            String referer = req.getHeader("Referer");
            resp.sendRedirect("/index");


        } else {
            resp.sendRedirect("/error");
        }


    }
}
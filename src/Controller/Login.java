package Controller;

import Model.Constant;
import Model.DAOUser;
import Model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Login extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("User email");
        String password = req.getParameter("User password");
        DAOUser daoUser=new DAOUser();
        User user=daoUser.selectByEmail(email);
        if(user!=null) {
            if (user.getPassword().equals(password)) {
                HttpSession session = req.getSession(true);
                session.setAttribute("id", user.getId());
                session.setAttribute("email", user.getEmail());
                session.setAttribute("firstName", user.getFirstName());
                session.setAttribute("lastName", user.getLastName());
                session.setAttribute("type", user.getType());

                if (user.getType() == Constant.USERTYPE.ADMIN) {
                    resp.sendRedirect("/indexAdmin");
                } else {
                    resp.sendRedirect("/indexTrainee");
                }
            } else {
                resp.sendRedirect("/wrongAuthtication");
            }
        }else {
            resp.sendRedirect("/wrongAuthtication");
        }

    }
}

package Controller;

import Helper.AccountHelper;
import Model.Constant;
import Model.DAOFactory;
import Model.Result;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

public class DisplayResultList extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        ArrayList<Result> resultList;
        if (AccountHelper.isAdmin((Constant.USERTYPE) session.getAttribute("type"))) {
            resultList=DAOFactory.getDAOResult().selectAll();
        }else{
            resultList=DAOFactory.getDAOResult().selectByTraineeID((Integer) session.getAttribute("id"));
        }
        req.setAttribute("resultList", resultList);
        req.getRequestDispatcher("/WEB-INF/pages/resultList.jsp").forward(req, resp);

    }
}

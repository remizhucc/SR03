package Controller;

import Helper.AccountHelper;
import Model.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

public class DisplayQuestionnaireList extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        ArrayList<Questionnaire> questionnaireList;
        questionnaireList = DAOFactory.getDAOQuestionnaire().selectAll();
        req.setAttribute("questionnaireList", questionnaireList);
        req.getRequestDispatcher("/WEB-INF/pages/questionnaireList.jsp").forward(req, resp);
    }
}

package Controller;

import Model.DAOFactory;
import Model.Question;
import Model.Questionnaire;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

public class DisplayQuestionnaire extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int QuestionnaireID = Integer.parseInt(req.getParameter("questionnaireId"));
        HttpSession session = req.getSession(true);

        //set questionnaire
        Questionnaire questionnaire = DAOFactory.getDAOQuestionnaire().selectByID(QuestionnaireID);
        req.setAttribute("questionnaire", questionnaire);

        //set questionList
        ArrayList<Question> questionList;
        questionList = DAOFactory.getDAOQuestion().selectByQuestionnaireID(QuestionnaireID);
        req.setAttribute("questionList", questionList);

        req.getRequestDispatcher("/WEB-INF/pages/questionnaire.jsp").forward(req, resp);
    }
}

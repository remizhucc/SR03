package Controller;

import Helper.SortHelper;
import Model.*;

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

        //set questionnaire
        Questionnaire questionnaire = DAOFactory.getDAOQuestionnaire().selectByID(QuestionnaireID);
        req.setAttribute("questionnaire", questionnaire);

        //set questionList
        ArrayList<Question> questionList = new ArrayList();
        DAOFactory.getDAOQuestion().selectByQuestionnaireID(QuestionnaireID)
                .forEach(question -> {
                            if (question.getStatus() == Constant.STATUS.ACTIVE) {
                                questionList.add(question);
                            }
                        }
                );
        req.setAttribute("questionList", SortHelper.sortQuestion(questionList));


        questionList.forEach(question -> {
            ArrayList<Answer> answerList = new ArrayList();
            DAOFactory.getDAOAnswer()
                    .selectByQuestionID(question.getId())
                    .forEach(answer -> {
                        if (answer.getStatus() == Constant.STATUS.ACTIVE) {
                            answerList.add(answer);
                        }
                    });
            question.setAnswers(SortHelper.sortAnswers(answerList));
        });

        req.getRequestDispatcher("/WEB-INF/pages/questionnaire.jsp").forward(req, resp);
    }
}

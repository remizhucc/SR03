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

public class DisplayResult extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        Integer resultID = Integer.valueOf(req.getParameter("resultId"));
//        ArrayList<Answer> answerList;
//        answerList = DAOFactory.getDAOResultAnswer().selectByResultID(resultID);
//        ArrayList<Question> questionList = new ArrayList();
//        answerList.forEach(answer -> {
//            questionList.add(DAOFactory.getDAOQuestion().selectByID(answer.getQuestion()));
//        });
//        Questionnaire questionnaire = null;
//        if (questionList.size() != 0) {
//            questionnaire = DAOFactory.getDAOQuestionnaire().selectByID(questionList.get(0).getQuestionnaire());
//        }
//        questionList.forEach(question -> {
//            ArrayList<Answer> options = new ArrayList();
//            DAOFactory.getDAOAnswer()
//                    .selectByQuestionID(question.getId())
//                    .forEach(option -> {
//                        if (option.getStatus() == Constant.STATUS.ACTIVE) {
//                            option.setChecked(false);
//                            answerList.forEach(answer -> {
//                                if (option.getId()==answer.getId()){
//                                    option.setChecked(true);
//                                }
//                            });
//                            options.add(option);
//                        }
//                    });
//            question.setAnswers(SortHelper.sortAnswers(options));
//        });
//        req.setAttribute("questionnaire", questionnaire);
//        req.setAttribute("questionList", questionList);
//        req.getRequestDispatcher("/WEB-INF/pages/result.jsp").forward(req, resp);
    }
}

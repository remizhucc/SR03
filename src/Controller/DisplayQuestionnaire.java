package Controller;

import Helper.SortHelper;
import Model.*;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class DisplayQuestionnaire extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        JSONObject Json = new JSONObject();

        int QuestionnaireID = Integer.parseInt(req.getParameter("questionnaireId"));
        //set questionnaire
        JSONObject questionnaireJson = new JSONObject();
        Questionnaire questionnaire = DAOFactory.getDAOQuestionnaire().selectByID(QuestionnaireID);
        questionnaireJson.put("id", questionnaire.getId());
        questionnaireJson.put("subject", questionnaire.getSubject());

        Json.put("questionnaire",questionnaireJson);

        //set questionList
        JSONArray questionListJson=new JSONArray();
        ArrayList<Question> questionList = new ArrayList();
        DAOFactory.getDAOQuestion().selectByQuestionnaireID(QuestionnaireID)
                .forEach(question -> {
                            if (question.getStatus() == Constant.STATUS.ACTIVE) {
                                questionList.add(question);
                            }
                        }
                );
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

        SortHelper.sortQuestion(questionList).forEach(question -> {
            JSONObject questionJson=new JSONObject();
            questionJson.put("id", question.getId());
            questionJson.put("text", question.getText());
            questionJson.put("status", question.getStatus().toString());

            //setanswer
            JSONArray answerListJson=new JSONArray();
            question.getAnswers().forEach(answer -> {
                JSONObject answerJson=new JSONObject();
                answerJson.put("id",answer.getId());
                answerJson.put("text",answer.getText());
                answerJson.put("correction",answer.getCorrection());
                answerListJson.put(answerJson);
            });
            questionJson.put("answer",answerListJson);
            questionListJson.put(questionJson);
        });
        Json.put("question",questionListJson);
        req.setAttribute("json", Json.toString());
        req.getRequestDispatcher("/WEB-INF/pages/questionnaire.jsp").forward(req, resp);
    }
}

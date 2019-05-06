package Controller;

import Helper.AccountHelper;
import Helper.SortHelper;
import Model.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.zip.DataFormatException;

import Helper.questionHelper;


public class CreateQuestion extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int questionnaireId = Integer.parseInt(req.getParameter("questionnaireId"));
        //To get the next index
        Question lastQuestion = questionHelper.getLastQuestionByQuestionnaireId(questionnaireId);
        int index = lastQuestion.getPosition() + 1;

        if (!AccountHelper.isEmailExisted(req.getParameter("Question subject"))) {
            Question newQuestion = new Question(
                    req.getParameter("Question subject"),
                    index,
                    questionnaireId
            );

            DAOFactory.getDAOQuestion().add(newQuestion);

            //get the question that we just put
            lastQuestion = questionHelper.getLastQuestionByQuestionnaireId(questionnaireId);

            //get correction
            String correction = req.getParameter("Correction");
            Map<String, Boolean> correctionMap = new HashMap<String, Boolean>();
            for(int i = 1; i <= 4 ; i++){
                if(correction.equals("AnswerCorrection" + i)){
                    correctionMap.put("Correction" + i, true);
                }else{
                    correctionMap.put("Correction" + i, false);
                }
            }

            //create answer
            for(int i = 1; i <= 4; i ++){
                Answer newAnswer = new Answer(
                        req.getParameter("Answer" + i),
                        i,
                        correctionMap.get("Correction" + i),
                        lastQuestion.getId()
                );
                DAOFactory.getDAOAnswer().add(newAnswer);
            }

            //set questionnaire
            Questionnaire questionnaire = DAOFactory.getDAOQuestionnaire().selectByID(questionnaireId);
            req.setAttribute("questionnaire", questionnaire);

            //set questionList
            ArrayList<Question> questionList = new ArrayList();
            DAOFactory.getDAOQuestion().selectByQuestionnaireID(questionnaireId)
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
        } else {
            resp.sendRedirect("/error");
        }
    }

//    /**
//     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
//     * * methods.      *
//     * * @param request servlet request
//     * * @param response servlet response
//     * * @throws ServletException if a servlet-specific error occurs
//     * * @throws IOException if an I/O error occurs
//     */
//    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        QuestionsTable.put(QuestionsTable.size(), new Question(request.getParameter("Question text")));
//        response.setContentType("text/html;charset=UTF-8");
//        try (PrintWriter out = response.getWriter()) {             /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Controller:</title>");
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1> Question crée " + QuestionsTable.get(QuestionsTable.size() - 1).toString() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        }
//
//        insererData();
//    }
//
//    private void insererData() {
//        Connection conn = null;
//        Statement stmt = null;
//        Question Question = QuestionsTable.get(QuestionsTable.size() - 1);
//
//        try {
//            conn = SQL.getSQLConnection();
//            stmt = conn.createStatement();
//            String sql;
//            sql = "INSERT INTO Question (text) VALUES ('" + Question.getText() + "')";
//            stmt.executeUpdate(sql);
//
//            stmt.close();
//            conn.close();
//        } catch (SQLException se) {
//            se.printStackTrace();
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                if (stmt != null)
//                    stmt.close();
//            } catch (SQLException se2) {
//            }
//            try {
//                if (conn != null)
//                    conn.close();
//            } catch (SQLException se) {
//                se.printStackTrace();
//            }
//        }
//    }
}
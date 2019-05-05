package Controller;

import Helper.AccountHelper;
import Model.DAOFactory;
import Model.DAOQuestion;
import Model.Question;
import Model.SQL;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Hashtable;
import java.sql.*;


public class CreateQuestion extends HttpServlet {
    private static Hashtable<Integer, Question> QuestionsTable = new Hashtable<Integer, Question>();


//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        if (!AccountHelper.isEmailExisted(req.getParameter("Question subject"))) {
//            Question newQuestion = new Question(
//                    req.getParameter("Answer1"),
//                    req.getParameter("Answer1"),
//                    req.getParameter("Answer1"),
//                    req.getParameter("Answer1")
//            );
//            DAOQuestion daoQuestion = new DAOQuestion();
//            daoQuestion.add(newQuestion);
//
//
//            //go to QuestionList
//            HttpSession session = req.getSession(true);
//            ArrayList<Question> QuestionList;
//            QuestionList = DAOFactory.getDAOQuestion().selectAll();
//            req.setAttribute("QuestionList", QuestionList);
//            req.getRequestDispatcher("/WEB-INF/pages/QuestionList.jsp").forward(req, resp);
//
//
//        } else {
//            resp.sendRedirect("/error");
//        }
//    }
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * * methods.      *
     * * @param request servlet request
     * * @param response servlet response
     * * @throws ServletException if a servlet-specific error occurs
     * * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        QuestionsTable.put(QuestionsTable.size(), new Question(request.getParameter("Question text")));
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {             /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Controller:</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1> Question crée " + QuestionsTable.get(QuestionsTable.size() - 1).toString() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }

        insererData();
    }

    private void insererData() {
        Connection conn = null;
        Statement stmt = null;
        Question Question = QuestionsTable.get(QuestionsTable.size() - 1);

        try {
            conn = SQL.getSQLConnection();
            stmt = conn.createStatement();
            String sql;
            sql = "INSERT INTO Question (text) VALUES ('" + Question.getText() + "')";
            stmt.executeUpdate(sql);

            stmt.close();
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}
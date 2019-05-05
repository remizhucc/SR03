
package Controller;
import Helper.AccountHelper;
import Model.DAOFactory;
import Model.DAOQuestionnaire;
import Model.Questionnaire;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

public class CreateQuestionnaire extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (!AccountHelper.isEmailExisted(req.getParameter("Questionnaire subject"))) {
            Questionnaire newQuestionnaire = new Questionnaire(
                    req.getParameter("Questionnaire subject")
            );
            DAOQuestionnaire daoQuestionnaire = new DAOQuestionnaire();
            daoQuestionnaire.add(newQuestionnaire);


            //go to questionnaireList
            HttpSession session = req.getSession(true);
            ArrayList<Questionnaire> questionnaireList;
            questionnaireList = DAOFactory.getDAOQuestionnaire().selectAll();
            req.setAttribute("questionnaireList", questionnaireList);
            req.getRequestDispatcher("/WEB-INF/pages/questionnaireList.jsp").forward(req, resp);


        } else {
            resp.sendRedirect("/error");
        }
    }
//    private static Hashtable<Integer, Questionnaire> questionnairesTable = new Hashtable<Integer, Questionnaire>();
//    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
//    static final String DB_URL = "jdbc:mysql://localhost:3306/root";
//
//    static final String USER = "xiaoroubao1996";
//    static final String PASS = "19960114";
//
//    /**
//     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
//     * * methods.      *
//     * * @param request servlet request
//     * * @param response servlet response
//     * * @throws ServletException if a servlet-specific error occurs
//     * * @throws IOException if an I/O error occurs
//     */
//    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        questionnairesTable.put(questionnairesTable.size(), new Questionnaire(request.getParameter("Questionnaire subject")));
//        response.setContentType("text/html;charset=UTF-8");
//        try (PrintWriter out = response.getWriter()) {             /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Controller:</title>");
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1> Questionnaire crée " + questionnairesTable.get(questionnairesTable.size() - 1).toString() + "</h1>");
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
//        Questionnaire questionnaire = questionnairesTable.get(questionnairesTable.size() - 1);
//
//        try{
//            conn= SQL.getSQLConnection();
//            stmt = conn.createStatement();
//            String sql;
//            sql = "INSERT INTO Questionnaire (subject) VALUES ('"+ questionnaire.getSubject()+"')";
//            stmt.executeUpdate(sql);
//
//            stmt.close();
//            conn.close();
//        } catch(SQLException se) {
//            se.printStackTrace();
//        } catch(Exception e) {
//            e.printStackTrace();
//        }finally{
//            try{
//                if(stmt!=null)
//                    stmt.close();
//            }catch(SQLException se2){
//            }
//            try{
//                if(conn!=null)
//                    conn.close();
//            }catch(SQLException se){
//                se.printStackTrace();
//            }
//        }
//    }
//    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
//    // /**
//    //  * Handles the HTTP <code>GET</code> method.
//    //   *
//    //      * @param request servlet request
//    //   * @param response servlet response
//    //  * @throws ServletException if a servlet-specific error occurs
//    //   * @throws IOException if an I/O error occurs      */
//
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        processRequest(request, response);
//    }
//
//    /**
//     * Handles the HTTP <code>POST</code> method.      *      * @param request servlet request      * @param response servlet response      * @throws ServletException if a servlet-specific error occurs      * @throws IOException if an I/O error occurs
//     */
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        processRequest(request, response);
//    }
//
//    /**
//     * Returns a short description of the servlet.
//     *
//     * @return a String containing servlet description
//     */
//    @Override
//    public String getServletInfo() {
//        return "Short description";
//    }// </editor-fold>  }
}
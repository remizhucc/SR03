

import Model.Question;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Hashtable;
import java.sql.*;


public class CreateQuestion extends HttpServlet {
    private static Hashtable<Integer, User> QuestionsTable = new Hashtable<Integer, User>();
    // JDBC �����������ݿ� URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://localhost:3306/root";
    
    // ���ݿ���û��������룬��Ҫ�����Լ�������
    static final String USER = "xiaoroubao1996";
    static final String PASS = "19960114";

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * * methods.      *
     * * @param request servlet request
     * * @param response servlet response
     * * @throws ServletException if a servlet-specific error occurs
     * * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        QuestionsTable.put(QuestionsTable.size(), new User(request.getParameter("Question text")));
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
        User user = QuestionsTable.get(QuestionsTable.size() - 1);

        try{
            // ע�� JDBC ������
            //Class.forName("com.mysql.jdbc.Driver");
            
            // ��һ������
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            // ִ�� SQL ��ѯ
            stmt = conn.createStatement();
            String sql;
            sql = "INSERT INTO User (subject) VALUES ('"+ Question.getText()+"')";
            ResultSet rs = stmt.executeQuery(sql);
            
            // ��ɺ�ر�
            rs.close();
            stmt.close();
            conn.close();
        } catch(SQLException se) {
            // ���� JDBC ����
            se.printStackTrace();
        } catch(Exception e) {
            // ���� Class.forName ����
            e.printStackTrace();
        }finally{
            // ��������ڹر���Դ�Ŀ�
            try{
                if(stmt!=null)
                stmt.close();
            }catch(SQLException se2){
            }
            try{
                if(conn!=null)
                conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    // /**
    //  * Handles the HTTP <code>GET</code> method.
    //   *
    //      * @param request servlet request
    //   * @param response servlet response
    //  * @throws ServletException if a servlet-specific error occurs
    //   * @throws IOException if an I/O error occurs      */

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.      *      * @param request servlet request      * @param response servlet response      * @throws ServletException if a servlet-specific error occurs      * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>  }

}
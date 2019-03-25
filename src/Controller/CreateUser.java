package Controller;

import Model.Constant;
import Model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;


import java.sql.Statement;
import java.util.Hashtable;
import java.sql.*;


public class CreateUser extends HttpServlet {
    private static Hashtable<Integer, User> usersTable = new Hashtable<Integer, User>();


    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * * methods.      *
     * * @param request servlet request
     * * @param response servlet response
     * * @throws ServletException if a servlet-specific error occurs
     * * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        usersTable.put(usersTable.size(), new User(
                request.getParameter("User email"),
                request.getParameter("User password"),
                request.getParameter("User first name"),
                request.getParameter("User last name"),
                request.getParameter("User company"),
                request.getParameter("User telephone")
                ));
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {             /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Controller:</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1> Utilisateur crée " + usersTable.get(usersTable.size() - 1).toString() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
        
        insererData();
    }
    private void insererData() {
        Connection conn = null;
        Statement stmt = null;
        User user = usersTable.get(usersTable.size() - 1);

        try{
            //Class.forName("com.mysql.jdbc.Driver");

            conn = DriverManager.getConnection(Constant.SQLConnection.URL,Constant.SQLConnection.USER,Constant.SQLConnection.PASSWORD);

            stmt = conn.createStatement();
            String sql;
            sql = "INSERT INTO User (email, firstName, lastName, company, telephone) VALUES ('"+ user.getEmail()+"', '"+ user.getFirstName() + "', '"+ user.getLastName()+ "', '"+ user.getCompany()+ "','"+ user.getTelephone()+ "')";
            ResultSet rs = stmt.executeQuery(sql);

            rs.close();
            stmt.close();
            conn.close();
        } catch(SQLException se) {
            se.printStackTrace();
        } catch(Exception e) {
            e.printStackTrace();
        }finally{
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
//        System.out.println("TEST OK!!!!!!!!!");
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
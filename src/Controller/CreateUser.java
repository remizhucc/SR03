package Controller;

import Model.Constant;
import Model.DAOUser;
import Model.SQL;
import Model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import com.mysql.jdbc.Driver;


import java.sql.Statement;
import java.util.Hashtable;
import java.sql.*;


public class CreateUser extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User newUser=new User(
                req.getParameter("User email"),
                req.getParameter("User password"),
                req.getParameter("User first name"),
                req.getParameter("User last name"),
                req.getParameter("User company"),
                req.getParameter("User telephone")
                );
        DAOUser daoUser=new DAOUser();
        daoUser.add(newUser);
    }
}
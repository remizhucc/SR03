package Model;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DAOUser implements DAOInterface<User> {
    public DAOUser() {
    }

    @Override
    public User selectByID(int id) {
        return null;
    }

    @Override
    public User select(User user) {
        return null;
    }

    @Override
    public void add(User user) {
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = SQL.getSQLConnection();
            stmt = conn.createStatement();
            String sql;
            sql = "INSERT INTO User (email, firstName, lastName, company, telephone) VALUES ('" + user.getEmail() + "', '" + user.getFirstName() + "', '" + user.getLastName() + "', '" + user.getCompany() + "','" + user.getTelephone() + "')";
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
                se2.printStackTrace();
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

    @Override
    public void update(User user) {

    }

    @Override
    public void delete(User user) {

    }
}


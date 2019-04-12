package Model;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

public class DAOUser implements DAOInterface<User> {


    @Override
    public User selectByID(int id) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet result;
        User user=null;
        try {
            conn = SQL.getSQLConnection();
            stmt = conn.createStatement();
            String sql;
            sql = "select * from user where id=" + String.valueOf(id);
            result = stmt.executeQuery(sql);
            while (result.next()) {
                user = new User(Integer.valueOf(result.getInt("id")),
                        result.getString("email"),
                        result.getString("password"),
                        result.getString("firstLame"),
                        result.getString("lastName"),
                        result.getString("company"),
                        result.getString("telephone"),
                        new Date(result.getTimestamp("dateCreation").getTime()),
                        Constant.STATUS.valueOf(result.getString("status")),
                        Constant.USERTYPE.valueOf(result.getString("type")));

            }
            stmt.close();
            conn.close();
            return user;
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<User> selectAll() {
        ArrayList<User> resultList=new ArrayList<>();
        Connection conn = null;
        Statement stmt = null;
        ResultSet result;
        try {
            conn = SQL.getSQLConnection();
            stmt = conn.createStatement();
            String sql;
            sql = "select * from user";
            result = stmt.executeQuery(sql);
            while (result.next()) {
                User user = new User(Integer.valueOf(result.getInt("id")),
                        result.getString("email"),
                        result.getString("password"),
                        result.getString("firstLame"),
                        result.getString("lastName"),
                        result.getString("company"),
                        result.getString("telephone"),
                        new Date(result.getTimestamp("dateCreation").getTime()),
                        Constant.STATUS.valueOf(result.getString("status")),
                        Constant.USERTYPE.valueOf(result.getString("type")));

                resultList.add(user);
            }
            stmt.close();
            conn.close();
            return resultList;
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultList;
    }

    @Override
    public void add(User user) {
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = SQL.getSQLConnection();
            stmt = conn.createStatement();
            String sql;
            sql = "INSERT INTO User (email, firstName, lastName, company, telephone) VALUES " +
                    "('" + user.getEmail() + "', '" + user.getFirstName() +
                    "', '" + user.getLastName() + "', '" + user.getCompany() + "','" + user.getTelephone() + "')";
            stmt.executeUpdate(sql);

            stmt.close();
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(User user) {
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = SQL.getSQLConnection();
            stmt = conn.createStatement();
            String sql;
            sql = "UPDATE User SET email="+user.getEmail()
                    +"password="+user.getPassword()
                    +"firstName="+user.getFirstName()
                    +"lastName="+user.getLastName()
                    +"company="+user.getCompany()
                    +"telephone="+user.getTelephone()
                    +"status="+user.getStatus().toString()
                    +"type="+user.getType().toString()
                    +" WHERE id="+user.getId();
            stmt.executeUpdate(sql);

            stmt.close();
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(User user) {
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = SQL.getSQLConnection();
            stmt = conn.createStatement();
            String sql;
            sql = "DELETE FROM User WHERE id="+user.getId();
            stmt.executeUpdate(sql);

            stmt.close();
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


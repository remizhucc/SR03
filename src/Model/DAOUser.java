package Model;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

public class DAOUser implements DAOInterface<User> {

    public User selectByEmail(String email) {
        Connection conn = null;
        ResultSet result;
        PreparedStatement sqlPrepare;
        User user = null;
        try {
            conn = SQL.getSQLConnection();
            String sql;
            sql = "SELECT * FROM User WHERE email= ? ";
            sqlPrepare=conn.prepareStatement(sql);
            sqlPrepare.setString(1,String.valueOf(email));
            result = sqlPrepare.executeQuery(sql);
            while (result.next()) {
                user = new User(Integer.valueOf(result.getInt("id")),
                        result.getString("email"),
                        result.getString("password"),
                        result.getString("firstName"),
                        result.getString("lastName"),
                        result.getString("company"),
                        result.getString("telephone"),
                        result.getDate("dateCreation"),
                        Constant.STATUS.valueOf(result.getString("status")),
                        Constant.USERTYPE.valueOf(result.getString("type")));

            }
            conn.close();
            return user;
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public User selectByID(Integer id) {
        Connection conn = null;
        ResultSet result;
        PreparedStatement sqlPrepare;
        User user = null;
        try {
            conn = SQL.getSQLConnection();
            String sql;
            sql = "SELECT * FROM User WHERE id= ? ";
            sqlPrepare=conn.prepareStatement(sql);
            sqlPrepare.setInt(1,id);
            result = sqlPrepare.executeQuery(sql);
            while (result.next()) {
                user = new User(Integer.valueOf(result.getInt("id")),
                        result.getString("email"),
                        result.getString("password"),
                        result.getString("firstLame"),
                        result.getString("lastName"),
                        result.getString("company"),
                        result.getString("telephone"),
                        result.getDate("dateCreation"),
                        Constant.STATUS.valueOf(result.getString("status")),
                        Constant.USERTYPE.valueOf(result.getString("type")));

            }
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
        ArrayList<User> resultList = new ArrayList<>();
        Connection conn = null;
        PreparedStatement sqlPrepare;
        ResultSet result;
        try {
            conn = SQL.getSQLConnection();
            String sql;
            sql = "SELECT * FROM user";
            sqlPrepare=conn.prepareStatement(sql);
            result = sqlPrepare.executeQuery();
            while (result.next()) {
                User user = new User(Integer.valueOf(result.getInt("id")),
                        result.getString("email"),
                        result.getString("password"),
                        result.getString("firstLame"),
                        result.getString("lastName"),
                        result.getString("company"),
                        result.getString("telephone"),
                        result.getDate("dateCreation"),
                        Constant.STATUS.valueOf(result.getString("status")),
                        Constant.USERTYPE.valueOf(result.getString("type")));

                resultList.add(user);
            }
            
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
        PreparedStatement sqlPrepare;
        try {
            conn = SQL.getSQLConnection();
            
            String sql;
            sql = "INSERT INTO User (email, password, firstName, lastName, company, telephone, type) VALUES (?,?,?,?,?,?,?)";

            sqlPrepare=conn.prepareStatement(sql);
            sqlPrepare.setString(1,user.getEmail());
            sqlPrepare.setString(2,user.getPassword());
            sqlPrepare.setString(3,user.getFirstName());
            sqlPrepare.setString(4,user.getLastName());
            sqlPrepare.setString(5,user.getCompany());
            sqlPrepare.setString(6,user.getTelephone());
            sqlPrepare.setString(7,user.getType().toString());
            sqlPrepare.executeUpdate();

            
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
        PreparedStatement sqlPrepare;
        try {
            conn = SQL.getSQLConnection();
            
            String sql;
            sql = "UPDATE User SET email= ?, password= ?, firstName= ?, lastName= ?, company=?, telephone=?, status=?"
                    + "type=?, WHERE id=?";

            sqlPrepare=conn.prepareStatement(sql);
            sqlPrepare.setString(1,user.getEmail());
            sqlPrepare.setString(2,user.getPassword());
            sqlPrepare.setString(3,user.getFirstName());
            sqlPrepare.setString(4,user.getLastName());
            sqlPrepare.setString(5,user.getCompany());
            sqlPrepare.setString(6,user.getTelephone());
            sqlPrepare.setString(7,user.getStatus().toString());
            sqlPrepare.setString(8,user.getType().toString());
            sqlPrepare.setInt(9,user.getId());
            sqlPrepare.executeUpdate();

            
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
        PreparedStatement sqlPrepare;
        try {
            conn = SQL.getSQLConnection();
            
            String sql;
            sql = "DELETE FROM User WHERE id=?";
            sqlPrepare=conn.prepareStatement(sql);
            sqlPrepare.setInt(1,user.getId());
            sqlPrepare.executeUpdate(sql);

            
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


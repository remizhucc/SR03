package Model;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

public class DAOAnswer implements DAOInterface<Answer> {


    @Override
    public Answer selectByID(Integer id) {
        Connection conn = null;
        PreparedStatement sqlPrepare;
        ResultSet result;
        Answer answer=null;
        try {
            conn = SQL.getSQLConnection();
            
            String sql;
            sql = "select * from Answer where id= ?";
            sqlPrepare = conn.prepareStatement(sql);
            sqlPrepare.setInt(1, id);
            result = sqlPrepare.executeQuery();
            while (result.next()) {
                answer = new Answer(Integer.valueOf(result.getInt("id")),
                        result.getString("text"),
                        Integer.valueOf(result.getInt("position")),
                        result.getBoolean("correction"),
                        Constant.STATUS.valueOf(result.getString("status")),
                        Integer.valueOf(result.getInt("question")));
            }
            
            conn.close();
            return answer;
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Answer> selectAll() {
        ArrayList<Answer> resultList=new ArrayList<>();
        Connection conn = null;
        PreparedStatement sqlPrepare;
        ResultSet result;
        try {
            conn = SQL.getSQLConnection();
            
            String sql;
            sql = "select * from Answer";
            sqlPrepare = conn.prepareStatement(sql);
            result = sqlPrepare.executeQuery();
            while (result.next()) {
                Answer answer = new Answer(Integer.valueOf(result.getInt("id")),
                        result.getString("text"),
                        Integer.valueOf(result.getInt("position")),
                        result.getBoolean("correction"),
                        Constant.STATUS.valueOf(result.getString("status")),
                        Integer.valueOf(result.getInt("question")));
                resultList.add(answer);
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
    public void add(Answer answer) {
        Connection conn = null;
        PreparedStatement sqlPrepare;
        try {
            conn = SQL.getSQLConnection();
            
            String sql;
            sql = "INSERT INTO Answer (text, position, correction, question) VALUES (?,?,?,?)";
            sqlPrepare = conn.prepareStatement(sql);
            sqlPrepare.setString(1, answer.getText());
            sqlPrepare.setInt(2, answer.getPosition());
            sqlPrepare.setBoolean(3, answer.getCorrection());
            sqlPrepare.setInt(4, answer.getQuestion());
            sqlPrepare.executeUpdate();
            
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Answer answer) {
        Connection conn = null;
        PreparedStatement sqlPrepare;
        try {
            conn = SQL.getSQLConnection();
            
            String sql;
            sql = "UPDATE Answer SET text= ? ,position=?,correction=?,status=?,question=? WHERE id=?";
            sqlPrepare = conn.prepareStatement(sql);
            sqlPrepare.setString(1, answer.getText());
            sqlPrepare.setInt(2, answer.getPosition());
            sqlPrepare.setBoolean(3, answer.getCorrection());
            sqlPrepare.setString(4, answer.getStatus().toString());
            sqlPrepare.setInt(5, answer.getQuestion());
            sqlPrepare.setInt(6, answer.getId());
            sqlPrepare.executeUpdate();

            
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Answer answer) {
        Connection conn = null;
        PreparedStatement sqlPrepare;
        try {
            conn = SQL.getSQLConnection();
            
            String sql;
            sql = "DELETE FROM Answer WHERE id=?";
            sqlPrepare = conn.prepareStatement(sql);
            sqlPrepare.setInt(1, answer.getId());
            sqlPrepare.executeUpdate();

            
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Answer> selectByQuestionID(Integer id) {
        ArrayList<Answer> resultList=new ArrayList<>();
        Connection conn = null;
        PreparedStatement sqlPrepare;
        ResultSet result;
        try {
            conn = SQL.getSQLConnection();
            
            String sql;
            sql = "select * from Answer WHERE question=?";
            sqlPrepare = conn.prepareStatement(sql);
            sqlPrepare.setInt(1, id);
            result=sqlPrepare.executeQuery();
            while (result.next()) {
                Answer answer = new Answer(Integer.valueOf(result.getInt("id")),
                        result.getString("text"),
                        Integer.valueOf(result.getInt("position")),
                        result.getBoolean("correction"),
                        Constant.STATUS.valueOf(result.getString("status")),
                        Integer.valueOf(result.getInt("question")));
                resultList.add(answer);
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

}


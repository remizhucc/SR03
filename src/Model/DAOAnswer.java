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
            sql = "select * from Answer where id=" + String.valueOf(id);
            result = stmt.executeQuery(sql);
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
            result = stmt.executeQuery(sql);
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
            Integer correction = answer.getCorrection()?1:0;
            sql = "INSERT INTO Answer (text, position, correction, question) VALUES " + "('"
                    + answer.getText() + "', '"
                    + answer.getPosition() + "', '"
                    + correction + "', '"
                    + answer.getQuestion() + "')";
            stmt.executeUpdate(sql);

            
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
            sql = "UPDATE Answer SET text="+answer.getText()+"'"
                    +"position='"+answer.getPosition()+"'"
                    +"correction='"+answer.getCorrection()+"'"
                    +"status='"+answer.getStatus()+"'"
                    +"question='"+answer.getQuestion()+"'"
                    +" WHERE id='"+answer.getId()+"'";
            stmt.executeUpdate(sql);

            
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
            sql = "DELETE FROM Answer WHERE id="+answer.getId();
            stmt.executeUpdate(sql);

            
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
            sql = "select * from Answer WHERE question='"+String.valueOf(id)+"'";
            result = stmt.executeQuery(sql);
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


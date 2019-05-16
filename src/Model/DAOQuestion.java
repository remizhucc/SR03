package Model;

import java.sql.*;
import java.util.ArrayList;

public class DAOQuestion implements DAOInterface<Question>{
    @Override
    public Question selectByID(Integer id) {
        Connection conn = null;
        PreparedStatement sqlPrepare;
        ResultSet result;
        Question question=null;
        try {
            conn = SQL.getSQLConnection();
            
            String sql;
            sql = "select * from Answer where id=?";
            sqlPrepare = conn.prepareStatement(sql);
            sqlPrepare.setInt(1, id);
            result = sqlPrepare.executeQuery();
            while (result.next()) {
                question = new Question(Integer.valueOf(result.getInt("id")),
                        result.getString("text"),
                        Integer.valueOf(result.getInt("position")),
                        Constant.STATUS.valueOf(result.getString("status")),
                        Integer.valueOf(result.getInt("questionnaire")));
            }
            
            conn.close();
            return question;
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Question> selectAll() {
        ArrayList<Question> resultList=new ArrayList<>();
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
                Question question = new Question(Integer.valueOf(result.getInt("id")),
                    result.getString("text"),
                    Integer.valueOf(result.getInt("position")),
                    Constant.STATUS.valueOf(result.getString("status")),
                    Integer.valueOf(result.getInt("questionnaire")));
                resultList.add(question);
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
    public void add(Question question) {
        Connection conn = null;
        PreparedStatement sqlPrepare;
        try {
            conn = SQL.getSQLConnection();
            
            String sql;
            sql = "INSERT INTO Question (text, position, questionnaire) VALUES (?,?,?)";
            sqlPrepare = conn.prepareStatement(sql);
            sqlPrepare.setString(1, question.getText());
            sqlPrepare.setInt(2, question.getPosition());
            sqlPrepare.setInt(3, question.getQuestionnaire());
            sqlPrepare.executeUpdate();


            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Question question) {
        Connection conn = null;
        PreparedStatement sqlPrepare;
        try {
            conn = SQL.getSQLConnection();
            
            String sql;
            sql = "UPDATE Question SET text=?,position=?,status=?,questionnaire=? WHERE id=?";
            sqlPrepare = conn.prepareStatement(sql);
            sqlPrepare.setString(1, question.getText());
            sqlPrepare.setInt(2, question.getPosition());
            sqlPrepare.setString(3, question.getStatus().toString());
            sqlPrepare.setInt(4, question.getQuestionnaire());
            sqlPrepare.setInt(5, question.getId());
            sqlPrepare.executeUpdate();

            
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Question question) {
        Connection conn = null;
        PreparedStatement sqlPrepare;
        try {
            conn = SQL.getSQLConnection();
            
            String sql;
            sql = "DELETE FROM Question WHERE id=?";
            sqlPrepare = conn.prepareStatement(sql);
            sqlPrepare.setInt(1, question.getId());
            sqlPrepare.executeUpdate();

            
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Question> selectByQuestionnaireID(Integer id) {
        ArrayList<Question> resultList=new ArrayList<>();
        Connection conn = null;
        PreparedStatement sqlPrepare;
        ResultSet result;
        try {
            conn = SQL.getSQLConnection();
            
            String sql;
            sql = "select * from Question WHERE questionnaire=?";
            sqlPrepare = conn.prepareStatement(sql);
            sqlPrepare.setInt(1, id);
            result=sqlPrepare.executeQuery();
            while (result.next()) {
                Question question = new Question(Integer.valueOf(result.getInt("id")),
                        result.getString("text"),
                        Integer.valueOf(result.getInt("position")),
                        Constant.STATUS.valueOf(result.getString("status")),
                        Integer.valueOf(result.getInt("questionnaire")));
                resultList.add(question);
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

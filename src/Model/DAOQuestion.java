package Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DAOQuestion implements DAOInterface<Question>{
    @Override
    public Question selectByID(Integer id) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet result;
        Question question=null;
        try {
            conn = SQL.getSQLConnection();
            stmt = conn.createStatement();
            String sql;
            sql = "select * from Answer where id=" + String.valueOf(id);
            result = stmt.executeQuery(sql);
            while (result.next()) {
                question = new Question(Integer.valueOf(result.getInt("id")),
                        result.getString("text"),
                        Integer.valueOf(result.getInt("position")),
                        Constant.STATUS.valueOf(result.getString("status")),
                        Integer.valueOf(result.getInt("questionnaire")));
            }
            stmt.close();
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
        Statement stmt = null;
        ResultSet result;
        try {
            conn = SQL.getSQLConnection();
            stmt = conn.createStatement();
            String sql;
            sql = "select * from Answer";
            result = stmt.executeQuery(sql);
            while (result.next()) {
                Question question = new Question(Integer.valueOf(result.getInt("id")),
                    result.getString("text"),
                    Integer.valueOf(result.getInt("position")),
                    Constant.STATUS.valueOf(result.getString("status")),
                    Integer.valueOf(result.getInt("questionnaire")));
                resultList.add(question);
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
    public void add(Question question) {
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = SQL.getSQLConnection();
            stmt = conn.createStatement();
            String sql;
            sql = "INSERT INTO Question (text, position, questionnaire) VALUES " +
                    "('" + question.getText() + "', '"
                    + question.getPosition() + "', '"
                    + question.getQuestionnaire() + "')";
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
    public void update(Question question) {
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = SQL.getSQLConnection();
            stmt = conn.createStatement();
            String sql;
            sql = "UPDATE Question SET text="+question.getText()+"'"
                    +"position='"+question.getPosition()+"'"
                    +"status='"+question.getStatus()+"'"
                    +"questionnaire='"+question.getQuestionnaire()+"'"
                    +" WHERE id='"+question.getId()+"'";
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
    public void delete(Question question) {
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = SQL.getSQLConnection();
            stmt = conn.createStatement();
            String sql;
            sql = "DELETE FROM Question WHERE id="+question.getId();
            stmt.executeUpdate(sql);

            stmt.close();
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
        Statement stmt = null;
        ResultSet result;
        try {
            conn = SQL.getSQLConnection();
            stmt = conn.createStatement();
            String sql;
            sql = "select * from Question WHERE questionnaire='"+String.valueOf(id)+"'";
            result = stmt.executeQuery(sql);
            while (result.next()) {
                Question question = new Question(Integer.valueOf(result.getInt("id")),
                        result.getString("text"),
                        Integer.valueOf(result.getInt("position")),
                        Constant.STATUS.valueOf(result.getString("status")),
                        Integer.valueOf(result.getInt("questionnaire")));
                resultList.add(question);
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

}

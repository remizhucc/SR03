package Model;


import java.sql.*;
import java.util.ArrayList;

public class DAOQuestionnaire implements DAOInterface<Questionnaire> {


    @Override
    public Questionnaire selectByID(Integer id) {
        ResultSet result;
        Connection conn = null;
        PreparedStatement sqlPrepare;
        Questionnaire questionnaire = null;
        try {
            conn = SQL.getSQLConnection();

            String sql;
            sql = "SELECT * FROM questionnaire WHERE id = ?";
            sqlPrepare = conn.prepareStatement(sql);
            sqlPrepare.setInt(1, id);
            result = sqlPrepare.executeQuery();
            if (result.next()) {
                questionnaire = new Questionnaire(
                        Integer.valueOf(result.getString("id")),
                        result.getString("subject"),
                        Constant.STATUS.valueOf(result.getString("status"))
                );
            }

            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return questionnaire;
    }

    @Override
    public ArrayList<Questionnaire> selectAll() {
        ResultSet result;
        Connection conn = null;
        PreparedStatement sqlPrepare;
        ArrayList<Questionnaire> questionnaires = new ArrayList<Questionnaire>();
        try {
            conn = SQL.getSQLConnection();

            String sql;
            sql = "SELECT * FROM questionnaire";
            sqlPrepare = conn.prepareStatement(sql);
            result = sqlPrepare.executeQuery();
            while (result.next()) {
                Questionnaire questionnaire = new Questionnaire(
                        Integer.valueOf(result.getString("id")),
                        result.getString("subject"),
                        Constant.STATUS.valueOf(result.getString("status"))
                );
                questionnaires.add(questionnaire);
            }

            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return questionnaires;
    }

    @Override
    public void add(Questionnaire questionnaire) {
        Connection conn = null;
        PreparedStatement sqlPrepare;
        try {
            conn = SQL.getSQLConnection();

            String sql;
            sql = "INSERT INTO Questionnaire (subject) VALUES (?)";
            sqlPrepare = conn.prepareStatement(sql);
            sqlPrepare.setString(1, questionnaire.getSubject());
            sqlPrepare.executeUpdate();

            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Questionnaire questionnaire) {
        Connection conn = null;
        PreparedStatement sqlPrepare;
        try {
            conn = SQL.getSQLConnection();

            String sql;
            sql = "UPDATE `questionnaire` SET `subject`=?,status`=? WHERE `id`=?";
            sqlPrepare = conn.prepareStatement(sql);
            sqlPrepare.setString(1, questionnaire.getSubject());
            sqlPrepare.setString(2, questionnaire.getStatus().toString());
            sqlPrepare.setInt(3, questionnaire.getId());
            sqlPrepare.executeUpdate();

            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Questionnaire questionnaire) {
        Connection conn = null;
        PreparedStatement sqlPrepare;
        try {
            conn = SQL.getSQLConnection();

            String sql;
            sql = "DELETE FROM `questionnaire` WHERE `id` = ?";
            sqlPrepare = conn.prepareStatement(sql);
            sqlPrepare.setInt(1, questionnaire.getId());
            sqlPrepare.executeUpdate();

            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

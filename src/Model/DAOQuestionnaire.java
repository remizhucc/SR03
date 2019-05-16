package Model;


import java.sql.*;
import java.util.ArrayList;

public class DAOQuestionnaire implements DAOInterface<Questionnaire> {


    @Override
    public Questionnaire selectByID(Integer id){
        ResultSet result;
        Connection conn = null;
        PreparedStatement sqlPrepare;
        Questionnaire questionnaire = null;
        try {
            conn = SQL.getSQLConnection();
            
            String sql;
            sql = "SELECT * FROM questionnaire WHERE id = "+ id;
            result = stmt.executeQuery(sql);
            if (result.next()){
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
        } finally {
            try {
                if (stmt != null)
                    
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
            result = stmt.executeQuery(sql);
            while (result.next()){
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
        } finally {
            try {
                if (stmt != null)
                    
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
        return questionnaires;
    }

    @Override
    public void add(Questionnaire questionnaire) {
        Connection conn = null;
        PreparedStatement sqlPrepare;
        try {
            conn = SQL.getSQLConnection();
            
            String sql;
            sql = "INSERT INTO Questionnaire (subject) VALUES ('"+ questionnaire.getSubject()+"')";
            stmt.executeUpdate(sql);
            
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    
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
    public void update(Questionnaire questionnaire) {
        Connection conn = null;
        PreparedStatement sqlPrepare;
        try {
            conn = SQL.getSQLConnection();
            
            String sql;
            sql = "UPDATE `questionnaire` SET `subject`='"+ questionnaire.getSubject() +
                    "',`status`= `"+ questionnaire.getStatus() +
                    "` WHERE `id`='"+ questionnaire.getId() +"'";
            stmt.executeUpdate(sql);
            
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    
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
    public void delete(Questionnaire questionnaire) {
        Connection conn = null;
        PreparedStatement sqlPrepare;
        try {
            conn = SQL.getSQLConnection();
            
            String sql;
            sql = "DELETE FROM `questionnaire`\n" +
                    "WHERE `id` = '"+questionnaire.getId()+"'";
            stmt.executeUpdate(sql);
            
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    
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
}

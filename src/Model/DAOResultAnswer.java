package Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DAOResultAnswer {
    public void add(Integer resultID,Integer answerID){
        Connection conn=null;
        Statement stmt=null;
        try {
            conn = SQL.getSQLConnection();
            stmt = conn.createStatement();
            String sql;
            sql = "INSERT INTO ResultAnswer (result,answer) VALUES ('" + "('"
                    + String.valueOf(resultID) + "', '"
                    + String.valueOf(answerID) + "')";
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
    public ArrayList<Answer> selectByResultID(Integer id){
        Connection conn = null;
        Statement stmt = null;
        ResultSet resultSet;
        ArrayList<Answer> resultList=new ArrayList<>();
        try {
            conn = SQL.getSQLConnection();
            stmt = conn.createStatement();
            String sql;
            sql = "select * from ResultAnswer where result=" + String.valueOf(id);
            resultSet = stmt.executeQuery(sql);
            while (resultSet.next()) {
                Answer answer = new Answer(Integer.valueOf(resultSet.getInt("id")),
                        resultSet.getString("text"),
                        Integer.valueOf(resultSet.getInt("position")),
                        resultSet.getBoolean("correction"),
                        Constant.STATUS.valueOf(resultSet.getString("status")),
                        Integer.valueOf(resultSet.getInt("question")));
                resultList.add(answer);
            }
            stmt.close();
            conn.close();
            return resultList;
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

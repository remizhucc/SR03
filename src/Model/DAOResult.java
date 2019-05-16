package Model;


import java.sql.*;
import java.util.ArrayList;

public class DAOResult implements DAOInterface<Result> {

    @Override
    public Result selectByID(Integer id){
        ResultSet result;
        Connection conn = null;
        PreparedStatement sqlPrepare;
        Result SQLresult = null;
        try {
            conn = SQL.getSQLConnection();
            
            String sql;
            sql = "SELECT * FROM result WHERE id =?";
            sqlPrepare=conn.prepareStatement(sql);
            sqlPrepare.setInt(1,id);
            result = sqlPrepare.executeQuery(sql);
            if (result.next()){
                SQLresult = new Result(
                        Integer.valueOf(result.getString("id")),
                        Integer.valueOf(result.getString("score")),
                        result.getDate("dateCreation"),
                        result.getString("trainee"),
                        result.getString("json")
                        );
            }
            
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return SQLresult;
    }

    @Override
    public ArrayList<Result> selectAll() {
        ResultSet result;
        Connection conn = null;
        PreparedStatement sqlPrepare;
        ArrayList<Result> results = new ArrayList<Result>();
        try {
            conn = SQL.getSQLConnection();
            
            String sql;
            sql = "SELECT * FROM result";
            result = stmt.executeQuery(sql);
            while (result.next()){
                Result SQLresult = new Result(
                        Integer.valueOf(result.getString("id")),
                        Integer.valueOf(result.getString("score")),
                        result.getDate("dateCreation"),
                        result.getString("trainee"),
                        result.getString("json")
                );
                results.add(SQLresult);
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
        return results;
    }

    @Override
    public void add(Result result) {
        Connection conn = null;
        PreparedStatement sqlPrepare;
        try {
            conn = SQL.getSQLConnection();
            
            String sql;
            sql = "INSERT INTO `result` (score,trainee,json) VALUES ('"+
                    result.getScore()+"','"+
                    result.getTrainee()+"','"+
                    result.getJson() +"')";

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
    public void update(Result result) {
        Connection conn = null;
        PreparedStatement sqlPrepare;
        try {
            conn = SQL.getSQLConnection();
            
            String sql;
            sql = "UPDATE `result` SET `score` = '"+ result.getScore()+
                    "',`trainee`= '"+ result.getTrainee()+
                    "',`json`= '"+ result.getJson()+
                    "' WHERE `id` = '" + result.getId() +"'";
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
    public void delete(Result result) {
        Connection conn = null;
        PreparedStatement sqlPrepare;
        try {
            conn = SQL.getSQLConnection();
            
            String sql;
            sql = "DELETE FROM `result`\n" +
                    "WHERE `id` = '"+result.getId()+"'";
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

    public ArrayList<Result> selectByTraineeID(Integer id){
        ResultSet result;
        Connection conn = null;
        PreparedStatement sqlPrepare;
        ArrayList<Result> results = new ArrayList<Result>();

        try {
            conn = SQL.getSQLConnection();
            
            String sql;
            sql = "SELECT * FROM result WHERE trainee = "+ String.valueOf(id);
            result = stmt.executeQuery(sql);
            while (result.next()){
                Result SQLresult = new Result(
                        Integer.valueOf(result.getString("id")),
                        Integer.valueOf(result.getString("score")),
                        result.getDate("dateCreation"),
                        result.getString("trainee"),
                        result.getString("json")
                );
                results.add(SQLresult);
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
        return results;
    }

}


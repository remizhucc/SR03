package Model;


import java.sql.*;
import java.util.ArrayList;

public class DAOResult implements DAOInterface<Result> {
    private ResultSet result;

    @Override
    public Result selectByID(int id){
        Connection conn = null;
        Statement stmt = null;
        Result SQLresult = null;
        try {
            conn = SQL.getSQLConnection();
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM result WHERE id = "+ id;
            result = stmt.executeQuery(sql);
            if (result.next()){
                SQLresult = new Result(
                        Integer.valueOf(result.getString("id")),
                        Integer.valueOf(result.getString("score")),
                        Date.valueOf(result.getString("dateCreation")),
                        result.getString("trainee")
                        );
            }
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
        return SQLresult;
    }

    @Override
    public ArrayList<Result> selectAll() {
        Connection conn = null;
        Statement stmt = null;
        ArrayList<Result> results = new ArrayList<Result>();
        try {
            conn = SQL.getSQLConnection();
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM result";
            result = stmt.executeQuery(sql);
            while (result.next()){
                Result SQLresult = new Result(
                        Integer.valueOf(result.getString("id")),
                        Integer.valueOf(result.getString("score")),
                        Date.valueOf(result.getString("dateCreation")),
                        result.getString("trainee")
                );
                results.add(SQLresult);
            }
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
        return results;
    }

    @Override
    public void add(Result result) {
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = SQL.getSQLConnection();
            stmt = conn.createStatement();
            String sql;
            sql = "INSERT INTO `result` (score,trainee) VALUES ('"+
                    result.getScore()+"','"+
                    result.getTrainee() +"')";

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

    @Override
    public void update(Result result) {
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = SQL.getSQLConnection();
            stmt = conn.createStatement();
            String sql;
            sql = "UPDATE `result` SET `score` = '"+ result.getScore()+
                    "',`trainee`= '"+ result.getTrainee()+
                    "' WHERE `id` = '" + result.getId() +"'";
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

    @Override
    public void delete(Result result) {
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = SQL.getSQLConnection();
            stmt = conn.createStatement();
            String sql;
            sql = "DELETE FROM `result`\n" +
                    "WHERE `id` = '"+result.getId()+"'";
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

    public Result selectByTraineeID(User user){
        Connection conn = null;
        Statement stmt = null;
        Result SQLresult = null;
        try {
            conn = SQL.getSQLConnection();
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM result WHERE trainee = "+ user.getId();
            result = stmt.executeQuery(sql);
            if (result.next()){
                SQLresult = new Result(
                        Integer.valueOf(result.getString("id")),
                        Integer.valueOf(result.getString("score")),
                        Date.valueOf(result.getString("dateCreation")),
                        result.getString("trainee")
                );
            }
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
        return SQLresult;
    }

}

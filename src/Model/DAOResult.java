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
            result = sqlPrepare.executeQuery();
            if (result.next()){
                SQLresult = new Result(
                        Integer.valueOf(result.getString("id")),
                        Integer.valueOf(result.getString("score")),
                        result.getDate("dateCreation"),
                        result.getInt("trainee"),
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
            sqlPrepare=conn.prepareStatement(sql);
            result = sqlPrepare.executeQuery(sql);
            while (result.next()){
                Result SQLresult = new Result(
                        Integer.valueOf(result.getString("id")),
                        Integer.valueOf(result.getString("score")),
                        result.getDate("dateCreation"),
                        result.getInt("trainee"),
                        result.getString("json")
                );
                results.add(SQLresult);
            }
            
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
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
            sql = "INSERT INTO `result` (score,trainee,json) VALUES (?,?,?)";
            sqlPrepare=conn.prepareStatement(sql);
            sqlPrepare.setInt(1,result.getScore());
            sqlPrepare.setInt(2,result.getTrainee());
            sqlPrepare.setString(3,result.getJson());
            sqlPrepare.executeQuery();
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Result result) {
        Connection conn = null;
        PreparedStatement sqlPrepare;
        try {
            conn = SQL.getSQLConnection();
            
            String sql;
            sql = "UPDATE `result` SET `score` = ?,`trainee`= ?,`json`= ?  WHERE `id` = ?";


            sqlPrepare=conn.prepareStatement(sql);
            sqlPrepare.setInt(1,result.getScore());
            sqlPrepare.setInt(2,result.getTrainee());
            sqlPrepare.setString(3,result.getJson());
            sqlPrepare.setInt(4,result.getId());
            sqlPrepare.executeUpdate();
            
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Result result) {
        Connection conn = null;
        PreparedStatement sqlPrepare;
        try {
            conn = SQL.getSQLConnection();
            
            String sql;
            sql = "DELETE FROM `result` WHERE `id` = ?";
            sqlPrepare=conn.prepareStatement(sql);
            sqlPrepare.setInt(1,result.getId());
            sqlPrepare.executeUpdate();
            
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
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
            sql = "SELECT * FROM result WHERE trainee = ?";
            sqlPrepare=conn.prepareStatement(sql);
            sqlPrepare.setInt(1,id);
            result = sqlPrepare.executeQuery();
            while (result.next()){
                Result SQLresult = new Result(
                        Integer.valueOf(result.getString("id")),
                        Integer.valueOf(result.getString("score")),
                        result.getDate("dateCreation"),
                        result.getInt("trainee"),
                        result.getString("json")
                );
                results.add(SQLresult);
            }
            
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return results;
    }

}


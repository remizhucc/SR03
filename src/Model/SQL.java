package Model;





import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.mysql.jdbc.Driver;
public class SQL {

    public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final String URL = "jdbc:mysql://localhost:3306/SR03?serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=utf-8";

    public static final String USER = "root";
    public static final String PASSWORD = "jdh19960114";

//    public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
//    public static final String URL = "jdbc:mysql://localhost:3306/SR03";
//
//    public static final String USER = "SR03";
//    public static final String PASSWORD = "SR03";

    public static Connection getSQLConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(ClassNotFoundException e){
            System.out.println(e.toString());
        }
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            return connection;
        }catch(SQLException e){
            System.out.println(e.toString());
            return null;
        }
    }
}

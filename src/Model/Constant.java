package Model;

public final class Constant {
    public enum STATUS{
        ACTIVE,
        INACTIVE
    }

    public enum USERTYPE{
        ADMIN,
        TRAINEE
    }

    public final class SQLConnection{
        public static final String DRIVER = "com.mysql.jdbc.Driver";
        public static final String URL = "jdbc:mysql://localhost:3306/root";

        public static final String USER = "xiaoroubao1996";
        public static final String PASSWORD = "19960114";
    }
}

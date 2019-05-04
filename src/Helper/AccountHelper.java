package Helper;

import Model.Constant;
import Model.DAOFactory;
import Model.DAOUser;
import Model.User;

import javax.servlet.http.HttpSession;

public class AccountHelper {
    public static Boolean isAuthentic(String email,String password){
        User user= DAOFactory.getDAOUser().selectByEmail(email);
        return user.getPassword().equals(password);
    }

    public static Boolean isEmailExisted(String email){
        User user= DAOFactory.getDAOUser().selectByEmail(email);
        return user!=null;
    }

    public static User getUserInformationByEmail(String email){
        User user= DAOFactory.getDAOUser().selectByEmail(email);
        return user;
    }

    public static Boolean isAdmin(User user){
        return user.getType()== Constant.USERTYPE.ADMIN;
    }

    public static Boolean isAdmin(String type){
        return Constant.USERTYPE.valueOf(type)== Constant.USERTYPE.ADMIN;

    }
    public static Boolean isAdmin(Constant.USERTYPE user){
        return user== Constant.USERTYPE.ADMIN;
    }

}

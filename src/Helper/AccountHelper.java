package Helper;

import Model.Constant;
import Model.DAOFactory;
import Model.DAOUser;
import Model.User;

public class AccountHelper {
    public static Boolean isAuthentic(String email,String password){
        User user= DAOFactory.getDAOUser().selectByEmail(email);
        return user.getPassword().equals(password);
    }

    public static User getUserInformationByEmail(String email){
        User user= DAOFactory.getDAOUser().selectByEmail(email);
        return user;
    }

    public static Boolean isAdmin(User user){
        return user.getType()== Constant.USERTYPE.ADMIN;
    }
}

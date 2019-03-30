package modelService;

import dao.DAOFactory;
import dao.UserDAO;
import model.User;

public class UserService {

    public void createUser(User user) {
        DAOFactory daoFactory = DAOFactory.getDAOFactory();
        UserDAO userDAO = daoFactory.getUserDAO();
        userDAO.create(user);
    }

    public User readUser(long primaryKey) {
        User resultUser = new User();
        DAOFactory daoFactory = DAOFactory.getDAOFactory();
        UserDAO userDAO = daoFactory.getUserDAO();
        resultUser = userDAO.read(primaryKey);
        return resultUser;
    }

    public User setUserAnAdmin(long primaryKey) {
        User resultUser = new User();
        DAOFactory daoFactory = DAOFactory.getDAOFactory();
        UserDAO userDAO = daoFactory.getUserDAO();
        userDAO.setUserAnAdmin(primaryKey);
        return resultUser;
    }
}

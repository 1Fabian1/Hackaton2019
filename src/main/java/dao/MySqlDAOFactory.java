package dao;

public class MySqlDAOFactory extends DAOFactory {


    @Override
    public NotificationDAO getNotificationDAO() {
        return new NotificationDAOImpl();
    }

    @Override
    public UserDAO getUserDAO() {
        return new UserDAOImpl();
    }
}

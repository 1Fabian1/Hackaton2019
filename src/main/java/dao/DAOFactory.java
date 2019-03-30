package dao;

import exceptions.NoSuchDbException;

public abstract class DAOFactory {

    public static final int MYSQL_DAO_FACTORY = 1;

    public abstract NotificationDAO getNotificationDAO();
    public abstract UserDAO getUserDAO();

    public static DAOFactory getDAOFactory() {
        DAOFactory factory = null;
        try {
            factory = getDAOFactory(MYSQL_DAO_FACTORY);
        } catch (NoSuchDbException e) {
            e.printStackTrace();
        }
        return factory;
    }

    private static DAOFactory getDAOFactory(int type) throws NoSuchDbException {
        switch (type) {
            case MYSQL_DAO_FACTORY:
                return new MySqlDAOFactory();
            default:
                throw new NoSuchDbException();
        }

    }

}

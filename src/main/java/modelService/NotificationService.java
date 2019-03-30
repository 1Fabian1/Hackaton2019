package modelService;

import dao.DAOFactory;
import dao.NotificationDAO;
import model.Notification;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class NotificationService {

    public void createNotification(Notification notification) {
        DAOFactory daoFactory = DAOFactory.getDAOFactory();
        NotificationDAO notificationDAO = daoFactory.getNotificationDAO();
        notificationDAO.create(notification);
    }

    public Notification readNotification(long primaryKey) {
        DAOFactory daoFactory = DAOFactory.getDAOFactory();
        NotificationDAO notificationDAO = daoFactory.getNotificationDAO();
        return notificationDAO.read(primaryKey);
    }

    public List<Notification> readAllNotifications() {
        return readAllNotifications(null);
    }

    public List<Notification> readAllNotifications(Comparator<Notification> comparator) {
        DAOFactory daoFactory = DAOFactory.getDAOFactory();
        NotificationDAO notificationDAO = daoFactory.getNotificationDAO();
        List<Notification> notificationList = notificationDAO.GetAll();
        if (comparator != null && notificationList != null) {
            notificationList.sort(comparator);
        }
        return notificationList;
    }

    public List<Notification> readSolvedNotifications() {
        DAOFactory daoFactory = DAOFactory.getDAOFactory();
        NotificationDAO notificationDAO = daoFactory.getNotificationDAO();
        List<Notification> notificationList = new ArrayList<>();
        notificationList = notificationDAO.readSolvedNotifications();
        return notificationList;
    }

    public List<Notification> readBest25scored() {
        DAOFactory daoFactory = DAOFactory.getDAOFactory();
        NotificationDAO notificationDAO = daoFactory.getNotificationDAO();
        List<Notification> notificationList = new ArrayList<>();
        notificationList = notificationDAO.readBest25Scored();
        return notificationList;
    }

    public List<Notification> readModeratedNotifications() {
        DAOFactory daoFactory = DAOFactory.getDAOFactory();
        NotificationDAO notificationDAO = daoFactory.getNotificationDAO();
        List<Notification> notificationList = new ArrayList<>();
        notificationList = notificationDAO.readModeratedNotifications();
        return notificationList;
    }

    public List<Notification> readAllHotNotifications() {
        DAOFactory daoFactory = DAOFactory.getDAOFactory();
        NotificationDAO notificationDAO = daoFactory.getNotificationDAO();
        List<Notification> notificationList = new ArrayList<>();
        notificationList = notificationDAO.readAllHotNotifications();
        return notificationList;
    }


    public Notification updateNotificationStatus(long idNotificationStatus) {
        Notification notification = new Notification();
        DAOFactory daoFactory = DAOFactory.getDAOFactory();
        NotificationDAO notificationDAO = daoFactory.getNotificationDAO();
        notificationDAO.setNotificationStatus(idNotificationStatus);
        return notification;
    }

    public Notification addPointInNotification(Notification notification, int score, long notificationPrimaryKey) {
        Notification resultNotification = new Notification();

        DAOFactory daoFactory = DAOFactory.getDAOFactory();
        NotificationDAO notificationDAO = daoFactory.getNotificationDAO();
        return resultNotification = notificationDAO.addPointInNotification(notification, score, notificationPrimaryKey);

    }
}

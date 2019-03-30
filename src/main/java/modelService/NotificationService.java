package modelService;

import dao.DAOFactory;
import dao.NotificationDAO;
import model.Notification;

public class NotificationService {

    public void createNotification(Notification notification){
        DAOFactory daoFactory = DAOFactory.getDAOFactory();
        NotificationDAO notificationDAO = daoFactory.getNotificationDAO();
        notificationDAO.create(notification);
    }

    public void updateNotification(Notification notification){

    }
}

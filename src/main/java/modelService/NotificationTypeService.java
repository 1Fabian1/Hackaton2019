package modelService;

import dao.DAOFactory;
import dao.NotificationTypeDAO;
import model.NotificationType;

import java.util.ArrayList;
import java.util.List;

public class NotificationTypeService {

    public List<NotificationType> readAll() {
        List<NotificationType> notificationTypeList = new ArrayList<>();
        DAOFactory daoFactory = DAOFactory.getDAOFactory();
        NotificationTypeDAO notificationTypeDAO = daoFactory.getNotificationTypeDAO();
        return notificationTypeList = notificationTypeDAO.GetAll();

    }
}

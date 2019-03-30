package modelService;

import dao.DAOFactory;
import dao.NotificationStatusDAO;
import model.NotificationStatus;

import java.util.ArrayList;
import java.util.List;

public class NotificationStatusService {

    public List<NotificationStatus> getAll() {
        List<NotificationStatus> notificationStatusList = new ArrayList<>();
        DAOFactory daoFactory = DAOFactory.getDAOFactory();
        NotificationStatusDAO notificationStatusDAO = daoFactory.getNotificationStatusDAO();
        return notificationStatusList = notificationStatusDAO.GetAll();
    }
}

package dao;

import model.Notification;

import java.util.List;

public interface NotificationDAO extends GenericDAO<Notification, Long> {


    Notification addPointInNotification(Notification notification, int score, long notificationPrimaryKey);

    void setNotificationStatus(long idStatus);

    List<Notification> readSolvedNotifications();

    List<Notification> readBest25Scored();

    List<Notification> readModeratedNotifications();

    List<Notification> readAllHotNotifications();


}

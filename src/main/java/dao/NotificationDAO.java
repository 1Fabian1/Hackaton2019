package dao;

import model.Notification;

import java.util.List;

public interface NotificationDAO extends GenericDAO<Notification, Long> {


    Notification addPointInNotification(Notification notification, int score);

    void setNotificationStatus(long idStatus);

    List<Notification> readSolvedNotifications();

    List<Notification> readBest25Scored();

}

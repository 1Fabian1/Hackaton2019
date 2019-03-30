package dao;

import model.Notification;

public interface NotificationDAO extends GenericDAO<Notification, Long> {


    Notification addPointInNotification(Notification notification, int score);

}

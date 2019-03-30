package model;

import java.util.Objects;

public class NotificationStatus {
    private long idNotificationStatus;
    private String notificationStatusName;

    public NotificationStatus() {
    }

    public NotificationStatus(long idNotificationStatus, String notificationStatusName) {
        this.idNotificationStatus = idNotificationStatus;
        this.notificationStatusName = notificationStatusName;
    }

    public long getIdNotificationStatus() {
        return idNotificationStatus;
    }

    public void setIdNotificationStatus(long idNotificationStatus) {
        this.idNotificationStatus = idNotificationStatus;
    }

    public String getNotificationStatusName() {
        return notificationStatusName;
    }

    public void setNotificationStatusName(String notificationStatusName) {
        this.notificationStatusName = notificationStatusName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NotificationStatus)) return false;
        NotificationStatus that = (NotificationStatus) o;
        return getIdNotificationStatus() == that.getIdNotificationStatus() &&
                Objects.equals(getNotificationStatusName(), that.getNotificationStatusName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdNotificationStatus(), getNotificationStatusName());
    }

    @Override
    public String toString() {
        return "NotificationStatus{" +
                "idNotificationStatus=" + idNotificationStatus +
                ", notificationStatusName='" + notificationStatusName + '\'' +
                '}';
    }
}

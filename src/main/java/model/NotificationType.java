package model;

import java.util.Objects;

public class NotificationType {

    private long idNotificationType;
    private String notificationTypeName;

    public NotificationType() {
    }

    public NotificationType(long idNotificationType, String notificationTypeName) {
        this.idNotificationType = idNotificationType;
        this.notificationTypeName = notificationTypeName;
    }

    public long getIdNotificationType() {
        return idNotificationType;
    }

    public void setIdNotificationType(long idNotificationType) {
        this.idNotificationType = idNotificationType;
    }

    public String getNotificationTypeName() {
        return notificationTypeName;
    }

    public void setNotificationTypeName(String notificationTypeName) {
        this.notificationTypeName = notificationTypeName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NotificationType)) return false;
        NotificationType that = (NotificationType) o;
        return getIdNotificationType() == that.getIdNotificationType() &&
                Objects.equals(getNotificationTypeName(), that.getNotificationTypeName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdNotificationType(), getNotificationTypeName());
    }

    @Override
    public String toString() {
        return "NotificationType{" +
                "idNotificationType=" + idNotificationType +
                ", notificationTypeName='" + notificationTypeName + '\'' +
                '}';
    }
}



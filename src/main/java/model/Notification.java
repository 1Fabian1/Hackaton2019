package model;

import java.sql.Date;
import java.util.Objects;

public class Notification {
    private long idNotification;
    private String notificationName;
    private long notificationType;
    private String description;
    private String localization;
    private long idStatus;
    private String statusDescription;
    private int score;
    private String notificationTime;
    private long idUser;

    public Notification() {
    }

    public Notification(long idNotification, String notificationName, long notificationType, String description, String localization, long idStatus, String statusDescription, int score, String notificationTime, long idUser) {
        this.idNotification = idNotification;
        this.notificationName = notificationName;
        this.notificationType = notificationType;
        this.description = description;
        this.localization = localization;
        this.idStatus = idStatus;
        this.statusDescription = statusDescription;
        this.score = score;
        this.notificationTime = notificationTime;
        this.idUser = idUser;
    }

    public long getIdNotification() {
        return idNotification;
    }

    public void setIdNotification(long idNotification) {
        this.idNotification = idNotification;
    }

    public String getNotificationName() {
        return notificationName;
    }

    public void setNotificationName(String notificationName) {
        this.notificationName = notificationName;
    }

    public long getNotificationType() {
        return notificationType;
    }

    public void setNotificationType(long notificationType) {
        this.notificationType = notificationType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocalization() {
        return localization;
    }

    public void setLocalization(String localization) {
        this.localization = localization;
    }

    public long getIdStatus() {
        return idStatus;
    }

    public void setIdStatus(long idStatus) {
        this.idStatus = idStatus;
    }

    public String getStatusDescription() {
        return statusDescription;
    }

    public void setStatusDescription(String statusDescription) {
        this.statusDescription = statusDescription;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getNotificationTime() {
        return notificationTime;
    }

    public void setNotificationTime(String notificationTime) {
        this.notificationTime = notificationTime;
    }

    public long getIdUser() {
        return idUser;
    }

    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Notification)) return false;
        Notification that = (Notification) o;
        return getIdNotification() == that.getIdNotification() &&
                getNotificationType() == that.getNotificationType() &&
                getIdStatus() == that.getIdStatus() &&
                getScore() == that.getScore() &&
                getIdUser() == that.getIdUser() &&
                Objects.equals(getNotificationName(), that.getNotificationName()) &&
                Objects.equals(getDescription(), that.getDescription()) &&
                Objects.equals(getLocalization(), that.getLocalization()) &&
                Objects.equals(getStatusDescription(), that.getStatusDescription()) &&
                Objects.equals(getNotificationTime(), that.getNotificationTime());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdNotification(), getNotificationName(), getNotificationType(), getDescription(), getLocalization(), getIdStatus(), getStatusDescription(), getScore(), getNotificationTime(), getIdUser());
    }

    @Override
    public String toString() {
        return "Notification{" +
                "idNotification=" + idNotification +
                ", notificationName='" + notificationName + '\'' +
                ", notificationType=" + notificationType +
                ", description='" + description + '\'' +
                ", localization='" + localization + '\'' +
                ", idStatus=" + idStatus +
                ", statusDescription='" + statusDescription + '\'' +
                ", score=" + score +
                ", notificationTime=" + notificationTime +
                ", idUser=" + idUser +
                '}';
    }
}

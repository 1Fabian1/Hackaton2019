package model;

import javax.sql.DataSource;
import java.sql.Date;
import java.util.Objects;

public class Notification {
    private long idNotification;
    private String photoPath;
    private long NotificationType;
    private String type;
    private String description;
    private String localization;
    private long idStatus;
    private String statusDescription;
    private int score;
    private Date notificationTime;
    private long idUser;

    public Notification() {
    }

    public Notification(long idNotification, String photoPath, long notificationType, String type, String description, String localization, long idStatus, String statusDescription, int score, Date notificationTime, long idUser) {
        this.idNotification = idNotification;
        this.photoPath = photoPath;
        NotificationType = notificationType;
        this.type = type;
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

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    public long getNotificationType() {
        return NotificationType;
    }

    public void setNotificationType(long notificationType) {
        NotificationType = notificationType;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public Date getNotificationTime() {
        return notificationTime;
    }

    public void setNotificationTime(Date notificationTime) {
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
                Objects.equals(getPhotoPath(), that.getPhotoPath()) &&
                Objects.equals(getType(), that.getType()) &&
                Objects.equals(getDescription(), that.getDescription()) &&
                Objects.equals(getLocalization(), that.getLocalization()) &&
                Objects.equals(getStatusDescription(), that.getStatusDescription()) &&
                Objects.equals(getNotificationTime(), that.getNotificationTime());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdNotification(), getPhotoPath(), getNotificationType(), getType(), getDescription(), getLocalization(), getIdStatus(), getStatusDescription(), getScore(), getNotificationTime(), getIdUser());
    }

    @Override
    public String toString() {
        return "Notification{" +
                "idNotification=" + idNotification +
                ", photoPath='" + photoPath + '\'' +
                ", NotificationType=" + NotificationType +
                ", type='" + type + '\'' +
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

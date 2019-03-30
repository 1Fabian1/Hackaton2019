package model;

import java.sql.Date;
import java.util.Objects;

public class Comment {
    private long idComment;
    private String commentContent;
    private int score;
    private String addTime;
    private long idNotification;
    private long idUser;

    public Comment(){}

    public Comment(long idComment, String commentContent, int score, String addTime, long idNotification, long idUser) {
        this.idComment = idComment;
        this.commentContent = commentContent;
        this.score = score;
        this.addTime = addTime;
        this.idNotification = idNotification;
        this.idUser = idUser;
    }

    public long getIdComment() {
        return idComment;
    }

    public void setIdComment(long idComment) {
        this.idComment = idComment;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    public long getIdNotification() {
        return idNotification;
    }

    public void setIdNotification(long idNotification) {
        this.idNotification = idNotification;
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
        if (!(o instanceof Comment)) return false;
        Comment comment = (Comment) o;
        return getIdComment() == comment.getIdComment() &&
                getScore() == comment.getScore() &&
                getIdNotification() == comment.getIdNotification() &&
                getIdUser() == comment.getIdUser() &&
                Objects.equals(getCommentContent(), comment.getCommentContent()) &&
                Objects.equals(getAddTime(), comment.getAddTime());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdComment(), getCommentContent(), getScore(), getAddTime(), getIdNotification(), getIdUser());
    }

    @Override
    public String toString() {
        return "Comment{" +
                "idComment=" + idComment +
                ", commentContent='" + commentContent + '\'' +
                ", score=" + score +
                ", addTime=" + addTime +
                ", idNotification=" + idNotification +
                ", idUser=" + idUser +
                '}';
    }
}

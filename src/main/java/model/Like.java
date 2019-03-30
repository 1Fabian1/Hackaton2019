package model;

import java.sql.Date;
import java.util.Objects;

public class Like {
    private long idLike;
    private Date likeTime;
    private long idUser;
    private long idComment;

    public Like() {
    }

    public Like(long idLike, Date likeTime, long idUser, long idComment) {
        this.idLike = idLike;
        this.likeTime = likeTime;
        this.idUser = idUser;
        this.idComment = idComment;
    }

    public long getIdLike() {
        return idLike;
    }

    public void setIdLike(long idLike) {
        this.idLike = idLike;
    }

    public Date getLikeTime() {
        return likeTime;
    }

    public void setLikeTime(Date likeTime) {
        this.likeTime = likeTime;
    }

    public long getIdUser() {
        return idUser;
    }

    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }

    public long getIdComment() {
        return idComment;
    }

    public void setIdComment(long idComment) {
        this.idComment = idComment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Like)) return false;
        Like like = (Like) o;
        return getIdLike() == like.getIdLike() &&
                getIdUser() == like.getIdUser() &&
                getIdComment() == like.getIdComment() &&
                Objects.equals(getLikeTime(), like.getLikeTime());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdLike(), getLikeTime(), getIdUser(), getIdComment());
    }

    @Override
    public String toString() {
        return "Like{" +
                "idLike=" + idLike +
                ", likeTime=" + likeTime +
                ", idUser=" + idUser +
                ", idComment=" + idComment +
                '}';
    }
}

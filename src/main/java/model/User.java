package model;

import java.util.Objects;

public class User {
    private long idUser;
    private String name;
    private String email;
    private int isModerator;

    public User() {
    }

    public User(long idUser, String name, String email, int isModerator) {
        this.idUser = idUser;
        this.name = name;
        this.email = email;
        this.isModerator = isModerator;
    }

    public long getIdUser() {
        return idUser;
    }

    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int isModerator() {
        return isModerator;
    }

    public void setModerator(int moderator) {
        isModerator = moderator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getIdUser() == user.getIdUser() &&
                isModerator() == user.isModerator() &&
                Objects.equals(getName(), user.getName()) &&
                Objects.equals(getEmail(), user.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdUser(), getName(), getEmail(), isModerator());
    }

    @Override
    public String toString() {
        return "User{" +
                "idUser=" + idUser +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", isModerator=" + isModerator +
                '}';
    }
}

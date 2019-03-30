package dao;

import model.User;

public interface UserDAO extends GenericDAO<User, Long> {

    void setUserAnAdmin(long primaryKey);

}

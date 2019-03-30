package dao;

import dbConnection.ConnectionProvider;
import model.Notification;
import model.NotificationStatus;
import model.NotificationType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class NotificationStatusDAOImpl implements NotificationStatusDAO {

    private static final String READ_ALL_NOTIFICATION_STATUSES = "SELECT * FROM hackaton.statusyzgloszen;";

    @Autowired
    private NamedParameterJdbcTemplate template;

    public NotificationStatusDAOImpl() {
        template = new NamedParameterJdbcTemplate(ConnectionProvider.getDataSource());
    }


    @Override
    public NotificationStatus create(NotificationStatus newObject) {
        return null;
    }

    @Override
    public NotificationStatus read(Long primaryKey) {
        return null;
    }

    @Override
    public Notification update(NotificationStatus updateObject) {
        return null;
    }

    @Override
    public boolean delete(Long primaryKey) {
        return false;
    }

    @Override
    public List<NotificationStatus> GetAll() {
        List<NotificationStatus> notificationTypeList = new ArrayList<>();
        try {
            notificationTypeList = template.query(READ_ALL_NOTIFICATION_STATUSES, new NotificationStatusRowMapper());
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return notificationTypeList;
    }

    private class NotificationStatusRowMapper implements RowMapper<NotificationStatus> {
        @Override
        public NotificationStatus mapRow(ResultSet resultSet, int rowNum) throws SQLException {
            NotificationStatus resultNotificationStatus = new NotificationStatus();
            resultNotificationStatus.setIdNotificationStatus(resultSet.getLong("idstatusyzgloszen"));
            resultNotificationStatus.setNotificationStatusName(resultSet.getString("nazwastatusu"));
            return resultNotificationStatus;

        }
    }
}

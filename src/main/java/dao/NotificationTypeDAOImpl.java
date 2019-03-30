package dao;

import dbConnection.ConnectionProvider;
import model.Notification;
import model.NotificationType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NotificationTypeDAOImpl implements NotificationTypeDAO {

    private static final String READ_NOTIFICATIONTYPE = "SELECT * FROM hackaton.rodzajezgloszen;";

    @Autowired
    private NamedParameterJdbcTemplate template;

    @Autowired
    public NotificationTypeDAOImpl() {
        template = new NamedParameterJdbcTemplate(ConnectionProvider.getDataSource());
    }

    @Override
    public NotificationType create(NotificationType notificationType) {
        return null;

    }

    @Override
    public NotificationType read(Long primaryKey) {
        return null;
    }

    @Override
    public Notification update(NotificationType updateObject) {
        return null;
    }

    @Override
    public boolean delete(Long primaryKey) {
        return false;
    }

    @Override
    public List<NotificationType> GetAll() {
        List<NotificationType> notificationTypeList = new ArrayList<>();
        try {
            notificationTypeList = template.query(READ_NOTIFICATIONTYPE, new NotificationTypeRowMapper());
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return notificationTypeList;
    }

    private class NotificationTypeRowMapper implements RowMapper<NotificationType> {
        @Override
        public NotificationType mapRow(ResultSet resultSet, int rowNum) throws SQLException {
            NotificationType resultNotificationType = new NotificationType();
            resultNotificationType.setIdNotificationType(resultSet.getLong("idrodzajezgloszen"));
            resultNotificationType.setNotificationTypeName(resultSet.getString("nazwarodzaju"));
            return resultNotificationType;

        }
    }
}

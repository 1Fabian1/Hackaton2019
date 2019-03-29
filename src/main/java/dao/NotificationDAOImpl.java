package dao;

import dbConnection.ConnectionProvider;
import model.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NotificationDAOImpl implements NotificationDAO {

    private static final String CREATE_NOTIFICATION = "";
    private static final String READ_NOTIFICATION = "";
    private static final String UPDATE_NOTIFICATION = "";
    private static final String DELETE_NOTIFICATION = "";

    private NamedParameterJdbcTemplate template;

    @Autowired
    public NotificationDAOImpl() {
        template = new NamedParameterJdbcTemplate(ConnectionProvider.getDataSource());
    }

    //TODO fill paramMap's Strings
    @Override
    public Notification create(Notification notification) {
        Notification resultNotification = new Notification();
        KeyHolder holder = new GeneratedKeyHolder();
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("",notification.getIdNotification());
        paramMap.put("",notification.getPhotoPath());
        paramMap.put("", notification.getNotificationType());
        paramMap.put("", notification.getNotificationType());


        return resultNotification;
    }

    @Override
    public Notification read(Long primaryKey) {
        return null;
    }

    @Override
    public boolean update(Notification updateObject) {
        return false;
    }

    @Override
    public boolean delete(Long primaryKey) {
        return false;
    }

    @Override
    public List<Notification> GetAll() {
        return null;
    }

    //TODO fill class with propper column names
    private class NotificationRowMapper implements RowMapper<Notification> {
        @Override
        public Notification mapRow(ResultSet resultSet, int rowNum) throws SQLException {
            Notification resultNotification = new Notification();

            resultNotification.setIdNotification(resultSet.getLong(""));
            resultNotification.setPhotoPath(resultSet.getString(""));
            resultNotification.setNotificationType(resultSet.getLong(""));
            resultNotification.setType(resultSet.getString(""));
            resultNotification.setDescription(resultSet.getString(""));
            resultNotification.setLocalization(resultSet.getString(""));
            resultNotification.setIdStatus(resultSet.getLong(""));
            resultNotification.setDescription(resultSet.getString(""));
            resultNotification.setScore(resultSet.getInt(""));
            resultNotification.setNotificationTime(resultSet.getDate(""));
            resultNotification.setIdUser(resultSet.getLong(""));

            return resultNotification;
        }
    }
}


package dao;

import dbConnection.ConnectionProvider;
import model.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NotificationDAOImpl implements NotificationDAO {

    //TODO fill querries
    private static final String CREATE_NOTIFICATION = "INSERT INTO zgloszenia (idzgloszenia, nazwazgloszenia, idrodzajezgloszen, opiszgloszenia, lokalizacja, idstatusyzgloszen, opisstatusu, punkty, czaszgloszenia, iduzytkownicy) VALUES (:idzgloszenia, :nazwazgloszenia, :idrodzajezgloszen, :opiszgloszenia, :lokalizacja, :idstatusyzgloszen, :opisstatusu, :punkty, :czaszgloszenia, :iduzytkownicy);";
    private static final String READ_NOTIFICATION = "";
    private static final String READ_NOTIFICATION_BY_ID = "";
    private static final String UPDATE_NOTIFICATION = "";
    private static final String UPDATE_NOTIFICATION_POINTS = "UPDATE zgloszenia SET punkty = :punkty WHERE zgloszenia.idzgloszenia = :idzgloszenia;";
    private static final String DELETE_NOTIFICATION = "";

    @Autowired
    private NamedParameterJdbcTemplate template;

    @Autowired
    public NotificationDAOImpl() {
        template = new NamedParameterJdbcTemplate(ConnectionProvider.getDataSource());
    }

    @Override
    public Notification create(Notification notification) {
        Notification resultNotification = new Notification();
        KeyHolder holder = new GeneratedKeyHolder();
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("idzgloszenia", notification.getIdNotification());
        paramMap.put("nazwazgloszenia", notification.getNotificationName());
        paramMap.put("idrodzajezgloszen", notification.getNotificationType());
        paramMap.put("opiszgloszenia", notification.getDescription());
        paramMap.put("lokalizacja", notification.getLocalization());
        paramMap.put("idstatusyzgloszen", notification.getIdStatus());
        paramMap.put("opisstatusu", notification.getStatusDescription());
        paramMap.put("punkty", notification.getScore());
        paramMap.put("czaszgloszenia", notification.getNotificationTime());
        paramMap.put("iduzytkownicy", notification.getIdUser());

        SqlParameterSource parameterSource = new MapSqlParameterSource(paramMap);
        int update = template.update(CREATE_NOTIFICATION, parameterSource, holder);
        return resultNotification;
    }

    @Override
    public Notification read(Long primaryKey) {
        Notification resultNotification = new Notification();
        SqlParameterSource parameterSource = new MapSqlParameterSource("idZgloszenia", primaryKey);
        resultNotification = template.queryForObject(READ_NOTIFICATION_BY_ID, parameterSource, new NotificationRowMapper());
        return resultNotification;
    }

    @Override
    public Notification update(Notification notification) {
        Notification updateNotification = new Notification();
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("idzgloszenia", notification.getIdUser());
        paramMap.put("nazwazgloszenia", notification.getNotificationName());
        paramMap.put("idrodzajezgloszen", notification.getNotificationType());
        paramMap.put("opiszgloszenia", notification.getDescription());
        paramMap.put("lokalizacja", notification.getLocalization());
        paramMap.put("idstatusyzgloszen", notification.getIdStatus());
        paramMap.put("opisstatusu", notification.getStatusDescription());
        paramMap.put("punkty", notification.getScore());
        paramMap.put("czaszgloszenia", notification.getNotificationTime());
        paramMap.put("iduzytkownicy", notification.getIdUser());

        SqlParameterSource parameterSource = new MapSqlParameterSource(paramMap);
        template.update(UPDATE_NOTIFICATION, parameterSource);
        return updateNotification;
    }

    @Override
    public boolean delete(Long primaryKey) {
        return false;
    }

    @Override
    public List<Notification> GetAll() {
        return null;
    }

    @Override
    public Notification addPointInNotification(Notification notification, int score) {
        return null;
    }


    private class NotificationRowMapper implements RowMapper<Notification> {
        @Override
        public Notification mapRow(ResultSet resultSet, int rowNum) throws SQLException {
            Notification resultNotification = new Notification();

            resultNotification.setIdNotification(resultSet.getLong("idzgloszenia"));
            resultNotification.setNotificationName(resultSet.getString("nazwazgloszenia"));
            resultNotification.setNotificationType(resultSet.getLong("idrodzajezgloszen"));
            resultNotification.setDescription(resultSet.getString("opiszgloszenia"));
            resultNotification.setLocalization(resultSet.getString("lokalizacja"));
            resultNotification.setIdStatus(resultSet.getLong("idstatusyzgloszen"));
            resultNotification.setStatusDescription(resultSet.getString("opisstatusu"));
            resultNotification.setScore(resultSet.getInt("punkty"));
            resultNotification.setNotificationTime(resultSet.getDate("czaszgloszenia"));
            resultNotification.setIdUser(resultSet.getLong("iduzytkownicy"));
            return resultNotification;
        }
    }
}


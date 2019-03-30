package dao;

import dbConnection.ConnectionProvider;
import model.Notification;
import model.User;
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

public class UserDAOImpl implements UserDAO {

    private static final String CREATE_USER = "INSERT INTO uzytkownicy (iduzytkownicy, nazwawyswietlana, email, czymoderator) VALUES (NULL, :nazwawyswietlana, :email, '0');";
    private static final String READ_USER = "SELECT * FROM uzytkownicy WHERE iduzytkownicy = :iduzytkownicy;";
    private static final String UPDATE_USER = "";
    private static final String UPDATE_USER_TO_ADMIN_BY_ID = "UPDATE uzytkownicy SET czymoderator = '1' WHERE uzytkownicy.iduzytkownicy = :iduzytkownicy;";
    private static final String DELETE_USER = "";

    @Autowired
    private NamedParameterJdbcTemplate template;

    public UserDAOImpl() {
        template = new NamedParameterJdbcTemplate(ConnectionProvider.getDataSource());
    }

    @Override
    public User create(User user) {
        User resultUser = new User();
        KeyHolder holder = new GeneratedKeyHolder();
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("iduzytkownicy", user.getIdUser());
        paramMap.put("nazwawyswietlana", user.getName());
        paramMap.put("email", user.getEmail());
        paramMap.put("czymoderator", user.isModerator());
        SqlParameterSource parameterSource = new MapSqlParameterSource(paramMap);
        int update = template.update(CREATE_USER, parameterSource, holder);

        return resultUser;
    }

    @Override
    public User read(Long primaryKey) {
        User resultUser = new User();
        SqlParameterSource parameterSource = new MapSqlParameterSource("iduzytkownicy", primaryKey);
        resultUser = template.queryForObject(READ_USER, parameterSource, new UserRowMapper());
        return resultUser;
    }

    @Override
    public Notification update(User updateObject) {
        return null;
    }

    @Override
    public boolean delete(Long primaryKey) {
        return false;
    }

    @Override
    public List<User> GetAll() {
        return null;
    }

    //TODO finish this method
    @Override
    public void setUserAnAdmin(long primaryKey) {
        SqlParameterSource parameterSource = new MapSqlParameterSource("iduzytkownicy", primaryKey);
        template.update(UPDATE_USER_TO_ADMIN_BY_ID, parameterSource);
    }

    private class UserRowMapper implements RowMapper<User> {
        @Override
        public User mapRow(ResultSet resultSet, int rowNum) throws SQLException {
            User resultUser = new User();
            resultUser.setIdUser(resultSet.getLong("iduzytkownicy"));
            resultUser.setName(resultSet.getString("nazwawyswietlana"));
            resultUser.setEmail(resultSet.getString("email"));
            resultUser.setModerator(resultSet.getInt("czymoderator"));
            return resultUser;
        }
    }

}

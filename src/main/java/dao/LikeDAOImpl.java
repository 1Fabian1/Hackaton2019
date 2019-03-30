package dao;

import dbConnection.ConnectionProvider;
import model.Like;
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

public class LikeDAOImpl implements LikeDAO {

    private static final String CREATE_LIKE = "INSERT INTO polubieniakomentarzy (idpolubieniakomentarzy, czaspolubienia, iduzytkownicy, idkomentarze) VALUES (null , :czaspolubienia, :iduzytkownicy, :idkomentarze);";


    @Autowired
    private NamedParameterJdbcTemplate template;

    public LikeDAOImpl() {
        template = new NamedParameterJdbcTemplate(ConnectionProvider.getDataSource());
    }

    @Override
    public Like create(Like like) {
        Like resultLike = new Like();
        KeyHolder holder = new GeneratedKeyHolder();
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("idpolubieniakomentarzy", like.getIdLike());
        paramMap.put("czaspolubienia", like.getLikeTime());
        paramMap.put("iduzytkownicy", like.getIdUser());
        paramMap.put("idkomentarze", like.getIdComment());

        SqlParameterSource parameterSource = new MapSqlParameterSource(paramMap);
        int update = template.update(CREATE_LIKE, parameterSource, holder);
        return resultLike;
    }

    @Override
    public Like read(Long primaryKey) {
        return null;
    }

    @Override
    public Notification update(Like updateObject) {
        return null;
    }

    @Override
    public boolean delete(Long primaryKey) {
        return false;
    }

    @Override
    public List<Like> GetAll() {
        return null;
    }

    private class LikeRowMapper implements RowMapper<Like> {
        @Override
        public Like mapRow(ResultSet resultSet, int rowNum) throws SQLException {
            Like resultLike = new Like();
            resultLike.setIdLike(resultSet.getLong("idpolubieniakomentarzy"));
            resultLike.setLikeTime(resultSet.getDate("czaspolubienia"));
            resultLike.setIdUser(resultSet.getLong("iduzytkownicy"));
            resultLike.setIdComment(resultSet.getLong("idkomentarze"));
            return resultLike;
        }
    }
}

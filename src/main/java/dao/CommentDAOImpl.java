package dao;

import dbConnection.ConnectionProvider;
import model.Comment;
import model.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.ws.rs.PUT;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CommentDAOImpl implements CommentDAO {

    private static final String CREATE_COMMENT = "INSERT INTO komentarze (idkomentarze, tresckomentarza, punkty, czasdodania, idzgloszenia, iduzytkownicy) VALUES (null, :tresckomentarza, '0', :czasdodania, :idzgloszenia, :iduzytkownicy);";
    private static final String READCOMMENT = "";
    private static final String UPDATE_COMMENT = "";
    private static final String DELETE_COMMENT = "";

    @Autowired
    private NamedParameterJdbcTemplate template;

    @Autowired
    public CommentDAOImpl() {
        template = new NamedParameterJdbcTemplate(ConnectionProvider.getDataSource());
    }

    @Override
    public Comment create(Comment newObject) {
        return null;
    }

    @Override
    public Comment read(Long primaryKey) {
        return null;
    }

    @Override
    public Notification update(Comment updateObject) {
        return null;
    }

    @Override
    public boolean delete(Long primaryKey) {
        return false;
    }

    @Override
    public List<Comment> GetAll() {
        return null;
    }

    private class CommentRowMapper implements RowMapper<Comment>{
        @Override
        public Comment mapRow(ResultSet resultSet, int rowNum) throws SQLException {
            Comment resultComment = new Comment();

            return resultComment;
        }
    }
}

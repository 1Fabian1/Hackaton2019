package dao;

import dbConnection.ConnectionProvider;
import model.Comment;
import model.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import javax.ws.rs.PUT;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommentDAOImpl implements CommentDAO {

    private static final String CREATE_COMMENT = "INSERT INTO komentarze (idkomentarze, tresckomentarza, punkty, czasdodania, idzgloszenia, iduzytkownicy) VALUES (null, :tresckomentarza, '0', :czasdodania, :idzgloszenia, :iduzytkownicy);";
    private static final String READ_FROM_OLDEST_BY_ID = "SELECT * FROM komentarze WHERE idzgloszenia = :idzgloszenia ORDER BY czasdodania;";
    private static final String READ_FROM_NEWEST_BY_ID = "SELECT * FROM komentarze WHERE idzgloszenia = :idzgloszenia ORDER BY czasdodania DESC;";
    private static final String READ_FROM_BEST_BY_ID = "SELECT * FROM komentarze WHERE idzgloszenia = :idzgloszenia ORDER BY punkty;";
    private static final String UPDATE_POINTS = "UPDATE komentarze SET punkty = :punkty WHERE komentarze.idkomentarze = :idkomentarze ;";
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
    public Comment create(Comment comment) {
        Comment resultComment = new Comment();
        KeyHolder holder = new GeneratedKeyHolder();
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("idkomentarze", comment.getIdComment());
        paramMap.put("tresckomentarza", comment.getCommentContent());
        paramMap.put("punkty", comment.getScore());
        paramMap.put("czasdodania", comment.getAddTime());
        paramMap.put("idzgloszenia", comment.getIdNotification());
        paramMap.put("iduzytkownicy", comment.getIdUser());

        SqlParameterSource parameterSource = new MapSqlParameterSource(paramMap);
        template.update(CREATE_COMMENT, parameterSource, holder);
        return resultComment;
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

    @Override
    public List<Comment> readCommentsFromOldest(long idNotification) {
        List<Comment> commentList = new ArrayList<>();
        SqlParameterSource parameterSource = new MapSqlParameterSource("idzgloszenia", idNotification);
        commentList = template.query(READ_FROM_OLDEST_BY_ID, parameterSource, new CommentRowMapper());
        return commentList;
    }

    @Override
    public List<Comment> readCommentsFromNewest(long idNotification) {
        List<Comment> commentList = new ArrayList<>();
        SqlParameterSource parameterSource = new MapSqlParameterSource("idzgloszenia", idNotification);
        commentList = template.query(READ_FROM_NEWEST_BY_ID, parameterSource, new CommentRowMapper());
        return commentList;
    }

    @Override
    public List<Comment> readCommentsByBest(long idNotification) {
        List<Comment> commentList = new ArrayList<>();
        SqlParameterSource parameterSource = new MapSqlParameterSource("idzgloszenia", idNotification);
        commentList = template.query(READ_FROM_BEST_BY_ID, parameterSource, new CommentRowMapper());
        return commentList;
    }

    @Override
    public Comment updatePointsById(Comment comment, long idComment, int score) {
        Comment updatedComment = new Comment();
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("idkomentarze", idComment);
        paramMap.put("tresckomentarza", comment.getCommentContent());
        paramMap.put("punkty", score);
        paramMap.put("czasdodania", comment.getAddTime());
        paramMap.put("idzgloszenia", comment.getIdNotification());
        paramMap.put("iduzytkownicy", comment.getIdUser());

        SqlParameterSource parameterSource = new MapSqlParameterSource(paramMap);
        template.update(UPDATE_POINTS, parameterSource);
        return updatedComment;
    }

    private class CommentRowMapper implements RowMapper<Comment> {
        @Override
        public Comment mapRow(ResultSet resultSet, int rowNum) throws SQLException {
            Comment resultComment = new Comment();
            resultComment.setIdComment(resultSet.getLong("idKomentarze"));
            resultComment.setCommentContent(resultSet.getString("tresckomentarza"));
            resultComment.setScore(resultSet.getInt("punkty"));
            resultComment.setAddTime(resultSet.getDate("czasdodania"));
            resultComment.setIdNotification(resultSet.getLong("idzgloszenia"));
            resultComment.setIdUser(resultSet.getLong("iduzytkownicy"));
            return resultComment;
        }
    }
}

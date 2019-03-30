package dao;

import model.Comment;

import java.util.List;

public interface CommentDAO extends GenericDAO<Comment, Long> {

    List<Comment> readCommentsFromOldest(long idNotification);

    List<Comment> readCommentsFromNewest(long idNotification);

    List<Comment> readCommentsByBest(long idNotification);

    Comment updatePointsById(Comment comment, long idComment, int score);


}

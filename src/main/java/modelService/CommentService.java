package modelService;

import dao.CommentDAO;
import dao.DAOFactory;
import model.Comment;
import model.Notification;

import java.util.Comparator;
import java.util.List;

public class CommentService {

    public void createComment(Comment comment) {
        DAOFactory daoFactory = DAOFactory.getDAOFactory();
        CommentDAO commentDAO = daoFactory.getCommentDAO();
        commentDAO.create(comment);
    }

    public List<Comment> readCommentsFromTheOldest(long idNotification) {
        DAOFactory daoFactory = DAOFactory.getDAOFactory();
        CommentDAO commentDAO = daoFactory.getCommentDAO();
        List<Comment> commentList = (List<Comment>) commentDAO.readCommentsFromOldest(idNotification);
        return commentList;
    }

    public List<Comment> readCommentsFromTheNewest(long idNotification) {
        DAOFactory daoFactory = DAOFactory.getDAOFactory();
        CommentDAO commentDAO = daoFactory.getCommentDAO();
        List<Comment> commentList = (List<Comment>) commentDAO.readCommentsFromNewest(idNotification);
        return commentList;
    }

    public List<Comment> readCommentsByBest(long idNotification) {
        DAOFactory daoFactory = DAOFactory.getDAOFactory();
        CommentDAO commentDAO = daoFactory.getCommentDAO();
        List<Comment> commentList = (List<Comment>) commentDAO.readCommentsByBest(idNotification);
        return commentList;
    }

    public Comment updatePointsById(Comment comment, long idComment, int score) {
        Comment updateComment = new Comment();
        DAOFactory daoFactory = DAOFactory.getDAOFactory();
        CommentDAO commentDAO = daoFactory.getCommentDAO();
        commentDAO.updatePointsById(comment, idComment, score);
        return updateComment;

    }


}

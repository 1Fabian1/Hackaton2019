package modelService;

import dao.DAOFactory;
import dao.LikeDAO;
import model.Like;

public class LikeService {

    public void createLike(Like like) {
        DAOFactory daoFactory = DAOFactory.getDAOFactory();
        LikeDAO likeDAO = daoFactory.getLikeDAO();
        likeDAO.create(like);
    }
}

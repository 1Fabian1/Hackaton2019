package restService;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.Comment;
import modelService.CommentService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/comment")
public class RestComment {

    @POST
    @Path("/createComment")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createComment(String commentJson) {
        System.out.println("commentJson: " + commentJson);
        //Gson gson = new GsonBuilder().setDateFormat("YYYY-MM-DD HH:MM:SS").create();
        Gson gson = new Gson();
        Comment comment = new Comment();
        CommentService commentService = new CommentService();
        comment = gson.fromJson(commentJson, Comment.class);
        System.out.println("Comment: " + comment.toString());
        commentService.createComment(comment);
        return Response.ok(commentJson).build();
    }

    @GET
    @Path("/readCommentsFromTheOldest/{idNotification}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response readCommentsFromTheOldest(@PathParam("idNotification") long primaryKey) {
        System.out.println("Oldest pk :" + primaryKey);
        List<Comment> commentList = new ArrayList<>();
        CommentService commentService = new CommentService();
        Gson gson = new Gson();
        commentList = commentService.readCommentsFromTheOldest(primaryKey);
        String jsonResponse = gson.toJson(commentList);
        return Response.ok(jsonResponse).build();
    }

    @GET
    @Path("/readCommentsFromTheNewest/{idNotification}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response readCommentsFromTheNewest(@PathParam("idNotification") long primaryKey) {
        System.out.println("Oldest pk :" + primaryKey);
        List<Comment> commentList = new ArrayList<>();
        CommentService commentService = new CommentService();
        Gson gson = new Gson();
        commentList = commentService.readCommentsFromTheNewest(primaryKey);
        String jsonResponse = gson.toJson(commentList);
        return Response.ok(jsonResponse).build();
    }

    @GET
    @Path("/readCommentsByTheBest/{idNotification}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response readCommentsByTheBest(@PathParam("idNotification") long primaryKey) {
        System.out.println("Oldest pk :" + primaryKey);
        List<Comment> commentList = new ArrayList<>();
        CommentService commentService = new CommentService();
        Gson gson = new Gson();
        commentList = commentService.readCommentsByBest(primaryKey);
        String jsonResponse = gson.toJson(commentList);
        return Response.ok(jsonResponse).build();
    }

    @POST
    @Path("/updatePointsById/{idComment}/{score}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updatePointsById(@PathParam("idComment") long idComment, @PathParam("score") int score, String commentJson) {
        Gson gson = new Gson();
        Comment comment = new Comment();
        Comment resultComment = new Comment();
        CommentService commentService = new CommentService();
        comment = gson.fromJson(commentJson, Comment.class);
        resultComment = commentService.updatePointsById(comment, idComment, score);
        return Response.ok().build();
    }

}

package restService;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.Like;
import modelService.LikeService;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/like")
public class RestLike {

    @POST
    @Path("/createLike")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createLike(String likeJson) {
        System.out.println("LikeJosn: " + likeJson);
        Gson gson = new GsonBuilder().setDateFormat("YYYY-MM-DD HH:MM:SS").create();
        Like like = new Like();
        LikeService likeService = new LikeService();
        like = gson.fromJson(likeJson, Like.class);
        System.out.println("likeOBJ: " + like.toString());
        likeService.createLike(like);
        return Response.ok(likeJson).build();
    }
}

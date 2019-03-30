package restService;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import model.User;
import modelService.UserService;
import org.springframework.dao.EmptyResultDataAccessException;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;

@Path("/user")
public class RestUser {

    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postUser(String userJson) {
        Gson gson = new Gson();
        User user = new User();
        user = gson.fromJson(userJson, User.class);
        UserService userService = new UserService();
        userService.createUser(user);
        return Response.ok(user).build();
    }

    @GET
    @Path("/readUser/{idUser}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response readUser(@PathParam("idUser") Long primaryKey) {
        User resultUser = new User();
        UserService userService = new UserService();
        Gson gson = new Gson();
        try {
            resultUser = userService.readUser(primaryKey);
        } catch (EmptyResultDataAccessException e) {
            e.printStackTrace();
            resultUser = null;
        }
        String userToJson = gson.toJson(resultUser);
        return Response.ok(userToJson).build();

    }

    @POST
    @Path("/setUserAnAdmin")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response setUserAnAdmin(String userJson) {
        UserService userService = new UserService();
        int primaryKey = Integer.parseInt(userJson.replaceAll("[\\D]", ""));
        userService.setUserAnAdmin(primaryKey);
        return Response.ok().build();

    }
}

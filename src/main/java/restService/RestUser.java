package restService;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import model.User;
import modelService.UserService;
import org.springframework.dao.EmptyResultDataAccessException;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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

    //TODO parse Json to int
    @POST
    @Path("/setUserAnAdmin")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response setUserAnAdmin(String userJson) {
        System.out.println("User admin Json: " + userJson);
        Gson gson = new Gson();
        UserService userService = new UserService();

        //wrong !!!
        userService.setUserAnAdmin(1);
        return Response.ok().build();

    }
}

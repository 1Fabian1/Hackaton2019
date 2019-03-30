package restService;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.Notification;
import modelService.NotificationService;
import org.springframework.dao.EmptyResultDataAccessException;

import javax.annotation.PostConstruct;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/notification")
public class RestNotification {


    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createNotification(String notificationJson) {
        System.out.println("notificationJson: " + notificationJson);

        Gson gson = new GsonBuilder().setDateFormat("YYYY-MM-DD HH:MM:SS").create();

        Notification notification = new Notification();
        notification = gson.fromJson(notificationJson, Notification.class);
        NotificationService notificationService = new NotificationService();
        System.out.println("notification: " + notification.toString());
        notificationService.createNotification(notification);
        return Response.ok(notificationJson).build();
    }

    @GET
    @Path("/readNotification/{idNotification}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response readNotification(@PathParam("idNotification") long primatyKey) {
        Notification resultNotification = new Notification();
        Gson gson = new Gson();
        NotificationService notificationService = new NotificationService();

        try {
            resultNotification = notificationService.readNotification(primatyKey);
        } catch (EmptyResultDataAccessException e) {
            e.printStackTrace();
        }
        String notificationJson = gson.toJson(resultNotification);

        return Response.ok(notificationJson).build();
    }

    @GET
    @Path("/allNotifications")
    @Produces(MediaType.APPLICATION_JSON)
    public Response readAllNotifications() {
        Gson gson = new Gson();
        NotificationService notificationService = new NotificationService();
        List<Notification> notificationList = new ArrayList<>();
        notificationList = notificationService.readAllNotifications();
        return Response.ok(gson.toJson(notificationList)).build();
    }

    @GET
    @Path("/readSolvedNotifications")
    @Produces(MediaType.APPLICATION_JSON)
    public Response readSolvedNotifications() {
        Gson gson = new Gson();
        NotificationService notificationService = new NotificationService();
        List<Notification> notificationList = new ArrayList<>();
        notificationList = notificationService.readSolvedNotifications();
        return Response.ok(gson.toJson(notificationList)).build();
    }

    @GET
    @Path("/readBest25scored")
    @Produces(MediaType.APPLICATION_JSON)
    public Response readBest25scored() {
        Gson gson = new Gson();
        NotificationService notificationService = new NotificationService();
        List<Notification> notificationList = new ArrayList<>();
        notificationList = notificationService.readBest25scored();
        return Response.ok(gson.toJson(notificationList)).build();
    }

    @GET
    @Path("/readModeratedNotificationsBe_AwareToMakeAdditionaSelect")
    @Produces(MediaType.APPLICATION_JSON)
    public Response readModeratedNotifications() {
        Gson gson = new Gson();
        NotificationService notificationService = new NotificationService();
        List<Notification> notificationList = new ArrayList<>();
        notificationList = notificationService.readModeratedNotifications();
        return Response.ok(gson.toJson(notificationList)).build();
    }

    @GET
    @Path("/readAllHotNotifications")
    @Produces(MediaType.APPLICATION_JSON)
    public Response readAllHotNotifications() {
        Gson gson = new Gson();
        NotificationService notificationService = new NotificationService();
        List<Notification> notificationList = new ArrayList<>();
        notificationList = notificationService.readAllHotNotifications();
        return Response.ok(gson.toJson(notificationList)).build();
    }

    @POST
    @Path("/addPointInNotification")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addPointInNotification(String notificationPrimaryKeyJson) {
        System.out.println("dostałem: " + notificationPrimaryKeyJson);
        Gson gson = new Gson();
        NotificationService notificationService = new NotificationService();
        Notification helperNotification = new Notification();
        Notification resultNotification = new Notification();
        int notificationPK, score;
        notificationPK = Integer.parseInt(notificationPrimaryKeyJson.replaceAll("[\\D]", ""));
        helperNotification = notificationService.readNotification(notificationPK);
        score = helperNotification.getScore() + 1;
        System.out.println("Score after add: " + score);
        resultNotification = notificationService.addPointInNotification(helperNotification, score, notificationPK);

        return Response.ok(resultNotification).build();

    }

    //TODO UNFINISHED METHOD!!!
    @POST
    @Path("/updateNotificationStatus")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateNotificationStatus(String notificationJson) {
        NotificationService notificationService = new NotificationService();
        int primaryKey = Integer.parseInt(notificationJson.replaceAll("[\\D]", ""));
        notificationService.updateNotificationStatus(primaryKey);
        return Response.ok().build();
    }

}

package restService;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.Notification;
import modelService.NotificationService;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

@Path("/notification")
public class RestNotification {


    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postNotification(String notificationJson) {
        System.out.println("notificationJson: " + notificationJson);

        Gson gson = new GsonBuilder().setDateFormat("YYYY-MM-DD HH:MM:SS").create();

        Notification notification = new Notification();
        notification = gson.fromJson(notificationJson, Notification.class);
        NotificationService notificationService = new NotificationService();
        System.out.println("notification: " + notification.toString());
        notificationService.createNotification(notification);
        return Response.ok(notificationJson).build();
    }
}

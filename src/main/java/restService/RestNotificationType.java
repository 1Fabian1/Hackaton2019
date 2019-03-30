package restService;

import com.google.gson.Gson;
import model.NotificationType;
import modelService.NotificationTypeService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@Path("/notificationType")
public class RestNotificationType {

    @GET
    @Path("/readAllNotificationTypes")
    @Produces(MediaType.APPLICATION_JSON)
    public Response readAllNotificationTypes() {
        Gson gson = new Gson();
        List<NotificationType> notificationTypeList = new ArrayList<>();
        NotificationTypeService notificationTypeService = new NotificationTypeService();
        notificationTypeList = notificationTypeService.readAll();
        return Response.ok(gson.toJson(notificationTypeList)).build();
    }
}

package restService;

import com.google.gson.Gson;
import model.NotificationStatus;
import modelService.NotificationStatusService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/notificationStatus")
public class RestNotificationStatus {

    @GET
    @Path("/readAllNotificationStatuses")
    @Produces(MediaType.APPLICATION_JSON)
    public Response readAllNotificationTypes() {
        Gson gson = new Gson();
        List<NotificationStatus> notificationStatusList = new ArrayList<>();
        NotificationStatusService notificationStatusService = new NotificationStatusService();
        notificationStatusList = notificationStatusService.getAll();
        return Response.ok(gson.toJson(notificationStatusList)).build();
    }
}

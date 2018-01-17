package com.asegroup52.aat.serverResource;

import com.asegroup52.aat.model.Attendance;
import com.asegroup52.aat.resource.AttendanceResource;
import com.asegroup52.aat.tools.NetworkUtils;
import com.google.appengine.repackaged.com.google.gson.reflect.TypeToken;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseToken;
import com.google.firebase.auth.UserRecord;
import com.googlecode.objectify.ObjectifyService;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.ServerResource;
import sun.net.www.http.HttpClient;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class AttendanceServerResource extends ServerResource implements AttendanceResource {

    @Override
    public Representation retrieve() {
        List<Attendance> attendances = ObjectifyService.ofy()
                .load()
                .type(Attendance.class)
                .order("-date")
                .list();

        return new JsonRepresentation(NetworkUtils.getGson().toJson(attendances, new TypeToken<List<Attendance>>() {
        }.getType()));
    }

    @Override
    public void store(Attendance attendance) {
        ObjectifyService.ofy().save().entity(attendance);
    }

    @Override
    public void remove() {

    }
}

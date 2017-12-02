package com.asegroup52.aat;

import com.asegroup52.aat.resource.GroupResource;
import com.asegroup52.aat.serverResource.AttendanceServerResource;
import com.asegroup52.aat.serverResource.GroupServerResource;
import com.asegroup52.aat.serverResource.StudentServerResource;
import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.routing.Router;

public class RestApplication extends Application {

    /**
     * Creates a root Restlet that will receive all incoming calls.
     */
    @Override
    public Restlet createInboundRoot() {
        // Create a router Restlet that routes each call to a
        // new instance of HelloWorldResource.
        Router router = new Router(getContext());

        // Defines only one route
        router.attach("/api/groups", GroupServerResource.class);
        router.attach("/api/student/{studentId}", StudentServerResource.class);
        router.attach("/api/attendance", AttendanceServerResource.class);

        return router;
    }
}
